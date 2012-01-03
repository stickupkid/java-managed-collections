package org.osjava.collections.managed;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import junit.framework.Assert;

import org.junit.After;
import org.junit.Test;

public class ManagedListBase {

	protected ManagedList<ManagedObject<Integer>> list;

	@After
	public void tearDown() {
		list = null;
	}

	@Test
	public void size_is_zero_when_created() {
		assertEquals("List is zero", 0, list.size());
	}

	@Test
	public void adding_one_element_should_have_size_of_one() {
		final ManagedObject<Integer> managedObject = list.retrieve();
		managedObject.setValue(1);

		final ManagedList<ManagedObject<Integer>> newList = list.add(managedObject);

		assertEquals("List is one", 1, newList.size());
	}

	@Test
	public void getting_one_element_should_be_the_same_as_inserted_element() {
		final ManagedObject<Integer> managedObject = list.retrieve();
		managedObject.setValue(1);

		final ManagedList<ManagedObject<Integer>> newList = list.add(managedObject);

		assertEquals("List element at 0 is identical as", managedObject, newList.getAt(0));
	}

	@Test
	public void retrieve_list_element_with_valid_parameter_should_not_throw_exception()
			throws IllegalArgumentException {
		final Integer value = 1;
		final ManagedObject<Integer> managedObject = list.retrieve(value);

		assertEquals(value, managedObject.getValue());
	}

	@Test(expected = IllegalArgumentException.class)
	public void retrieve_list_element_with_invalid_parameter_should_not_throw_exception()
			throws IllegalArgumentException {
		final ManagedObject<Integer> managedObject = list.retrieve("Invalid");

		if (null != managedObject.getValue()) {
			Assert.fail("This should fail with invalid IllegalArgumentException");
		}
	}

	@Test
	public void list_should_equal_self() {
		assertTrue(list.equals(list));
	}
}
