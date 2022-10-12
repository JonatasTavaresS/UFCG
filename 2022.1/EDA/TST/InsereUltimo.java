import java.util.Arrays;
import java.util.Scanner;

class InsereUltimo {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] s = in.nextLine().split(" ");
        in.close();
        int[] v = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            v[i] = Integer.parseInt(s[i]);
        }
        for (int i = v.length - 1; i > 0; i--) {
            if (v[i] < v[i - 1]) {
                int temp = v[i];
                v[i] = v[i - 1];
                v[i - 1] = temp;
            } else {
                break;
            }
        }
        System.out.println(Arrays.toString(v));
    }
}
