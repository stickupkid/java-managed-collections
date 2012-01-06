package org.osjava.collections.managed;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Test;

public class ManagedListRemoveBase {

	protected ManagedList<Integer> list;

	@After
	public void tearDown() {
		list = null;
	}

	@Test(expected = IllegalArgumentException.class)
	public void removing_null_does_not_return_a_null_list() {
		ManagedList<Integer> newList = list.remove(null);
		fail("Failed if reached " + newList);
	}
}
