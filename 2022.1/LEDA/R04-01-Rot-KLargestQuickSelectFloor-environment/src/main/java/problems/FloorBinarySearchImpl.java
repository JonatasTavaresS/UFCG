package problems;

import util.Util;

/**
 * @author Jônatas Tavares dos Santos - 121110769
 */
public class FloorBinarySearchImpl implements Floor {

	@Override
	public Integer floor(Integer[] array, Integer x) {
		// Verificação de entradas inválidas
		if (array != null && array.length > 0 && x != null) {
			sort(array, 0, array.length - 1);
			return search(array, x, null, 0, array.length - 1);
		}
		return null;
	}

	private Integer search(Integer[] array, Integer x, Integer floor, int leftIndex, int rightIndex) {
		if (array != null && leftIndex >= 0 && leftIndex <= rightIndex && rightIndex < array.length) {
			Integer medium = (leftIndex + rightIndex) / 2;
			if (x.equals(array[medium])) {
				return x;
			}
			if (x.compareTo(array[medium]) < 0) {
				return search(array, x, floor, leftIndex, medium - 1);
			} else {
				return search(array, x, array[medium], medium + 1, rightIndex);
			}
		}
		return floor;
	}

	private void sort(Integer[] array, int leftIndex, int rightIndex) {
		// Verificação de entradas inválidas
		if (array != null && leftIndex >= 0 && leftIndex < rightIndex && rightIndex < array.length) {
			int pivotIndex = this.partition(array, leftIndex, rightIndex);
			sort(array, leftIndex, pivotIndex - 1);
			sort(array, pivotIndex + 1, rightIndex);
		}
	}

	private int partition(Integer[] array, int leftIndex, int rightIndex) {
		int pivotIndex = this.pivotMedianOfThree(array, leftIndex, rightIndex);
		Util.swap(array, pivotIndex, rightIndex - 1);
		Integer pivot = array[rightIndex - 1];
		int i = rightIndex - 1;
		for (int j = rightIndex - 2; j >= leftIndex + 1; j--) {
			if ((array[j].compareTo(pivot) >= 0)) {
				Util.swap(array, --i, j);
			}
		}
		Util.swap(array, rightIndex - 1, i);
		return i;
	}

	private int pivotMedianOfThree(Integer[] array, int leftIndex, int rightIndex) {
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
