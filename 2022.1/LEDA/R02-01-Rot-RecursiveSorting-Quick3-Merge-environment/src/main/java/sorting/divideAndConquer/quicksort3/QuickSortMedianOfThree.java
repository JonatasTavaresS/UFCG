package sorting.divideAndConquer.quicksort3;

import sorting.AbstractSorting;
import util.Util;

/**
 * A classe QuickSortMedianOfThree representa uma variação do QuickSort que
 * funciona de forma ligeiramente diferente. Relembre que quando o pivô
 * escolhido divide o array aproximadamente na metade, o QuickSort tem um
 * desempenho perto do ótimo. Para aproximar a entrada do caso ótimo, diversas
 * abordagens podem ser utilizadas. Uma delas é usar a mediana de 3 para achar o
 * pivô. Essa técnica consiste no seguinte:
 * 1. Comparar o elemento mais a esquerda, o central e o mais a direita do
 * intervalo.
 * 2. Ordenar os elementos, tal que: A[left] < A[center] < A[right].
 * 3. Adotar o A[center] como pivô.
 * 4. Colocar o pivô na penúltima posição A[right-1].
 * 5. Aplicar o particionamento considerando o vetor menor, de A[left+1] até
 * A[right-1].
 * 6. Aplicar o algoritmo na particao a esquerda e na particao a direita do
 * pivô.
 * 
 * @author Jônatas Tavares dos Santos - 121110769
 */
public class QuickSortMedianOfThree<T extends Comparable<T>> extends
		AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (leftIndex < rightIndex) {
			int pivotIndex = this.partition(array, leftIndex, rightIndex);
			sort(array, leftIndex, pivotIndex - 1);
			sort(array, pivotIndex + 1, rightIndex);
		}
	}

	private int partition(T[] array, int leftIndex, int rightIndex) {
		int pivotIndex = this.pivotMedianOfThree(array, leftIndex, rightIndex);
		Util.swap(array, pivotIndex, rightIndex - 1);
		T pivot = array[rightIndex - 1];
		int i = rightIndex - 1;
		for (int j = rightIndex - 2; j >= leftIndex + 1; j--) {
			if ((array[j].compareTo(pivot) >= 0)) {
				Util.swap(array, --i, j);
			}
		}
		Util.swap(array, rightIndex - 1, i);
		return i;
	}

	private int pivotMedianOfThree(T[] array, int leftIndex, int rightIndex) {
		int middleIndex = (leftIndex + rightIndex) / 2;
		if (array[rightIndex].compareTo(array[leftIndex]) < 0) {
			Util.swap(array, rightIndex, leftIndex);
		}
		if (array[middleIndex].compareTo(array[leftIndex]) < 0) {
			Util.swap(array, middleIndex, leftIndex);
		}
		if (array[rightIndex].compareTo(array[middleIndex]) < 0) {
			Util.swap(array, rightIndex, middleIndex);
		}
		return middleIndex;
	}
}
