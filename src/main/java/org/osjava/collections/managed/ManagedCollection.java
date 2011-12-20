package org.osjava.collections.managed;

import java.util.List;

public interface ManagedCollection<E extends ManagedObject<?>> {

	public ManagedCollection<E> removeAll();

	public Boolean equals(ManagedCollection<E> value);

	public int size();

	public Boolean isEmpty();

	public ManagedIterator<E> iterator();

	public List<E> toList();
}
