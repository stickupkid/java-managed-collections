package org.osjava.collections.managed;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Test;

public class ManagedListBase {

	protected ManagedList<Integer> list;

	@After
	public void tearDown() {
		list = null;
	}

	@Test
	public void size_is_zero_when_created() {
		assertEquals("List is zero", 0, list.size());
	}

	@Test
	public void getting_one_element_should_be_the_same_as_inserted_element() {
		final Integer value = 1;
		final ManagedList<Integer> newList = list.add(value);

		assertEquals("List element at 0 is identical as", value, newList.getAt(0));
	}
}
