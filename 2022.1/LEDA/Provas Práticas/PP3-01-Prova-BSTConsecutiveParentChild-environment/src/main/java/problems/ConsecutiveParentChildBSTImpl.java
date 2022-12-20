package problems;

import java.util.Set;
import java.util.TreeSet;

import adt.bst.BSTNode;

/**
 * @author Jônatas Tavares dos Santos - 121110769
 */
public class ConsecutiveParentChildBSTImpl extends BSTInteger implements ConsecutiveParentChildBST {

    public Set<Pair> findConsecutives() {
        Set<Pair> consecutives = new TreeSet<>();
        return this.findConsecutives(this.getRoot(), consecutives);
    }

    private Set<Pair> findConsecutives(BSTNode<Integer> node, Set<Pair> consecutives) {
        if (node != null && !node.isEmpty()) {
            // Caso haja nó na esquerda, busca consecutivos no nó da esquerda
            if (node.getLeft() != null && !node.getLeft().isEmpty()) {
                if ((node.getData() - node.getLeft().getData()) == 1) {
                    consecutives.add(new Pair(node.getData(), node.getLeft().getData()));
                }
                consecutives = this.findConsecutives((BSTNode<Integer>) node.getLeft(), consecutives);
            }
            // Caso haja nó na direita, busca consecutivos no nó da direita
            if (node.getRight() != null && !node.getRight().isEmpty()) {
                if ((node.getData() - node.getRight().getData()) == -1) {
                    consecutives.add(new Pair(node.getData(), node.getRight().getData()));
                }
                consecutives = this.findConsecutives((BSTNode<Integer>) node.getRight(), consecutives);
            }
        }
        return consecutives;
    }

}
