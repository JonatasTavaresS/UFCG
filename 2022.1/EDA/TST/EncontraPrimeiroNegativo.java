import java.util.Scanner;

class EncontraPrimeiroNegativo {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] v = arrayToInt(in.nextLine().split(" "));
        in.close();
        primeiroNegativo(v, 0);
    }

    private static void primeiroNegativo(int[] v, int i) {
        if (i == v.length) {
            System.out.println("-");
        } else if (v[i] < 0) {
            System.out.println(v[i]);
        } else {
            primeiroNegativo(v, i + 1);
        }
    }

    private static int[] arrayToInt(String[] s) {
        int[] v = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            v[i] = Integer.parseInt(s[i]);
        }
        return v;
    }
}
