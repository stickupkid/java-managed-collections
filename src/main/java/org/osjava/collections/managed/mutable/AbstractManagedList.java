package org.osjava.collections.managed.mutable;

import java.util.List;

import org.osjava.collections.managed.AbstractManagedCollection;
import org.osjava.collections.managed.ManagedBinding;
import org.osjava.collections.managed.ManagedIterator;
import org.osjava.collections.managed.ManagedList;
import org.osjava.collections.managed.ManagedObject;

public abstract class AbstractManagedList<E extends ManagedObject<?>> extends
		AbstractManagedCollection<E> implements ManagedList<E> {

	private final List<ManagedBinding<E>> _list;

	public AbstractManagedList(List<ManagedBinding<E>> list) {
		_list = list;
	}

	@Override
	public ManagedList<E> add(E value) {
		addAt(value, size());
		return this;
	}

	@Override
	public ManagedList<E> addAll(ManagedList<E> collection) {
		final ManagedIterator<E> iterator = collection.iterator();
		while (iterator.hasNext()) {
			add(iterator.next());
		}
		return this;
	}

	@Override
	public ManagedList<E> addAt(E value, int index) {
		if (!contains(value)) {
			final ManagedBinding<E> binding = bindingPool.retain(value);

			_list.add(index, binding);
			unmark(binding);
		}

		return this;
	}

	@Override
	public Boolean contains(E value) {
		Boolean result = false;
		synchronized (_list) {
			for (final ManagedBinding<E> binding : _list) {
				if (binding.getManagedObject().equals(value)) {
					result = true;
					break;
				}
			}
		}
		return result;
	}

	@Override
	public ManagedList<E> remove(E value) {
		synchronized (_list) {
			for (final ManagedBinding<E> binding : _list) {
				if (binding.getManagedObject().equals(value)) {
					_list.remove(binding);
					break;
				}
			}
		}
		return this;
	}

	@Override
	public E getAt(int index) {
		if (index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException();
		}

		E result = null;
		final ManagedBinding<E> binding = _list.get(index);
		if (!binding.isEmpty())
			result = binding.getManagedObject();
		return result;
	}

	@Override
	public int indexOf(E value) {
		int result = -1;
		final int total = _list.size();
		for (int i = 0; i < total; i++) {
			final ManagedBinding<E> binding = _list.get(i);
			if (binding.getManagedObject().equals(value)) {
				result = 1;
				break;
			}
		}
		return result;
	}

	@Override
	public int size() {
		return _list.size();
	}
}
