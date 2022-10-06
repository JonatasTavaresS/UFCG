import java.util.Arrays;

/**
 * @author Jônatas Tavares dos Santos - 121110769
 */
public class AnaliseAssintotica {

    public static void main(String[] args) {
        int[] v = new int[] { 1, 13, 3, 4, 5 };
        troca_vizinhos(v);
        System.out.println(Arrays.toString(v));
        System.out.println(eh_palindromo(new char[] { 'a', 'n', 'a' }));
        System.out.println(eh_palindromo(new char[] { 'c', 'a', 's', 'a' }));
        System.out.println(Arrays.toString(two_sum(new int[] { 1, 13, 0, 4, 5 }, 5)));
        System.out.println(eh_primo(3));
        System.out.println(eh_primo(15));
        System.out.println(tem_repetido(new int[] { 1, 13, 3, 4, 5, 1 }));
        System.out.println(tem_repetido(new int[] { 1, 13, 3, 4, 5, 2 }));
        System.out.println(vetorCircular(new int[] { 4, 5, 6, 1 }, 6));
        System.out.println(vetorCircular(new int[] { 3, 4, 2 }, 8));
    }

    public static void troca_vizinhos(int[] v) {
        for (int i = 0; i < v.length - 1; i += 2) {
            int temp = v[i];
            v[i] = v[i + 1];
            v[i + 1] = temp;
        }
    }

    public static boolean eh_palindromo(char[] palavra) {
        for (int i = 0; i < palavra.length / 2; i++) {
            if (palavra[i] != palavra[palavra.length - 1 - i]) {
                return false;
            }
        }
        return true;
    }

    public static int[] two_sum(int[] v, int target) {
        for (int i = 0; i < v.length; i++) {
            for (int j = i + 1; j < v.length; j++) {
                if (v[i] + v[j] == target) {
                    return new int[] { v[i], +v[j] };
                }
            }
        }
        return new int[2];
    }

    public static boolean eh_primo(int n) {
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean tem_repetido(int[] v) {
        for (int i = 0; i < v.length; i++) {
            for (int j = i + 1; j < v.length; j++) {
                if (v[i] == v[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    public static String vetorCircular(int[] array, int quantidadeElementos) {
        String saida = "";
        int j = 0;
        for (int i = 0; i < quantidadeElementos; i++) {
            saida += " " + array[j];
            j++;
            if (j == array.length) {
                j = 0;
            }
        }
        return saida.trim();
    }
}
