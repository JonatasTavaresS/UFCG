package adt.linkedList;

public class RecursiveSingleLinkedListImpl<T> implements LinkedList<T> {

	protected T data;
	protected RecursiveSingleLinkedListImpl<T> next;

	public RecursiveSingleLinkedListImpl() {

	}

	@Override
	public boolean isEmpty() {
		boolean isEmpty = false;
		if (this.getData() == null) {
			isEmpty = true;
		}
		return isEmpty;
	}

	@Override
	public int size() {
		int size = 0;
		if (!this.isEmpty()) {
			size = 1 + this.getNext().size();
		}
		return size;
	}

	@Override
	public T search(T element) {
		T search = null;
		if (!this.isEmpty() && element != null) {
			if (this.getData().equals(element)) {
				search = this.getData();
			} else {
				search = this.getNext().search(element);
			}
		}
		return search;
	}

	@Override
	public void insert(T element) {
		if (element != null) {
			if (this.isEmpty()) {
				this.setData(element);
				this.setNext(new RecursiveSingleLinkedListImpl<T>());
			} else {
				this.getNext().insert(element);
			}
		}
	}

	@Override
	public void remove(T element) {
		if (!this.isEmpty() && element != null) {
			if (this.getData().equals(element)) {
				this.setData(this.getNext().getData());
				this.setNext(this.getNext().getNext());
			} else {
				this.getNext().remove(element);
			}
		}
	}

	@Override
	public T[] toArray() {
		// FIXME
		//T[] toArray = new java.util.LinkedList<T>();
		//toArray(toArray, this);
		//return (T[]) toArray;
		return null;
	}

	private void toArray(java.util.LinkedList<T> list, RecursiveSingleLinkedListImpl<T> node) {
		if (!node.isEmpty()) {
			list.add(node.getData());
			toArray(list, node.getNext());
		}
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public RecursiveSingleLinkedListImpl<T> getNext() {
		return next;
	}

	public void setNext(RecursiveSingleLinkedListImpl<T> next) {
		this.next = next;
	}

}
