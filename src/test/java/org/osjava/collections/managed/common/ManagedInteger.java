package org.osjava.collections.managed.common;
import org.osjava.collections.managed.ManagedCollection;
import org.osjava.collections.managed.ManagedObject;

public final class ManagedInteger implements ManagedObject<Integer> {

	private int _value;

	private ManagedCollection<ManagedObject<Integer>> _collection;

	public ManagedInteger(ManagedCollection<ManagedObject<Integer>> collection) {
		if (null == collection)
			throw new IllegalArgumentException("ManagedCollection can not be null");

		_collection = collection;
	}

	@Override
	public ManagedCollection<ManagedObject<Integer>> getCollection() {
		return _collection;
	}

	@Override
	public Integer getValue() {
		return _value;
	}

	@Override
	public void setValue(Integer value) {
		_value = value;
	}
}
