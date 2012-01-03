package org.osjava.collections.managed;

public interface ManagedGC<T> {

	public ManagedGCObserver<T> addObserver(ManagedGCObserver<T> observer);

	public ManagedGCObserver<T> removeObserver(ManagedGCObserver<T> observer);

	public Boolean hasObserver(ManagedGCObserver<T> observer);

	public void mark(T value);

	public void unmark(T value);

	public void sweep();

	public ManagedIterator<T> iterator();
}
