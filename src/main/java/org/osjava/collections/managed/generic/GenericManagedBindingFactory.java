package org.osjava.collections.managed.generic;

import org.osjava.collections.managed.ManagedBinding;
import org.osjava.collections.managed.ManagedCollection;
import org.osjava.collections.managed.ManagedFactory;
import org.osjava.collections.managed.ManagedObject;

public final class GenericManagedBindingFactory<T extends ManagedObject<?>> implements
		ManagedFactory<ManagedBinding<T>> {

	public static <T extends ManagedObject<?>> GenericManagedBindingFactory<T> newInstance() {
		return new GenericManagedBindingFactory<T>();
	}

	@Override
	@SuppressWarnings("unchecked")
	public <E extends ManagedObject<?>> ManagedBinding<T> create(ManagedCollection<E> collection) {
		return (ManagedBinding<T>) new GenericManagedBinding<E>(collection);
	}
}
