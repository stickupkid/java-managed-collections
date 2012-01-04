package org.osjava.collections.managed;

public interface ManagedFactory<T> {

	public <E extends ManagedObject<?>> T create(ManagedCollection<E> collection);
}
