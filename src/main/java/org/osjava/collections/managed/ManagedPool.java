package org.osjava.collections.managed;

public interface ManagedPool<T> {

	public ManagedBinding<T> retain();

	public void release(ManagedBinding<T> value);

	public ManagedPoolGC<T> getGC();

	public ManagedFactory<T> getFactory();

	public int getSize();

	public int getAvailable();

	public int getPriority();

	public interface ManagedPoolGC<T> {

		public void addObserver(ManagedPoolGCObserver<T> observer);

		public void removeObserver(ManagedPoolGCObserver<T> observer);

		public Boolean hasObserver(ManagedPoolGCObserver<T> observer);

		public void mark(ManagedBinding<T> binding);

		public void unmark(ManagedBinding<T> binding);

		public void sweep();

		public interface ManagedPoolGCObserver<T> {

			public void onStartSweep(ManagedPoolGC<T> gc);

			public void onFinishSweep(ManagedPoolGC<T> gc);
		}

		public interface ManagedCollectionGC {

			public void add(ManagedPoolGC<?> gc);
		}
	}
}
