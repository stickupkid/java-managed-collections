package org.osjava.collections.managed;

public interface ManagedMap<K, V> extends ManagedCollection<V> {

	public ManagedMap<K, V> put(K key, V value);

	public V getAt(K key);

	public ManagedMap<K, V> remove(K key);

	public Boolean containsKey(K key);

	public Boolean containsValue(V value);

	public ManagedList<V> asList();

}
