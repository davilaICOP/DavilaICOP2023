package Main;

import Modelo.*;
import Excepciones.*;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Sistema sistema = new Sistema();
        Scanner scanner = new Scanner(System.in);
                
        int opcion;
        do {
            System.out.println("Menú Principal:");
            System.out.println("1. Registrar Votante");
            System.out.println("2. Registrar Candidato");
            System.out.println("3. Generar Padrón de Votantes Ordenado");
            System.out.println("4. Generar Lista de Candidatos Ordenada");
            System.out.println("5. Registrar Voto");
            System.out.println("6. Escrutinio Provisorio");
            System.out.println("7. Validar Escrutinio");
            System.out.println("8. Emitir Escrutinio Definitivo y Terna de Ganadores");
            System.out.println("0. Salir");
            System.out.print("Ingrese la opción deseada: ");
            opcion = scanner.nextInt();
            scanner.nextLine();  // Consumir el salto de línea

            switch (opcion) {
                case 1:
                // Implementar lógica para registrar un votante
                System.out.println("Ingrese el apellido del votante:");
                String apellidoVotante = scanner.nextLine();
                System.out.println("Ingrese el nombre del votante:");
                String nombreVotante = scanner.nextLine();
                System.out.println("Ingrese la edad del votante:");
                int edadVotante = scanner.nextInt();
                scanner.nextLine();  // Consumir el salto de línea
                System.out.println("Ingrese el género del votante (Masculino/Femenino):");
                Genero generoVotante = Genero.valueOf(scanner.nextLine());
                System.out.println("Ingrese el domicilio del votante:");
                String domicilioVotante = scanner.nextLine();
                System.out.println("Ingrese el número de documento del votante:");
                String duVotante = scanner.nextLine();

                Sufragante nuevoVotante = new Sufragante(apellidoVotante, nombreVotante, edadVotante,
                        generoVotante, domicilioVotante, duVotante);

                try {
                    sistema.registrarVotante(nuevoVotante);
                    System.out.println("Votante registrado exitosamente.");
                } catch (ExcepcionVotanteReincidente e) {
                    System.out.println("Error: " + e.getMessage());
                }
                break;
                case 2:
                // Implementar lógica para registrar un candidato
                System.out.println("Ingrese el apellido del candidato:");
                String apellidoCandidato = scanner.nextLine();
                System.out.println("Ingrese el nombre del candidato:");
                String nombreCandidato = scanner.nextLine();
                System.out.println("Ingrese la edad del candidato:");
                int edadCandidato = scanner.nextInt();
                scanner.nextLine();  // Consumir el salto de línea
                System.out.println("Ingrese el género del candidato (Masculino/Femenino):");
                Genero generoCandidato = Genero.valueOf(scanner.nextLine());
                System.out.println("Ingrese el domicilio del candidato:");
                String domicilioCandidato = scanner.nextLine();
                System.out.println("Ingrese el número de documento del candidato:");
                String duCandidato = scanner.nextLine();

                System.out.println("Ingrese el partido político del candidato (LLA/UXP/JXC/FIT):");
                PartidoPolitico partidoCandidato = PartidoPolitico.valueOf(scanner.nextLine());
                System.out.println("Ingrese el lema del candidato:");
                String lemaCandidato = scanner.nextLine();

                Candidato nuevoCandidato = new Candidato(apellidoCandidato, nombreCandidato, edadCandidato,
                        generoCandidato, domicilioCandidato, duCandidato, partidoCandidato, lemaCandidato);

                sistema.registrarCandidato(nuevoCandidato);
                System.out.println("Candidato registrado exitosamente.");
                break;
                case 3:
                // Implementar lógica para generar el padrón de votantes ordenado
                List<Sufragante> padronOrdenado = sistema.generarPadronVotantesOrdenado();
                System.out.println("Padrón de Votantes Ordenado:");
                for (Sufragante votante : padronOrdenado) {
                    System.out.println(votante.getApellido() + ", " + votante.getNombre() +
                            " - Edad: " + votante.getEdad());
                }
                break;
                case 4:
                    // Implementar lógica para generar la lista de candidatos ordenada
                    List<Candidato> listaCandidatosOrdenada = sistema.generarListaCandidatosOrdenada();
                    System.out.println("Lista de Candidatos Ordenada por Partido Político:");
                    for (Candidato candidato : listaCandidatosOrdenada) {
                        System.out.println(candidato.getPartidoPolitico().getNombreCompleto() + ": " +
                                candidato.getApellido() + ", " + candidato.getNombre());
                    }
                break;
                case 5:
                    // Implementar lógica para realizar el registro de votos
                    System.out.println("\n--- Votación ---");
                    System.out.print("Ingrese DNI del votante: ");
                    String dniVotante = scanner.next();
                    scanner.nextLine(); // Limpiar el buffer del scanner

                    List<Candidato> listaCandidatos = sistema.generarListaCandidatosOrdenada();

                    // Mostrar lista de opciones
                    System.out.println("Lista de Opciones:");
                    System.out.println("0. Votar en blanco");
                    System.out.println("1. Impugnar el voto");

                    // Mostrar lista de candidatos disponibles
                    System.out.println("\nLista de Candidatos Disponibles:");
                    for (int i = 0; i < listaCandidatos.size(); i++) {
                        Candidato candidato = listaCandidatos.get(i);
                        System.out.println((i + 2) + ". " + candidato.getNombre() + " - Partido: " + candidato.getPartidoPolitico());
                    }

                    // Solicitar al usuario que ingrese el número de la opción
                    System.out.print("\nSeleccione el número de la opción deseada: ");
                    int opcion1 = scanner.nextInt();
                    scanner.nextLine(); // Limpiar el buffer del scanner

                    if (opcion1 == 0) {
                        // Votar en blanco
                        try {
                            sistema.votarEnBlanco(dniVotante);
                            System.out.println("Voto en blanco registrado correctamente.");
                        } catch (ExcepcionVotanteNoEncontrado | ExcepcionVotanteReincidente e) {
                            System.err.println("Error al votar en blanco: " + e.getMessage());
                        }
                    } else if (opcion1 == 1) {
                        // Impugnar el voto
                        try {
                            sistema.impugnarVoto(dniVotante);
                            System.out.println("Voto impugnado correctamente.");
                        } catch (ExcepcionVotanteNoEncontrado | ExcepcionVotanteReincidente e) {
                            System.err.println("Error al impugnar el voto: " + e.getMessage());
                        }
                    } else if (opcion1 > 1 && opcion1 <= listaCandidatos.size() + 1) {
                        // Validar la opción ingresada por el usuario y realizar la votación para el candidato seleccionado
                        Candidato candidatoSeleccionado = listaCandidatos.get(opcion1 - 2);
                        try {
                            sistema.votar(dniVotante, candidatoSeleccionado.getDU());
                            System.out.println("Voto registrado correctamente para " + candidatoSeleccionado.getNombre());
                        } catch (ExcepcionVotanteNoEncontrado | ExcepcionVotanteReincidente e) {
                            System.err.println("Error al votar: " + e.getMessage());
                        }
                    } else {
                        System.err.println("Opción inválida. Por favor, seleccione una opción válida.");
                    }
                    break;
	
                case 6:
                    // Implementar lógica para realizar el escrutinio provisorio
                    sistema.escrutinioProvisorio();
                break;

                case 7:
                    // Implementar lógica para validar el escrutinio
                    try {
                        sistema.validarEscrutinio();
                        System.out.println("Escrutinio validado correctamente.");
                    } catch (RuntimeException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                break;

                case 8:
                    // Implementar lógica para emitir el escrutinio definitivo y terna de ganadores
                    sistema.emitirEscrutinioDefinitivoYTernaGanadores();
                break;
                case 0:
                    System.out.println("Saliendo del programa. Fin");
                break;
                default:
                    System.out.println("Opción no válida. Intentelo otra vez.");
            }

        } while (opcion != 0);
    }
    
}