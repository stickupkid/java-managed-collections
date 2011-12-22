package org.osjava.collections.managed;

public interface ManagedList<E extends ManagedObject<?>> extends ManagedCollection<E> {

	public ManagedList<E> add(E value);

	public ManagedList<E> addAll(ManagedList<E> collection);

	public ManagedList<E> addAt(E value, int index);

	public Boolean contains(E value);

	public ManagedList<E> remove(E value);

	public ManagedObject<?> getAt(int index);

	public int indexOf(E value);
}
