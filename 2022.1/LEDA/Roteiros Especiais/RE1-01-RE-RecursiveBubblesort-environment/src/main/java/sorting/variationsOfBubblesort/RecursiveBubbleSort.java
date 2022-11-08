package sorting.variationsOfBubblesort;

import sorting.AbstractSorting;

/**
 * @author Jônatas Tavares dos Santos - 121110769
 */
public class RecursiveBubbleSort<T extends Comparable<T>> extends
		AbstractSorting<T> {

	/**
	 * Implementação recursiva do bubble sort. Você deve implementar apenas esse
	 * método sem usar nenhum outro método auxiliar (exceto
	 * Util.swap(array,int,int)). Para isso, tente definir o caso base do
	 * algoritmo e depois o caso indutivo, que reduz o problema para uma entrada
	 * menor em uma chamada recursiva. Seu algoritmo deve ter complexidade
	 * quadrática O(n^2).
	 */
	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		// Validação de entradas válidas
		if (array != null && leftIndex >= 0 && leftIndex < rightIndex && rightIndex < array.length) {
			for (int i = leftIndex; i < rightIndex; i++) {
				if (array[i].compareTo(array[i + 1]) > 0) {
					this.swap(array, i, i + 1);
				}
			}
			sort(array, leftIndex, rightIndex - 1);
		}
	}

	/**
	 * Troca o conteúdo de duas posições em um array.
	 *
	 * @param array O array a ser modificado.
	 * @param i     Uma das posições a ser trocada.
	 * @param j     A outra posição a ser trocada.
	 */
	private void swap(T[] array, int i, int j) {
		T temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}
