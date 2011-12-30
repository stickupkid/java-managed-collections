package org.osjava.collections.managed;

import java.util.List;

import org.osjava.collections.managed.generic.GenericManagedBindingFactory;
import org.osjava.collections.managed.generic.GenericManagedObjectFactory;
import org.osjava.collections.managed.generic.GenericManagedPool;

public abstract class AbstractManagedCollection<E extends ManagedObject<?>> implements
		ManagedCollection<E> {

	protected ManagedPool<E, E, ManagedFactory<E>> managedObjectPool;

	protected ManagedPool<E, ManagedBinding<E>, ManagedFactory<ManagedBinding<E>>> bindingPool;

	public AbstractManagedCollection() {
		final ManagedFactory<ManagedBinding<E>> bindingFactory =
				GenericManagedBindingFactory.newInstance();
		bindingPool = GenericManagedPool.newInstance(this, bindingFactory);

		final ManagedFactory<E> objectFactory = GenericManagedObjectFactory.newInstance();
		managedObjectPool = GenericManagedPool.newInstance(this, objectFactory);
	}

	public E retrieve() {
		// TODO Auto-generated method stub
		return null;
	}

	public void release(E value) {
		// TODO Auto-generated method stub
	}

	@Override
	public ManagedCollection<E> removeAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean equals(ManagedCollection<E> value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean isEmpty() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ManagedIterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<E> toList() {
		// TODO Auto-generated method stub
		return null;
	}

	protected void mark(ManagedBinding<E> binding) {

	}

	protected void unmark(ManagedBinding<E> binding) {

	}
}
