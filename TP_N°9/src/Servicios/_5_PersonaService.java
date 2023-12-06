package Servicios;

import Entidades._5_Persona;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class _5_PersonaService {
    private Scanner scanner;

    public _5_PersonaService() {
        this.scanner = new Scanner(System.in);
    }

    public _5_Persona crearPersona() {
        System.out.print("Ingrese el nombre de la persona: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese la fecha de nacimiento (YYYY-MM-DD): ");
        String fechaNacimientoStr = scanner.nextLine();

        // Convertir la cadena de fecha a objeto Date
        Date fechaNacimiento = convertirFecha(fechaNacimientoStr);

        return new _5_Persona(nombre, fechaNacimiento);
    }

    public int calcularEdad(_5_Persona persona) {
        // Obtener la fecha actual
        Date fechaActual = new Date();

        // Calcular la edad
        Calendar calPersona = Calendar.getInstance();
        calPersona.setTime(persona.getFechaNacimiento());
        int yearPersona = calPersona.get(Calendar.YEAR);

        Calendar calActual = Calendar.getInstance();
        calActual.setTime(fechaActual);
        int yearActual = calActual.get(Calendar.YEAR);

        return yearActual - yearPersona;
    }

    public boolean menorQue(_5_Persona persona, int edad) {
        int edadPersona = calcularEdad(persona);
        return edadPersona < edad;
    }

    public void mostrarPersona(_5_Persona persona) {
        System.out.println("Información de la persona:");
        System.out.println("Nombre: " + persona.getNombre());
        System.out.println("Fecha de Nacimiento: " + persona.getFechaNacimiento());
        System.out.println("Edad: " + calcularEdad(persona) + " años");
    }

    // Método privado para convertir la cadena de fecha a objeto Date
    private Date convertirFecha(String fechaStr) {
        try {
            return java.sql.Date.valueOf(fechaStr);
        } catch (IllegalArgumentException e) {
            System.out.println("Error al convertir la fecha. Asegúrese de ingresarla en el formato correcto (YYYY-MM-DD).");
            return null;
        }
    }
}
