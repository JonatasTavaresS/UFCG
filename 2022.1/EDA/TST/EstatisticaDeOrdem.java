import java.util.Scanner;

class EstatisticaDeOrdem {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] v = arrayToInt(in.nextLine().split(" "));
        in.close();
        int i = 0;
        int pivot = v[i];
        for (int j = 1; j < v.length; j++) {
            if (v[j] <= pivot) {
                swap(v, ++i, j);
            }
        }
        swap(v, 0, i);
        System.out.println(i + 1);
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
