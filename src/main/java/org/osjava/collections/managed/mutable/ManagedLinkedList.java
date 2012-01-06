package org.osjava.collections.managed.mutable;

import java.util.LinkedList;

import org.osjava.collections.managed.ManagedBinding;

public class ManagedLinkedList<T> extends AbstractManagedList<T> {

	public ManagedLinkedList() {
		super(new LinkedList<ManagedBinding<T>>());
	}

	public static <T> ManagedLinkedList<T> newInstance() {
		return new ManagedLinkedList<T>();
	}
}
