import java.util.Arrays;
import java.util.Scanner;

class MarianaEOsLivros {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] v = in.nextLine().split(",");
        in.close();
        for (int i = 0; i < v.length; i++) {
            int j = i;
            while (j > 0 && v[j].compareTo(v[j - 1]) < 0) {
                swap(v, j, j - 1);
                j--;
            }
            String s = Arrays.toString(v);
            System.out.println(s.substring(1, s.length() - 1));
        }
    }

    private static void swap(String[] v, int i, int j) {
        String temp = v[i];
        v[i] = v[j];
        v[j] = temp;
    }
}
