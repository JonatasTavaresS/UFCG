package adt.bst.extended;

import adt.bst.BSTImpl;
import adt.bst.BSTNode;

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
			for (Integer i : array) {
				this.insert(i);
			}
			floor = this.floor(this.getRoot(), numero, floor);
		}
		return floor;
	}

	private Integer floor(BSTNode<Integer> node, double numero, Integer floor) {
		if (!node.isEmpty()) {
			if (numero == node.getData()) {
				floor = node.getData();
			} else if (numero < node.getData()) {
				floor = this.floor((BSTNode<Integer>) node.getLeft(), numero, floor);
			} else {
				floor = this.floor((BSTNode<Integer>) node.getRight(), numero, node.getData());
			}
		}
		return floor;
	}

	@Override
	public Integer ceil(Integer[] array, double numero) {
		Integer ceil = null;
		if (array != null && array.length > 0) {
			for (Integer i : array) {
				this.insert(i);
			}
			ceil = this.ceil(this.getRoot(), numero, ceil);
		}
		return ceil;
	}

	private Integer ceil(BSTNode<Integer> node, double numero, Integer ceil) {
		if (!node.isEmpty()) {
			if (numero == node.getData()) {
				ceil = node.getData();
			} else if (numero > node.getData()) {
				ceil = this.ceil((BSTNode<Integer>) node.getRight(), numero, ceil);
			} else {
				ceil = this.ceil((BSTNode<Integer>) node.getLeft(), numero, node.getData());
			}
		}
		return ceil;
	}
}
