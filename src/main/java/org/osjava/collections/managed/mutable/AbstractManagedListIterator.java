package org.osjava.collections.managed.mutable;

import java.util.List;

import org.osjava.collections.managed.ManagedBinding;
import org.osjava.collections.managed.ManagedIterator;
import org.osjava.collections.managed.ManagedObject;

public class AbstractManagedListIterator<T extends ManagedObject<?>> implements ManagedIterator<T> {

	private final List<ManagedBinding<T>> _list;

	private int _pointer;

	private AbstractManagedListIterator(List<ManagedBinding<T>> list) {
		if (null == list)
			throw new IllegalArgumentException("List can not be null");

		_list = list;
		_pointer = 0;
	}

	public static <T extends ManagedObject<?>> AbstractManagedListIterator<T> newInstance(
			List<ManagedBinding<T>> list) {
		return new AbstractManagedListIterator<T>(list);
	}

	@Override
	public T next() {
		T result = null;

		if (_pointer < _list.size())
			result = _list.get(_pointer).getManagedObject();

		return result;
	}

	@Override
	public Boolean hasNext() {
		Boolean result = false;
		while (_pointer < _list.size()) {
			ManagedBinding<T> binding = _list.get(_pointer);
			if (!binding.isEmpty()) {
				result = true;
				break;
			}
			_pointer++;
		}

		return result;
	}
}