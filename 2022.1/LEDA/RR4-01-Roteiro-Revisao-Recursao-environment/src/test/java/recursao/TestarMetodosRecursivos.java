package recursao;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestarMetodosRecursivos {

	private MetodosRecursivos metodosRecursivos;

	@Before
	public void setUp() {
		this.metodosRecursivos = new MetodosRecursivos();
	}

	@Test
	public void testCalcularFatorial() {
		assertEquals(1, this.metodosRecursivos.calcularFatorial(0));
		assertEquals(1, this.metodosRecursivos.calcularFatorial(1));
		assertEquals(2, this.metodosRecursivos.calcularFatorial(2));
		assertEquals(6, this.metodosRecursivos.calcularFatorial(3));
		assertEquals(24, this.metodosRecursivos.calcularFatorial(4));
		assertEquals(120, this.metodosRecursivos.calcularFatorial(5));
	}

	@Test
	public void testCalcularFibonacci() {
		assertEquals(0, this.metodosRecursivos.calcularFibonacci(1));
		assertEquals(1, this.metodosRecursivos.calcularFibonacci(2));
		assertEquals(1, this.metodosRecursivos.calcularFibonacci(3));
		assertEquals(2, this.metodosRecursivos.calcularFibonacci(4));
		assertEquals(3, this.metodosRecursivos.calcularFibonacci(5));
	}

	@Test
	public void testCountNotNull() {
		assertEquals(0, this.metodosRecursivos.countNotNull(new Object[] { null, null, null }));
		assertEquals(2, this.metodosRecursivos.countNotNull(new Object[] { "a", null, "0" }));
	}
}
