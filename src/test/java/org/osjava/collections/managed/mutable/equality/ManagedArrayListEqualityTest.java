package org.osjava.collections.managed.mutable.equality;

import org.junit.Before;
import org.osjava.collections.managed.ManagedListEqualityBase;
import org.osjava.collections.managed.common.ManagedIntegerFactory;
import org.osjava.collections.managed.mutable.ManagedArrayList;

public class ManagedArrayListEqualityTest extends ManagedListEqualityBase {

	@Before
	public void setUp() {
		list = ManagedArrayList.newInstance(new ManagedIntegerFactory());
	}
}
