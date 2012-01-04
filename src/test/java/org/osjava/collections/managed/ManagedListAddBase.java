package org.osjava.collections.managed;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Test;
import org.osjava.collections.managed.common.ManagedInteger;

public class ManagedListAddBase {

	protected ManagedList<ManagedInteger> list;

	@After
	public void tearDown() {
		list = null;
	}

	@Test
	public void adding_1_element_should_be_the_same_size() {
		final int total = 1;
		final ManagedList<ManagedInteger> newList = generateList(total);

		assertEquals(total, newList.size());
	}

	@Test
	public void adding_10_elements_should_be_the_same_size() {
		final int total = 10;
		final ManagedList<ManagedInteger> newList = generateList(total);

		assertEquals(total, newList.size());
	}

	@Test
	public void adding_1013_elements_should_be_the_same_size() {
		final int total = 1013;
		final ManagedList<ManagedInteger> newList = generateList(total);

		assertEquals(total, newList.size());
	}

	private ManagedList<ManagedInteger> generateList(final int numItems) {
		if (numItems < 1)
			throw new IllegalArgumentException("NumItems has to be greater than 0");

		ManagedList<ManagedInteger> newList = null;

		for (int i = 0; i < numItems; i++) {
			ManagedInteger object = list.retrieve();
			object.setValue(i);

			newList = list.add(object);
		}

		return newList;
	}
}
