package sorting.variationsOfBubblesort;

import sorting.AbstractSorting;
import util.Util;

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
		if (leftIndex == rightIndex + 1) {
			return;
		}
		boolean swapped = false;
		if (array[leftIndex].compareTo(array[leftIndex + 1]) > 0) {
			Util.swap(array, leftIndex, leftIndex + 1);
			swapped = true;

		}
		sort(array, leftIndex + 1, rightIndex);
		return;
	}

}
