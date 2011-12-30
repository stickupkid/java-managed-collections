package org.osjava.collections.managed;

public interface ManagedObject<T> extends ManagedPoolItem {

	public T getValue();

	public void setValue(T value);

}
