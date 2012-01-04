package org.osjava.collections.managed.mutable;

import java.util.List;
import java.util.Map;

import org.osjava.collections.managed.AbstractManagedCollection;
import org.osjava.collections.managed.ManagedBinding;
import org.osjava.collections.managed.ManagedCollection;
import org.osjava.collections.managed.ManagedFactory;
import org.osjava.collections.managed.ManagedIterator;
import org.osjava.collections.managed.ManagedList;
import org.osjava.collections.managed.ManagedMap;
import org.osjava.collections.managed.ManagedObject;

public abstract class AbstractManagedMap<K, E extends ManagedObject<?>> extends
		AbstractManagedCollection<E> implements ManagedMap<K, E> {

	private final Map<K, ManagedBinding<E>> _map;

	public AbstractManagedMap(ManagedFactory<E> factory, Map<K, ManagedBinding<E>> map) {
		super(factory);

		_map = map;
	}

	@Override
	public ManagedMap<K, E> put(K key, ManagedObject<?> value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ManagedObject<E> getAt(K key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ManagedMap<K, E> remove(K key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean contains(K key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean contains(ManagedObject<?> value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ManagedList<E> asList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ManagedCollection<E> removeAll() {
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
	public ManagedIterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<E> toList() {
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
