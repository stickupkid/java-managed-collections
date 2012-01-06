package org.osjava.collections.managed;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.osjava.collections.managed.ManagedPool.ManagedPoolGC;
import org.osjava.collections.managed.ManagedPool.ManagedPoolGC.ManagedCollectionGC;
import org.osjava.collections.managed.generic.GenericManagedBindingPool;
import org.osjava.collections.managed.generic.GenericManagedCollectionInspector;

public abstract class AbstractManagedCollection<T> implements ManagedCollection<T> {

	private ManagedCollectionInspector _inspector;

	protected final ManagedPool<T> bindingPool;

	private static AbstractManagedCollectionGC gc = new AbstractManagedCollectionGC();

	public AbstractManagedCollection() {
		bindingPool = GenericManagedBindingPool.newInstance(this);

		_inspector = GenericManagedCollectionInspector.newInstance(bindingPool);

		gc.add(bindingPool.getGC());
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

	private static class AbstractManagedCollectionGC implements ManagedCollectionGC {

		private static final long SWEEP_TIMEOUT = 500000000;

		private final List<ManagedPoolGC<?>> _list = new CopyOnWriteArrayList<ManagedPoolGC<?>>();

		private final Thread _thread;

		private boolean _active;

		private long _nanoTime;

		private AbstractManagedCollectionGC() {

			_active = true;
			_nanoTime = System.nanoTime();

			_thread = new Thread(new Runnable() {

				@Override
				public void run() {
					while (_active) {
						if (System.nanoTime() - _nanoTime > SWEEP_TIMEOUT) {

							for (final ManagedPoolGC<?> gc : _list) {
								gc.sweep();
							}

							_nanoTime = System.nanoTime();
						}
					}
				}
			});
			_thread.start();
		}

		@Override
		public void add(ManagedPoolGC<?> bindingGC) {
			_list.add(bindingGC);
		}
	}
}
