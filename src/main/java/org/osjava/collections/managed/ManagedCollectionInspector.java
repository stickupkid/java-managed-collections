package org.osjava.collections.managed;

public interface ManagedCollectionInspector<E extends ManagedObject<?>> {

	public int getBindingPoolSize();

	public int getBindingPoolAvailable();

	public int getBindingPoolPriority();

	public boolean isBindingPoolGCSweeping();

	public int getObjectPoolSize();

	public int getObjectPoolAvailable();

	public int getObjectPoolPriority();

	public boolean isObjectPoolGCSweeping();

}
