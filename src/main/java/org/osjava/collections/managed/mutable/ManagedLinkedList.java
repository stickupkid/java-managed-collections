package org.osjava.collections.managed.mutable;

import java.util.LinkedList;

import org.osjava.collections.managed.ManagedBinding;
import org.osjava.collections.managed.ManagedFactory;
import org.osjava.collections.managed.ManagedObject;

public class ManagedLinkedList<E extends ManagedObject<?>> extends AbstractManagedList<E> {

	public ManagedLinkedList(ManagedFactory<E> factory) {
		super(factory, new LinkedList<ManagedBinding<E>>());
	}

	public static <E extends ManagedObject<?>> ManagedLinkedList<E> newInstance(
			ManagedFactory<E> factory) {
		return new ManagedLinkedList<E>(factory);
	}
}
