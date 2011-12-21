package org.osjava.collections.managed;

public interface ManagedGCObserver<T> {

	public void onStartSweep(ManagedGC<T> gc);

	public void onFinishSweep(ManagedGC<T> gc);
}
