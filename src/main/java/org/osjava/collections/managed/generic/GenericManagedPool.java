package org.osjava.collections.managed.generic;

import java.util.ArrayList;
import java.util.List;

import org.osjava.collections.managed.AbstractManagedPool;
import org.osjava.collections.managed.ManagedCollection;
import org.osjava.collections.managed.ManagedFactory;
import org.osjava.collections.managed.ManagedGC;
import org.osjava.collections.managed.ManagedObject;
import org.osjava.collections.managed.ManagedPool;
import org.osjava.collections.managed.ManagedPoolItem;

public final class GenericManagedPool<T extends ManagedObject<?>, E, F extends ManagedFactory<E>>
		extends AbstractManagedPool<T, E, F> implements ManagedPool<T, E, F> {

	private static final int ALLOCATIONS = 512;

	private final ManagedCollection<T> _collection;

	private final List<E> _available = new ArrayList<E>();

	private final List<E> _utilised = new ArrayList<E>();

	private final F _factory;

	private final boolean _strictAllocations;

	private GenericManagedPool(final ManagedCollection<T> collection, final ManagedGC<E> gc,
			final F factory, final boolean strictAllocations) {
		super(gc);

		if (null == collection)
			throw new IllegalArgumentException("ManagedCollection can not be null");
		if (null == factory)
			throw new IllegalArgumentException("ManagedFactory can not be null");

		_factory = factory;
		_collection = collection;
		_strictAllocations = strictAllocations;
	}

	public static <T extends ManagedObject<?>, E, F extends ManagedFactory<E>>
			GenericManagedPool<T, E, F> newInstance(final ManagedCollection<T> collection,
					final ManagedGC<E> gc, final F factory, final boolean strictAllocations) {
		return new GenericManagedPool<T, E, F>(collection, gc, factory, strictAllocations);
	}

	@Override
	public synchronized E retain() {
		if (getAvailable() < 1)
			allocate();

		final E item = _available.remove(_available.size() - 1);
		if (!_strictAllocations)
			_utilised.add(item);
		else {

			if (_utilised.indexOf(item) < 0) {
				_utilised.add(item);
			} else
				throw new IllegalAccessError("Item is already in use");
		}

		priority++;
		if (priority >= 100)
			priority = 100;

		return item;
	}

	@Override
	public synchronized void release(E value) {
		if (value instanceof ManagedPoolItem) {

			final ManagedPoolItem<?> poolItem = (ManagedPoolItem<?>) value;

			if (poolItem.getCollection().equals(_collection)) {
				final int index = _utilised.indexOf(value);

				if (!_strictAllocations) {

					final E item = _utilised.remove(index);
					_available.add(item);
				} else {

					if (index >= 0) {
						final E item = _utilised.remove(index);
						_available.add(item);
					} else
						throw new IllegalAccessError("Item has already been released");
				}

			} else
				throw new IllegalAccessError("Released item collection is not valid");

		} else
			throw new IllegalArgumentException("Value us not a valid ManagedPoolItem");
	}

	@Override
	public F getFactory() {
		return _factory;
	}

	@Override
	public int getSize() {
		return _available.size() + _utilised.size();
	}

	@Override
	public int getAvailable() {
		return _available.size();
	}

	@Override
	protected void allocate() {
		int index = ALLOCATIONS;
		while (--index > -1) {
			_available.add(getFactory().create(_collection));
		}
		super.allocate();
	}
}
