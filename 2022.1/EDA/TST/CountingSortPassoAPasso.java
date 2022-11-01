import java.util.Scanner;

class CountingSortPassoAPasso {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] A = arrayToInt(in.nextLine().split(" "));
        int d = in.nextInt();
        in.close();
        for (int i = 0; i < A.length; i++) {
            for (int j = A.length; j >= 0; j -= 2) {
                
            }
        }
        for (int i = 0; i < A.length; i++) {
            C[A[i]]++;
            arrayToString(C);
        }
        for (int i = 1; i < C.length; i++) {
            C[i] += C[i - 1];
        }
        System.out.print("Cumulativa do vetor de contagem - ");
        arrayToString(C);
        int[] B = new int[A.length];
        for (int i = B.length - 1; i >= 0; i--) {
            B[C[A[i]] - 1] = A[i];
            C[A[i]]--;
        }
        arrayToString(C);
        arrayToString(B);
    }

    private int max(String[] A, int left, int right) {
        String max = A[0].substring(left, right);
        for (int i = 0; i < A.length; i++) {
            if (A[i] > max) {
                max = A[i];
            }
        }
        return max;
    }

    private static int[] arrayToInt(String[] s) {
        int[] v = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            v[i] = Integer.parseInt(s[i]);
        }
        return v;
    }
}
