package org.osjava.collections.managed.mutable;

import java.util.LinkedList;

import org.osjava.collections.managed.ManagedBinding;
import org.osjava.collections.managed.ManagedObject;

public class ManagedLinkedList<E extends ManagedObject<?>> extends AbstractManagedList<E> {

	public ManagedLinkedList() {
		super(new LinkedList<ManagedBinding<E>>());
	}

	public static <E extends ManagedObject<?>> ManagedLinkedList<E> newInstance() {
		return new ManagedLinkedList<E>();
	}
}
