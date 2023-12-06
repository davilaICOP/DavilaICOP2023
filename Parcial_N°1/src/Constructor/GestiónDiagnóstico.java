package Constructor;
import java.util.ArrayList;
import java.util.Scanner;

public class GestiónDiagnóstico {
    private ArrayList<Persona> personas;
    private ArrayList<Diagnóstico> diagnósticos;

    public GestiónDiagnóstico() {
        personas = new ArrayList<>();
        diagnósticos = new ArrayList<>();
    }

    public ArrayList<Persona> getPersonas() {
        return personas;
    }

    public ArrayList<Diagnóstico> getDiagnósticos() {
        return diagnósticos;
    }

    public void agregarPersona(Persona persona) {
        personas.add(persona);
    }

    public void agregarDiagnóstico(Diagnóstico diagnóstico) {
        diagnósticos.add(diagnóstico);
    }

    public void mostrarInformes() {
        System.out.println("=== Informe de Médicos ===");
        for (Persona persona : personas) {
            if (persona instanceof Médico) {
                ((Médico) persona).mostrar();
                System.out.println();
            }
        }

        System.out.println("=== Informe de Ciudadanos ===");
        for (Persona persona : personas) {
            if (persona instanceof Ciudadano) {
                ((Ciudadano) persona).mostrar();
                System.out.println();
            }
        }

        System.out.println("=== Informe de Diagnósticos ===");
        for (Diagnóstico diagnóstico : diagnósticos) {
            diagnóstico.mostrar();
            System.out.println();
        }
    }

}