package problems;

import util.Util;

/**
 * @author Jônatas Tavares dos Santos - 121110769
 */
public class FloorBinarySearchImpl implements Floor {

	@Override
	public Integer floor(Integer[] array, Integer x) {
		// Verificação de entradas inválidas
		if (array == null || x == null) {
			return null;
		}
		sort(array, 0, array.length - 1);
		return search(array, x, 0, array.length - 1);
	}

	private Integer search(Integer[] array, Integer x, int leftIndex, int rightIndex) {
		Integer medium = (leftIndex + rightIndex) / 2;
		if (leftIndex > rightIndex) {
			return null;
		}
		if (x.equals(array[medium])) {
			return x;
		}
		if (x.compareTo(array[medium]) < 0) {
			return search(array, x, leftIndex, medium - 1);
		} else {
			return search(array, x, medium + 1, rightIndex);
		}
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
		Integer pivot = array[leftIndex];
		int i = leftIndex;
		for (int j = leftIndex + 1; j <= rightIndex; j++) {
			if (array[j].compareTo(pivot) <= 0) {
				Util.swap(array, ++i, j);
			}
		}
		Util.swap(array, leftIndex, i);
		return i;
	}
}
