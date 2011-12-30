package org.osjava.collections.managed.mutable;

import org.junit.Before;
import org.osjava.collections.managed.ManagedListBase;
import org.osjava.collections.managed.mutable.factories.ManagedIntegerFactory;

public class ManagedLinkedListTest extends ManagedListBase {

	@Before
	public void setUp() {
		list = ManagedLinkedList.newInstance(new ManagedIntegerFactory());
	}
}
