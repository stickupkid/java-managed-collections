package org.osjava.collections.managed;

import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Test;
import org.osjava.collections.managed.common.ManagedInteger;

public class ManagedListRemoveBase {

	protected ManagedList<ManagedInteger> list;

	@After
	public void tearDown() {
		list = null;
	}

	@Test
	public void size_is_zero_when_created() {
		assertNotNull(list.remove(null));
	}
}
