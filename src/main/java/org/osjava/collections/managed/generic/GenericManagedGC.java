package org.osjava.collections.managed.generic;

import org.osjava.collections.managed.AbstractManagedGC;
import org.osjava.collections.managed.ManagedGCObserver;

public final class GenericManagedGC<T> extends AbstractManagedGC<T> {

	private GenericManagedGC() {
		super();
	}

	public static <T> GenericManagedGC<T> newInstance() {
		return new GenericManagedGC<T>();
	}

	@Override
	public void sweep() {
		for (ManagedGCObserver<T> observer : listeners) {
			observer.onStartSweep(this);
		}

		for (ManagedGCObserver<T> observer : listeners) {
			observer.onFinishSweep(this);
		}
	}
}
