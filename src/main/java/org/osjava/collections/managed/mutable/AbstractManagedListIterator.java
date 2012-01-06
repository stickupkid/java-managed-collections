package org.osjava.collections.managed.mutable;

import java.util.List;

import org.osjava.collections.managed.ManagedBinding;
import org.osjava.collections.managed.ManagedIterator;

public class AbstractManagedListIterator<T> implements ManagedIterator<T> {

	private final List<ManagedBinding<T>> _list;

	private int _pointer;

	private AbstractManagedListIterator(List<ManagedBinding<T>> list) {
		if (null == list)
			throw new IllegalArgumentException("List can not be null");

		_list = list;
		_pointer = 0;
	}

	public static <T> AbstractManagedListIterator<T> newInstance(List<ManagedBinding<T>> list) {
		return new AbstractManagedListIterator<T>(list);
	}

	@Override
	public T next() {
		T result = null;

		if (_pointer < _list.size())
			result = _list.get(_pointer).getValue();

		_pointer++;

		return result;
	}

	@Override
	public boolean hasNext() {
		boolean result = false;
		while (_pointer < _list.size()) {
			ManagedBinding<T> binding = _list.get(_pointer);

			if (binding.isEmpty()) {
				_pointer++;
			} else {
				result = true;
				break;
			}
		}

		return result;
	}
}
