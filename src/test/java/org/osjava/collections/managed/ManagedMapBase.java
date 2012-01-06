package org.osjava.collections.managed;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Test;

public class ManagedMapBase {

	protected ManagedMap<String, Integer> map;

	@After
	public void tearDown() {
		map = null;
	}

	@Test
	public void size_is_zero_when_created() {
		assertEquals("Map is zero", 0, map.size());
	}

	@Test
	public void adding_one_element_should_have_size_of_one() {
		final Integer value = 1;
		final ManagedMap<String, Integer> newMap = map.put("Element0", value);

		assertTrue(value == newMap.size());
	}

	@Test
	public void getting_one_element_should_be_the_same_as_inserted_element() {
		final Integer value = 1;
		final ManagedMap<String, Integer> newMap = map.put("Element0", value);

		assertEquals("Map element at Element0 is identical as", value, newMap.getAt("Element0"));
	}
}
