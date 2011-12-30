package org.osjava.collections.managed;

public interface ManagedPool<T, E, F extends ManagedFactory<E>> {

	public E retain();

	public void release(E value);

	public F getFactory();

	public int size();

	public int available();

	public int priority();
}
