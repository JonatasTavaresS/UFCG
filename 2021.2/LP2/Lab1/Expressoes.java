import java.util.Scanner;

/**
 * Laboratório de Programação 2 - Lab 1
 * 
 * @author Jônatas Tavares dos Santos - 121110769
 */
public class Expressoes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt();
        int Y = 2 * X;
        int Z = 3 * X;
        System.out.println("dobro: " + Y + ", triplo: " + Z);
    }
}