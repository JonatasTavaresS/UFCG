package adt.bst;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Jônatas Tavares dos Santos - 121110769
 */
public class BSTVerifierImplTest {

    BSTVerifierImpl<Integer> implementation;

    @Before
    public void setUp() {
        // this.implementation = new BSTVerifierImpl<>(tree);
    }

    private BSTImpl<Integer> fillTree(Integer[] array) {
        BSTImpl<Integer> tree = new BSTImpl<>();
        for (int i : array) {
            tree.insert(i);
        }
        return tree;
    }

    @Test
    public void testIsBST01() {

    }
}
