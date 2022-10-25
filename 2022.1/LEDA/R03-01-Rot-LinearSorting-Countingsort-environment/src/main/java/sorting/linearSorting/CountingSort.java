package sorting.linearSorting;

import java.util.Arrays;

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
 */
public class CountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {
		if (leftIndex >= rightIndex) {
			return;
		}
		Integer[] C = new Integer[this.bigger(array, leftIndex, rightIndex) + 1];
		for (int i = 0; i < C.length; i++) {
			C[i] = 0;
		}
		for (int i = leftIndex; i < rightIndex + 1; i++) {
			C[array[i]]++;
		}
		for (int i = 1; i < C.length; i++) {
			C[i] += C[i - 1];
		}
		System.out.println(Arrays.toString(C));
	}

	private Integer bigger(Integer[] array, int leftIndex, int rightIndex) {
		Integer bigger = array[leftIndex];
		for (int i = leftIndex + 1; i < rightIndex + 1; i++) {
			if (array[i] > bigger) {
				bigger = array[i];
			}
		}
		return bigger;
	}

}
