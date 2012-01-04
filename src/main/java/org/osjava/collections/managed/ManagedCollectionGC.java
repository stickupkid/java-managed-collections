package org.osjava.collections.managed;

public interface ManagedCollectionGC {

	public <E> void addManagedObjectGC(ManagedGC<E> gc);

	public <E> void removeManagedObjectGC(ManagedGC<E> gc);

	public <B> void addManagedBindingGC(ManagedGC<B> gc);

	public <B> void removeManagedBindingGC(ManagedGC<B> gc);

}
