package main.java.com.solvd.vehiclefactory;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

import org.apache.logging.log4j.*;

public class LinkedList<T> implements Iterable<T>{

	private static Logger logger = LogManager.getLogger(Runner.class.getName());
	private Node<T> head;
	private int size;

	LinkedList() {
		this.head = null;
		this.size = 0;
	}

	// Add Node at end of LinkedList
	public void add(T data){

		Node<T> temp = new Node<>(data);

		if (this.head == null) {
			head = temp;
		}
		else {
			Node<T> x = head;
			while (x.getNext() != null) {
				x = x.getNext();
			}
			x.setNext(temp);
		}
		size++;
	}

	// Add Node at particular position
	public void add(int position, T data){

		if (position > size + 1) {
			logger.warn("Position Unavailable in LinkedList");
			return;
		}

		if (position == 1) {
			Node<T> temp = head;
			head = new Node<T>(data);
			head = head.getNext();
			head = temp;
			return;
		}
		Node<T> temp = head;
		Node<T> prev = new Node<T>(null);
		while (position - 1 > 0) {
			prev = temp;
			temp = temp.getNext();
			position--;
		}
		prev = prev.getNext();
		prev = new Node<T>(data);
		prev = prev.getNext().getNext();
		prev = temp;
	}

	public void clear() {
		head = null;
		size = 0;
	}

	public boolean isEmpty(){

		return size == 0;
	}


	public int getSize() {
		return size;
	}


	public void setSize(int size) {
		this.size = size;
	}


	public String toString() {

		String S = "{ ";
		Node<T> X = head;

		if (X == null)
			return S + " }";

		while (X.getNext() != null) {
			S += String.valueOf(X.getData()) + " -> ";
			X = X.getNext();
		}

		S += String.valueOf(X.getData());
		return S + " }";
	}



	public void remove(Object key) {
		Node<T> prev = new Node<>(null);
		prev = prev.getNext();
		prev = head;
		Node<T> next = head.getNext();
		Node<T> temp = head;
		boolean exists = false;
		if (head.getData() == key) {
			head = head.getNext();
			exists = true;
		}
		while (temp.getNext() != null) {
			if (String.valueOf(temp.getData()).equals(
					String.valueOf(key))) {
				prev = prev.getNext();
				prev = next;
				exists = true;
				break;
			}

			prev = temp;
			temp = temp.getNext();
			next = temp.getNext();
		}

		if (exists == false
				&& String.valueOf(temp.getData()).equals(
						String.valueOf(key))) {
			prev = prev.getNext();
			prev = null;
			exists = true;
		}

		if (exists) {
			size--;
		} else {
			logger.warn("Given Value is not present in linked list");
		}
	}

	public void foreach(Consumer<T> consumer) {
		Node<T> current = head;
		while (current != null) {
			consumer.accept(current.getData());
			current = current.getNext();
		}
	}


	@Override
	public Iterator<T> iterator() {
		return new ListIterator(head);
	}

	public Node<T> getHead() {
		return head;
	}

	public void setHead(Node<T> head) {
		this.head = head;
	}


}


