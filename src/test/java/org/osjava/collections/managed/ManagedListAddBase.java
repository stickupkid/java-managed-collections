package org.osjava.collections.managed;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Test;

public class ManagedListAddBase {

	protected ManagedList<ManagedObject<Integer>> list;

	@After
	public void tearDown() {
		list = null;
	}

	@Test
	public void adding_1_element_should_be_the_same_size() {
		final int total = 1;
		final ManagedList<ManagedObject<Integer>> newList = generateList(total);

		assertEquals(total, newList.size());
	}

	@Test
	public void adding_10_elements_should_be_the_same_size() {
		final int total = 10;
		final ManagedList<ManagedObject<Integer>> newList = generateList(total);

		assertEquals(total, newList.size());
	}

	@Test
	public void adding_1013_elements_should_be_the_same_size() {
		final int total = 1013;
		final ManagedList<ManagedObject<Integer>> newList = generateList(total);

		assertEquals(total, newList.size());
	}

	private ManagedList<ManagedObject<Integer>> generateList(final int numItems) {
		if (numItems < 1)
			throw new IllegalArgumentException("NumItems has to be greater than 0");

		ManagedList<ManagedObject<Integer>> newList = null;

		for (int i = 0; i < numItems; i++) {
			ManagedObject<Integer> object = list.retrieve();
			object.setValue(i);

			newList = list.add(object);
		}

		return newList;
	}
}
