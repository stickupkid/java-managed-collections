package org.osjava.collections.managed;

public interface ManagedPoolItem<E extends ManagedObject<?>> {

	public ManagedCollection<E> getCollection();
}
