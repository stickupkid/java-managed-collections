package org.osjava.collections.managed.common;

import org.osjava.collections.managed.ManagedCollection;
import org.osjava.collections.managed.ManagedFactory;
import org.osjava.collections.managed.ManagedObject;

public class ManagedIntegerFactory implements ManagedFactory<ManagedObject<Integer>> {

	@Override
	public ManagedObject<Integer> create() {
		return new ManagedInteger(0);
	}

	private final class ManagedInteger implements ManagedObject<Integer> {

		private int _value;

		public ManagedInteger(int value) {
			_value = value;
		}

		@Override
		public ManagedCollection<ManagedObject<Integer>> getCollection() {
			return null;
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
}
