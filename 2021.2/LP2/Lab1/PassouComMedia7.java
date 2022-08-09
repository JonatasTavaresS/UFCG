import java.util.Scanner;

/**
 * Laboratório de Programação 2 - Lab 1
 * 
 * @author Jônatas Tavares dos Santos - 121110769
 */
public class PassouComMedia7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        float nota1 = sc.nextFloat();
        float nota2 = sc.nextFloat();
        float media = (nota1 + nota2) / 2;
        if (media >= 7) {
            System.out.println("pass: True!");
        } else {
            System.out.println("pass: False!");
        }
    }
}