package org.osjava.collections.managed.mutable;

import org.junit.Before;
import org.osjava.collections.managed.ManagedMapBase;
import org.osjava.collections.managed.mutable.factories.ManagedIntegerFactory;

public class ManagedHashMapTest extends ManagedMapBase {

	@Before
	public void setUp() {
		map = ManagedHashMap.newInstance(new ManagedIntegerFactory());
	}
}
