package org.osjava.collections.managed;

public interface ManagedIterator<E extends ManagedObject<?>> {

	public E next();

	public Boolean hasNext();
}
