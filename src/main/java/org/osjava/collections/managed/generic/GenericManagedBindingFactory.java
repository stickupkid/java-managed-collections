package org.osjava.collections.managed.generic;

import org.osjava.collections.managed.ManagedBinding;
import org.osjava.collections.managed.ManagedCollection;
import org.osjava.collections.managed.ManagedFactory;

public final class GenericManagedBindingFactory<T> implements ManagedFactory<T> {

	private int _id;

	private final ManagedCollection<T> _collection;

	public GenericManagedBindingFactory(ManagedCollection<T> collection) {
		if (null == collection)
			throw new IllegalArgumentException("ManagedCollection can not be null");

		_id = 0;
		_collection = collection;
	}

	@Override
	public ManagedBinding<T> create() {
		return new GenericManagedBinding();
	}

	private class GenericManagedBinding implements ManagedBinding<T> {

		private T _value;

		private int _uuid;

		public GenericManagedBinding() {
			_uuid = _id++;
		}

		@Override
		public int hashCode() {
			int hash = 17;
			hash *= 31 + _uuid;
			hash *= 31 + (isEmpty() ? 1 : _value.hashCode());
			return hash;
		}

		@Override
		@SuppressWarnings("unchecked")
		public boolean equals(Object obj) {
			if (obj == this)
				return true;

			boolean result = false;
			if (obj instanceof GenericManagedBindingFactory.GenericManagedBinding) {
				final GenericManagedBinding managed = (GenericManagedBinding) obj;
				if (_uuid == managed._uuid && hashCode() == managed.hashCode()) {
					result = true;
				}
			}
			return result;
		}

		@Override
		public Boolean isEmpty() {
			return null == _value;
		}

		@Override
		public ManagedCollection<T> getCollection() {
			return _collection;
		}

		@Override
		public T getValue() {
			return _value;
		}

		@Override
		public void setValue(T value) {
			_value = value;
		}

		@Override
		public String toString() {
			return "Binding {" + hashCode() + "}";
		}
	}
}
