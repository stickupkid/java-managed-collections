package org.osjava.collections.managed;

import java.util.Iterator;
import java.util.List;

public class AbstractManagedGCIterator<T> implements ManagedIterator<T> {

	private final Iterator<T> _iterator;

	private AbstractManagedGCIterator(Iterator<T> iterator) {
		if (null == iterator)
			throw new IllegalArgumentException("Iterator can not be null");

		_iterator = iterator;
	}

	public static <T> AbstractManagedGCIterator<T> newInstance(List<T> list) {
		return new AbstractManagedGCIterator<T>(list.iterator());
	}

	@Override
	public T next() {
		return _iterator.next();
	}

	@Override
	public Boolean hasNext() {
		return _iterator.hasNext();
	}
}
