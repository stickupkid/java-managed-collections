package org.osjava.collections.managed.mutable;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.osjava.collections.managed.ManagedCollection;
import org.osjava.collections.managed.ManagedFactory;
import org.osjava.collections.managed.ManagedObject;
import org.osjava.collections.managed.common.ManagedInteger;

public class ManagedFactoryTest {

	private ManagedFactory<ManagedInteger> factory;

	private ManagedCollection<ManagedInteger> collection;

	@Before
	public void setUp() {
		factory = new ManagedFactory<ManagedInteger>() {
			private int counter = 0;

			@SuppressWarnings("unchecked")
			public <E extends ManagedObject<?>> ManagedInteger create(
					ManagedCollection<E> collection) {
				final ManagedInteger managed =
						new ManagedInteger((ManagedCollection<ManagedObject<Integer>>) collection);
				managed.setValue(counter++);
				return managed;
			}
		};
		collection = ManagedArrayList.newInstance(factory);
	}

	@After
	public void tearDown() {
		factory = null;
		collection = null;
	}

	@Test
	public void test_integer_is_created_on_create() {
		assertTrue("Create creates an ManagedInteger",
				factory.create(collection) instanceof ManagedInteger);
	}

	@Test
	public void create_creates_unique_Integers() {
		final List<ManagedInteger> list = new ArrayList<ManagedInteger>();
		for (int i = 0; i < 100; i++) {
			list.add(factory.create(collection));
		}

		Boolean uniqueList = true;
		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < list.size(); j++) {
				if (i != j) {
					if (list.get(i).getValue().equals(list.get(j).getValue())) {
						uniqueList = false;
						fail("Items should be unique");
					}
				}
			}
		}

		assertTrue("Items are unique integers", uniqueList);
	}
}
