package org.osjava.collections.managed.generic;

import org.osjava.collections.managed.ManagedFactory;
import org.osjava.collections.managed.ManagedObject;

public final class GenericManagedBindingFactory<T> implements ManagedFactory<T> {

	public static <T> GenericManagedBindingFactory<T> newInstance() {
		return new GenericManagedBindingFactory<T>();
	}

	@Override
	@SuppressWarnings("unchecked")
	public T create() {
		// TODO : T should extend ManagedBinding
		return (T) new GenericManagedBinding<ManagedObject<?>>();
	}
}
