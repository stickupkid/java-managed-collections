package org.osjava.collections.managed.mutable;

import java.util.HashMap;

import org.osjava.collections.managed.ManagedBinding;

public class ManagedHashMap<K, V> extends AbstractManagedMap<K, V> {

	public ManagedHashMap() {
		super(new HashMap<K, ManagedBinding<V>>());
	}

	public static <K, V> ManagedHashMap<K, V> newInstance() {
		return new ManagedHashMap<K, V>();
	}
}
