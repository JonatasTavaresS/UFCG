import java.util.Scanner;

/**
 * Laboratório de Programação 2 - Lab 1
 * 
 * @author Jônatas Tavares dos Santos - 121110769
 */
public class CalculadoraComOpcao {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String operacao = sc.nextLine();
        if (operacao.equals("+") || operacao.equals("-") || operacao.equals("*") || operacao.equals("/")) {
            float valor1 = sc.nextFloat();
            float valor2 = sc.nextFloat();
            if (operacao.equals("+")) {
                System.out.println("RESULTADO: " + (valor1 + valor2));
            } else if (operacao.equals("-")) {
                System.out.println("RESULTADO: " + (valor1 - valor2));
            } else if (operacao.equals("*")) {
                System.out.println("RESULTADO: " + (valor1 * valor2));
            } else if (operacao.equals("/")) {
                if (valor2 == 0) {
                    System.out.println("ERRO");
                } else {
                    System.out.println("RESULTADO: " + (valor1 / valor2));
                }
            }
        } else {
            System.out.println("ENTRADA INVALIDA");
        }
    }
}
