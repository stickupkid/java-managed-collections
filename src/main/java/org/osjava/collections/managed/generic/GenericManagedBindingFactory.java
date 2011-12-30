package org.osjava.collections.managed.generic;

import org.osjava.collections.managed.ManagedFactory;

public class GenericManagedBindingFactory<T> implements ManagedFactory<T> {

	public GenericManagedBindingFactory() {

	}

	public static <T> GenericManagedBindingFactory<T> newInstance() {
		return new GenericManagedBindingFactory<T>();
	}

	@Override
	public T create() {
		return null;
	}
}
