package sorting.simpleSorting;

import sorting.AbstractSorting;
import util.Util;

/**
 * The selection sort algorithm chooses the smallest element from the array and
 * puts it in the first position. Then chooses the second smallest element and
 * stores it in the second position, and so on until the array is sorted.
 * 
 * @author Jônatas Tavares dos Santos - 121110769
 */
public class SelectionSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (leftIndex >= rightIndex || rightIndex >= array.length) {
			return;
		}
		for (int i = leftIndex; i < rightIndex + 1; i++) {
			int minorIndex = i;
			for (int j = i + 1; j < rightIndex + 1; j++) {
				if (array[j].compareTo(array[minorIndex]) < 0) {
					minorIndex = j;
				}
			}
			Util.swap(array, i, minorIndex);
		}
	}
}
