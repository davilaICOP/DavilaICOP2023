package Main;

import java.util.Scanner;

import Excepciones.ExcepcionVotanteNoEncontrado;
import Excepciones.ExcepcionVotanteReincidente;
import java.util.InputMismatchException;
import Modelo.*;

public class Main {

    public static void main(String[] args) throws ExcepcionVotanteNoEncontrado, ExcepcionVotanteReincidente {
        Sistema sistema = new Sistema();
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

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

            try {
                opcion = scanner.nextInt();
                scanner.nextLine();

                switch (opcion) {
                    case 1:
                    	sistema.registrarVotanteConsola();
                        break;
                    case 2:
                    	sistema.registrarCandidatoConsola();
                        break;
                    case 3:
                    	sistema.imprimirPadronVotantesOrdenado();
                        break;
                    case 4:
                    	sistema.imprimirListaCandidatosOrdenada();
                        break;
                    case 5:
                        sistema.registrarVoto();
                        break;
                    case 6:
                        sistema.escrutinioProvisorio();
                        break;
                    case 7:
                    	sistema.validarEscrutinio();
                        break;
                    case 8:
                        sistema.emitirEscrutinioDefinitivoYTernaGanadores();
                        break;
                    case 0:
                        System.out.println("Saliendo del programa. Fin");
                        break;
                    default:
                        System.out.println("Opción no válida. Inténtelo otra vez.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Inicie nuevamente el sistema e ingrese un número.");
                scanner.nextLine();
            }
        } while (opcion != 0);
        
    }
}