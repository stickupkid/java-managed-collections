package org.osjava.collections.managed.mutable;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.osjava.collections.managed.AbstractManagedCollection;
import org.osjava.collections.managed.ManagedBinding;
import org.osjava.collections.managed.ManagedCollection;
import org.osjava.collections.managed.ManagedList;
import org.osjava.collections.managed.ManagedMap;

public abstract class AbstractManagedMap<K, V> extends AbstractManagedCollection<V> implements
		ManagedMap<K, V> {

	private final Map<K, ManagedBinding<V>> _map;

	public AbstractManagedMap(Map<K, ManagedBinding<V>> map) {
		super();

		_map = map;
	}

	@Override
	public ManagedMap<K, V> put(K key, V value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public V getAt(K key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ManagedMap<K, V> remove(K key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean containsKey(K key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean containsValue(V value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ManagedList<V> asList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ManagedCollection<V> removeAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean equals(Object value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Boolean isEmpty() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<V> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<V> toList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		return _map.size();
	}

	@Override
	public String toString() {
		return _map.toString();
	}
}
