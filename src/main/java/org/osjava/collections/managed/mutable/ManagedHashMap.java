package org.osjava.collections.managed.mutable;

import java.util.HashMap;

import org.osjava.collections.managed.ManagedBinding;
import org.osjava.collections.managed.ManagedObject;

public class ManagedHashMap<K, E extends ManagedObject<?>> extends AbstractManagedMap<K, E> {

	public ManagedHashMap() {
		super(new HashMap<K, ManagedBinding<E>>());
	}

	public static <K, E extends ManagedObject<?>> ManagedHashMap<K, E> newInstance() {
		return new ManagedHashMap<K, E>();
	}
}
