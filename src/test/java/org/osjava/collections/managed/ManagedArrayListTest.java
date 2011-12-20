package org.osjava.collections.managed;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.osjava.collections.managed.mutable.ManagedArrayList;

public class ManagedArrayListTest {

	private ManagedList<ManagedObject<Integer>> list;

	@Before
	public void setUp() {
		list = ManagedArrayList.newInstance();
	}

	@After
	public void tearDown() {
		list = null;
	}

	@Test
	public void size_is_zero_when_created() {
		assertEquals("List is zero", 0, list.size());
	}
}
