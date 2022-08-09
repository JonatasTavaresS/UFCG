import java.util.Scanner;

/**
 * Laboratório de Programação 2 - Lab 1
 * 
 * @author Jônatas Tavares dos Santos - 121110769
 */
public class ConsultandoOsGastosMensais {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] meses = sc.nextLine().split(" ");
        String[] valores = sc.nextLine().split(" ");
        String mes = sc.nextLine();
        System.out.println(consultarMes(mes, meses, valores));
    }

    public static String consultarMes(String mes, String[] meses, String[] valores) {
        String valor = "";
        for (int i = 0; i < meses.length; i++) {
            if (meses[i].equals(mes)) {
                valor = valores[i];
                break;
            }
        }
        return valor;
    }
}
