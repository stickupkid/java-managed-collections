package org.osjava.collections.managed.mutable;

import java.util.ArrayList;

import org.osjava.collections.managed.ManagedCollectionImpl;
import org.osjava.collections.managed.ManagedList;
import org.osjava.collections.managed.ManagedObject;

public class ManagedArrayList<E extends ManagedObject<?>> extends ManagedCollectionImpl<E>
		implements ManagedList<E> {

	private final ArrayList<E> list = new ArrayList<E>();

	public ManagedArrayList() {
		// TODO Auto-generated constructor stub
	}

	public static <E extends ManagedObject<?>> ManagedArrayList<E> newInstance() {
		return new ManagedArrayList<E>();
	}

	@Override
	public ManagedList<E> add(ManagedObject<?> value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ManagedList<E> addAll(ManagedList<E> collection) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ManagedList<E> addAt(ManagedObject<?> value, int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean contains(ManagedObject<?> value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ManagedList<E> remove(ManagedObject<?> value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ManagedObject<?> getAt(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int indexOf(ManagedObject<?> value) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int size() {
		return list.size();
	}
}
