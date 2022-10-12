import java.util.Scanner;

class VetorCircular {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] v = in.nextLine().split(" ");
        int N = in.nextInt();
        in.close();
        String saida = "";
        int j = 0;
        for (int i = 0; i < N; i++) {
            saida += " " + v[j];
            j++;
            if (j == v.length) {
                j = 0;
            }
        }
        System.out.println(saida.trim());
    }
}
