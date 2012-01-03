package org.osjava.collections.managed;

public interface ManagedObject<T> extends ManagedPoolItem<ManagedObject<T>> {

	public T getValue();

	public void setValue(T value);

}
