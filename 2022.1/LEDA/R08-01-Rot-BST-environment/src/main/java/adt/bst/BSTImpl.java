package adt.bst;

import java.util.ArrayList;

/**
 * @author Jônatas Tavares dos Santos - 121110769
 */
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
			} else if (compareTo > 0) {
				this.insert((BSTNode<T>) node.getRight(), element);
			}
		}
	}

	@Override
	public BSTNode<T> maximum() {
		BSTNode<T> maximum = null;
		if (!this.isEmpty()) {
			maximum = this.maximum(this.getRoot());
		}
		return maximum;
	}

	private BSTNode<T> maximum(BSTNode<T> node) {
		BSTNode<T> maximum = node;
		if (!node.getRight().isEmpty()) {
			maximum = this.maximum((BSTNode<T>) node.getRight());
		}
		return maximum;
	}

	@Override
	public BSTNode<T> minimum() {
		BSTNode<T> minimum = null;
		if (!this.isEmpty()) {
			minimum = this.minimum(this.getRoot());
		}
		return minimum;
	}

	private BSTNode<T> minimum(BSTNode<T> node) {
		BSTNode<T> minimum = node;
		if (!node.getLeft().isEmpty()) {
			minimum = this.minimum((BSTNode<T>) node.getLeft());
		}
		return minimum;
	}

	@Override
	public BSTNode<T> sucessor(T element) {
		BSTNode<T> sucessor = null;
		BSTNode<T> node = search(element);
		if (!node.isEmpty()) {
			if (!node.getRight().isEmpty()) {
				sucessor = this.minimum((BSTNode<T>) node.getRight());
			} else {
				BSTNode<T> aux = (BSTNode<T>) node.getParent();
				while (aux != null && aux.getData().compareTo(node.getData()) > 0) {
					aux = (BSTNode<T>) aux.getParent();
				}
				sucessor = aux;
			}
		}
		return sucessor;
	}

	@Override
	public BSTNode<T> predecessor(T element) {
		BSTNode<T> predecessor = null;
		BSTNode<T> node = search(element);
		if (!node.isEmpty()) {
			if (!node.getLeft().isEmpty()) {
				predecessor = this.maximum((BSTNode<T>) node.getLeft());
			} else {
				BSTNode<T> aux = (BSTNode<T>) node.getParent();
				while (aux != null && aux.getData().compareTo(node.getData()) > 0) {
					aux = (BSTNode<T>) aux.getParent();
				}
				predecessor = aux;
			}
		}
		return predecessor;
	}

	@Override
	public void remove(T element) {
		BSTNode<T> toRemove = search(element);
		if (!toRemove.isEmpty()) {
			this.remove(toRemove);
		}
	}

	private void remove(BSTNode<T> node) {
		if (!node.isEmpty()) {
			if (node.isLeaf())
				node.setData(null);
			else if (hasOnlyChild(node)) {

				if (node.getParent() != null) {
					if (node.getParent().getData().compareTo(node.getData()) > 0) {
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
					if (node.getLeft().isEmpty()) {
						root = (BSTNode<T>) node.getRight();
						root.setParent(null);
					} else {
						root = (BSTNode<T>) node.getLeft();
						root.setParent(null);
					}
				}

			} else { // complete node
				BSTNode<T> sucessor = sucessor(node.getData());
				node.setData(sucessor.getData());
				remove(sucessor);
			}
		}
	}

	private boolean hasOnlyChild(BSTNode<T> node) {
		return (node.getLeft().isEmpty() && !node.getRight().isEmpty()) ||
				(!node.getLeft().isEmpty() && node.getRight().isEmpty());
	}

	@SuppressWarnings("unchecked")
	@Override
	public T[] preOrder() {
		ArrayList<T> list = new ArrayList<>();
		this.preOrder(list, this.getRoot());
		return (T[]) list.toArray(new Comparable[list.size()]);
	}

	private void preOrder(ArrayList<T> list, BSTNode<T> node) {
		if (node != null && !node.isEmpty()) {
			list.add(node.getData());
			this.preOrder(list, (BSTNode<T>) node.getLeft());
			this.preOrder(list, (BSTNode<T>) node.getRight());
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public T[] order() {
		ArrayList<T> list = new ArrayList<>();
		this.order(list, this.getRoot());
		return (T[]) list.toArray(new Comparable[list.size()]);
	}

	private void order(ArrayList<T> list, BSTNode<T> node) {
		if (node != null && !node.isEmpty()) {
			this.order(list, (BSTNode<T>) node.getLeft());
			list.add(node.getData());
			this.order(list, (BSTNode<T>) node.getRight());
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public T[] postOrder() {
		ArrayList<T> list = new ArrayList<>();
		this.postOrder(list, this.getRoot());
		return (T[]) list.toArray(new Comparable[list.size()]);
	}

	private void postOrder(ArrayList<T> list, BSTNode<T> node) {
		if (node != null && !node.isEmpty()) {
			this.postOrder(list, (BSTNode<T>) node.getLeft());
			this.postOrder(list, (BSTNode<T>) node.getRight());
			list.add(node.getData());
		}
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
