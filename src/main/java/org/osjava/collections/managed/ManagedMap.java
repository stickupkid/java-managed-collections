package org.osjava.collections.managed;

public interface ManagedMap<K, E extends ManagedObject<?>> extends ManagedCollection<E> {

	public ManagedMap<K, E> put(K key, ManagedObject<?> value);

	public ManagedObject<E> getAt(K key);

	public ManagedMap<K, E> remove(K key);

	public Boolean contains(K key);

	public Boolean contains(ManagedObject<?> value);

	public ManagedList<E> asList();

}
