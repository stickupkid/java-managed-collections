package org.osjava.collections.managed.mutable.add;

import org.junit.Before;
import org.osjava.collections.managed.ManagedListAddBase;
import org.osjava.collections.managed.mutable.ManagedLinkedList;

public class ManagedLinkedListAddTest extends ManagedListAddBase {

	@Before
	public void setUp() {
		list = ManagedLinkedList.newInstance();
	}
}
