package sorting.linearSorting;

import sorting.AbstractSorting;

/**
 * Classe que implementa a estratégia de Counting Sort vista em sala.
 *
 * Procure evitar desperdício de memória: AO INVÉS de alocar o array de
 * contadores
 * com um tamanho arbitrariamente grande (por exemplo, com o maior valor de
 * entrada possível),
 * aloque este array com o tamanho sendo o máximo inteiro presente no array a
 * ser ordenado.
 *
 * Seu algoritmo deve assumir que o array de entrada nao possui numeros
 * negativos,
 * ou seja, possui apenas numeros inteiros positivos e o zero.
 *
 * @author Jônatas Tavares dos Santos - 121110769
 */
public class CountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {
		// Verificação de entradas válidas
		if (array != null && leftIndex >= 0 && leftIndex < rightIndex && rightIndex < array.length) {
			int[] C = new int[this.maximum(array, leftIndex, rightIndex) + 1];
			// Frequência
			for (int i = leftIndex; i < rightIndex + 1; i++) {
				C[array[i]]++;
			}
			// Cumulativa
			for (int i = 1; i < C.length; i++) {
				C[i] += C[i - 1];
			}
			// Array auxiliar com tamanho do intervalo
			int[] B = new int[rightIndex - leftIndex + 1];
			for (int i = rightIndex; i >= leftIndex; i--) {
				B[C[array[i]] - 1] = array[i];
				C[array[i]]--;
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
}
