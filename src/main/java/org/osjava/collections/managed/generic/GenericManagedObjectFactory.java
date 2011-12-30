package org.osjava.collections.managed.generic;

import org.osjava.collections.managed.ManagedFactory;

public class GenericManagedObjectFactory<T> implements ManagedFactory<T> {

	public GenericManagedObjectFactory() {

	}

	public static <T> GenericManagedObjectFactory<T> newInstance() {
		return new GenericManagedObjectFactory<T>();
	}

	@Override
	public T create() {
		return null;
	}

}
