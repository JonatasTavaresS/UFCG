import java.util.Scanner;

/**
 * Laboratório de Programação 2 - Lab 1
 * 
 * @author Jônatas Tavares dos Santos - 121110769
 */
public class DoisMaioresGastosDaEmpresa {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] gastosStr = sc.nextLine().split(" ");
        int[] gastos = converterStringParaInteiro(gastosStr);
        System.out.println(somaMaioresGastos(gastos));
    }

    public static int[] converterStringParaInteiro(String[] gastosStr) {
        int[] gastosInt = new int[gastosStr.length];
        for (int i = 0; i < gastosInt.length; i++) {
            gastosInt[i] = Integer.parseInt(gastosStr[i]);
        }
        return gastosInt;
    }

    public static int somaMaioresGastos(int[] gastos) {
        int maior1 = gastos[0];
        int maior2 = 0;
        for (int i = 1; i < gastos.length; i++) {
            if (gastos[i] > maior2) {
                maior2 = gastos[i];
            }
            if (maior2 > maior1) {
                int aux = maior1;
                maior1 = maior2;
                maior2 = aux;
            }
        }
        return maior1 + maior2;
    }
}
