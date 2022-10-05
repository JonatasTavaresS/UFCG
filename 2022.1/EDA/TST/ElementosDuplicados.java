import java.util.Scanner;

class ElementosDuplicados {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] elementos = in.nextLine().split(" ");
        in.close();
        for (int i = 0; i < elementos.length; i++) {
            for (int j = i + 1; j < elementos.length; j++) {
                if (elementos[i].equals(elementos[j])) {
                    System.out.println("true");
                    return;
                }
            }
        }
        System.out.println("false");
    }
}
