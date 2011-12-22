package org.osjava.collections.managed;

import java.util.List;

public abstract class AbstractManagedCollection<E extends ManagedObject<?>> implements
		ManagedCollection<E> {

	protected ManagedPool<ManagedBinding<E>, ManagedFactory<ManagedBinding<E>>, E> bindingPool;

	protected ManagedPool<E, ManagedFactory<E>, ?> managedObjectPool;

	public AbstractManagedCollection() {
		// TODO Auto-generated constructor stub
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
