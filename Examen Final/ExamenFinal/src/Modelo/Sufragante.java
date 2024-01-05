package Modelo;

import java.util.Scanner;
import java.util.Comparator;
import java.util.InputMismatchException;

public class Sufragante extends Ciudadano {
    private boolean emitioVoto;
    
    // Constructor por defecto
    public Sufragante() {
        this.emitioVoto = false;    
    }

    // Constructor con parámetros
    public Sufragante(String apellido, String nombre, int edad, Genero genero,
                      String domicilio, int DU) {
        super(apellido, nombre, edad, genero, domicilio, DU);
        this.emitioVoto = false;
        
    }
    // Getter y setter
    public boolean haEmitidoVoto() {
        return emitioVoto;
    }    

    public void setEmitioVoto(boolean emitioVoto) {
        this.emitioVoto = emitioVoto;
    }
    
    //Registrar sufragante
    public static Sufragante registrarSufragante() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el apellido del sufragante:");
        String apellido = scanner.nextLine();
        System.out.println("Ingrese el nombre del sufragante:");
        String nombre = scanner.nextLine();
        int edad;
        try {
            System.out.println("Ingrese la edad del sufragante:");
            edad = scanner.nextInt();
            scanner.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("Error: Ingresó mal la edad. Intente nuevamente.");
            return null;
        }  
        Genero genero;
        try {
            System.out.println("Seleccione el género del sufragante:");
            System.out.println("1. Masculino");
            System.out.println("2. Femenino");
            
            int opcionGenero = scanner.nextInt();
            scanner.nextLine();

            switch (opcionGenero) {
                case 1:
                    genero = Genero.Masculino;
                    break;
                case 2:
                    genero = Genero.Femenino;
                    break;
                default:
                    throw new InputMismatchException();
            }
        } catch (InputMismatchException e) {
            System.out.println("Error: No eligió un género. Intente nuevamente.");
            return null;
        }
        System.out.println("Ingrese el domicilio del sufragante:");
        String domicilio = scanner.nextLine();
        
        int du;
        try {
            System.out.println("Ingrese el número de documento del sufragante:");
            du = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Error: Ingresó mal el número de documento. Intente nuevamente.");
            return null;
        }

        // Verificar y registrar el documento
        if (!Ciudadano.verificarYRegistrarDocumento(du, true)) {
            return null;
        }

        return new Sufragante(apellido, nombre, edad, genero, domicilio, du);
    }   
    
    // Método estático para obtener un comparador
    public static Comparator<Sufragante> getComparadorPorApellidoNombreEdad() {
        return Comparator
                .comparing(Sufragante::getApellido)
                .thenComparing(Sufragante::getNombre)
                .thenComparingInt(Sufragante::getEdad);
    }
}