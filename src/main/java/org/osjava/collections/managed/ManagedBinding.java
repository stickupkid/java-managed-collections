package org.osjava.collections.managed;

public interface ManagedBinding<T> {

	public Boolean isEmpty();

	public ManagedCollection<T> getCollection();

	public T getValue();

	public void setValue(T value);
}
