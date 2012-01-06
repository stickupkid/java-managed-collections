package org.osjava.collections.managed;

import org.osjava.collections.managed.ManagedPool.ManagedPoolGC.ManagedPoolGCObserver;

public abstract class AbstractManagedPool<T> implements ManagedPool<T> {

	private final AbstractManagedGCObserver _gcObserver = new AbstractManagedGCObserver();

	private ManagedPoolGC<T> _gc;

	protected int priority;

	public AbstractManagedPool() {

	}

	protected void init(final ManagedPoolGC<T> gc) {
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
}
