package adt.queue;

import adt.stack.Stack;
import adt.stack.StackImpl;
import adt.stack.StackOverflowException;
import adt.stack.StackUnderflowException;

public class QueueUsingStack<T> implements Queue<T> {

	private Stack<T> stack1;
	private Stack<T> stack2;

	public QueueUsingStack(int size) {
		stack1 = new StackImpl<T>(size);
		stack2 = new StackImpl<T>(size);
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if (this.isFull())
			throw new QueueOverflowException();
		try {
			if (element != null)
				this.stack1.push(element);
		} catch (StackOverflowException e) {
			throw new QueueOverflowException();
		}
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		T dequeue = null;
		if (this.isEmpty())
			throw new QueueUnderflowException();
		try {
			if (this.stack2.isEmpty()) {
				while (!this.stack1.isEmpty()) {
					dequeue = this.stack1.pop();
					this.stack2.push(dequeue);
				}
			}
			dequeue = this.stack2.top();
			this.stack2.pop();
		} catch (StackUnderflowException | StackOverflowException e) {

		}
		return dequeue;
	}

	@Override
	public T head() {
		T head = null;
		if (this.stack2.isEmpty()) {
			try {
				while (!this.stack1.isEmpty()) {
					this.stack2.push(this.stack1.top());
					this.stack1.pop();
				}
				head = this.stack2.top();
			} catch (StackOverflowException | StackUnderflowException e) {

			}
		}
		return head;
	}

	@Override
	public boolean isEmpty() {
		return this.stack1.isEmpty() && this.stack2.isEmpty();
	}

	@Override
	public boolean isFull() {
		return this.stack1.isFull() || this.stack2.isFull();
	}

}
