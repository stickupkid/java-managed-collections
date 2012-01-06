package org.osjava.collections.managed.mutable.remove;

import org.junit.Before;
import org.osjava.collections.managed.ManagedListRemoveBase;
import org.osjava.collections.managed.mutable.ManagedVector;

public class ManagedVectorRemoveTest extends ManagedListRemoveBase {

	@Before
	public void setUp() {
		list = ManagedVector.newInstance();
	}
}
