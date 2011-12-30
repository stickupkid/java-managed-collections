package org.osjava.collections.managed.mutable;

import java.util.ArrayList;

import org.osjava.collections.managed.ManagedBinding;
import org.osjava.collections.managed.ManagedFactory;
import org.osjava.collections.managed.ManagedObject;

public class ManagedArrayList<E extends ManagedObject<?>> extends AbstractManagedList<E> {

	public ManagedArrayList(ManagedFactory<E> factory) {
		super(factory, new ArrayList<ManagedBinding<E>>());
	}

	public static <E extends ManagedObject<?>> ManagedArrayList<E> newInstance(
			ManagedFactory<E> factory) {
		return new ManagedArrayList<E>(factory);
	}
}
