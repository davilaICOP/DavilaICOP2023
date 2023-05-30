package Entidad;
import java.util.Scanner;

public class Operacion {
    private double numero1;
    private double numero2;

    // Método constructor con todos los atributos pasados por parámetro
    public Operacion(double numero1, double numero2) {
        this.numero1 = numero1;
        this.numero2 = numero2;
    }

    // Método constructor sin los atributos pasados por parámetro
    public Operacion() {
        this.numero1 = 0;
        this.numero2 = 0;
    }

    // Métodos getter y setter para los atributos numero1 y numero2
    public double getNumero1() {
        return numero1;
    }

    public void setNumero1(double numero1) {
        this.numero1 = numero1;
    }

    public double getNumero2() {
        return numero2;
    }

    public void setNumero2(double numero2) {
        this.numero2 = numero2;
    }

    // Método para crear una operación pidiendo los números al usuario
    public void crearOperacion() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce el primer número: ");
        numero1 = scanner.nextDouble();
        System.out.print("Introduce el segundo número: ");
        numero2 = scanner.nextDouble();
    }

    // Método para calcular la suma de los números
    public double sumar() {
        return numero1 + numero2;
    }

    // Método para calcular la resta de los números
    public double restar() {
        return numero1 - numero2;
    }

    // Método para calcular la multiplicación de los números
    public double multiplicar() {
        if (numero2 == 0) {
            System.out.println("Error: No se puede multiplicar por cero.");
            return 0;
        }
        return numero1 * numero2;
    }

    // Método para calcular la división de los números
    public double dividir() {
        if (numero2 == 0) {
            System.out.println("Error: No se puede dividir por cero.");
            return 0;
        }
        return numero1 / numero2;
    }

}
