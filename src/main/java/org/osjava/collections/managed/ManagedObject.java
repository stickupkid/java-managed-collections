package org.osjava.collections.managed;

public interface ManagedObject<T> {

	public T getValue();

	public ManagedCollection<ManagedObject<T>> getCollection();
}
