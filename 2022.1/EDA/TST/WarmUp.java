import java.util.Scanner;

class WarmUp {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        in.nextLine();
        String[] sequencia = in.nextLine().split(" ");
        in.close();
        for (int i = 0; i < sequencia.length; i++) {
            if (i != 0) {
                System.out.print(" ");
            }
            System.out.print(Integer.parseInt(sequencia[i]) * N);
        }
        System.out.println();
    }
}
