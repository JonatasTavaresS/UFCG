import java.util.Arrays;
import java.util.Scanner;

class SelectionSortPassoAPasso {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] v = arrayToInt(in.nextLine().split(" "));
        in.close();
        for (int i = 0; i < v.length; i++) {
            int index_menor = i;
            for (int j = i + 1; j < v.length; j++) {
                if (v[j] < v[index_menor]) {
                    index_menor = j;
                }
            }
            if (i != index_menor) {
                swap(v, i, index_menor);
                System.out.println(Arrays.toString(v));
            }
        }
    }

    private static void swap(int[] v, int i, int j) {
        int temp = v[i];
        v[i] = v[j];
        v[j] = temp;
    }

    private static int[] arrayToInt(String[] s) {
        int[] v = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            v[i] = Integer.parseInt(s[i]);
        }
        return v;
    }
}
