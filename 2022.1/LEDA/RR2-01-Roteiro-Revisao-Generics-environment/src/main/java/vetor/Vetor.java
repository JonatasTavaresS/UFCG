package vetor;

import java.util.Comparator;

/**
 * Implementação de um vetor de objetos simples para exercitar os conceitos de
 * Generics.
 * 
 * @author Adalberto
 *
 */
public class Vetor<T extends Comparable<T>> {

	// O array interno onde os objetos manipulados são guardados
	private T[] arrayInterno;

	// O tamanho que o array interno terá
	private int tamanho;

	// Indice que guarda a proxima posição vazia do array interno
	private int indice;

	// O Comparators a serem utilizados
	private Comparator<T> comparadorMaximo;
	private Comparator<T> comparadorMinimo;

	public Vetor(int tamanho) {
		super();
		this.tamanho = tamanho;
		this.indice = -1;
		this.arrayInterno = (T[]) new Comparable[tamanho];
	}

	public void setComparadorMaximo(Comparator<T> comparadorMaximo) {
		this.comparadorMaximo = comparadorMaximo;
	}

	public void setComparadorMinimo(Comparator<T> comparadorMinimo) {
		this.comparadorMinimo = comparadorMinimo;
	}

	// Insere um objeto no vetor
	public void inserir(T o) {
		if (this.indice != this.tamanho - 1) {
			this.indice++;
			this.arrayInterno[indice] = o;
		}
	}

	// Remove um objeto do vetor
	public T remover(T o) {
		for (int i = 0; i < this.arrayInterno.length; i++) {
			if (this.arrayInterno[i].equals(o)) {
				indice--;
				return this.arrayInterno[i] = null;
			}
		}
		return null;
	}

	// Procura um elemento no vetor
	public T procurar(T o) {
		if (o == null) {
			return null;
		}
		for (T t : this.arrayInterno) {
			if (o.equals(t)) {
				return t;
			}
		}
		return null;
	}

	// Diz se o vetor está vazio
	public boolean isVazio() {
		if (this.indice == -1) {
			return true;
		}
		return false;
	}

	// Diz se o vetor está cheio
	public boolean isCheio() {
		return this.indice == this.tamanho - 1;
	}

	public T maximo() {
		T result = null;
		if (!isVazio()) {
			result = arrayInterno[0];
			for (int i = 0; i <= indice; i++) {
				if (comparadorMaximo.compare(result, arrayInterno[i]) < 0) {
					result = arrayInterno[i];
				}
			}
		}
		return result;
	}

	public T minimo() {
		T result = null;
		if (!isVazio()) {
			result = arrayInterno[0];
			for (int i = 0; i <= indice; i++) {
				if (comparadorMinimo.compare(result, arrayInterno[i]) < 0) {
					result = arrayInterno[i];
				}
			}
		}
		return result;
	}
}

class ComparadorMaximo implements Comparator<Aluno> {

	@Override
	public int compare(Aluno o1, Aluno o2) {
		return (int) (o1.getMedia() - o2.getMedia());
	}
}

class ComparadorMinimo implements Comparator<Aluno> {

	@Override
	public int compare(Aluno o1, Aluno o2) {
		return (int) (o2.getMedia() - o1.getMedia());
	}
}
