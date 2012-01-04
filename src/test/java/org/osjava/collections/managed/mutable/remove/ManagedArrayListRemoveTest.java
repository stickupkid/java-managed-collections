package org.osjava.collections.managed.mutable.remove;

import org.junit.Before;
import org.osjava.collections.managed.ManagedListRemoveBase;
import org.osjava.collections.managed.common.ManagedIntegerFactory;
import org.osjava.collections.managed.mutable.ManagedArrayList;

public class ManagedArrayListRemoveTest extends ManagedListRemoveBase {

	@Before
	public void setUp() {
		list = ManagedArrayList.newInstance(new ManagedIntegerFactory());
	}
}
