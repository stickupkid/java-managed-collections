package org.osjava.collections.managed.generic;

import org.osjava.collections.managed.ManagedBinding;
import org.osjava.collections.managed.ManagedCollection;
import org.osjava.collections.managed.ManagedObject;

public class GenericManagedBinding<T extends ManagedObject<?>> implements ManagedBinding<T> {

	private ManagedCollection<ManagedObject<?>> _collection;

	private T _managedObject;

	public GenericManagedBinding() {

	}

	@Override
	public ManagedCollection<ManagedObject<?>> getCollection() {
		return _collection;
	}

	@Override
	public void setCollection(ManagedCollection<ManagedObject<?>> collection) {
		if (null == collection)
			throw new IllegalArgumentException("ManagedCollection can not be null");

		_collection = collection;
	}

	@Override
	public Boolean isEmpty() {
		return null == getManagedObject();
	}

	@Override
	public T getManagedObject() {
		return _managedObject;
	}

	@Override
	public void setManagedObject(T value) {
		_managedObject = value;
	}
}
