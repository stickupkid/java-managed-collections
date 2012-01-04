package org.osjava.collections.managed.mutable;

import java.util.ArrayList;
import java.util.List;

import org.osjava.collections.managed.AbstractManagedCollection;
import org.osjava.collections.managed.ManagedBinding;
import org.osjava.collections.managed.ManagedCollection;
import org.osjava.collections.managed.ManagedFactory;
import org.osjava.collections.managed.ManagedIterator;
import org.osjava.collections.managed.ManagedList;
import org.osjava.collections.managed.ManagedObject;

public abstract class AbstractManagedList<E extends ManagedObject<?>> extends
		AbstractManagedCollection<E> implements ManagedList<E> {

	private final List<ManagedBinding<E>> _list;

	public AbstractManagedList(ManagedFactory<E> factory, List<ManagedBinding<E>> list) {
		super(factory);

		_list = list;
	}

	@Override
	public ManagedList<E> add(E value) {
		add(value, size());
		return this;
	}

	@Override
	public ManagedList<E> add(ManagedList<E> collection) {
		final ManagedIterator<E> iterator = collection.iterator();
		while (iterator.hasNext()) {
			add(iterator.next());
		}
		return this;
	}

	@Override
	public ManagedList<E> add(E value, int index) {
		if (!contains(value)) {
			final ManagedBinding<E> binding = bindingPool.retain();
			binding.setManagedObject(value);

			_list.add(index, binding);
			unmark(binding);
		}

		return this;
	}

	@Override
	public Boolean contains(E value) {
		Boolean result = false;
		for (final ManagedBinding<E> binding : _list) {
			if (binding.getManagedObject().equals(value)) {
				result = true;
				break;
			}
		}
		return result;
	}

	@Override
	public ManagedList<E> remove(E value) {
		for (final ManagedBinding<E> binding : _list) {
			if (binding.getManagedObject().equals(value)) {
				_list.remove(binding);
				mark(binding);
				break;
			}
		}
		return this;
	}

	@Override
	public ManagedList<E> remove(int value) {
		E managedObject = getAt(value);
		for (final ManagedBinding<E> binding : _list) {
			if (binding.getManagedObject().equals(managedObject)) {
				_list.remove(binding);
				mark(binding);
				break;
			}
		}
		return this;
	}

	@Override
	public E getAt(int index) {
		if (index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException();
		}

		final ManagedBinding<E> binding = _list.get(index);
		return binding.getManagedObject();
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
	public ManagedCollection<E> removeAll() {
		for (ManagedBinding<E> binding : _list) {
			managedBindingGC.mark(binding);
		}
		managedBindingGC.sweep();

		_list.removeAll(_list);

		return this;
	}

	@Override
	@SuppressWarnings("unchecked")
	public boolean equals(Object value) {
		if (value == this)
			return true;

		boolean result = false;
		if (value instanceof ManagedList) {
			ManagedList<E> list = (ManagedList<E>) value;
			if (size() == list.size()) {
				result = true;
				ManagedIterator<E> iteratorA = iterator();
				ManagedIterator<E> iteratorB = list.iterator();
				while (iteratorA.hasNext()) {
					if (!iteratorA.next().equals(iteratorB.next())) {
						result = false;
						break;
					}
				}
			}
		}
		return result;
	}

	@Override
	public Boolean isEmpty() {
		return _list.size() == 0;
	}

	@Override
	public ManagedIterator<E> iterator() {
		// TODO : Pool this iterator.
		return AbstractManagedListIterator.newInstance(_list);
	}

	@Override
	public List<E> toList() {
		final List<E> list = new ArrayList<E>();
		for (ManagedBinding<E> binding : _list) {
			if (!binding.isEmpty())
				list.add(binding.getManagedObject());
		}

		return list;
	}

	@Override
	public int size() {
		return _list.size();
	}

	@Override
	public String toString() {
		return _list.toString();
	}
}
