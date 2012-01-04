package org.osjava.collections.managed.mutable.add;

import org.junit.Before;
import org.osjava.collections.managed.ManagedListAddBase;
import org.osjava.collections.managed.common.ManagedIntegerFactory;
import org.osjava.collections.managed.mutable.ManagedVector;

public class ManagedVectorAddTest extends ManagedListAddBase {

	@Before
	public void setUp() {
		list = ManagedVector.newInstance(new ManagedIntegerFactory());
	}
}
