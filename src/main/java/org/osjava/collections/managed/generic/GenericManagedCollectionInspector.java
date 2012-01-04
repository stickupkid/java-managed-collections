package org.osjava.collections.managed.generic;

import org.osjava.collections.managed.ManagedBinding;
import org.osjava.collections.managed.ManagedCollectionInspector;
import org.osjava.collections.managed.ManagedFactory;
import org.osjava.collections.managed.ManagedGC;
import org.osjava.collections.managed.ManagedGCObserver;
import org.osjava.collections.managed.ManagedObject;
import org.osjava.collections.managed.ManagedPool;

public class GenericManagedCollectionInspector<E extends ManagedObject<?>> implements
		ManagedCollectionInspector<E> {

	private final ManagedPool<E, E, ManagedFactory<E>> _objectPool;

	private final ManagedPool<E, ManagedBinding<E>, ManagedFactory<ManagedBinding<E>>> _bindingPool;

	private final ManagedGC<E> _objectGC;

	private final ManagedGC<ManagedBinding<E>> _bindingGC;

	private final ManagedGCObserver<E> _objectGCObserver;

	private final ManagedGCObserver<ManagedBinding<E>> _bindingGCObserver;

	private boolean _objectGCSweeping;

	private boolean _bindingGCSweeping;

	private GenericManagedCollectionInspector(
			ManagedPool<E, ManagedBinding<E>, ManagedFactory<ManagedBinding<E>>> bindingPool,
			ManagedGC<ManagedBinding<E>> bindingGC,
			ManagedPool<E, E, ManagedFactory<E>> objectPool, ManagedGC<E> objectGC) {
		if (null == bindingPool)
			throw new IllegalArgumentException("ManagedBindingPool can not be null");
		if (null == bindingGC)
			throw new IllegalArgumentException("ManagedBindingGC can not be null");
		if (null == objectPool)
			throw new IllegalArgumentException("ManagedObjectPool can not be null");
		if (null == objectGC)
			throw new IllegalArgumentException("ManagedObjectGC can not be null");

		_bindingPool = bindingPool;
		_bindingGC = bindingGC;
		_objectPool = objectPool;
		_objectGC = objectGC;

		_objectGCSweeping = false;
		_bindingGCSweeping = false;

		_objectGCObserver = new GenericObjectGCObserver();
		_bindingGCObserver = new GenericBindingGCObserver();

		_objectGC.addObserver(_objectGCObserver);
		_bindingGC.addObserver(_bindingGCObserver);
	}

	public static <E extends ManagedObject<?>> GenericManagedCollectionInspector<E> newInstance(
			ManagedPool<E, ManagedBinding<E>, ManagedFactory<ManagedBinding<E>>> bindingPool,
			ManagedGC<ManagedBinding<E>> bindingGC,
			ManagedPool<E, E, ManagedFactory<E>> objectPool, ManagedGC<E> objectGC) {
		return new GenericManagedCollectionInspector<E>(bindingPool, bindingGC, objectPool,
				objectGC);
	}

	@Override
	public int getBindingPoolSize() {
		return _bindingPool.getSize();
	}

	@Override
	public int getBindingPoolAvailable() {
		return _bindingPool.getAvailable();
	}

	@Override
	public int getBindingPoolPriority() {
		return _bindingPool.getPriority();
	}

	@Override
	public boolean isBindingPoolGCSweeping() {
		return _bindingGCSweeping;
	}

	@Override
	public int getObjectPoolSize() {
		return _objectPool.getSize();
	}

	@Override
	public int getObjectPoolAvailable() {
		return _objectPool.getAvailable();
	}

	@Override
	public int getObjectPoolPriority() {
		return _objectPool.getPriority();
	}

	@Override
	public boolean isObjectPoolGCSweeping() {
		return _objectGCSweeping;
	}

	@Override
	public String toString() {
		final StringBuilder builder = new StringBuilder();

		builder.append("ManagedCollectionInspector:\n");

		builder.append("\tManagedBinding (gc=");
		builder.append(isBindingPoolGCSweeping());
		builder.append(")\n\t\tSize: ");
		builder.append(getBindingPoolSize());
		builder.append("\n\t\tAvailable: ");
		builder.append(getBindingPoolAvailable());
		builder.append("\n\t\tPriority: ");
		builder.append(getBindingPoolPriority());

		builder.append("\n\tManagedObject (gc=");
		builder.append(isObjectPoolGCSweeping());
		builder.append(")\n\t\tSize: ");
		builder.append(getObjectPoolSize());
		builder.append("\n\t\tAvailable: ");
		builder.append(getObjectPoolAvailable());
		builder.append("\n\t\tPriority: ");
		builder.append(getObjectPoolPriority());

		return builder.toString();
	}

	private class GenericBindingGCObserver implements ManagedGCObserver<ManagedBinding<E>> {

		@Override
		public void onStartSweep(ManagedGC<ManagedBinding<E>> gc) {
			_bindingGCSweeping = true;
		}

		@Override
		public void onFinishSweep(ManagedGC<ManagedBinding<E>> gc) {
			_bindingGCSweeping = false;
		}

	}

	private class GenericObjectGCObserver implements ManagedGCObserver<E> {

		@Override
		public void onStartSweep(ManagedGC<E> gc) {
			_objectGCSweeping = true;
		}

		@Override
		public void onFinishSweep(ManagedGC<E> gc) {
			_objectGCSweeping = false;
		}

	}
}
