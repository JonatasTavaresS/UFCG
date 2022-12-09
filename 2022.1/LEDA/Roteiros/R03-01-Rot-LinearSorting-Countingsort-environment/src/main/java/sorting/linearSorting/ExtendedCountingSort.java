package sorting.linearSorting;

import sorting.AbstractSorting;

/**
 * Classe que implementa do Counting Sort vista em sala. Desta vez este
 * algoritmo deve satisfazer os seguitnes requisitos:
 * - Alocar o tamanho minimo possivel para o array de contadores (C)
 * - Ser capaz de ordenar arrays contendo numeros negativos
 * 
 * @author Jônatas Tavares dos Santos - 121110769
 */
public class ExtendedCountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {
		// Verificação de entradas válidas
		if (array != null && leftIndex >= 0 && leftIndex < rightIndex && rightIndex < array.length) {
			// Valores minimo e máximo
			int maximum = this.maximum(array, leftIndex, rightIndex);
			int minimum = this.minimum(array, leftIndex, rightIndex);
			int[] C = new int[maximum - minimum + 1];
			// Frequência
			for (int i = leftIndex; i < rightIndex + 1; i++) {
				C[array[i] - minimum]++;
			}
			// Cumulativa
			for (int i = 1; i < C.length; i++) {
				C[i] += C[i - 1];
			}
			// Array auxiliar com tamanho do intervalo
			int[] B = new int[rightIndex - leftIndex + 1];
			for (int i = rightIndex; i >= leftIndex; i--) {
				B[C[array[i] - minimum] - 1] = array[i];
				C[array[i] - minimum]--;
			}
			// Cópia do intervalo ordenado para o array original
			for (int i = 0; i < B.length; i++) {
				array[i + leftIndex] = B[i];
			}
		}
	}

	/**
	 * Método que retorna o valor máximo de um array presente no intervalo
	 * especificado.
	 * 
	 * @param array      Array onde será buscado o valor.
	 * @param leftIndex  Início do intervalo.
	 * @param rightIndex Fim do intervalo.
	 * @return Maior valor presente no intervalo.
	 */
	private int maximum(Integer[] array, int leftIndex, int rightIndex) {
		int maximum = array[leftIndex];
		for (int i = leftIndex + 1; i < rightIndex + 1; i++) {
			if (array[i] > maximum) {
				maximum = array[i];
			}
		}
		return maximum;
	}

	/**
	 * Método que retorna o valor mínimo de um array presente no intervalo
	 * especificado.
	 * 
	 * @param array      Array onde será buscado o valor.
	 * @param leftIndex  Início do intervalo.
	 * @param rightIndex Fim do intervalo.
	 * @return Maior valor presente no intervalo.
	 */
	private int minimum(Integer[] array, int leftIndex, int rightIndex) {
		int minimum = array[leftIndex];
		for (int i = leftIndex + 1; i < rightIndex + 1; i++) {
			if (array[i] < minimum) {
				minimum = array[i];
			}
		}
		return minimum;
	}
}
