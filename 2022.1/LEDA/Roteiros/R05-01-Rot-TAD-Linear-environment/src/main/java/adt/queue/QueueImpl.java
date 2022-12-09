package adt.queue;

/**
 * @author Jônatas Tavares dos Santos - 121110769
 */
public class QueueImpl<T> implements Queue<T> {

	private T[] array;
	private int tail;

	@SuppressWarnings("unchecked")
	public QueueImpl(int size) {
		array = (T[]) new Object[size];
		tail = -1;
	}

	@Override
	public T head() {
		T head = null;
		if (!this.isEmpty())
			head = this.array[0];
		return head;
	}

	@Override
	public boolean isEmpty() {
		return this.tail == -1;
	}

	@Override
	public boolean isFull() {
		return this.tail == this.array.length - 1;
	}

	private void shiftLeft() {
		for (int i = 0; i < this.tail; i++)
			this.array[i] = this.array[i + 1];
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if (this.isFull())
			throw new QueueOverflowException();
		if (element != null)
			this.array[++this.tail] = element;
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		if (this.isEmpty())
			throw new QueueUnderflowException();
		T dequeue = this.array[0];
		this.shiftLeft();
		this.tail--;
		return dequeue;
	}

}
