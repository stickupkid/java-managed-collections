package org.osjava.collections.managed.generic;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.osjava.collections.managed.ManagedPool.ManagedPoolGC;
import org.osjava.collections.managed.ManagedPool.ManagedPoolGC.ManagedCollectionGC;

public class GenericManagedCollectionGC<T> implements ManagedCollectionGC<T> {

	private static final long SWEEP_TIMEOUT = 500000000;

	private final List<ManagedPoolGC<T>> _list = new CopyOnWriteArrayList<ManagedPoolGC<T>>();

	private final Thread _thread;

	private boolean _active;

	private long _nanoTime;

	private GenericManagedCollectionGC() {

		_active = true;
		_nanoTime = System.nanoTime();

		_thread = new Thread(new Runnable() {

			@Override
			public void run() {
				while (_active) {
					if (System.nanoTime() - _nanoTime > SWEEP_TIMEOUT) {

						for (final ManagedPoolGC<T> gc : _list) {
							gc.sweep();
						}

						_nanoTime = System.nanoTime();
					}
				}
			}
		});
		_thread.start();
	}

	public static <T> GenericManagedCollectionGC<T> newInstance() {
		return new GenericManagedCollectionGC<T>();
	}

	@Override
	public void add(ManagedPoolGC<T> bindingGC) {
		_list.add(bindingGC);
	}
}
