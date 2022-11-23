package adt.linkedList;

public class RecursiveDoubleLinkedListImpl<T> extends
		RecursiveSingleLinkedListImpl<T> implements DoubleLinkedList<T> {

	protected RecursiveDoubleLinkedListImpl<T> previous;

	public RecursiveDoubleLinkedListImpl() {

	}

	@Override
	public void insertFirst(T element) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public void removeFirst() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public void removeLast() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public void insert(T element) {
		if (element != null) {
			if (this.isEmpty()) {
				this.setData(element);
				this.setNext(new RecursiveDoubleLinkedListImpl<T>());
				if (this.getPrevious() == null) {
					this.setPrevious(new RecursiveDoubleLinkedListImpl<T>());
				}
			} else {
				this.getNext().insert(element);
			}
		}
	}

	@Override
	public void remove(T element) {
		if (!this.isEmpty() && element != null) {
			if (this.getData().equals(element)) {
				if (this.getPrevious().isEmpty() && this.getNext().isEmpty()) {
					this.setData(null);
					this.setNext(null);
					this.setPrevious(null);
				} else {
					this.setData(this.getNext().getData());
					this.setNext(this.getNext().getNext());
					if (this.getNext() != null) {
						((RecursiveDoubleLinkedListImpl<T>) this.getNext()).setPrevious(this);
					}
				}
			} else {
				this.getNext().remove(element);
			}
		}
	}

	public RecursiveDoubleLinkedListImpl<T> getPrevious() {
		return previous;
	}

	public void setPrevious(RecursiveDoubleLinkedListImpl<T> previous) {
		this.previous = previous;
	}

}
