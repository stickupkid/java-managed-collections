package org.osjava.collections.managed;

import java.util.List;

public interface ManagedCollection<T> {

	public ManagedCollection<T> removeAll();

	public int size();

	public Boolean isEmpty();

	public ManagedIterator<T> iterator();

	public ManagedCollectionInspector inspector();

	public List<T> toList();
}
