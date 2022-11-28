package adt.hashtable.open;

import adt.hashtable.hashfunction.HashFunctionClosedAddressMethod;
import adt.hashtable.hashfunction.HashFunctionQuadraticProbing;

public class HashtableOpenAddressQuadraticProbingImpl<T extends Storable>
		extends AbstractHashtableOpenAddress<T> {

	public HashtableOpenAddressQuadraticProbingImpl(int size,
			HashFunctionClosedAddressMethod method, int c1, int c2) {
		super(size);
		hashFunction = new HashFunctionQuadraticProbing<T>(size, method, c1, c2);
		this.initiateInternalTable(size);
	}

	@Override
	public void insert(T element) {
		if (!this.isFull() && element != null) {
			int probe = 0;
			int hash = ((HashFunctionQuadraticProbing<T>) this.getHashFunction()).hash(element, probe);
			while (probe < this.capacity() && this.table[hash] != null && this.table[hash] != this.deletedElement) {
				probe++;
				hash = ((HashFunctionQuadraticProbing<T>) this.getHashFunction()).hash(element, probe);
				this.COLLISIONS++;
			}
			this.table[hash] = element;
			this.elements++;
		}
	}

	@Override
	public void remove(T element) {
		if (this.indexOf(element) >= 0) {
			this.table[this.indexOf(element)] = this.deletedElement;
			this.elements--;
		}
	}

	@Override
	public T search(T element) {
		T search = null;
		if (this.indexOf(element) >= 0) {
			search = (T) this.table[this.indexOf(element)];
		}
		return search;
	}

	@Override
	public int indexOf(T element) {
		int indexOf = -1;
		if (!this.isEmpty() && element != null) {
			int probe = 0;
			int hash = ((HashFunctionQuadraticProbing<T>) this.getHashFunction()).hash(element, probe);
			while (probe < this.capacity() && this.table[hash] != null
					&& this.table[hash] != this.deletedElement && !this.table[hash].equals(element)) {
				probe++;
				hash = ((HashFunctionQuadraticProbing<T>) this.getHashFunction()).hash(element, probe);
			}
			if (this.table[hash] != null && this.table[hash].equals(element)) {
				indexOf = hash;
			}
		}
		return indexOf;
	}
}