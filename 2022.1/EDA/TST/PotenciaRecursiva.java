import java.util.Scanner;

class PotenciaRecursiva {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int i = in.nextInt();
        int j = in.nextInt();
        in.close();
        System.out.println(potencia(i, j, 0, 1));
    }

    private static int potencia(int i, int j, int vezes, int potencia) {
        if (vezes == j) {
            return potencia;
        }
        return potencia(i, j, vezes + 1, potencia * i);
    }
}
