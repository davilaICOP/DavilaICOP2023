package Entidad;
import java.util.Scanner;

public class Circunferencia {
    private double radio;
    private double area;
    private double perimetro;

    // Método constructor que inicializa el radio pasado como parámetro
    public Circunferencia(double radio) {
        this.radio = radio;
    }

    // Método getter para el atributo radio
    public double getRadio() {
        return radio;
    }

    // Método setter para el atributo radio
    public void setRadio(double radio) {
        this.radio = radio;
    }

    // Método para crear una circunferencia pidiendo el radio al usuario
    public void crearCircunferencia() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce el radio de la circunferencia: ");
        radio = scanner.nextDouble();
    }

    // Método para calcular el área de la circunferencia
    public void calcularArea() {
        area = Math.PI * Math.pow(radio, 2);
    }

    // Método para calcular el perímetro de la circunferencia
    public void calcularPerimetro() {
        perimetro = 2 * Math.PI * radio;
    }
    
    // Métodos getter para los atributos area y perimetro
    public double getArea() {
        return area;
    }

    public double getPerimetro() {
        return perimetro;
    }
}
