package org.osjava.collections.managed.mutable;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.osjava.collections.managed.ManagedBinding;
import org.osjava.collections.managed.ManagedCollection;
import org.osjava.collections.managed.ManagedFactory;

public class ManagedFactoryTest {

	private static int ID = 0;

	private ManagedFactory<Integer> factory;

	private ManagedCollection<Integer> collection;

	@Before
	public void setUp() {
		collection = ManagedArrayList.newInstance();
		factory = new ManagedFactory<Integer>() {

			@Override
			public ManagedBinding<Integer> create() {
				return new ManagedBinding<Integer>() {

					private Integer _value = ID++;

					@Override
					public Boolean isEmpty() {
						return null == _value;
					}

					@Override
					public ManagedCollection<Integer> getCollection() {
						return collection;
					}

					@Override
					public Integer getValue() {
						return _value;
					}

					@Override
					public void setValue(Integer value) {
						_value = value;
					}

				};
			}
		};
	}

	@After
	public void tearDown() {
		factory = null;
		collection = null;
	}

	@Test
	public void test_integer_is_created_on_create() {
		assertTrue("Create creates an ManagedBinding", factory.create() instanceof ManagedBinding);
	}

	@Test
	public void create_creates_unique_Integers() {
		final List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < 100; i++) {
			list.add(factory.create().getValue());
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
