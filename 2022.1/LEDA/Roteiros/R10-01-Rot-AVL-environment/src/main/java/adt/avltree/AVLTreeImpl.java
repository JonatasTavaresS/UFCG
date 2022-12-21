package adt.avltree;

import adt.bst.BSTImpl;
import adt.bst.BSTNode;
import adt.bt.Util;

/**
 * 
 * Implementacao de uma arvore AVL
 * A CLASSE AVLTree herda de BSTImpl. VOCE PRECISA SOBRESCREVER A IMPLEMENTACAO
 * DE BSTIMPL RECEBIDA COM SUA IMPLEMENTACAO "OU ENTAO" IMPLEMENTAR OS SEGUITNES
 * METODOS QUE SERAO TESTADOS NA CLASSE AVLTREE:
 * - insert
 * - preOrder
 * - postOrder
 * - remove
 * - height
 * - size
 *
 * @author Claudio Campelo
 *
 * @param <T>
 */
public class AVLTreeImpl<T extends Comparable<T>> extends BSTImpl<T> implements
		AVLTree<T> {

	// Do not forget: you must override the methods insert and remove
	// conveniently.

	@Override
	public void insert(T element) {
		if (element != null) {
			this.insert(this.getRoot(), element);
		}
	}

	private void insert(BSTNode<T> node, T element) {
		if (node != null && node.isEmpty()) {
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
			this.rebalance(node);
		}
	}

	@Override
	public void remove(T element) {
		BSTNode<T> found = this.search(element);
		if (found != null) {
			this.remove(this.search(element));
		}
	}

	private void remove(BSTNode<T> node) {
		if (!node.isEmpty()) {
			if (node.isLeaf()) {
				node.setData(null);
				rebalanceUp(node);
			} else if (this.hasOneChild(node)) {
				if (node.getData().compareTo(this.getRoot().getData()) != 0) {
					if (this.isLeftChild(node)) {
						if (!node.getLeft().isEmpty()) {
							node.getParent().setLeft(node.getLeft());
							node.getLeft().setParent(node.getParent());
						} else {
							node.getParent().setLeft(node.getRight());
							node.getRight().setParent(node.getParent());
						}
					} else {
						if (!node.getLeft().isEmpty()) {
							node.getParent().setRight(node.getLeft());
							node.getLeft().setParent(node.getParent());
						} else {
							node.getParent().setRight(node.getRight());
							node.getRight().setParent(node.getParent());
						}
					}
				} else {
					if (!node.getLeft().isEmpty()) {
						this.root = (BSTNode<T>) node.getLeft();
					} else if (!node.getRight().isEmpty()) {
						this.root = (BSTNode<T>) node.getRight();
					}
					this.getRoot().setParent(null);
				}
				this.rebalanceUp(node);
			} else {
				BSTNode<T> sucessor = this.sucessor(node.getData());
				node.setData(sucessor.getData());
				this.remove(sucessor);
			}
		}
	}

	private boolean hasOneChild(BSTNode<T> node) {
		return (!node.getLeft().isEmpty() && node.getRight().isEmpty()) || (node.getLeft().isEmpty()
				&& !node.getRight().isEmpty());
	}

	private boolean isLeftChild(BSTNode<T> node) {
		return node.getData().compareTo(node.getParent().getLeft().getData()) == 0;
	}

	// AUXILIARY
	protected int calculateBalance(BSTNode<T> node) {
		return this.height((BSTNode<T>) node.getLeft()) - this.height((BSTNode<T>) node.getRight());
	}

	// AUXILIARY
	protected void rebalance(BSTNode<T> node) {
		if (node != null) {
			BSTNode<T> newRoot = null;
			int balance = this.calculateBalance(node);
			if (Math.abs(balance) > 1)
				if (balance > 1)
					if (this.calculateBalance((BSTNode<T>) node.getLeft()) >= 0) {
						newRoot = Util.rightRotation(node);
					} else {
						Util.leftRotation((BSTNode<T>) node.getLeft());
						newRoot = Util.rightRotation(node);
					}
				else {
					if (this.calculateBalance((BSTNode<T>) node.getRight()) <= 0) {
						newRoot = Util.leftRotation(node);
					} else {
						Util.rightRotation((BSTNode<T>) node.getRight());
						newRoot = Util.leftRotation(node);
					}
				}
			if (this.getRoot().equals(node) && newRoot != null) {
				this.root = newRoot;
			}
		}
	}

	// AUXILIARY
	protected void rebalanceUp(BSTNode<T> node) {
		if (node != null) {
			BSTNode<T> parent = (BSTNode<T>) node.getParent();
			while (parent != null) {
				this.rebalance(parent);
				parent = (BSTNode<T>) parent.getParent();
			}
		}
	}

}
