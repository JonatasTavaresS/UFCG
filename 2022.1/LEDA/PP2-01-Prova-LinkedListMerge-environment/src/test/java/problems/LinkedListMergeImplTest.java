package problems;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import adt.linkedList.SingleLinkedListNode;

public class LinkedListMergeImplTest {

    LinkedListMerge<Integer> linkedList;
    SingleLinkedListNode<Integer> emptyNode;
    SingleLinkedListNode<Integer> node1;
    SingleLinkedListNode<Integer> node2;

    @Before
    public void setUp() {
        this.linkedList = new LinkedListMergeImpl<>();
        this.emptyNode = new SingleLinkedListNode<Integer>();
        this.node1 = this.createNode(new Integer[] { 1, 2, 3, 4, 5 });
        this.node2 = this.createNode(new Integer[] { 6, 7, 8, 9, 10 });
    }

    @Test
    public void testMerge01() {
        SingleLinkedListNode<Integer> expected = this.createNode(new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 });
        SingleLinkedListNode<Integer> result = this.linkedList.merge(node1, node2);
        assertEquals(expected, result);
        assertEquals(toString(expected), toString(result));
    }

    @Test
    public void testMerge02() {
        SingleLinkedListNode<Integer> expected = this.createNode(new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 });
        SingleLinkedListNode<Integer> result = this.linkedList.merge(node2, node1);
        assertEquals(expected, result);
        assertEquals(toString(expected), toString(result));
    }

    @Test
    public void testMerge03() {
        SingleLinkedListNode<Integer> node1 = this.createNode(new Integer[] { 1, 3, 6 });
        SingleLinkedListNode<Integer> node2 = this.createNode(new Integer[] { 2, 4, 5, 8, 9 });
        SingleLinkedListNode<Integer> expected = this.createNode(new Integer[] { 1, 2, 3, 4, 5, 6, 8, 9 });
        SingleLinkedListNode<Integer> result = this.linkedList.merge(node1, node2);
        assertEquals(expected, result);
        assertEquals(toString(expected), toString(result));
    }

    @Test
    public void testMerge04() {
        SingleLinkedListNode<Integer> node2 = this.createNode(new Integer[] { 1, 3, 6 });
        SingleLinkedListNode<Integer> node1 = this.createNode(new Integer[] { 2, 4, 5, 8, 9 });
        SingleLinkedListNode<Integer> expected = this.createNode(new Integer[] { 1, 2, 3, 4, 5, 6, 8, 9 });
        SingleLinkedListNode<Integer> result = this.linkedList.merge(node1, node2);
        assertEquals(expected, result);
        assertEquals(toString(expected), toString(result));
    }

    @Test
    public void testMerge05() {
        SingleLinkedListNode<Integer> node1 = this.createNode(new Integer[] { -3000, 83, 650 });
        SingleLinkedListNode<Integer> node2 = this.createNode(new Integer[] { 78, 239, 562, 3450, 6964 });
        SingleLinkedListNode<Integer> expected = this
                .createNode(new Integer[] { -3000, 78, 83, 239, 562, 650, 3450, 6964 });
        SingleLinkedListNode<Integer> result = this.linkedList.merge(node1, node2);
        assertEquals(expected, result);
        assertEquals(toString(expected), toString(result));
    }

    @Test
    public void testMerge06() {
        SingleLinkedListNode<Integer> node1 = this.createNode(new Integer[] { 0 });
        SingleLinkedListNode<Integer> node2 = this.createNode(new Integer[] {});
        SingleLinkedListNode<Integer> expected = this.createNode(new Integer[] { 0 });
        SingleLinkedListNode<Integer> result = this.linkedList.merge(node1, node2);
        assertEquals(expected, result);
        assertEquals(toString(expected), toString(result));
    }

    @Test
    public void testMergeAmbosNull() {
        SingleLinkedListNode<Integer> expected = this.emptyNode;
        SingleLinkedListNode<Integer> result = this.linkedList.merge(null, null);
        assertEquals(expected, result);
        assertEquals(toString(expected), toString(result));
    }

    @Test
    public void testMergePrimeiroNull() {
        SingleLinkedListNode<Integer> expected = this.node2;
        SingleLinkedListNode<Integer> result = this.linkedList.merge(null, this.node2);
        assertEquals(expected, result);
        assertEquals(toString(expected), toString(result));
    }

    @Test
    public void testMergeSegundoNull() {
        SingleLinkedListNode<Integer> expected = this.node1;
        SingleLinkedListNode<Integer> result = this.linkedList.merge(this.node1, null);
        assertEquals(expected, result);
        assertEquals(toString(expected), toString(result));
    }

    @Test
    public void testMergeAmbosEmpty() {
        SingleLinkedListNode<Integer> expected = this.emptyNode;
        SingleLinkedListNode<Integer> result = this.linkedList.merge(this.emptyNode, this.emptyNode);
        assertEquals(expected, result);
        assertEquals(toString(expected), toString(result));
    }

    @Test
    public void testMergePrimeiroEmpty() {
        SingleLinkedListNode<Integer> expected = this.node2;
        SingleLinkedListNode<Integer> result = this.linkedList.merge(this.emptyNode, this.node2);
        assertEquals(expected, result);
        assertEquals(toString(expected), toString(result));
    }

    @Test
    public void testMergeSegundoEmpty() {
        SingleLinkedListNode<Integer> expected = this.node1;
        SingleLinkedListNode<Integer> result = this.linkedList.merge(this.node1, this.emptyNode);
        assertEquals(expected, result);
        assertEquals(toString(expected), toString(result));
    }

    public SingleLinkedListNode<Integer> createNode(Integer[] values) {
        SingleLinkedListNode<Integer> node = new SingleLinkedListNode<Integer>();
        SingleLinkedListNode<Integer> aux = node;
        for (int i = 0; i < values.length; i++) {
            aux.setData(values[i]);
            aux.setNext(new SingleLinkedListNode<Integer>());
            aux = aux.getNext();
        }
        return node;
    }

    public String toString(SingleLinkedListNode<Integer> node) {
        String retorno = "";
        SingleLinkedListNode<Integer> aux = node;
        while (!aux.isNIL()) {
            retorno += aux.toString() + " ";
            aux = aux.getNext();
        }
        return retorno;
    }

}
