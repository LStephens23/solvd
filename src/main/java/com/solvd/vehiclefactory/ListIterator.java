package main.java.com.solvd.vehiclefactory;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ListIterator<T> implements Iterator<T> {
	private Node<T> current;

	public ListIterator(Node<T> head) {
		this.current = head;
	}

	@Override
	public boolean hasNext() {
		return current != null;
	}

	@Override
	public T next() {
		if (!hasNext()) {
			throw new NoSuchElementException();
		}
		T data = current.getData();
		current = current.getNext();
		return data;
	}

	public Node<T> getCurrent() {
		return current;
	}

	public void setCurrent(Node<T> current) {
		this.current = current;
	}

}
