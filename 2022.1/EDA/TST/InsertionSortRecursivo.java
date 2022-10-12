import java.util.Arrays;
import java.util.Scanner;

class InsertionSortRecursivo {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] v = arrayToInt(in.nextLine().split(" "));
        in.close();
        selectionSort(v, 1);
    }

    private static void selectionSort(int[] v, int i) {
        if (i == v.length) {
            return;
        }
        int j = i;
        while (j > 0 && v[j] < v[j - 1]) {
            swap(v, j, j - 1);
            j--;
        }
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
