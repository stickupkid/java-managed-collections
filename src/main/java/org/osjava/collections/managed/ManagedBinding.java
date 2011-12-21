package org.osjava.collections.managed;

public interface ManagedBinding<T extends ManagedObject<?>> {

	public Boolean isEmpty();

	public ManagedCollection<T> collection();

	public ManagedObject<?> getManagedObject();

	public void setManagedObject(ManagedObject<?> value);
}
