import java.util.Scanner;

/**
 * Laboratório de Programação 2 - Lab 1
 * 
 * @author Jônatas Tavares dos Santos - 121110769
 */
public class ResultadosDeProva {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String notasStr = "";
        while (true) {
            String[] entrada = sc.nextLine().split(" ");
            if (entrada[0].equals("-")) {
                break;
            }
            notasStr = notasStr + entrada[1] + " ";
        }
        int[] notas = converterStringParaInteiro(notasStr);
        System.out.println("maior: " + maiorNota(notas));
        System.out.println("menor: " + menorNota(notas));
        int media = calcularMedia(notas);
        System.out.println("media: " + media);
        System.out.println("acima: " + acimaDaMedia(notas, media));
        System.out.println("abaixo: " + abaixoDaMedia(notas, media));
    }

    public static int[] converterStringParaInteiro(String notas) {
        String[] notasStr = notas.split(" ");
        int[] notasInt = new int[notasStr.length];
        for (int i = 0; i < notasInt.length; i++) {
            notasInt[i] = Integer.parseInt(notasStr[i]);
        }
        return notasInt;
    }

    public static int maiorNota(int[] notas) {
        int maior = 0;
        for (int i = 0; i < notas.length; i++) {
            if (notas[i] > maior) {
                maior = notas[i];
            }
        }
        return maior;
    }

    public static int menorNota(int[] notas) {
        int menor = 1000;
        for (int i = 0; i < notas.length; i++) {
            if (notas[i] < menor) {
                menor = notas[i];
            }
        }
        return menor;
    }

    public static int calcularMedia(int[] notas) {
        int soma = 0;
        for (int i = 0; i < notas.length; i++) {
            soma = soma + notas[i];
        }
        int media = soma / notas.length;
        return media;
    }

    public static int acimaDaMedia(int[] notas, int media) {
        int resultado = 0;
        for (int i = 0; i < notas.length; i++) {
            if (notas[i] > media) {
                resultado++;
            }
        }
        return resultado;
    }

    public static int abaixoDaMedia(int[] notas, int media) {
        int resultado = 0;
        for (int i = 0; i < notas.length; i++) {
            if (notas[i] < media) {
                resultado++;
            }
        }
        return resultado;
    }
}