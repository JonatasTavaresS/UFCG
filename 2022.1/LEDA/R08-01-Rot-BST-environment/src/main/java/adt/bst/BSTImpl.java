package adt.bst;

import java.util.ArrayList;

import adt.bt.BTNode;

public class BSTImpl<T extends Comparable<T>> implements BST<T> {

	protected BSTNode<T> root;

	public BSTImpl() {
		root = new BSTNode<T>();
	}

	public BSTNode<T> getRoot() {
		return this.root;
	}

	@Override
	public boolean isEmpty() {
		return root.isEmpty();
	}

	@Override
	public int height() {
		return this.height(this.getRoot());
	}

	private int height(BSTNode<T> node) {
		int height = -1;
		if (!node.isEmpty()) {
			height = 1 + Math.max(this.height((BSTNode<T>) node.getLeft()), this.height((BSTNode<T>) node.getRight()));
		}
		return height;
	}

	@Override
	public BSTNode<T> search(T element) {
		return this.search(this.getRoot(), element);
	}

	private BSTNode<T> search(BSTNode<T> node, T element) {
		BSTNode<T> search = new BSTNode<>();
		if (element != null && !node.isEmpty()) {
			int compareTo = element.compareTo(node.getData());
			if (compareTo == 0) {
				search = node;
			} else if (compareTo < 0) {
				search = this.search((BSTNode<T>) node.getLeft(), element);
			} else if (compareTo > 0) {
				search = this.search((BSTNode<T>) node.getRight(), element);
			}
		}
		return search;
	}

	@Override
	public void insert(T element) {
		if (element != null && this.search(element).isEmpty()) {
			this.insert(this.getRoot(), element);
		}
	}

	private void insert(BSTNode<T> node, T element) {
		if (node.isEmpty()) {
			node.setData(element);
			node.setLeft(new BSTNode<>());
			node.setRight(new BSTNode<>());
		} else {
			int compareTo = element.compareTo(node.getData());
			if (compareTo < 0) {
				this.insert((BSTNode<T>) node.getLeft(), element);
			} else if (compareTo < 0) {
				this.insert((BSTNode<T>) node.getRight(), element);
			}
		}
	}

	@Override
	public BSTNode<T> maximum() {
		return this.maximum(this.getRoot());
	}

	private BSTNode<T> maximum(BSTNode<T> node) {
		return null;
	}

	@Override
	public BSTNode<T> minimum() {
		return this.minimum(this.getRoot());
	}

	private BSTNode<T> minimum(BSTNode<T> root2) {
		return null;
	}

	@Override
	public BSTNode<T> sucessor(T element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BSTNode<T> predecessor(T element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove(T element) {
		// TODO Auto-generated method stub
		// throw new UnsupportedOperationException("Not implemented yet!");
	}

	@SuppressWarnings("unchecked")
	@Override
	public T[] preOrder() {
		ArrayList<T> list = new ArrayList<>();
		this.preOrder(list, this.getRoot());
		return (T[]) list.toArray(new Comparable[list.size()]);
	}

	private void preOrder(ArrayList<T> list, BSTNode<T> node) {
		if (!node.isEmpty()) {
			list.add(node.getData());
			this.preOrder(list, (BSTNode<T>) node.getLeft());
			this.preOrder(list, (BSTNode<T>) node.getRight());
		}
	}

	@Override
	public T[] order() {
		// TODO Auto-generated method stub
		ArrayList<T> list = new ArrayList<>();
		// this.preOrder(list, this.getRoot());
		return (T[]) list.toArray();
	}

	@Override
	public T[] postOrder() {
		ArrayList<T> list = new ArrayList<>();
		// this.preOrder(list, this.getRoot());
		return (T[]) list.toArray();
	}

	/**
	 * This method is already implemented using recursion. You must understand
	 * how it work and use similar idea with the other methods.
	 */
	@Override
	public int size() {
		return size(root);
	}

	private int size(BSTNode<T> node) {
		int result = 0;
		// base case means doing nothing (return 0)
		if (!node.isEmpty()) { // indusctive case
			result = 1 + size((BSTNode<T>) node.getLeft())
					+ size((BSTNode<T>) node.getRight());
		}
		return result;
	}

}
