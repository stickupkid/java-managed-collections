package org.osjava.collections.managed;

public abstract class AbstractManagedPool<T extends ManagedObject<?>, E, F extends ManagedFactory<E>>
		implements ManagedPool<T, E, F> {

	private final AbstractManagedGCObserver _gcObserver = new AbstractManagedGCObserver();

	private final ManagedGC<E> _gc;

	protected int priority;

	public AbstractManagedPool(ManagedGC<E> gc) {
		if (null == gc)
			throw new IllegalArgumentException("ManagedGC can not be null");

		_gc = gc;
		_gc.addObserver(_gcObserver);
	}

	@Override
	public int getPriority() {
		return priority;
	}

	@Override
	public void dispose() {
		_gc.removeObserver(_gcObserver);
		priority = -1;
	}

	protected void allocate() {
		priority = 100;
	}

	protected void deallocate() {
		priority = 0;
	}

	private class AbstractManagedGCObserver implements ManagedGCObserver<E> {

		@Override
		public void onStartSweep(ManagedGC<E> gc) {
		}

		@Override
		public void onFinishSweep(ManagedGC<E> gc) {
			if (priority <= 0) {
				_gc.removeObserver(_gcObserver);
			}

			priority--;
			if (priority < 0)
				priority = 0;
		}
	}
}
