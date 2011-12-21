package org.osjava.collections.managed.mutable;

import org.junit.Before;
import org.osjava.collections.managed.ManagedMapBase;
import org.osjava.collections.managed.mutable.ManagedHashMap;

public class ManagedHashMapTest extends ManagedMapBase {

	@Before
	public void setUp() {
		map = ManagedHashMap.newInstance();
	}
}
