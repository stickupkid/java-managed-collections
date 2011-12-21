package org.osjava.collections.managed.mutable;

import org.junit.Before;
import org.osjava.collections.managed.ManagedListBase;
import org.osjava.collections.managed.mutable.ManagedArrayList;

public class ManagedArrayListTest extends ManagedListBase {

	@Before
	public void setUp() {
		list = ManagedArrayList.newInstance();
	}
}
