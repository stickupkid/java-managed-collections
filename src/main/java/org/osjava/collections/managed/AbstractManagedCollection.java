package org.osjava.collections.managed;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.osjava.collections.managed.generic.GenericManagedBindingFactory;
import org.osjava.collections.managed.generic.GenericManagedGC;
import org.osjava.collections.managed.generic.GenericManagedPool;

public abstract class AbstractManagedCollection<E extends ManagedObject<?>> implements
		ManagedCollection<E> {

	private final ManagedFactory<ManagedBinding<E>> bindingFactory = GenericManagedBindingFactory
			.newInstance(this);

	protected final ManagedGC<E> managedObjectGC = GenericManagedGC.newInstance();

	protected final ManagedGC<ManagedBinding<E>> managedBindingGC = GenericManagedGC.newInstance();

	protected final ManagedPool<E, E, ManagedFactory<E>> managedObjectPool;

	protected final ManagedPool<E, ManagedBinding<E>, ManagedFactory<ManagedBinding<E>>> bindingPool;

	public AbstractManagedCollection(ManagedFactory<E> factory) {
		managedObjectGC.onRemoveListener(new ManagedObjectRemoveListener<E>());
		managedBindingGC.onRemoveListener(new ManagedBindingRemoveListener<ManagedBinding<E>>());

		bindingPool = GenericManagedPool.newInstance(this, managedBindingGC, bindingFactory);
		managedObjectPool = GenericManagedPool.newInstance(this, managedObjectGC, factory);
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

	public void release(E value) {
		final ManagedIterator<ManagedBinding<E>> iterator = managedBindingGC.iterator();
		while (iterator.hasNext()) {
			final ManagedBinding<E> binding = iterator.next();
			if (binding.getManagedObject().equals(value)) {
				mark(binding);
				break;
			}
		}
	}

	protected void mark(ManagedBinding<E> binding) {
		managedBindingGC.mark(binding);
	}

	protected void unmark(ManagedBinding<E> binding) {
		managedBindingGC.unmark(binding);
	}

	@Override
	public int hashCode() {
		int hash = 1;

		ManagedIterator<E> iter = iterator();
		while (iter.hasNext()) {
			E item = iter.next();
			hash = hash * 31 + item.hashCode();
		}

		return hash;
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
