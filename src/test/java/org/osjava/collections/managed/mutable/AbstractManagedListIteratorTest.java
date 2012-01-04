package org.osjava.collections.managed.mutable;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.osjava.collections.managed.ManagedBinding;
import org.osjava.collections.managed.ManagedCollection;
import org.osjava.collections.managed.ManagedObject;
import org.osjava.collections.managed.common.ManagedInteger;
import org.osjava.collections.managed.common.ManagedIntegerFactory;

public class AbstractManagedListIteratorTest {

	private List<ManagedBinding<ManagedObject<?>>> _list;

	@Before
	public void setUp() {
		_list = new ArrayList<ManagedBinding<ManagedObject<?>>>();
	}

	@After
	public void tearDown() {
		_list.removeAll(_list);
	}

	@Test
	public void create_iterator_using_newInstance_is_not_null() {
		AbstractManagedListIterator<ManagedObject<?>> iterator =
				AbstractManagedListIterator
						.newInstance(new ArrayList<ManagedBinding<ManagedObject<?>>>());
		Assert.assertNotNull(iterator);
	}

	@Test
	public void verify_num_items_in_iterable_is_1() {
		int total = 1;
		assertEquals(total, countIterators(total));
	}

	@Test
	public void verify_num_items_in_iterable_is_2() {
		int total = 2;
		assertEquals(total, countIterators(total));
	}

	@Test
	public void verify_num_items_in_iterable_is_10() {
		int total = 10;
		assertEquals(total, countIterators(total));
	}

	@Test
	public void verify_num_items_in_iterable_is_100() {
		int total = 100;
		assertEquals(total, countIterators(total));
	}

	private int countIterators(final int total) {
		populateList(total);

		AbstractManagedListIterator<ManagedObject<?>> iterator =
				AbstractManagedListIterator.newInstance(_list);

		int count = 0;
		while (iterator.hasNext()) {
			ManagedObject<?> managedObject = iterator.next();
			if (null != managedObject)
				count++;
		}

		return count;
	}

	private void populateList(int numItems) {
		final ManagedIntegerFactory factory = new ManagedIntegerFactory();
		final ManagedCollection<ManagedInteger> managedCollection =
				ManagedArrayList.newInstance(factory);

		for (int i = 0; i < numItems; i++) {
			final ManagedBinding<ManagedObject<?>> binding =
					new ManagedBinding<ManagedObject<?>>() {

						private ManagedObject<?> _managedObject;

						private ManagedCollection<ManagedObject<?>> _managedCollection;

						@Override
						public ManagedCollection<ManagedObject<?>> getCollection() {
							return _managedCollection;
						}

						@Override
						public Boolean isEmpty() {
							return null == _managedObject;
						}

						@Override
						public ManagedObject<?> getManagedObject() {
							return _managedObject;
						}

						@Override
						public void setManagedObject(ManagedObject<?> value) {
							_managedObject = value;
						}
					};

			binding.setManagedObject(factory.create(managedCollection));
			_list.add(binding);
		}

		assertEquals(numItems, _list.size());
	}
}
