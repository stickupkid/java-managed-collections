package org.osjava.collections.managed;

import org.osjava.collections.managed.generic.GenericManagedBindingFactory;
import org.osjava.collections.managed.generic.GenericManagedGC;
import org.osjava.collections.managed.generic.GenericManagedPool;

public abstract class AbstractManagedCollection<E extends ManagedObject<?>> implements
		ManagedCollection<E> {

	private final ManagedFactory<ManagedBinding<E>> bindingFactory = GenericManagedBindingFactory
			.newInstance();

	protected final ManagedGC<E> managedObjectGC = GenericManagedGC.newInstance();

	protected final ManagedGC<ManagedBinding<E>> managedBindingGC = GenericManagedGC.newInstance();

	protected final ManagedPool<E, E, ManagedFactory<E>> managedObjectPool;

	protected final ManagedPool<E, ManagedBinding<E>, ManagedFactory<ManagedBinding<E>>> bindingPool;

	public AbstractManagedCollection(ManagedFactory<E> factory) {
		bindingPool = GenericManagedPool.newInstance(this, managedBindingGC, bindingFactory);
		managedObjectPool = GenericManagedPool.newInstance(this, managedObjectGC, factory);
	}

	public E retrieve() {
		// TODO Auto-generated method stub
		return null;
	}

	public void release(E value) {
		// TODO Auto-generated method stub
	}

	protected void mark(ManagedBinding<E> binding) {

	}

	protected void unmark(ManagedBinding<E> binding) {

	}
}
