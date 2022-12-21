package adt.bst;

/**
 * 
 * Performs consistency validations within a BST instance
 * 
 * @author Claudio Campelo
 *
 * @param <T>
 */
public class BSTVerifierImpl<T extends Comparable<T>> implements BSTVerifier<T> {

	private BSTImpl<T> bst;

	public BSTVerifierImpl(BST<T> bst) {
		this.bst = (BSTImpl<T>) bst;
	}

	private BSTImpl<T> getBSt() {
		return bst;
	}

	@Override
	public boolean isBST() {
		return this.getBSt().isEmpty() || this.isBST(this.getBSt().getRoot());
	}

	private boolean isBST(BSTNode<T> node) {
		boolean isBST = true;
		if (node != null && !node.isEmpty()) {
			if (this.isValidLeft(node) && this.isValidRight(node)) {
				isBST = this.isBST((BSTNode<T>) node.getLeft()) && this.isBST((BSTNode<T>) node.getRight());
			} else {
				isBST = false;
			}
		}
		return isBST;
	}

	private boolean isValidLeft(BSTNode<T> node) {
		return this.isValidLeft((BSTNode<T>) node.getLeft(), node);
	}

	private boolean isValidLeft(BSTNode<T> node, BSTNode<T> root) {
		boolean isValid = true;
		if (node != null && !node.isEmpty()) {
			if (node.getData().compareTo(root.getData()) < 0) {
				isValid = this.isValidLeft((BSTNode<T>) node.getLeft(), root)
						&& this.isValidLeft((BSTNode<T>) node.getRight(), root);
			} else {
				isValid = false;
			}
		}
		return isValid;
	}

	private boolean isValidRight(BSTNode<T> node) {
		return this.isValidRight((BSTNode<T>) node.getRight(), node);
	}

	private boolean isValidRight(BSTNode<T> node, BSTNode<T> root) {
		boolean isValid = true;
		if (node != null && !node.isEmpty()) {
			if (node.getData().compareTo(root.getData()) > 0) {
				isValid = this.isValidRight((BSTNode<T>) node.getLeft(), root)
						&& this.isValidRight((BSTNode<T>) node.getRight(), root);
			} else {
				isValid = false;
			}
		}
		return isValid;
	}

}
