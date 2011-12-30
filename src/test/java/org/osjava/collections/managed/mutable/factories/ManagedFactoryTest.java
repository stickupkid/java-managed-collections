package org.osjava.collections.managed.mutable.factories;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.osjava.collections.managed.ManagedFactory;

public class ManagedFactoryTest {

	private ManagedFactory<Integer> factory;

	@Before
	public void setUp() {
		factory = new ManagedFactory<Integer>() {
			private int counter = 0;

			@Override
			public Integer create() {
				return new Integer(counter++);
			}
		};
	}

	@After
	public void tearDown() {
		factory = null;
	}

	@Test
	public void test_integer_is_created_on_create() {
		assertTrue("Create creates an Integer", factory.create() instanceof Integer);
	}

	@Test
	public void create_creates_unique_Integers() {
		final List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < 100; i++) {
			list.add(factory.create());
		}

		Boolean uniqueList = true;
		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < list.size(); j++) {
				if (i != j) {
					if (list.get(i).equals(list.get(j))) {
						uniqueList = false;
						fail("Items should be unique");
					}
				}
			}
		}

		assertTrue("Items are unique integers", uniqueList);
	}
}
