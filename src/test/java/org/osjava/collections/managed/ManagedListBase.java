package org.osjava.collections.managed;

import static org.junit.Assert.assertEquals;
import junit.framework.Assert;

import org.junit.After;
import org.junit.Test;
import org.osjava.collections.managed.common.ManagedInteger;

public class ManagedListBase {

	protected ManagedList<ManagedInteger> list;

	@After
	public void tearDown() {
		list = null;
	}

	@Test
	public void size_is_zero_when_created() {
		assertEquals("List is zero", 0, list.size());
	}

	@Test
	public void retrieve_list_element_with_valid_parameter_should_not_throw_exception()
			throws IllegalArgumentException {
		final Integer value = 1;
		final ManagedInteger managedObject = list.retrieve(value);

		assertEquals(value, managedObject.getValue());
	}

	@Test
	public void getting_one_element_should_be_the_same_as_inserted_element() {
		final ManagedInteger managedObject = list.retrieve();
		managedObject.setValue(1);

		final ManagedList<ManagedInteger> newList = list.add(managedObject);

		assertEquals("List element at 0 is identical as", managedObject, newList.getAt(0));
	}

	@Test(expected = IllegalArgumentException.class)
	public void retrieve_list_element_with_invalid_parameter_should_not_throw_exception()
			throws IllegalArgumentException {
		final ManagedInteger managedObject = list.retrieve("Invalid");

		if (null != managedObject.getValue()) {
			Assert.fail("This should fail with invalid IllegalArgumentException");
		}
	}
}
