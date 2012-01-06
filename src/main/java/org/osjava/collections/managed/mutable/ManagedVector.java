package org.osjava.collections.managed.mutable;

import java.util.Vector;

import org.osjava.collections.managed.ManagedBinding;

public class ManagedVector<T> extends AbstractManagedList<T> {

	public ManagedVector() {
		super(new Vector<ManagedBinding<T>>());
	}

	public static <T> ManagedVector<T> newInstance() {
		return new ManagedVector<T>();
	}
}