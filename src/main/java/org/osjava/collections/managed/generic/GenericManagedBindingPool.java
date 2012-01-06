package org.osjava.collections.managed.generic;

import java.util.ArrayList;
import java.util.List;

import org.osjava.collections.managed.AbstractManagedPool;
import org.osjava.collections.managed.ManagedBinding;
import org.osjava.collections.managed.ManagedCollection;
import org.osjava.collections.managed.ManagedFactory;

public final class GenericManagedBindingPool<T> extends AbstractManagedPool<T> {

	private static final int ALLOCATIONS = 512;

	private final ManagedCollection<T> _collection;

	private final ManagedFactory<T> _factory;

	private final List<ManagedBinding<T>> _available = new ArrayList<ManagedBinding<T>>();

	private final List<ManagedBinding<T>> _utilised = new ArrayList<ManagedBinding<T>>();

	private GenericManagedBindingPool(final ManagedCollection<T> collection) {
		if (null == collection)
			throw new IllegalArgumentException("ManagedCollection can not be null");

		init(new GenericManagedBindingPoolGC());

		_collection = collection;
		_factory = new GenericManagedBindingFactory<T>(collection);
	}

	public static <T> GenericManagedBindingPool<T>
			newInstance(final ManagedCollection<T> collection) {
		return new GenericManagedBindingPool<T>(collection);
	}

	@Override
	public ManagedBinding<T> retain() {
		ManagedBinding<T> item = null;

		if (getAvailable() < 1)
			allocate();

		final int index = _available.size() - 1;
		if (index >= 0) {
			item = _available.remove(index);
		}

		if (null != item) {
			if (!_utilised.contains(item)) {
				_utilised.add(item);

				priority++;
				if (priority >= 100)
					priority = 100;
			} else
				throw new IllegalAccessError("Item is already in use");
		}

		return item;
	}

	@Override
	public void release(final ManagedBinding<T> value) {
		if (null == value)
			throw new IllegalArgumentException("Value can not be null");

		if (value.getCollection().equals(_collection)) {

			if (!_utilised.contains(value)) {
				_utilised.remove(value);
				_available.add(value);
			} else
				throw new IllegalAccessError("Item has already been released");

		} else
			throw new IllegalAccessError("Released item collection is not valid");
	}

	@Override
	public ManagedFactory<T> getFactory() {
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
			_available.add(_factory.create());
		}
		super.allocate();
	}

	private class GenericManagedBindingPoolGC extends AbstractManagedPoolGC {

		private GenericManagedBindingPoolGC() {
		}

		@Override
		protected void onSweep() {

		}
	}
}
