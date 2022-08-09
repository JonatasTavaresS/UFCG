import java.util.Scanner;

/**
 * Laboratório de Programação 2 - Lab 1
 * 
 * @author Jônatas Tavares dos Santos - 121110769
 */
public class FuncaoMonotona {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int valor1 = sc.nextInt();
        int valor2 = sc.nextInt();
        int valor3 = sc.nextInt();
        int valor4 = sc.nextInt();
        if ((valor1 < valor2) && (valor2 < valor3) && (valor3 < valor4)) {
            System.out.println("POSSIVELMENTE ESTRITAMENTE CRESCENTE");
        } else if ((valor1 > valor2) && (valor2 > valor3) && (valor3 > valor4)) {
            System.out.println("POSSIVELMENTE ESTRITAMENTE DECRESCENTE");
        } else {
            System.out.println("FUNCAO NAO ESTRITAMENTE CRES/DECR");
        }
    }
}