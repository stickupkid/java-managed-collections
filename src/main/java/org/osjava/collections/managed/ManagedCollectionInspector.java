package org.osjava.collections.managed;

public interface ManagedCollectionInspector {

	public int getPoolSize();

	public int getPoolAvailable();

	public int getPoolPriority();

	public boolean isPoolGCSweeping();

}
