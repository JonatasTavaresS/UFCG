import java.util.Scanner;

/**
 * Laboratório de Programação 2 - Lab 1
 * 
 * @author Jônatas Tavares dos Santos - 121110769
 */
public class MaiorQueAMedia {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String entrada = sc.nextLine();
        int[] valores = converterStringParaInteiro(entrada);
        double media = calcularMedia(valores);
        System.out.println(verificarAcimaDaMedia(valores, media));
    }

    public static int[] converterStringParaInteiro(String entrada) {
        String[] valoresStr = entrada.split(" ");
        int[] valoresInt = new int[valoresStr.length];
        for (int i = 0; i < valoresInt.length; i++) {
            valoresInt[i] = Integer.parseInt(valoresStr[i]);
        }
        return valoresInt;
    }

    public static double calcularMedia(int[] valores) {
        int soma = 0;
        for (int i = 0; i < valores.length; i++) {
            soma = soma + valores[i];
        }
        double media = soma / valores.length;
        return media;
    }

    public static String verificarAcimaDaMedia(int[] valores, double media) {
        String saida = "";
        for (int i = 0; i < valores.length; i++) {
            if (valores[i] > media) {
                if (saida.length() > 0) {
                    saida = saida + " ";
                }
                saida = saida + valores[i];
            }
        }
        return saida;
    }
}