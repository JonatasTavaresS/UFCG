package orderStatistic;

import java.util.PriorityQueue;

/**
 * @author Jônatas Tavares dos Santos - 121110769
 */
public class OrderStatisticsHeapImpl<T extends Comparable<T>> implements OrderStatistics<T> {

	/**
	 * Existem diversas formas de se calcular uma estatistica de ordem.
	 * Voce deve fazer isso usando uma heap restricoes:
	 * - nenhuma copia ou estrutura array auxiliar serah permitida, exceto o uso de
	 * uma PriorityQueue
	 * - caso a estatistica de ordem procurada nao exista no array o metodo deve
	 * retornar null
	 * 
	 * @param array
	 * @param k
	 * @return
	 */
	@Override
	public T getOrderStatistics(T[] array, int k) {
		T getOrderStatistics = null;
		if (array != null && array.length > 0 && k >= 1 && k <= array.length) {
			PriorityQueue<T> heap = new PriorityQueue<T>();
			for (T element : array) {
				heap.add(element);
			}
			for (int i = k; i > 0; i--) {
				getOrderStatistics = heap.poll();
			}
		}
		return getOrderStatistics;
	}

}
