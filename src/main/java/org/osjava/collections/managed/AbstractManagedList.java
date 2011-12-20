package org.osjava.collections.managed;

import java.util.List;

public abstract class AbstractManagedList<E extends ManagedObject<?>> extends
		AbstractManagedCollection<E> implements ManagedList<E> {

	private final List<ManagedBinding<E>> _list;

	public AbstractManagedList(List<ManagedBinding<E>> list) {
		_list = list;
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
		return _list.size();
	}
}
