package org.osjava.collections.managed.mutable;

import java.util.ArrayList;
import java.util.List;

import org.osjava.collections.managed.AbstractManagedCollection;
import org.osjava.collections.managed.ManagedBinding;
import org.osjava.collections.managed.ManagedCollection;
import org.osjava.collections.managed.ManagedIterator;
import org.osjava.collections.managed.ManagedList;

public abstract class AbstractManagedList<T> extends AbstractManagedCollection<T> implements
		ManagedList<T> {

	private final List<ManagedBinding<T>> _list;

	public AbstractManagedList(List<ManagedBinding<T>> list) {
		super();

		_list = list;
	}

	@Override
	public ManagedList<T> add(T value) {
		if (null == value)
			throw new IllegalArgumentException("Value can not be null");

		add(value, size());
		return this;
	}

	@Override
	public ManagedList<T> add(T value, int index) {
		if (null == value)
			throw new IllegalArgumentException("Value can not be null");

		if (!contains(value)) {
			final ManagedBinding<T> binding = bindingPool.retain();
			if (null != binding) {
				binding.setValue(value);

				_list.add(index, binding);
				unmark(binding);
			} else
				throw new IllegalAccessError("Binding can not be null");
		}

		return this;
	}

	@Override
	public ManagedList<T> add(ManagedList<T> collection) {
		if (null == collection)
			throw new IllegalArgumentException("Collection can not be null");

		final ManagedIterator<T> iterator = collection.iterator();
		while (iterator.hasNext()) {
			add(iterator.next());
		}
		return this;
	}

	@Override
	public Boolean contains(T value) {
		Boolean result = false;
		if (null != value) {
			for (final ManagedBinding<T> binding : _list) {
				if (binding.getValue().equals(value)) {
					result = true;
					break;
				}
			}
		}
		return result;
	}

	@Override
	public ManagedList<T> remove(T value) {
		if (null == value)
			throw new IllegalArgumentException("Value can not be null");

		for (final ManagedBinding<T> binding : _list) {
			if (binding.getValue().equals(value)) {
				_list.remove(binding);
				mark(binding);
				break;
			}
		}
		return this;
	}

	@Override
	public ManagedList<T> remove(int value) {
		T managedObject = getAt(value);
		for (final ManagedBinding<T> binding : _list) {
			if (binding.getValue().equals(managedObject)) {
				_list.remove(binding);
				mark(binding);
				break;
			}
		}
		return this;
	}

	@Override
	public T getAt(int index) {
		if (index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException();
		}

		final ManagedBinding<T> binding = _list.get(index);
		return binding.getValue();
	}

	@Override
	public int indexOf(T value) {
		int result = -1;

		if (null != value) {
			final int total = _list.size();
			for (int i = 0; i < total; i++) {
				final ManagedBinding<T> binding = _list.get(i);

				if (binding.getValue().equals(value)) {
					result = 1;
					break;
				}
			}
		}

		return result;
	}

	@Override
	public ManagedCollection<T> removeAll() {
		for (ManagedBinding<T> binding : _list) {
			bindingPool.getGC().mark(binding);
		}
		bindingPool.getGC().sweep();

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
			ManagedList<T> list = (ManagedList<T>) value;
			if (size() == list.size()) {
				result = true;
				ManagedIterator<T> iteratorA = iterator();
				ManagedIterator<T> iteratorB = list.iterator();
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
	public ManagedIterator<T> iterator() {
		// TODO : Pool this iterator.
		return AbstractManagedListIterator.newInstance(_list);
	}

	@Override
	public List<T> toList() {
		final List<T> list = new ArrayList<T>();
		for (ManagedBinding<T> binding : _list) {
			if (!binding.isEmpty())
				list.add(binding.getValue());
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
