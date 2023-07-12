package Main;
import Entidades.Aseguradora;
import Entidades.TipoDeCobertura;

import java.util.Scanner;
public class Main {
    private static Aseguradora aseguradora = new Aseguradora();
    private static Scanner sc = new Scanner(System.in);

    private static void mostrarMenu() {
        int opcion;
        do {
        	System.out.println("Menu: ");
            System.out.println("1: Registrar cliente");
            System.out.println("2: Listar todos los clientes");
            System.out.println("3: Buscar cliente por documento");
            System.out.println("4: Registrar vehiculo");
            System.out.println("5: Listar todos los vehiculos");
            System.out.println("6: Listar vehiculos por tipo de vehículo segun se especifique");
            System.out.println("7: Listar vehiculos por tipo de cobertura segun se especifique");
            System.out.println("8: Buscar vehiculo por matricula");
            System.out.println("9: Registrar una poliza");
            System.out.println("10: Pagar cuota");
            System.out.println("11: Listar poliza por tipo de cobertura");
            System.out.println("12: Buscar poliza, mostrar informacion y lista de cuotas");
            System.out.println("13: Ver datos estadisticos.");
            System.out.println("14: Salir");
            System.out.println(""); 
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                	System.out.println("Registrar cliente:");
                    aseguradora.registrarCliente();
                    break;
                case 2:
                	System.out.println("Listar todos los clientes:");
                    aseguradora.listarCliente();
                    break;
                case 3:
                	System.out.println("Buscar cliente por documento:");
                    aseguradora.buscarClienteDocumento();
                    break;
                case 4:
                	System.out.println("Registrar vehiculo:");
                    aseguradora.registrarVehículo();
                    break;
                case 5:
                	System.out.println("Listar todos los vehiculos:");
                    aseguradora.listarVehículo();
                    break;
                case 6:
                	System.out.println("Listar vehiculos por tipo de vehículo segun se especifique:");
                    aseguradora.listarVehículoTipo();
                    break;
                case 7:
                	System.out.println("Listar vehiculos por tipo de cobertura segun se especifique:");
                    aseguradora.listarVehículoCobertura(null);
                    break;    
                case 8:
                	System.out.println("Buscar vehiculo por matricula:");
                    aseguradora.buscarVehículoMatrícula();
                    break;
                case 9:
                	System.out.println("Registrar una poliza:");
                    aseguradora.registrarPoliza();
                    break;
                case 10:
                	System.out.println("Pagar cuota:");
                    aseguradora.pagarCuota();
                    break;
                case 11:
                	System.out.println("Listar poliza por tipo de cobertura:");
                    aseguradora.listarPolizaCobertura();
                    break;
                case 12:
                	System.out.println("Buscar poliza, mostrar informacion y lista de cuotas:");
                    aseguradora.buscarPolizaMostrarInfoListarCuotas();
                    break;
                case 13:
                	System.out.println("Ver datos estadisticos:");
                    aseguradora.verDatosEstadísticos();
                    break;
                case 14:
                    System.out.println("Saliendo del programa...");
                    return;
                default:
                    System.out.println("Ingrese una opción válida!");
            }
        } while (opcion != 14);
    }

    public static void main(String[] args) {
        mostrarMenu();
    }
}	