package org.osjava.collections.managed;

public interface ManagedObject<T> {

	public T getValue();

	public void setValue(T value);

	public ManagedCollection<ManagedObject<T>> getCollection();
}
