package forma;

/**
 * @author Jônatas Tavares dos Santos - 121110769
 */
public class Triangulo implements Forma {

    
    private double base;
    private double altura;

    public Triangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    @Override
    public double calculaArea() {
        return (this.base * this.altura) / 2;
    }
}
