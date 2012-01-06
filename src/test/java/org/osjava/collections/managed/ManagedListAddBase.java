package org.osjava.collections.managed;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Test;

public class ManagedListAddBase {

	protected ManagedList<Integer> list;

	@After
	public void tearDown() {
		list = null;
	}

	@Test
	public void adding_1_element_should_be_the_same_size() {
		final int total = 1;
		final ManagedList<Integer> newList = generateList(total);

		assertEquals(total, newList.size());
	}

	@Test
	public void adding_10_elements_should_be_the_same_size() {
		final int total = 10;
		final ManagedList<Integer> newList = generateList(total);

		assertEquals(total, newList.size());
	}

	@Test
	public void adding_1013_elements_should_be_the_same_size() {
		final int total = 1013;
		final ManagedList<Integer> newList = generateList(total);

		assertEquals(total, newList.size());
	}

	private ManagedList<Integer> generateList(final int numItems) {
		if (numItems < 1)
			throw new IllegalArgumentException("NumItems has to be greater than 0");

		ManagedList<Integer> newList = null;

		for (int i = 0; i < numItems; i++) {
			newList = list.add(i);
		}

		return newList;
	}
}
