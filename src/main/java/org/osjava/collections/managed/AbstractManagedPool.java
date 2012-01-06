package org.osjava.collections.managed;

import java.util.ArrayList;
import java.util.List;

import org.osjava.collections.managed.ManagedPool.ManagedPoolGC.ManagedPoolGCObserver;

public abstract class AbstractManagedPool<T> implements ManagedPool<T> {

	private final AbstractManagedGCObserver _gcObserver = new AbstractManagedGCObserver();

	private ManagedPoolGC<T> _gc;

	protected int priority;

	public AbstractManagedPool() {
	}

	protected void init(ManagedPoolGC<T> gc) {
		if (null == gc)
			throw new IllegalArgumentException("ManagedGC can not be null");

		_gc = gc;
		_gc.addObserver(_gcObserver);

		priority = 100;
	}

	@Override
	public ManagedPoolGC<T> getGC() {
		return _gc;
	}

	@Override
	public int getPriority() {
		return priority;
	}

	protected void allocate() {
		priority = 100;
	}

	protected void deallocate() {
		priority = 0;
	}

	private class AbstractManagedGCObserver implements ManagedPoolGCObserver<T> {

		@Override
		public void onStartSweep(final ManagedPoolGC<T> gc) {
		}

		@Override
		public void onFinishSweep(final ManagedPoolGC<T> gc) {
			priority--;
			if (priority < 0)
				priority = 0;
		}
	}

	public abstract class AbstractManagedPoolGC implements ManagedPoolGC<T> {

		protected static final long SWEEP_TIMEOUT = 500000000;

		protected final List<ManagedBinding<T>> marked = new ArrayList<ManagedBinding<T>>();

		protected final List<ManagedPoolGCObserver<T>> listeners =
				new ArrayList<ManagedPoolGCObserver<T>>();

		public AbstractManagedPoolGC() {

		}

		@Override
		public void addObserver(final ManagedPoolGCObserver<T> observer) {
			if (listeners.indexOf(observer) < 0) {
				listeners.add(observer);
			}
		}

		@Override
		public void removeObserver(final ManagedPoolGCObserver<T> observer) {
			listeners.remove(observer);
		}

		@Override
		public Boolean hasObserver(final ManagedPoolGCObserver<T> observer) {
			return listeners.contains(observer);
		}

		@Override
		public void mark(final ManagedBinding<T> value) {
			if (!marked.contains(value))
				marked.add(value);
		}

		@Override
		public void unmark(final ManagedBinding<T> value) {
			marked.remove(value);
		}

		@Override
		public void sweep() {
			for (final ManagedPoolGCObserver<T> observer : listeners) {
				observer.onStartSweep(this);
			}

			onSweep();

			for (final ManagedPoolGCObserver<T> observer : listeners) {
				observer.onFinishSweep(this);
			}
		}

		protected void onSweep() {
			throw new AbstractMethodError();
		}
	}
}
