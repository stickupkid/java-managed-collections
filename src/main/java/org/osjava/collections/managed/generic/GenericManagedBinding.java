package org.osjava.collections.managed.generic;

import org.osjava.collections.managed.ManagedBinding;
import org.osjava.collections.managed.ManagedCollection;
import org.osjava.collections.managed.ManagedObject;

public class GenericManagedBinding<E extends ManagedObject<?>> implements ManagedBinding<E> {

	private static int HASH_ID = 0;

	private final int _id;

	private E _managedObject;

	private final ManagedCollection<E> _collection;

	public GenericManagedBinding(ManagedCollection<E> collection) {
		if (null == collection)
			throw new IllegalArgumentException("ManagedCollection can not be null");

		_id = HASH_ID++;
		_collection = collection;
	}

	@Override
	public int hashCode() {
		int hash = 17;
		hash *= 31 + _id;
		hash *= 31 + (isEmpty() ? 1 : getManagedObject().hashCode());
		return hash;
	}

	@Override
	@SuppressWarnings("unchecked")
	public boolean equals(Object obj) {
		if (obj == this)
			return true;

		boolean result = false;
		if (obj instanceof GenericManagedBinding) {
			final GenericManagedBinding<E> managed = (GenericManagedBinding<E>) obj;
			if (managed._id == _id && managed.hashCode() == obj.hashCode()) {
				result = true;
			}
		}
		return result;
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
