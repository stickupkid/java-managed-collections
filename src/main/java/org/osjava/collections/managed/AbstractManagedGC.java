package org.osjava.collections.managed;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class AbstractManagedGC<T> implements ManagedGC<T> {

	private final List<T> _marked = new ArrayList<T>();

	protected final List<ManagedGCObserver<T>> listeners =
			new CopyOnWriteArrayList<ManagedGCObserver<T>>();

	public AbstractManagedGC() {

	}

	@Override
	public ManagedGCObserver<T> addObserver(ManagedGCObserver<T> observer) {
		if (listeners.indexOf(observer) < 0) {
			listeners.add(observer);
		}
		return observer;
	}

	@Override
	public ManagedGCObserver<T> removeObserver(ManagedGCObserver<T> observer) {
		listeners.remove(observer);
		return observer;
	}

	@Override
	public Boolean hasObserver(ManagedGCObserver<T> observer) {
		return listeners.indexOf(observer) >= 0;
	}

	@Override
	public void mark(T value) {
		if (_marked.indexOf(value) < 0) {
			_marked.add(value);
		}
	}

	@Override
	public void unmark(T value) {
		_marked.remove(value);
	}
}
