package adt.linkedList;

public class RecursiveDoubleLinkedListImpl<T> extends
		RecursiveSingleLinkedListImpl<T> implements DoubleLinkedList<T> {

	protected RecursiveDoubleLinkedListImpl<T> previous;

	public RecursiveDoubleLinkedListImpl() {

	}

	@Override
	public void insertFirst(T element) {
		if (element != null) {
			if (this.isEmpty()) {
				this.insert(element);
			} else {
				RecursiveDoubleLinkedListImpl<T> aux = new RecursiveDoubleLinkedListImpl<>();
				aux.setData(this.getData());
				aux.setNext(this.getNext());
				aux.setPrevious(new RecursiveDoubleLinkedListImpl<>());
				this.setData(element);
				((RecursiveDoubleLinkedListImpl<T>) this.getNext()).setPrevious(aux);
				this.setNext(aux);
				aux.setPrevious(this);
			}
		}
	}

	@Override
	public void removeFirst() {
		if (!this.isEmpty()) {
			if (this.getNext().isEmpty() && this.getPrevious().isEmpty()) {
				this.setData(null);
				this.setNext(null);
				this.setPrevious(null);
			} else {
				this.setData(this.next.getData());
				this.setNext(this.next.getNext());
				((RecursiveDoubleLinkedListImpl<T>) this.getNext()).setPrevious(this);
			}
		}
	}

	@Override
	public void removeLast() {
		if (!this.isEmpty()) {
			if (this.getNext().isEmpty()) {
				this.setData(null);
				this.setNext(null);
				if (this.getPrevious().isEmpty()) {
					this.setPrevious(null);
				}
			} else {
				((RecursiveDoubleLinkedListImpl<T>) this.getNext()).removeLast();
			}
		}
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
