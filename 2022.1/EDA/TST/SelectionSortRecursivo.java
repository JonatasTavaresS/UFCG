import java.util.Arrays;
import java.util.Scanner;

class SelectionSortRecursivo {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] v = arrayToInt(in.nextLine().split(" "));
        in.close();
        selectionSort(v, 0);
    }

    private static void selectionSort(int[] v, int i) {
        if (i == v.length - 1) {
            return;
        }
        int index_menor = i;
        for (int j = i + 1; j < v.length; j++) {
            if (v[j] < v[index_menor]) {
                index_menor = j;
            }
        }
        swap(v, i, index_menor);
        System.out.println(Arrays.toString(v));
        selectionSort(v, i + 1);
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
