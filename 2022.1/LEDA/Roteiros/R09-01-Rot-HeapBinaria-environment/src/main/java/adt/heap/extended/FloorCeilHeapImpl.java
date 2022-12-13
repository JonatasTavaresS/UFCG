package adt.heap.extended;

import java.util.Comparator;

import adt.heap.HeapImpl;

/**
 * @author Jônatas Tavares dos Santos - 121110769
 */
public class FloorCeilHeapImpl extends HeapImpl<Integer> implements FloorCeilHeap {

	public FloorCeilHeapImpl(Comparator<Integer> comparator) {
		super(comparator);
	}

	@Override
	public Integer floor(Integer[] array, double numero) {
		Integer floor = null;
		if (array != null) {
			for (Integer element : array) {
				this.insert(element);
			}
			floor = this.floor(numero, floor);
		}
		return floor;
	}

	private Integer floor(double numero, Integer floor) {
		Integer rootElement = this.extractRootElement();
		if (rootElement != null) {
			if (numero >= rootElement && (floor == null || rootElement >= floor)) {
				floor = this.floor(numero, rootElement);
			} else {
				floor = this.floor(numero, floor);
			}
		}
		return floor;
	}

	@Override
	public Integer ceil(Integer[] array, double numero) {
		Integer ceil = null;
		if (array != null) {
			for (Integer element : array) {
				this.insert(element);
			}
			ceil = this.ceil(numero, ceil);
		}
		return ceil;
	}

	private Integer ceil(double numero, Integer ceil) {
		Integer rootElement = this.extractRootElement();
		if (rootElement != null) {
			if (numero <= rootElement && (ceil == null || rootElement <= ceil)) {
				ceil = this.ceil(numero, rootElement);
			} else {
				ceil = this.ceil(numero, ceil);
			}
		}
		return ceil;
	}

}
