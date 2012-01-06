package org.osjava.collections.managed.mutable;

import java.util.ArrayList;

import org.osjava.collections.managed.ManagedBinding;

public class ManagedArrayList<T> extends AbstractManagedList<T> {

	public ManagedArrayList() {
		super(new ArrayList<ManagedBinding<T>>());
	}

	public static <T> ManagedArrayList<T> newInstance() {
		return new ManagedArrayList<T>();
	}
}
