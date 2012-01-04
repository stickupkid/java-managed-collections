package org.osjava.collections.managed.mutable.equality;

import org.junit.Before;
import org.osjava.collections.managed.ManagedListEqualityBase;
import org.osjava.collections.managed.common.ManagedIntegerFactory;
import org.osjava.collections.managed.mutable.ManagedVector;

public class ManagedVectorEqualityTest extends ManagedListEqualityBase {

	@Before
	public void setUp() {
		list = ManagedVector.newInstance(new ManagedIntegerFactory());
	}
}
