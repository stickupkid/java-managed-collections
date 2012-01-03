package org.osjava.collections.managed;

public interface ManagedIterator<T> {

	public T next();

	public boolean hasNext();
}
