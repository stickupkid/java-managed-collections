package org.osjava.collections.managed;

public interface ManagedBinding<E extends ManagedObject<?>> extends ManagedPoolItem<E> {

	public Boolean isEmpty();

	public E getManagedObject();

	public void setManagedObject(E value);
}
