package problems;

/**
 * @author Jônatas Tavares dos Santos - 121110769
 */
public class BitonicPointBinarySearchImpl<T extends Comparable<T>> implements BitonicPointBinarySearch<T> {

    @Override
    public T bitonicPoint(T[] array) {
        // Tratamento caso o array não tenha elementos
        if (array != null && array.length > 0) {
            return this.search(array, 0, array.length - 1);
        }
        return null;
    }

    private T search(T[] array, int leftIndex, int rightIndex) {
        if (leftIndex >= 0 && leftIndex <= rightIndex && rightIndex < array.length) {
            int middleIndex = (leftIndex + rightIndex) / 2;

            // Caso base onde o intervalo do array tem 1 ou 2 elementos, retorna o maior
            if (middleIndex == leftIndex) {
                if (array[leftIndex].compareTo(array[rightIndex]) >= 0) {
                    return array[leftIndex];
                } else {
                    return array[rightIndex];
                }
            }

            if (array[middleIndex - 1].compareTo(array[middleIndex]) < 0) {
                // Middle atual é o ponto bitônico
                if (array[middleIndex + 1].compareTo(array[middleIndex]) < 0) {
                    return array[middleIndex];
                }
                // Ponto bitônico está na partição a direita do middle
                else {
                    return search(array, middleIndex + 1, rightIndex);
                }
            }
            // Ponto bitônico está na partição a esquerda do middle
            else {
                return search(array, leftIndex, middleIndex - 1);
            }
        }
        return null;
    }
}
