import java.util.Scanner;

class QuickSortPassoAPasso {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] v = arrayToInt(in.nextLine().split(" "));
        in.close();
        quickSort(v, 0, v.length - 1);
    }

    private static void quickSort(int[] v, int left, int right) {
        if (left < right) {
            int index_pivot = partition(v, left, right);
            System.out.println(arrayToString(v));
            quickSort(v, left, index_pivot - 1);
            quickSort(v, index_pivot + 1, right);
        }
    }

    private static int partition(int[] v, int left, int right) {
        int pivot = v[left];
        int i = left;
        for (int j = left + 1; j <= right; j++) {
            if (v[j] <= pivot) {
                i += 1;
                swap(v, i, j);
            }
        }
        swap(v, left, i);
        return i;
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

    private static String arrayToString(int[] v) {
        String array = "";
        for (int i = 0; i < v.length; i++) {
            if (i == 0) {
                array += v[i];
            } else {
                array += " " + v[i];
            }
        }
        return array;
    }
}
