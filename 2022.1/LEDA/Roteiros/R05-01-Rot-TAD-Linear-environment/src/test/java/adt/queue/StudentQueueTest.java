package adt.queue;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class StudentQueueTest {

	public Queue<Integer> queue1;
	public Queue<Integer> queue2;
	public Queue<Integer> queue3;

	@Before
	public void setUp() throws QueueOverflowException {

		getImplementations();

		// Fila com 3 elementos não cheia.
		queue1.enqueue(1);
		queue1.enqueue(2);
		queue1.enqueue(3);

		// Fila com 2 elementos de tamanho 2. Fila cheia.
		queue2.enqueue(1);
		queue2.enqueue(2);

	}

	private void getImplementations() {
		// O aluno deve ajustar aqui para instanciar sua implementação
		queue1 = new QueueUsingStack<>(4);
		queue2 = new QueueUsingStack<>(2);
		queue3 = new QueueUsingStack<>(0);
	}

	// MÉTODOS DE TESTE
	@Test
	public void testHead() {
		assertEquals((Integer) 1, queue1.head());
		assertNull(queue3.head());
	}

	@Test
	public void testIsEmpty() {
		assertFalse(queue1.isEmpty());
		assertTrue(queue3.isEmpty());
	}

	@Test
	public void testIsFull() {
		assertFalse(queue1.isFull());
		assertTrue(queue2.isFull());
	}

	@Test
	public void testEnqueue() {
		try {
			queue1.enqueue((Integer) 5);
		} catch (QueueOverflowException e) {
			e.printStackTrace();
		}
	}

	@Test(expected = QueueOverflowException.class)
	public void testEnqueueComErro() throws QueueOverflowException {
		queue2.enqueue((Integer) 5);
	}

	@Test
	public void testDequeue() {
		try {
			assertEquals((Integer) 1, queue1.dequeue());
		} catch (QueueUnderflowException e) {
			e.printStackTrace();
		}
	}

	@Test(expected = QueueUnderflowException.class)
	public void testDequeueComErro() throws QueueUnderflowException {
		assertEquals((Integer) 1, queue2.dequeue());
		assertEquals((Integer) 2, queue2.dequeue());
		queue2.dequeue();
	}
}
