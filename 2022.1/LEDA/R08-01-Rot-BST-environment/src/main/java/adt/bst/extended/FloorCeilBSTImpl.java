package adt.bst.extended;

import adt.bst.BSTImpl;

/**
 * Note que esta classe estende sua implementacao de BST (BSTImpl).
 * Dependendo do design que voce use, sua BSTImpl precisa ter apenas funcionando
 * corretamente o metodo insert para que voce consiga testar esta classe.
 * 
 * @author Jônatas Tavares dos Santos - 121110769
 */
public class FloorCeilBSTImpl extends BSTImpl<Integer> implements FloorCeilBST {

	@Override
	public Integer floor(Integer[] array, double numero) {
		Integer floor = null;
		if (array != null && array.length > 0) {
			floor = this.floor(array, numero, 0, null);
		}
		return floor;
	}

	private Integer floor(Integer[] array, double numero, int index, Integer floor) {
		if (index < array.length) {
			this.insert(array[index]);
			Integer actualFloor = array[index];
			if (numero == actualFloor || (floor == null && actualFloor < numero)
					|| (floor != null && actualFloor < numero && actualFloor > floor)) {
				floor = actualFloor;
			}
			floor = this.floor(array, numero, index + 1, floor);
		}
		return floor;
	}

	@Override
	public Integer ceil(Integer[] array, double numero) {
		Integer ceil = null;
		if (array != null && array.length > 0) {
			ceil = this.ceil(array, numero, 0, null);
		}
		return ceil;
	}

	private Integer ceil(Integer[] array, double numero, int index, Integer ceil) {
		if (index < array.length) {
			this.insert(array[index]);
			Integer actualCeil = array[index];
			if (numero == actualCeil || (ceil == null && actualCeil > numero)
					|| (ceil != null && actualCeil > numero && actualCeil < ceil)) {
				ceil = actualCeil;
			}
			ceil = this.ceil(array, numero, index + 1, ceil);
		}
		return ceil;
	}
}
