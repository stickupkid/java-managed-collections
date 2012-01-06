package org.osjava.collections.managed;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Test;

public class ManagedListEqualityBase {

	protected ManagedList<Integer> list;

	@After
	public void tearDown() {
		list = null;
	}

	@Test
	public void list_should_equal_self() {
		assertTrue(list.equals(list));
	}

	@Test
	public void list_should_not_equal_null() {
		assertFalse(list.equals(null));
	}
}
