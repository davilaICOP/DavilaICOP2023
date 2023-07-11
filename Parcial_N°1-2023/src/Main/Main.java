package Main;
import Entidades.*;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Aseguradora aseguradora = new Aseguradora();
        Scanner scanner = new Scanner(System.in);

        int opcion;
        do {
            System.out.println("===== MENÚ =====");
            System.out.println("1. Registrar un cliente");
            System.out.println("2. Listar todos los clientes");
            System.out.println("3. Buscar un cliente por documento");
            System.out.println("4. Registrar un vehículo");
            System.out.println("5. Listar todos los vehículos");
            System.out.println("6. Listar vehículos por tipo y cobertura");
            System.out.println("7. Buscar vehículo por matrícula");
            System.out.println("8. Registrar una póliza");
            System.out.println("9. Pagar cuota");
            System.out.println("10. Listar pólizas por tipo de cobertura");
            System.out.println("11. Buscar una póliza");
            System.out.println("12. Ver datos estadísticos");
            System.out.println("0. Salir");
            System.out.print("Ingrese una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    aseguradora.registrarCliente();
                    break;
                case 2:
                    aseguradora.listarClientes();
                    break;
                case 3:
                    aseguradora.buscarClientePorDocumento();
                    break;
                case 4:
                    aseguradora.registrarVehiculo();
                    break;
                case 5:
                    aseguradora.listarVehiculos();
                    break;
                case 6:
                    scanner.nextLine();
                    System.out.print("Ingrese el tipo de vehículo: Taxi o Autobús): ");
                    String tipo = scanner.nextLine();
                    System.out.print("Ingrese el tipo de cobertura: ");
                    String cobertura = scanner.nextLine();
                    aseguradora.listarVehiculosPorTipoYCobertura(tipo, cobertura);
                    break;
                case 7:
                    aseguradora.buscarVehiculoPorMatricula();
                    break;
                case 8:
                    aseguradora.registrarPoliza();
                    break;
                case 9:
                    aseguradora.pagarCuota();
                    break;
                case 10:
                    scanner.nextLine();
                    System.out.print("Ingrese el tipo de cobertura: ");
                    String tipoCobertura = scanner.nextLine();
                    aseguradora.listarPolizasPorTipoCobertura(tipoCobertura);
                    break;
                case 11:
                    System.out.print("Ingrese el número de póliza: ");
                    int numeroPoliza = scanner.nextInt();
                    aseguradora.buscarPoliza(numeroPoliza);
                    break;
                case 12:
                    aseguradora.verDatosEstadisticos();
                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }

            System.out.println();
        } while (opcion != 0);

        scanner.close();
    }
}
