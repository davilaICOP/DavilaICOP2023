package Entidades;

import Servicios._5_PersonaService;

public class _5_Main {
    public static void main(String[] args) {
    	_5_PersonaService personaService = new _5_PersonaService();

        // Crear una nueva persona
    	_5_Persona nuevaPersona = personaService.crearPersona();

        // Mostrar información de la persona
        personaService.mostrarPersona(nuevaPersona);

        // Verificar si la persona es menor que una edad específica
        int edadLimite = 18;
        boolean esMenor = personaService.menorQue(nuevaPersona, edadLimite);
        System.out.println("¿Es menor de " + edadLimite + " años? " + (esMenor ? "Sí" : "No"));
    }
}
