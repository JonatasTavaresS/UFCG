package recursao;

public class MetodosRecursivos {

	public int calcularSomaArray(int[] array) {
		int result = 0;
		// TODO ESCREVA AQUI O CÓDIGO (USANDO RECURSAO) PARA CALCULAR A SOMA
		// DOS EMENTOS DE UM ARRAY
		return result;
	}

	public long calcularFatorial(int n) {
		long result = 1;
		if (n != 0) {
			result = n * calcularFatorial(n - 1);
		}
		System.out.println(n + "! = " + result);
		return result;
	}

	public int calcularFibonacci(int n) {
		if (n == 1) {
			return 0;
		}
		if (n == 1 || n == 2) {
			return 1;
		}
		return calcularFibonacci(n - 2) + calcularFibonacci(n - 1);
	}

	public int countNotNull(Object[] array) {
		int result = 0;
		result = countNotNull(array, 0);
		return result;
	}

	private int countNotNull(Object[] array, int indexFrom) {
		int result = 0;
		if (array[indexFrom] != null) {
			result++;
		}
		if (indexFrom != array.length - 1) {
			result = result + countNotNull(array, indexFrom + 1);
		}
		return result;
	}

	public long potenciaDe2(int expoente) {
		long result = 1;
		if (expoente != 0) {
			result = 2 * potenciaDe2(expoente - 1);
		}
		return result;
	}

	public double progressaoAritmetica(double termoInicial, double razao, int n) {
		double result = termoInicial;
		if (n != 1) {
			result = progressaoAritmetica(termoInicial, razao, n - 1) + razao;
		}
		return result;
	}

	public double progressaoGeometrica(double termoInicial, double razao, int n) {
		double result = termoInicial;
		if (n != 1) {
			result = progressaoAritmetica(termoInicial, razao, n - 1) * razao;
		}
		return result;
	}
}
