package org.osjava.collections.managed.mutable;

import org.junit.Before;
import org.osjava.collections.managed.ManagedListBase;

public class ManagedLinkedListTest extends ManagedListBase {

	@Before
	public void setUp() {
		list = ManagedLinkedList.newInstance();
	}
}
