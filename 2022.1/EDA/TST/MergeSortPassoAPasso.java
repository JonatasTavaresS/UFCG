import java.util.Scanner;

class MergeSortPassoAPasso {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] v = arrayToInt(in.nextLine().split(" "));
        in.close();
        mergeSort(v, 0, v.length - 1);
    }

    private static void mergeSort(int[] v, int left, int right) {
        arrayToStringIntervalo(v, left, right);
        if (left < right) {
            int middleIndex = (left + right) / 2;
            mergeSort(v, left, middleIndex);
            mergeSort(v, middleIndex + 1, right);
            merge(v, left, middleIndex, right);
            arrayToStringIntervalo(v, left, right);
        }
    }

    private static void merge(int[] v, int left, int middleIndex, int right) {
        int[] helper = new int[v.length];
        for (int i = left; i <= right; i++) {
            helper[i] = v[i];
        }
        int i = left, k = left, j = middleIndex + 1;
        while (i <= middleIndex && j <= right) {
            if (helper[i] < helper[j]) {
                v[k++] = helper[i++];
            } else {
                v[k++] = helper[j++];
            }
        }
        while (i <= middleIndex) {
            v[k++] = helper[i++];
        }
        while (j <= right) {
            v[k++] = helper[j++];
        }
    }

    private static int[] arrayToInt(String[] s) {
        int[] v = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            v[i] = Integer.parseInt(s[i]);
        }
        return v;
    }

    private static void arrayToStringIntervalo(int[] v, int left, int right) {
        System.out.print("[");
        for (int i = left; i < right + 1; i++) {
            if (i != left) {
                System.out.print(", " + v[i]);
            } else {
                System.out.print(v[i]);
            }
        }
        System.out.println("]");
    }
}
