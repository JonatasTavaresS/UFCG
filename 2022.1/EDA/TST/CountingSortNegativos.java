import java.util.Arrays;
import java.util.Scanner;

class CountingSortNegativos {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] A = arrayToInt(in.nextLine().split(" "));
        int maior = in.nextInt();
        int menor = in.nextInt();
        int[] C = new int[maior - menor + 1];
        in.close();
        for (int i = 0; i < A.length; i++) {
            C[A[i] - menor]++;
            System.out.println(Arrays.toString(C));
        }
        for (int i = 1; i < C.length; i++) {
            C[i] += C[i - 1];
        }
        System.out.println("Cumulativa do vetor de contagem - " + Arrays.toString(C));
        int[] B = new int[A.length];
        for (int i = B.length - 1; i >= 0; i--) {
            B[C[A[i] - menor] - 1] = A[i];
            C[A[i] - menor]--;
        }
        System.out.println(Arrays.toString(C));
        System.out.println(Arrays.toString(B));
    }

    private static int[] arrayToInt(String[] s) {
        int[] v = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            v[i] = Integer.parseInt(s[i]);
        }
        return v;
    }
}
