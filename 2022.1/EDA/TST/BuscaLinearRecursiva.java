import java.util.Scanner;

class BuscaLinearRecursiva {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] v = arrayToInt(in.nextLine().split(" "));
        int N = in.nextInt();
        in.close();
        System.out.println(buscaLinear(N, v, 0));
    }

    private static int buscaLinear(int N, int[] v, int i) {
        if (i == v.length) {
            return -1;
        } else if (v[i] == N) {
            return i;
        }
        return buscaLinear(N, v, i + 1);
    }

    private static int[] arrayToInt(String[] s) {
        int[] v = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            v[i] = Integer.parseInt(s[i]);
        }
        return v;
    }
}
