package org.osjava.collections.managed;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Test;
import org.osjava.collections.managed.common.ManagedInteger;

public class ManagedListEqualityBase {

	protected ManagedList<ManagedInteger> list;

	@After
	public void tearDown() {
		list = null;
	}

	@Test
	public void list_should_equal_self() {
		assertTrue(list.equals(list));
	}
}
