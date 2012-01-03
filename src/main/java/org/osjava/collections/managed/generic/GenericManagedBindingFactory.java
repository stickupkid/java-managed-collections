package org.osjava.collections.managed.generic;

import org.osjava.collections.managed.ManagedBinding;
import org.osjava.collections.managed.ManagedCollection;
import org.osjava.collections.managed.ManagedFactory;
import org.osjava.collections.managed.ManagedObject;

public final class GenericManagedBindingFactory<E extends ManagedObject<?>> implements
		ManagedFactory<ManagedBinding<E>> {

	private final ManagedCollection<E> _collection;

	private GenericManagedBindingFactory(ManagedCollection<E> collection) {
		if (null == collection)
			throw new IllegalArgumentException("ManagedCollection can not be null");

		_collection = collection;
	}

	public static <E extends ManagedObject<?>> GenericManagedBindingFactory<E> newInstance(
			ManagedCollection<E> collection) {
		return new GenericManagedBindingFactory<E>(collection);
	}

	@Override
	public ManagedBinding<E> create() {
		return new GenericManagedBinding<E>(_collection);
	}
}
