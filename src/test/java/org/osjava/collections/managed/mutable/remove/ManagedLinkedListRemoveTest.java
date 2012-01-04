package org.osjava.collections.managed.mutable.remove;

import org.junit.Before;
import org.osjava.collections.managed.ManagedListRemoveBase;
import org.osjava.collections.managed.common.ManagedIntegerFactory;
import org.osjava.collections.managed.mutable.ManagedLinkedList;

public class ManagedLinkedListRemoveTest extends ManagedListRemoveBase {

	@Before
	public void setUp() {
		list = ManagedLinkedList.newInstance(new ManagedIntegerFactory());
	}
}
