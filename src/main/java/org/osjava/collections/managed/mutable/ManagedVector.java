package org.osjava.collections.managed.mutable;

import java.util.Vector;

import org.osjava.collections.managed.ManagedBinding;
import org.osjava.collections.managed.ManagedFactory;
import org.osjava.collections.managed.ManagedObject;

public class ManagedVector<E extends ManagedObject<?>> extends AbstractManagedList<E> {

	public ManagedVector(ManagedFactory<E> factory) {
		super(factory, new Vector<ManagedBinding<E>>());
	}

	public static <E extends ManagedObject<?>> ManagedVector<E> newInstance(
			ManagedFactory<E> factory) {
		return new ManagedVector<E>(factory);
	}

}
