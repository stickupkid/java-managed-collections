package org.osjava.collections.managed.mutable.add;

import org.junit.Before;
import org.osjava.collections.managed.ManagedListAddBase;
import org.osjava.collections.managed.mutable.ManagedArrayList;

public class ManagedArrayListAddTest extends ManagedListAddBase {

	@Before
	public void setUp() {
		list = ManagedArrayList.newInstance();
	}
}
