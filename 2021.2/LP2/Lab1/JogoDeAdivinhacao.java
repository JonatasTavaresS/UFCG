import java.util.Scanner;

/**
 * Laboratório de Programação 2 - Lab 1
 * 
 * @author Jônatas Tavares dos Santos - 121110769
 */
public class JogoDeAdivinhacao {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numeroImaginado = sc.nextInt();
        while (true) {
            int numero = sc.nextInt();
            if (numero == numeroImaginado) {
                System.out.println("ACERTOU");
                break;
            } else if (numero > numeroImaginado) {
                System.out.println("MAIOR");
            } else if (numero < numeroImaginado) {
                System.out.println("MENOR");
            }
        }
    }
}
