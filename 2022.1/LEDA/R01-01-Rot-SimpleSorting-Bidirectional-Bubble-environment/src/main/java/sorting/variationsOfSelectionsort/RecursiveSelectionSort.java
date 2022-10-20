package sorting.variationsOfSelectionsort;

import java.util.Arrays;

import sorting.AbstractSorting;
import util.Util;

/**
 * @author Jônatas Tavares dos Santos - 121110769
 */
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
		if (leftIndex == rightIndex + 1) {
            return;
        }
        int index_menor = leftIndex;
        for (int i = leftIndex + 1; i < rightIndex + 1; i++) {
            if (array[i].compareTo(array[index_menor]) < 0) {
                index_menor = i;
            }
        }
        Util.swap(array, leftIndex, index_menor);
        sort(array, leftIndex + 1, rightIndex);
	}
}
