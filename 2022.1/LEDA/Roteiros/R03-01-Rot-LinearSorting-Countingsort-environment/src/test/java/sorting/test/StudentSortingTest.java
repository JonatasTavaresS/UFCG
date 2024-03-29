package sorting.test;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import sorting.AbstractSorting;
import sorting.linearSorting.*;

public class StudentSortingTest {

	private Integer[] vetorTamPar;
	private Integer[] vetorTamImpar;
	private Integer[] vetorVazio = {};
	private Integer[] vetorValoresRepetidos;
	private Integer[] vetorValoresIguais;

	public AbstractSorting<Integer> implementation;

	@Before
	public void setUp() {
		populaVetorTamanhoPar(new Integer[] { 30, 28, 7, 29, 11, 26, 4, 22, 23,
				31 });
		populaVetorTamanhoImpar(new Integer[] { 6, 41, 32, 7, 26, 4, 37, 49,
				11, 18, 36 });
		populaVetorRepetido(new Integer[] { 4, 9, 3, 4, 0, 5, 1, 4 });
		populaVetorIgual(new Integer[] { 6, 6, 6, 6, 6, 6 });

		getImplementation();
	}

	// // MÉTODOS AUXILIARES DA INICIALIZAÇÃO
	/**
	 * Método que inicializa a implementação a ser testada com a implementação
	 * do aluno
	 */
	private void getImplementation() {
		this.implementation = new CountingSort();
		// this.implementation = new ExtendedCountingSort();
	}

	public void populaVetorTamanhoPar(Integer[] arrayPadrao) {
		this.vetorTamPar = Arrays.copyOf(arrayPadrao, arrayPadrao.length);
	}

	public void populaVetorTamanhoImpar(Integer[] arrayPadrao) {
		this.vetorTamImpar = Arrays.copyOf(arrayPadrao, arrayPadrao.length);
	}

	public void populaVetorRepetido(Integer[] arrayPadrao) {
		this.vetorValoresRepetidos = Arrays.copyOf(arrayPadrao,
				arrayPadrao.length);
	}

	public void populaVetorIgual(Integer[] arrayPadrao) {
		this.vetorValoresIguais = Arrays
				.copyOf(arrayPadrao, arrayPadrao.length);
	}

	// FIM DOS METODOS AUXILIARES DA INICIALIZAÇÃO

	// MÉTODOS DE TESTE

	public void genericTest(Integer[] array) {
		Integer[] copy1 = {};
		if (array.length > 0) {
			copy1 = Arrays.copyOf(array, array.length);
		}
		implementation.sort(array);
		Arrays.sort(copy1);
		Assert.assertArrayEquals(copy1, array);
	}

	@Test
	public void testSort01() {
		genericTest(vetorTamPar);
	}

	@Test
	public void testSort02() {
		genericTest(vetorTamImpar);
	}

	@Test
	public void testSort03() {
		genericTest(vetorVazio);
	}

	@Test
	public void testSort04() {
		genericTest(vetorValoresIguais);
	}

	@Test
	public void testSort05() {
		genericTest(vetorValoresRepetidos);
	}

	// MÉTODOS QUE OS ALUNOS PODEM CRIAR
	/**
	 * O ALUNO PODE IMPLEMENTAR METODOS DE ORDENAÇÃO TESTANDO O SORT COM TRES
	 * ARGUMENTOS PARA TESTAR A ORDENACAO EM UM PEDAÇO DO ARRAY. DICA: PROCUREM
	 * SEGUIR A ESTRUTURA DOS MÉTODOS DE TESTE ACIMA DESCRITOS, ORDENANDO APENAS
	 * UMA PARTE DO ARRAY.
	 */

	/**
	 * Teste ordenando uma parte do array.
	 */
	@Test
	public void testSort06() {
		this.implementation.sort(vetorTamPar, 3, 7);
		Assert.assertArrayEquals(new Integer[] { 30, 28, 7, 4, 11, 22, 26, 29, 23, 31 }, vetorTamPar);
	}

	/**
	 * Teste com índice da esquerda maior que o índice da direita.
	 */
	@Test
	public void testSort07() {
		this.implementation.sort(vetorTamPar, 7, 3);
		Assert.assertArrayEquals(new Integer[] { 30, 28, 7, 29, 11, 26, 4, 22, 23, 31 }, vetorTamPar);
	}

	/**
	 * Teste com índice da esquerda igual ao índice da direita.
	 */
	@Test
	public void testSort08() {
		this.implementation.sort(vetorTamPar, 7, 7);
		Assert.assertArrayEquals(new Integer[] { 30, 28, 7, 29, 11, 26, 4, 22, 23, 31 }, vetorTamPar);
	}

	/**
	 * Teste com índice da esquerda negativo.
	 */
	@Test
	public void testSort09() {
		this.implementation.sort(vetorTamPar, -3, 7);
		Assert.assertArrayEquals(new Integer[] { 30, 28, 7, 29, 11, 26, 4, 22, 23, 31 }, vetorTamPar);
	}

	/**
	 * Teste com índice da direita negativo.
	 */
	@Test
	public void testSort10() {
		this.implementation.sort(vetorTamPar, 3, -7);
		Assert.assertArrayEquals(new Integer[] { 30, 28, 7, 29, 11, 26, 4, 22, 23, 31 }, vetorTamPar);
	}

	/**
	 * Teste com índice da direita maior que o tamanho do array.
	 */
	@Test
	public void testSort11() {
		this.implementation.sort(vetorTamPar, 3, 11);
		Assert.assertArrayEquals(new Integer[] { 30, 28, 7, 29, 11, 26, 4, 22, 23, 31 }, vetorTamPar);
	}

	/**
	 * Teste com array unitário.
	 */
	@Test
	public void testSort12() {
		Integer[] vetorUnitario = new Integer[] { 0 };
		this.implementation.sort(vetorUnitario, 0, 0);
		Assert.assertArrayEquals(new Integer[] { 0 }, vetorUnitario);
	}

	/**
	 * Teste com array vazio.
	 */
	@Test
	public void testSort13() {
		this.implementation.sort(vetorVazio, 0, 0);
		Assert.assertArrayEquals(new Integer[] {}, vetorVazio);
	}

	/**
	 * Teste com array nulo.
	 */
	@Test
	public void testSort14() {
		Integer[] array = null;
		this.implementation.sort(array, 0, 0);
		Assert.assertArrayEquals(null, array);
	}

	// Extended Counting Sort

	/**
	 * Testes com valores negativos e positivos para o ExtendedCountingSort.
	 */
	// @Test
	public void testSort16() {
		genericTest(new Integer[] { 30, 28, -7, 28, -11, 26, 4, 22, 23, 0 });
	}

	/**
	 * Testes com valores negativos para o ExtendedCountingSort.
	 */
	// @Test
	public void testSort17() {
		genericTest(new Integer[] { -30, -28, -7, -29, -11, -26, -4, -22, -23, -31 });
	}

	/**
	 * Testes com valores negativos para o ExtendedCountingSort com intervalos.
	 */
	// @Test
	public void testSort18() {
		Integer[] vetorNegativos = new Integer[] { -30, -28, -7, -29, -11, -26, -4, -22, -23, -31 };
		this.implementation.sort(vetorNegativos, 3, 7);
		Assert.assertArrayEquals(new Integer[] { -30, -28, -7, -29, -26, -22, -11, -4, -23, -31 }, vetorNegativos);
	}
}
