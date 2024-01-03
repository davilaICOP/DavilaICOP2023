package Modelo;

import java.util.Scanner;
import java.util.Comparator;
import java.util.InputMismatchException;

public class Candidato extends Ciudadano {
    private PartidoPolitico partidoPolitico;
    private String lema;
    private int cantidadVotos;

    // Constructor por defecto
    public Candidato() {}

    // Constructor con parámetros
    public Candidato(String apellido, String nombre, int edad, Genero genero,
                     String domicilio, int DU,
                     PartidoPolitico partidoPolitico, String lema) {
        super(apellido, nombre, edad, genero, domicilio, DU);
        this.partidoPolitico = partidoPolitico;
        this.lema = lema;
        this.cantidadVotos = 0;
    }

    // Getter y setter específicos para Candidato
    public PartidoPolitico getPartidoPolitico() {
        return partidoPolitico;
    }

    public void setPartidoPolitico(PartidoPolitico partidoPolitico) {
        this.partidoPolitico = partidoPolitico;
    }

    public String getLema() {
        return lema;
    }

    public void setLema(String lema) {
        this.lema = lema;
    }

    public int getCantidadVotos() {
        return cantidadVotos;
    }

    public void setCantidadVotos(int cantidadVotos) {
        this.cantidadVotos = cantidadVotos;
    }
    
    public void incrementarCantidadVotos() {
        this.cantidadVotos++;
    }
    
    // Método estático para crear un candidato
    public static Candidato crearCandidato() {
    	Scanner scanner = new Scanner(System.in);
    	
        System.out.println("Ingrese el apellido del candidato:");
        String apellido = scanner.nextLine();
        System.out.println("Ingrese el nombre del candidato:");
        String nombre = scanner.nextLine();
        int edad;
        try {
            System.out.println("Ingrese la edad del candidato:");
            edad = scanner.nextInt();
            scanner.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("Error: Ingresó mal la edad. Intente nuevamente.");
            return null;
        }
        Genero genero;
        try {
            System.out.println("Seleccione el género del candidato:");
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
        System.out.println("Ingrese el domicilio del candidato:");
        String domicilio = scanner.nextLine();
        
        int du;
        try {
            System.out.println("Ingrese el número de documento del candidato:");
            du = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Error: Ingresó mal el número de documento. Intente nuevamente.");
            return null;
        }
        
        // Verificar y registrar el documento
        if (!Ciudadano.verificarYRegistrarDocumento(du, true)) {
            return null;
        }
        
        System.out.println("Seleccione el partido político del candidato:");
        System.out.println("1. La Libertad Avanza");
        System.out.println("2. Unión por la Patria");
        System.out.println("3. Juntos por el Cambio");
        System.out.println("4. Frente de Izquierda");
        PartidoPolitico partido;
        try {
            int opcionPartido = scanner.nextInt();
            scanner.nextLine();
            switch (opcionPartido) {
                case 1:
                    partido = PartidoPolitico.LLA;
                    break;
                case 2:
                    partido = PartidoPolitico.UXP;
                    break;
                case 3:
                    partido = PartidoPolitico.JXC;
                    break;
                case 4:
                    partido = PartidoPolitico.FIT;
                    break;
                default:
                    throw new InputMismatchException();
            }
        } catch (InputMismatchException e) {
            System.out.println("Error: No eligió un partido político. Intente nuevamente.");
            return null;
        }
        System.out.println("Ingrese el lema del candidato:");
        String lema = scanner.nextLine();
        return new Candidato(apellido, nombre, edad, genero, domicilio, du, partido, lema);
    }
    
    // Método comparador estático para ordenar candidatos
    public static Comparator<Candidato> comparadorPorPartidoApellidoNombre() {
        return Comparator
                .comparing(Candidato::getPartidoPolitico)
                .thenComparing(Candidato::getApellido)
                .thenComparing(Candidato::getNombre);
    }
}