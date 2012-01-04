package org.osjava.collections.managed;

import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Test;

public class ManagedListRemoveBase {

	protected ManagedList<ManagedObject<Integer>> list;

	@After
	public void tearDown() {
		list = null;
	}

	@Test
	public void size_is_zero_when_created() {
		assertNotNull(list.remove(null));
	}
}
