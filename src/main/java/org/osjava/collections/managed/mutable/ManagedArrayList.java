package org.osjava.collections.managed.mutable;

import java.util.ArrayList;

import org.osjava.collections.managed.ManagedBinding;
import org.osjava.collections.managed.ManagedObject;

public class ManagedArrayList<E extends ManagedObject<?>> extends AbstractManagedList<E> {

	public ManagedArrayList() {
		super(new ArrayList<ManagedBinding<E>>());
	}

	public static <E extends ManagedObject<?>> ManagedArrayList<E> newInstance() {
		return new ManagedArrayList<E>();
	}

}
