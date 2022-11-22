package adt.linkedList;

public class DoubleLinkedListImpl<T> extends SingleLinkedListImpl<T> implements
		DoubleLinkedList<T> {

	protected DoubleLinkedListNode<T> last;

	public DoubleLinkedListImpl() {
		this.last = new DoubleLinkedListNode<T>();
		this.head = this.last;
	}

	@Override
	public void insertFirst(T element) {
		if (element != null) {
			DoubleLinkedListNode<T> newHead = new DoubleLinkedListNode<T>(element,
					(DoubleLinkedListNode<T>) this.getHead(), new DoubleLinkedListNode<>());
			((DoubleLinkedListNode<T>) this.getHead()).setPrevious(newHead);
			if (this.getHead().isNIL()) {
				this.setLast(newHead);
			}
			this.setHead(newHead);
		}
	}

	@Override
	public void removeFirst() {
		if (!this.getHead().isNIL()) {
			this.setHead(this.getHead().getNext());
			if (this.getHead().isNIL()) {
				this.setLast((DoubleLinkedListNode<T>) this.getHead());
			} else {
				((DoubleLinkedListNode<T>) this.getHead()).setPrevious(new DoubleLinkedListNode<>());
			}
		}
	}

	@Override
	public void removeLast() {
		if (!this.getLast().isNIL()) {
			this.setLast(this.getLast().getPrevious());
			if (this.getLast().isNIL()) {
				this.setHead(this.getLast());
			} else {
				this.getLast().setNext(new DoubleLinkedListNode<>());
			}
		}
	}

	@Override
	public T search(T element) {
		T search = null;
		if (!this.isEmpty() && element != null) {
			DoubleLinkedListNode<T> auxHead = (DoubleLinkedListNode<T>) this.getHead();
			DoubleLinkedListNode<T> auxLast = this.getLast();
			while (!auxHead.equals(auxLast) && !auxHead.getNext().equals(auxLast) && !auxHead.getData().equals(element)
					&& !auxLast.getData().equals(element)) {
				auxHead = (DoubleLinkedListNode<T>) auxHead.getNext();
				auxLast = auxLast.getPrevious();
			}
			if (auxHead.getData().equals(element)) {
				search = auxHead.getData();
			}
			if (auxLast.getData().equals(element)) {
				search = auxLast.getData();
			}
		}
		return search;
	}

	@Override
	public void insert(T element) {
		if (element != null) {
			DoubleLinkedListNode<T> newLast = new DoubleLinkedListNode<T>(element, this.getLast(),
					new DoubleLinkedListNode<>());
			this.getLast().setNext(newLast);
			if (this.getLast().isNIL()) {
				this.setHead(newLast);
			}
			this.setLast(newLast);
		}
	}

	@Override
	public void remove(T element) {
		if (!this.isEmpty() || element != null) {
			if (this.head.getData().equals(element)) {
				this.removeFirst();
			} else {
				DoubleLinkedListNode<T> aux = (DoubleLinkedListNode<T>) this.getHead();
				while (!aux.isNIL() && !aux.getData().equals(element)) {
					aux = (DoubleLinkedListNode<T>) aux.getNext();
				}
				if (!aux.isNIL()) {
					aux.getPrevious().setNext(aux.getNext());
					((DoubleLinkedListNode<T>) aux.getNext()).setPrevious(aux.getPrevious());
				}
			}
		}
	}

	public DoubleLinkedListNode<T> getLast() {
		return last;
	}

	public void setLast(DoubleLinkedListNode<T> last) {
		this.last = last;
	}

}
