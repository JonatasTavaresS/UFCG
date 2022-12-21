package adt.avltree;

import adt.bst.BSTNode;
import adt.bt.Util;

/**
 * @author Jônatas Tavares dos Santos - 121110769
 */
public class AVLCountAndFillImpl<T extends Comparable<T>> extends
		AVLTreeImpl<T> implements AVLCountAndFill<T> {

	private int LLcounter;
	private int LRcounter;
	private int RRcounter;
	private int RLcounter;

	public AVLCountAndFillImpl() {

	}

	@Override
	public int LLcount() {
		return LLcounter;
	}

	@Override
	public int LRcount() {
		return LRcounter;
	}

	@Override
	public int RRcount() {
		return RRcounter;
	}

	@Override
	public int RLcount() {
		return RLcounter;
	}

	@Override
	public void fillWithoutRebalance(T[] array) {
		if (array != null && array.length > 0) {
			for (T element : array) {
				this.insert(this.getRoot(), element);
			}
		}
	}

	protected void rebalance(BSTNode<T> node) {
		if (node != null) {
			BSTNode<T> newRoot = null;
			int balance = this.calculateBalance(node);
			if (Math.abs(balance) > 1)
				if (balance > 1)
					if (this.calculateBalance((BSTNode<T>) node.getLeft()) >= 0) {
						newRoot = Util.rightRotation(node);
						this.LLcounter++;
					} else {
						Util.leftRotation((BSTNode<T>) node.getLeft());
						newRoot = Util.rightRotation(node);
						this.LRcounter++;
					}
				else {
					if (this.calculateBalance((BSTNode<T>) node.getRight()) <= 0) {
						newRoot = Util.leftRotation(node);
						this.RRcounter++;
					} else {
						Util.rightRotation((BSTNode<T>) node.getRight());
						newRoot = Util.leftRotation(node);
						this.RLcounter++;
					}
				}
			if (this.getRoot().equals(node) && newRoot != null) {
				this.root = newRoot;
			}
		}
	}

	private void insert(BSTNode<T> node, T element) {
		if (node.isEmpty()) {
			node.setData(element);
			node.setLeft(new BSTNode<>());
			node.setRight(new BSTNode<>());
			node.getLeft().setParent(node);
			node.getRight().setParent(node);
		} else {
			if (element.compareTo(node.getData()) < 0) {
				this.insert((BSTNode<T>) node.getLeft(), element);
			} else if (element.compareTo(node.getData()) > 0) {
				this.insert((BSTNode<T>) node.getRight(), element);
			}
		}
	}

}
