import java.util.Scanner;

/**
 * Laboratório de Programação 2 - Lab 1
 * 
 * @author Jônatas Tavares dos Santos - 121110769
 */
public class OndeEstaWally {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            String entrada = sc.nextLine();
            if (entrada.equals("wally")) {
                break;
            }
            String[] nomes = entrada.split(" ");
            System.out.println(nomePossivel(nomes));
        }
    }

    public static String nomePossivel(String[] nomes) {
        String nomePossivel = "?";
        for (int i = 0; i < nomes.length; i++) {
            if (nomes[i].length() == 5) {
                nomePossivel = nomes[i];
            }
        }
        return nomePossivel;
    }
}