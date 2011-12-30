package org.osjava.collections.managed;

public interface ManagedBinding<T extends ManagedObject<?>> extends ManagedPoolItem {

	public Boolean isEmpty();

	public T getManagedObject();

	public void setManagedObject(T value);

	public void setCollection(ManagedCollection<ManagedObject<?>> collection);
}
