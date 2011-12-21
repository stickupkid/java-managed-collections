package org.osjava.collections.managed;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Test;

public class ManagedMapBase {

	protected ManagedMap<String, ManagedObject<Integer>> map;

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
		final ManagedObject<Integer> managedObject = map.retrieve();
		managedObject.setValue(1);

		final ManagedMap<String, ManagedObject<Integer>> newMap =
				map.put("Element0", managedObject);

		assertEquals("Map is one", 1, newMap.size());
	}

	@Test
	public void getting_one_element_should_be_the_same_as_inserted_element() {
		final ManagedObject<Integer> managedObject = map.retrieve();
		managedObject.setValue(1);

		final ManagedMap<String, ManagedObject<Integer>> newList =
				map.put("Element0", managedObject);

		assertEquals("Map element at Element0 is identical as", managedObject,
				newList.getAt("Element0"));
	}
}
