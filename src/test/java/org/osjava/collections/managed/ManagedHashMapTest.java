package org.osjava.collections.managed;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.osjava.collections.managed.mutable.ManagedHashMap;

public class ManagedHashMapTest {

	private ManagedMap<String, ManagedObject<Integer>> map;

	@Before
	public void setUp() {
		map = ManagedHashMap.newInstance();
	}

	@After
	public void tearDown() {
		map = null;
	}

	@Test
	public void size_is_zero_when_created() {
		assertEquals("Map is zero", 0, map.size());
	}
}
