package forma;

/**
 * @author Jônatas Tavares dos Santos - 121110769
 */
public class Main {

    public static void main(String[] args) {
        Forma triangulo = new Triangulo(2.5, 5);
        Forma retangulo = new Retangulo(3, 6);
        Forma quadrado = new Quadrado(4);
        Forma circulo = new Circulo(2);

        System.out.println("Área triângulo: " + triangulo.calculaArea());
        System.out.println("Área retângulo: " + retangulo.calculaArea());
        System.out.println("Área quadrado: " + quadrado.calculaArea());
        System.out.println("Área circulo: " + circulo.calculaArea());
    }
}
