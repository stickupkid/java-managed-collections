package org.osjava.collections.managed;

public interface ManagedFactory<T> {

	public ManagedBinding<T> create();
}
