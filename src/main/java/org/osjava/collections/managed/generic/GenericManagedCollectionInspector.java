package org.osjava.collections.managed.generic;

import org.osjava.collections.managed.ManagedCollectionInspector;
import org.osjava.collections.managed.ManagedPool;
import org.osjava.collections.managed.ManagedPool.ManagedPoolGC;
import org.osjava.collections.managed.ManagedPool.ManagedPoolGC.ManagedPoolGCObserver;

public class GenericManagedCollectionInspector<T> implements ManagedCollectionInspector {

	private final ManagedPoolGC<T> _gc;

	private final ManagedPool<T> _pool;

	private final ManagedPoolGCObserver<T> _gcObserver;

	private boolean _gcSweeping;

	private GenericManagedCollectionInspector(ManagedPool<T> bindingPool) {
		if (null == bindingPool)
			throw new IllegalArgumentException("ManagedBindingPool can not be null");

		_pool = bindingPool;

		_gcSweeping = false;

		_gcObserver = new GCObserver();

		_gc = bindingPool.getGC();
		_gc.addObserver(_gcObserver);
	}

	public static <T> GenericManagedCollectionInspector<T> newInstance(ManagedPool<T> bindingPool) {
		return new GenericManagedCollectionInspector<T>(bindingPool);
	}

	@Override
	public int getPoolSize() {
		return _pool.getSize();
	}

	@Override
	public int getPoolAvailable() {
		return _pool.getAvailable();
	}

	@Override
	public int getPoolPriority() {
		return _pool.getPriority();
	}

	@Override
	public boolean isPoolGCSweeping() {
		return _gcSweeping;
	}

	@Override
	public String toString() {
		final StringBuilder builder = new StringBuilder();

		builder.append("ManagedCollectionInspector:\n");

		builder.append("\tManagedBinding (gc=");
		builder.append(isPoolGCSweeping());
		builder.append(")\n\t\tSize: ");
		builder.append(getPoolSize());
		builder.append("\n\t\tAvailable: ");
		builder.append(getPoolAvailable());
		builder.append("\n\t\tPriority: ");
		builder.append(getPoolPriority());

		return builder.toString();
	}

	private class GCObserver implements ManagedPoolGCObserver<T> {

		@Override
		public void onStartSweep(ManagedPoolGC<T> gc) {
			_gcSweeping = true;
		}

		@Override
		public void onFinishSweep(ManagedPoolGC<T> gc) {
			_gcSweeping = false;
		}
	}
}
