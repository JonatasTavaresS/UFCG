package sorting.divideAndConquer;

import sorting.AbstractSorting;

/**
 * Merge sort is based on the divide-and-conquer paradigm. The algorithm
 * consists of recursively dividing the unsorted list in the middle, sorting
 * each sublist, and then merging them into one single sorted list. Notice that
 * if the list has length == 1, it is already sorted.
 * 
 * @author Jônatas Tavares dos Santos - 121110769
 */
public class MergeSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (leftIndex >= rightIndex || rightIndex >= array.length) {
			return;
		}
		if (leftIndex < rightIndex) {
			int middleIndex = (leftIndex + rightIndex) / 2;
			sort(array, leftIndex, middleIndex);
			sort(array, middleIndex + 1, rightIndex);
			this.merge(array, leftIndex, middleIndex, rightIndex);
		}
	}

	private void merge(T[] array, int leftIndex, int middleIndex, int rightIndex) {
		T[] helper = (T[]) new Comparable[array.length];
		for (int i = leftIndex; i <= rightIndex; i++) {
			helper[i] = array[i];
		}
		int i = leftIndex, k = leftIndex, j = middleIndex + 1;
		while (i <= middleIndex && j <= rightIndex) {
			if (helper[i].compareTo(helper[j]) <= 0) {
				array[k++] = helper[i++];
			} else {
				array[k++] = helper[j++];
			}
		}
		while (i <= middleIndex) {
			array[k++] = helper[i++];
		}
		while (j <= rightIndex) {
			array[k++] = helper[j++];
		}
	}
}
