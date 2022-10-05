import java.util.Scanner;

class DoisSomam {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] sequencia = in.nextLine().split(" ");
        int numero = in.nextInt();
        in.close();
        for (int i = 0; i < sequencia.length; i++) {
            int atual = Integer.parseInt(sequencia[i]);
            for (int j = i + 1; j < sequencia.length; j++) {
                if (atual + Integer.parseInt(sequencia[j]) == numero) {
                    System.out.println(atual + " " + sequencia[j]);
                    return;
                }
            }
        }
        System.out.println(-1);
    }

    public String vetorCircular(int[] array, int quantidadeElementos) {
        return null;
    }
}
