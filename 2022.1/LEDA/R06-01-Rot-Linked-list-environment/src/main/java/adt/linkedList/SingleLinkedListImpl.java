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
			SingleLinkedListNode<T> auxHead = this.getHead();
			while (!auxHead.isNIL()) {
				size++;
				auxHead = auxHead.getNext();
			}
		}
		return size;
	}

	@Override
	public T search(T element) {
		T search = null;
		SingleLinkedListNode<T> auxHead = this.getHead();
		if (!this.isEmpty() && element != null) {
			while (!auxHead.isNIL() && !auxHead.getData().equals(element)) {
				auxHead = auxHead.getNext();
			}
			search = auxHead.getData();
		}
		return search;
	}

	@Override
	public void insert(T element) {
		if (element != null) {
			SingleLinkedListNode<T> auxHead = this.getHead();
			if (this.isEmpty()) {
				SingleLinkedListNode<T> newHead = new SingleLinkedListNode<>(element, this.getHead());
				this.setHead(newHead);
			} else {
				while (!auxHead.isNIL()) {
					auxHead = auxHead.getNext();
				}
				auxHead.setData(element);
				auxHead.setNext(new SingleLinkedListNode<>());
			}
		}
	}

	@Override
	public void remove(T element) {
		if (!this.isEmpty() && element != null) {
			if (this.getHead().getData().equals(element)) {
				this.setHead(this.getHead().getNext());
			} else {
				SingleLinkedListNode<T> auxHead = this.getHead();
				while (!auxHead.isNIL() && !auxHead.getData().equals(element)) {
					auxHead = auxHead.getNext();
				}
				if (!auxHead.isNIL()) {
					auxHead.setData(auxHead.getNext().getData());
					auxHead.setNext(auxHead.getNext().getNext());
				}
			}
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public T[] toArray() {
		T[] array = (T[]) new Comparable[this.size()];
		int i = 0;
		SingleLinkedListNode<T> auxHead = this.getHead();
		while (!auxHead.isNIL()) {
			array[i++] = auxHead.getData();
			auxHead = auxHead.getNext();
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
