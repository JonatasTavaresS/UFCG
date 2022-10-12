import java.util.Arrays;
import java.util.Scanner;

class TrocaVizinhos {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] v = in.nextLine().split(" ");
        in.close();
        for (int i = 0; i < v.length - 1; i += 2) {
            String temp = v[i];
            v[i] = v[i + 1];
            v[i + 1] = temp;
        }
        System.out.println(Arrays.toString(v));
    }
}
