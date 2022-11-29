package problems;

import adt.linkedList.SingleLinkedListNode;

/**
 * @author Jônatas Tavares dos Santos - 121110769
 */
public class LinkedListMergeImpl<T extends Comparable<T>> implements LinkedListMerge<T> {
    public SingleLinkedListNode<T> merge(SingleLinkedListNode<T> node1, SingleLinkedListNode<T> node2) {

        // Primeiro nó da uma lista resultante do merge de node1 com node2
        SingleLinkedListNode<T> mergeNode = new SingleLinkedListNode<T>();

        // Tratamento para evitar NullPointerException
        if (node1 != null && node2 != null) {
            SingleLinkedListNode<T> aux = mergeNode;

            // Enquanto houver elementos em uma das listas, compara-os e insere
            // ordenadamente.
            while (!node1.isNIL() && !node2.isNIL()) {
                if (node1.getData().compareTo(node2.getData()) < 0) {
                    aux.setData(node1.getData());
                    node1 = node1.getNext();
                } else {
                    aux.setData(node2.getData());
                    node2 = node2.getNext();
                }
                aux.setNext(new SingleLinkedListNode<T>());
                aux = aux.getNext();
            }

            // Insere os elementos restantes da primeira lista.
            while (!node1.isNIL()) {
                aux.setData(node1.getData());
                aux.setNext(new SingleLinkedListNode<T>());
                node1 = node1.getNext();
                aux = aux.getNext();
            }

            // Insere os elementos restantes da segunda lista.
            while (!node2.isNIL()) {
                aux.setData(node2.getData());
                aux.setNext(new SingleLinkedListNode<T>());
                node2 = node2.getNext();
                aux = aux.getNext();
            }

        } else if (node1 == null && node2 != null) {
            mergeNode = node2;
        } else if (node2 == null && node1 != null) {
            mergeNode = node1;
        }

        return mergeNode;
    }
}
