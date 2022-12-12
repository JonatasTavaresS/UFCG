package adt.heap.extended;

import java.util.Comparator;

import adt.heap.HeapImpl;

public class FloorCeilHeapImpl extends HeapImpl<Integer> implements FloorCeilHeap {

	public FloorCeilHeapImpl(Comparator<Integer> comparator) {
		super(comparator);
	}

	@Override
	public Integer floor(Integer[] array, double numero) {
		Integer floor = null;
		if (array != null) {
			for (Integer integer : array) {
				this.insert(integer);
			}
			// floor = this.floor(numero, floor);
		}
		return floor;
	}

	@Override
	public Integer ceil(Integer[] array, double numero) {
		Integer ceil = null;
		if (array != null) {
			for (Integer integer : array) {
				this.insert(integer);
			}
			// ceil = this.ceil(numero, ceil);
		}
		return ceil;
	}

}
