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
		return isBST(this.getBSt().getRoot());
	}

	private boolean isBST(BSTNode<T> node) {
		boolean isBST = true;
		if (node != null && !node.isEmpty()) {
			boolean left = true;
			boolean right = true;
			System.out.println(node.getData() + " " + node.getLeft().getData() + " " + node.getRight().getData());
			if (!node.getLeft().isEmpty()) {
				left = node.getData().compareTo(node.getLeft().getData()) > 0;
			}
			if (!node.getRight().isEmpty()) {
				right = node.getData().compareTo(node.getRight().getData()) < 0;
			}
			System.out.println(left + " " + right);
			if (left && right) {
				isBST = this.isBST((BSTNode<T>) node.getLeft()) && this.isBST((BSTNode<T>) node.getRight());
			} else {
				isBST = false;
			}
		}
		return isBST;
	}

}
