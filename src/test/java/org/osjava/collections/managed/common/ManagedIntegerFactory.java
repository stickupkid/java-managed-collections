package org.osjava.collections.managed.common;
import org.osjava.collections.managed.ManagedCollection;
import org.osjava.collections.managed.ManagedFactory;
import org.osjava.collections.managed.ManagedObject;

public class ManagedIntegerFactory implements ManagedFactory<ManagedInteger> {

	@Override
	@SuppressWarnings("unchecked")
	public <E extends ManagedObject<?>> ManagedInteger create(ManagedCollection<E> collection) {
		final ManagedInteger managed =
				new ManagedInteger((ManagedCollection<ManagedObject<Integer>>) collection);
		managed.setValue(0);
		return managed;
	}
}
