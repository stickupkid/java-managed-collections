package org.osjava.collections.managed;

public interface ManagedList<T> extends ManagedCollection<T> {

	public ManagedList<T> add(T value);

	public ManagedList<T> add(T value, int index);

	public ManagedList<T> add(ManagedList<T> collection);

	public Boolean contains(T value);

	public ManagedList<T> remove(T value);

	public ManagedList<T> remove(int index);

	public T getAt(int index);

	public int indexOf(T value);
}
