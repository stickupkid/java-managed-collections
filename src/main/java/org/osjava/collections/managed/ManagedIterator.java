package org.osjava.collections.managed;

public interface ManagedIterator<E extends ManagedObject<?>> {

	public ManagedObject<E> next();

	public Boolean hasNext();
}
