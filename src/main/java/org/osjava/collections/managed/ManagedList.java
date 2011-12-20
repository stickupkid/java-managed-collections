package org.osjava.collections.managed;

public interface ManagedList<E extends ManagedObject<?>> extends ManagedCollection<E> {

	public ManagedList<E> add(ManagedObject<?> value);

	public ManagedList<E> addAll(ManagedList<E> collection);

	public ManagedList<E> addAt(ManagedObject<?> value, int index);

	public Boolean contains(ManagedObject<?> value);

	public ManagedList<E> remove(ManagedObject<?> value);

	public ManagedObject<?> getAt(int index);

	public int indexOf(ManagedObject<?> value);
}
