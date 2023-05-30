package Entidad;
import java.util.Scanner;

public class Rectangulo {
    private double base;
    private double altura;

    // Método constructor con todos los atributos pasados por parámetro
    public Rectangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    // Método constructor sin los atributos pasados por parámetro
    public Rectangulo() {
        this.base = 0;
        this.altura = 0;
    }

    // Métodos getter y setter para los atributos base y altura
    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    // Método para crear un rectángulo pidiendo los datos al usuario
    public void crearRectangulo() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce la base del rectángulo: ");
        base = scanner.nextDouble();
        System.out.print("Introduce la altura del rectángulo: ");
        altura = scanner.nextDouble();
    }

    // Método para calcular la superficie del rectángulo
    public double calcularSuperficie() {
        return base * altura;
    }

    // Método para calcular el perímetro del rectángulo
    public double calcularPerimetro() {
        return (base + altura) * 2;
    }

    // Método para dibujar el rectángulo mediante asteriscos
    public void dibujarRectangulo() {
        for (int i = 0; i < altura; i++) {
            for (int j = 0; j < base; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

}
