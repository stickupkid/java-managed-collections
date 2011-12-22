package org.osjava.collections.managed.mutable;

import java.util.Map;

import org.osjava.collections.managed.AbstractManagedCollection;
import org.osjava.collections.managed.ManagedBinding;
import org.osjava.collections.managed.ManagedList;
import org.osjava.collections.managed.ManagedMap;
import org.osjava.collections.managed.ManagedObject;

public abstract class AbstractManagedMap<K, E extends ManagedObject<?>> extends
		AbstractManagedCollection<E> implements ManagedMap<K, E> {

	private final Map<K, ManagedBinding<E>> _map;

	public AbstractManagedMap(Map<K, ManagedBinding<E>> map) {
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
	public int size() {
		return _map.size();
	}
}
