package org.osjava.collections.managed;

public interface ManagedPool<T, F> {

	public T retain();

	public void release(T value);

	public F getFactory();

	public ManagedCollection<ManagedObject<?>> collection();

	public int size();

	public int available();

	public int priority();

}
