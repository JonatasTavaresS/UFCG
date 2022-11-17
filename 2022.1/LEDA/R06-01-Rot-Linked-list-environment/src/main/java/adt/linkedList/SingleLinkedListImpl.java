package adt.linkedList;

public class SingleLinkedListImpl<T> implements LinkedList<T> {

	protected SingleLinkedListNode<T> head;

	public SingleLinkedListImpl() {
		this.head = new SingleLinkedListNode<T>();
	}

	@Override
	public boolean isEmpty() {
		return this.getHead().isNIL();
	}

	@Override
	public int size() {
		int size = 0;
		if (!this.isEmpty()) {
			SingleLinkedListNode<T> aux = this.getHead();
			while (!aux.isNIL()) {
				aux = aux.getNext();
				size++;
			}
		}
		return size;
	}

	@Override
	public T search(T element) {
		T search = null;
		if (!this.isEmpty() && element != null) {
			SingleLinkedListNode<T> aux = this.getHead();
			while (!aux.isNIL() && !aux.getData().equals(element)) {
				aux = aux.getNext();
			}
			if (!aux.isNIL()) {
				search = aux.getData();
			}
		}
		return search;
	}

	@Override
	public void insert(T element) {
		if (element != null) {
			SingleLinkedListNode<T> aux = this.getHead();
			while (!aux.isNIL()) {
				aux = aux.getNext();
			}
			aux.setData(element);
			aux.setNext(new SingleLinkedListNode<>());
		}
	}

	@Override
	public void remove(T element) {
		if (!this.isEmpty() && element != null) {
			SingleLinkedListNode<T> aux = this.getHead();
			while (!aux.isNIL() && !aux.getData().equals(element)) {
				aux = aux.getNext();
			}
			if (!aux.isNIL()) {
				aux.setData(aux.getNext().getData());
				aux.setNext(aux.getNext().getNext());
			}
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public T[] toArray() {
		T[] array = (T[]) new Comparable[this.size()];
		int i = 0;
		SingleLinkedListNode<T> aux = this.getHead();
		while (!aux.isNIL()) {
			array[i++] = aux.getData();
			aux = aux.getNext();
		}
		return array;
	}

	public SingleLinkedListNode<T> getHead() {
		return head;
	}

	public void setHead(SingleLinkedListNode<T> head) {
		this.head = head;
	}

}
