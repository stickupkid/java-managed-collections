package org.osjava.collections.managed;

public interface ManagedBinding<T extends ManagedObject<?>> extends ManagedPoolItem {

	public Boolean isEmpty();

	public T getManagedObject();
}
