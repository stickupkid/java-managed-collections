package org.osjava.collections.managed;

import org.osjava.collections.managed.generic.GenericManagedBindingPool;
import org.osjava.collections.managed.generic.GenericManagedCollectionInspector;

public abstract class AbstractManagedCollection<T> implements ManagedCollection<T> {

	private ManagedCollectionInspector _inspector;

	protected final ManagedPool<T> bindingPool;

	public AbstractManagedCollection() {
		bindingPool = GenericManagedBindingPool.newInstance(this);

		init();
	}

	private void init() {
		_inspector = GenericManagedCollectionInspector.newInstance(bindingPool);
	}

	@Override
	public ManagedCollectionInspector inspector() {
		return _inspector;
	}

	protected final void mark(ManagedBinding<T> binding) {
		bindingPool.getGC().mark(binding);
	}

	protected final void unmark(ManagedBinding<T> binding) {
		bindingPool.getGC().unmark(binding);
	}
}
