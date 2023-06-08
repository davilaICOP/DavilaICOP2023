package Entidad;
import java.util.Scanner;

public class Cuenta {
    private String titular;
    private double saldo;

    // Método para crear una cuenta con un titular y saldo inicial
    public Cuenta(String titular, double saldoInicial) {
        this.titular = titular;
        this.saldo = saldoInicial;
    }

    // Método para retirar dinero de la cuenta
    public void retirar_dinero() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese la cantidad a retirar: ");
        double cantidad = scanner.nextDouble();

        if (cantidad > saldo) {
            System.out.println("Saldo insuficiente. No se puede realizar la transacción.");
        } else {
            saldo -= cantidad;
            System.out.println("Retiro exitoso. Nuevo saldo: " + saldo);
        }
    }
}
