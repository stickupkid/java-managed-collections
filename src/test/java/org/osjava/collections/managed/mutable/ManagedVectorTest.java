package org.osjava.collections.managed.mutable;

import org.junit.Before;
import org.osjava.collections.managed.ManagedListBase;
import org.osjava.collections.managed.common.ManagedIntegerFactory;

public class ManagedVectorTest extends ManagedListBase {

	@Before
	public void setUp() {
		list = ManagedVector.newInstance(new ManagedIntegerFactory());
	}
}
