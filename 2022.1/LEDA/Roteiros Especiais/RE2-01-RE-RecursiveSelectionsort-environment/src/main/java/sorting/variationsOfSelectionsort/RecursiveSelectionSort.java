package sorting.variationsOfSelectionsort;

import sorting.AbstractSorting;

public class RecursiveSelectionSort<T extends Comparable<T>> extends
		AbstractSorting<T> {

	/**
	 * Implementação recursiva do selection sort. Você deve implementar apenas
	 * esse método sem usar nenhum outro método auxiliar (exceto
	 * Util.swap(array,int,int)). Para isso, tente definir o caso base do
	 * algoritmo e depois o caso indutivo, que reduz o problema para uma entrada
	 * menor em uma chamada recursiva. Seu algoritmo deve ter complexidade
	 * quadrática O(n^2).
	 */
	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		// Validação de entradas válidas
		if (array != null && leftIndex >= 0 && leftIndex < rightIndex && rightIndex < array.length) {
			int smallerIndex = leftIndex;
			for (int j = leftIndex + 1; j <= rightIndex; j++) {
				if (array[j].compareTo(array[smallerIndex]) < 0) {
					smallerIndex = j;
				}
			}
			this.swap(array, leftIndex, smallerIndex);
			sort(array, leftIndex + 1, rightIndex);
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
