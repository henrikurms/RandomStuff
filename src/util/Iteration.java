package util;

import java.util.Iterator;

public class Iteration<T> implements Iterable<T>{

	private Iterator<? extends T> iterator;

	public Iteration(Iterable<? extends T> iteration) {
		this.iterator = iteration.iterator();
	}

	public Iterator<T> iterator() {
		return new Iterator<T>() {

			public boolean hasNext() {
				return iterator.hasNext();
			}

			public T next() {
				return iterator.next();
			}

			public void remove() {
				iterator.remove();
			}
		};
	}

}
