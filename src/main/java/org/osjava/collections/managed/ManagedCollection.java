package org.osjava.collections.managed;

import java.util.List;

public interface ManagedCollection<E extends ManagedObject<?>> {

	public E retrieve();

	public void release(E value);

	public ManagedCollection<E> removeAll();

	public int size();

	public Boolean isEmpty();

	public ManagedIterator<E> iterator();

	public List<E> toList();
}
