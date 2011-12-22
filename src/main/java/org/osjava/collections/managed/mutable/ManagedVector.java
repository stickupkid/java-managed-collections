package org.osjava.collections.managed.mutable;

import java.util.Vector;

import org.osjava.collections.managed.ManagedBinding;
import org.osjava.collections.managed.ManagedObject;

public class ManagedVector<E extends ManagedObject<?>> extends AbstractManagedList<E> {

	public ManagedVector() {
		super(new Vector<ManagedBinding<E>>());
	}

	public static <E extends ManagedObject<?>> ManagedVector<E> newInstance() {
		return new ManagedVector<E>();
	}

}
