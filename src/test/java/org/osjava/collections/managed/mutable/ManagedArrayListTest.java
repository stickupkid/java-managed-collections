package org.osjava.collections.managed.mutable;

import org.junit.Before;
import org.osjava.collections.managed.ManagedListBase;
import org.osjava.collections.managed.mutable.factories.ManagedIntegerFactory;

public class ManagedArrayListTest extends ManagedListBase {

	@Before
	public void setUp() {
		list = ManagedArrayList.newInstance(new ManagedIntegerFactory());
	}
}
