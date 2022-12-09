package adt.bst;

/**
 * - Esta eh a unica classe que pode ser modificada
 * 
 * @author adalbertocajueiro
 *
 * @param <T>
 */
public class SimpleBSTManipulationImpl<T extends Comparable<T>> implements SimpleBSTManipulation<T> {

	@Override
	public boolean equals(BST<T> tree1, BST<T> tree2) {
		boolean equals = false;
		if (tree1 != null && tree2 != null) {
			equals = this.equals((BSTNode<T>) tree1.getRoot(), (BSTNode<T>) tree2.getRoot());
		}
		return equals;
	}

	private boolean equals(BSTNode<T> node1, BSTNode<T> node2) {
		boolean equals = false;
		if (node1.isEmpty() && node2.isEmpty()) {
			equals = true;
		} else if (node1.getData().equals(node2.getData())) {
			boolean left = this.equals((BSTNode<T>) node1.getLeft(), (BSTNode<T>) node2.getLeft());
			boolean right = this.equals((BSTNode<T>) node1.getRight(), (BSTNode<T>) node2.getRight());
			equals = left && right;
		}
		return equals;
	}

	@Override
	public boolean isSimilar(BST<T> tree1, BST<T> tree2) {
		boolean isSimilar = false;
		if (tree1 != null && tree2 != null) {
			isSimilar = this.isSimilar((BSTNode<T>) tree1.getRoot(), (BSTNode<T>) tree2.getRoot());
		}
		return isSimilar;
	}

	private boolean isSimilar(BSTNode<T> node1, BSTNode<T> node2) {
		boolean isSimilar = false;
		if (node1.isEmpty() && node2.isEmpty()) {
			isSimilar = true;
		} else if (!node1.isEmpty() && !node2.isEmpty()) {
			boolean left = this.isSimilar((BSTNode<T>) node1.getLeft(), (BSTNode<T>) node2.getLeft());
			boolean right = this.isSimilar((BSTNode<T>) node1.getRight(), (BSTNode<T>) node2.getRight());
			isSimilar = left && right;
		}
		return isSimilar;
	}

	@Override
	public T orderStatistic(BST<T> tree, int k) {
		T orderStatistic = null;
		if (tree != null && k >= 1 && k <= tree.size()) {
			orderStatistic = this.orderStatistic(tree, k, tree.minimum(), 1);
		}
		return orderStatistic;
	}

	private T orderStatistic(BST<T> tree, int k, BSTNode<T> node, int index) {
		T orderStatistic = null;
		if (index == k) {
			orderStatistic = node.getData();
		} else {
			orderStatistic = this.orderStatistic(tree, k, tree.sucessor(node.getData()), index + 1);
		}
		return orderStatistic;
	}

}
