package org.osjava.collections.managed;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.osjava.collections.managed.generic.GenericManagedBindingFactory;
import org.osjava.collections.managed.generic.GenericManagedCollectionGC;
import org.osjava.collections.managed.generic.GenericManagedCollectionInspector;
import org.osjava.collections.managed.generic.GenericManagedGC;
import org.osjava.collections.managed.generic.GenericManagedPool;

public abstract class AbstractManagedCollection<E extends ManagedObject<?>> implements
		ManagedCollection<E> {

	private final ManagedFactory<ManagedBinding<E>> _bindingFactory = GenericManagedBindingFactory
			.newInstance();

	private final ManagedCollectionInspector<E> _inspector;

	protected final ManagedGC<E> managedObjectGC = GenericManagedGC.newInstance();

	protected final ManagedGC<ManagedBinding<E>> managedBindingGC = GenericManagedGC.newInstance();

	protected final ManagedPool<E, E, ManagedFactory<E>> managedObjectPool;

	protected final ManagedPool<E, ManagedBinding<E>, ManagedFactory<ManagedBinding<E>>> bindingPool;

	private static final ManagedCollectionGC gc = GenericManagedCollectionGC.newInstance();

	public AbstractManagedCollection(ManagedFactory<E> factory) {
		managedObjectGC.onRemoveListener(new ManagedObjectRemoveListener<E>());
		managedBindingGC.onRemoveListener(new ManagedBindingRemoveListener<ManagedBinding<E>>());

		bindingPool =
				GenericManagedPool.newInstance(this, managedBindingGC, _bindingFactory, false);
		managedObjectPool = GenericManagedPool.newInstance(this, managedObjectGC, factory, false);

		gc.addManagedObjectGC(managedObjectGC);
		gc.addManagedBindingGC(managedBindingGC);

		_inspector =
				GenericManagedCollectionInspector.newInstance(bindingPool, managedBindingGC,
						managedObjectPool, managedObjectGC);
	}

	public E retrieve() {
		return managedObjectPool.retain();
	}

	public <T> E retrieve(T value) throws IllegalArgumentException {
		E managedObject = retrieve();

		final Method[] methods = managedObject.getClass().getMethods();
		for (final Method method : methods) {
			if (method.getName().equals("setValue")) {
				final Class<?>[] parameters = method.getParameterTypes();
				if (parameters.length == 1) {

					if (!method.isAccessible())
						method.setAccessible(true);

					try {
						final Object[] params = { value };
						method.invoke(managedObject, params);
					} catch (IllegalAccessException e) {
						managedObject = null;
					} catch (InvocationTargetException e) {
						managedObject = null;
					}

					break;
				}
			}

		}

		return managedObject;
	}

	public synchronized void release(E value) {
		final ManagedIterator<ManagedBinding<E>> iterator = managedBindingGC.iterator();
		while (iterator.hasNext()) {
			final ManagedBinding<E> binding = iterator.next();
			if (binding.getManagedObject().equals(value)) {
				mark(binding);
				break;
			}
		}
	}

	protected final void mark(ManagedBinding<E> binding) {
		managedBindingGC.mark(binding);
	}

	protected final void unmark(ManagedBinding<E> binding) {
		managedBindingGC.unmark(binding);
	}

	@Override
	public int hashCode() {
		int hash = 17;

		ManagedIterator<E> iter = iterator();
		while (iter.hasNext()) {
			E item = iter.next();
			hash *= 31 + item.hashCode();
		}

		return hash;
	}

	@Override
	public ManagedCollectionInspector<E> inspector() {
		return _inspector;
	}

	private class ManagedObjectRemoveListener<T extends E> implements ManagedGCRemoveListener<T> {

		@Override
		public void onRemove(T item) {
			managedObjectPool.release(item);
		}
	}

	private class ManagedBindingRemoveListener<T extends ManagedBinding<E>> implements
			ManagedGCRemoveListener<T> {

		@Override
		public void onRemove(T item) {
			if (!item.isEmpty()) {
				managedObjectGC.mark(item.getManagedObject());
			}

			bindingPool.release(item);
		}
	}
}
