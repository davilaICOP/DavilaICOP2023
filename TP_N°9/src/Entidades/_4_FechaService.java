package Entidades;

import java.util.Date;
import java.util.Scanner;

public class _4_FechaService {

    private Scanner scanner;

    public _4_FechaService() {
        scanner = new Scanner(System.in);
    }

    public Date fechaNacimiento() {
        System.out.print("Ingrese el año de su nacimiento: ");
        int anio = scanner.nextInt();
        System.out.print("Ingrese el mes de su nacimiento (1-12): ");
        int mes = scanner.nextInt() - 1; // Restamos 1 para ajustar al formato de Date (0-11)
        System.out.print("Ingrese el día de su nacimiento: ");
        int dia = scanner.nextInt();

        return new Date(anio - 1900, mes, dia);
    }

    public Date fechaActual() {
        return new Date(); // Crea un objeto Date con la fecha y hora actual
    }

    public int diferencia(Date fecha1, Date fecha2) {
        long diferenciaEnMillis = fecha2.getTime() - fecha1.getTime();
        long millisPorAnio = (long) (1000L * 60 * 60 * 24 * 365.25); // Tomamos en cuenta los años bisiestos
        int diferenciaEnAnios = (int) (diferenciaEnMillis / millisPorAnio);
        return diferenciaEnAnios;
    }

    public static void main(String[] args) {
        _4_FechaService fechaService = new _4_FechaService();

        Date fechaNacimiento = fechaService.fechaNacimiento();
        Date fechaActual = fechaService.fechaActual();

        int edad = fechaService.diferencia(fechaNacimiento, fechaActual);
        System.out.println("Su edad es: " + edad + " años.");
    }
}
