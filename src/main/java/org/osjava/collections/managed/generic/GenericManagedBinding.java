package org.osjava.collections.managed.generic;

import org.osjava.collections.managed.ManagedBinding;
import org.osjava.collections.managed.ManagedCollection;
import org.osjava.collections.managed.ManagedObject;

public class GenericManagedBinding<E extends ManagedObject<?>> implements ManagedBinding<E> {

	private E _managedObject;

	private final ManagedCollection<E> _collection;

	public GenericManagedBinding(ManagedCollection<E> collection) {
		if (null == collection)
			throw new IllegalArgumentException("ManagedCollection can not be null");

		_collection = collection;
	}

	@Override
	public ManagedCollection<E> getCollection() {
		return _collection;
	}

	@Override
	public Boolean isEmpty() {
		return null == getManagedObject();
	}

	@Override
	public E getManagedObject() {
		return _managedObject;
	}

	@Override
	public void setManagedObject(E value) {
		_managedObject = value;
	}
}
