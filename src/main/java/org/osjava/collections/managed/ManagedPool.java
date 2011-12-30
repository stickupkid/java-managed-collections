package org.osjava.collections.managed;

public interface ManagedPool<T, E, F extends ManagedFactory<E>> extends ManagedDisposable {

	public E retain();

	public void release(E value);

	public F getFactory();

	public int getSize();

	public int getAvailable();

	public int getPriority();
}
