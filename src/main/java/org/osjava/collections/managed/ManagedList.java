package org.osjava.collections.managed;

public interface ManagedList<E extends ManagedObject<?>> extends ManagedCollection<E> {

	public ManagedList<E> add(E value);

	public ManagedList<E> add(ManagedList<E> collection);

	public ManagedList<E> add(E value, int index);

	public Boolean contains(E value);

	public ManagedList<E> remove(E value);

	public ManagedList<E> remove(int index);

	public ManagedObject<?> getAt(int index);

	public int indexOf(E value);
}
