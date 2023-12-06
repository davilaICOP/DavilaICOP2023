package Resolucion;
import java.util.Scanner;

public class Principal {
	private static String eleccion="";
	private static void mostrarMenu()
	{
		System.out.println("Menu: ");
		System.out.println("1: Registrar cliente");
		System.out.println("2: Listar todos los clientes");
		System.out.println("3: Buscar cliente por documento");
		System.out.println("4: Registrar vehiculo");
		System.out.println("5: Listar todos los vehiculos");
		System.out.println("6: Listar vehiculos por tipo y cobertura segun se especifique");
		System.out.println("7: Buscar vehiculo por matricula");
		System.out.println("8: Registrar una poliza");
		System.out.println("9: Pagar cuota");
		System.out.println("10: Listar polizar por tipo de cobertura");
		System.out.println("11: Buscar poliza, mostrar informacion y lista de cuotas");
		System.out.println("12: Ver datos estadisticos.");
		
		System.out.println("q: Salir");	
		System.out.println("");
		Scanner scanner = new Scanner(System.in);
		System.out.print("Opción: ");
		eleccion = scanner.nextLine();
	}
	public static void main(String[] args) {
		Aseguradora ase = new Aseguradora();
		Cliente cliente = new Cliente("Denis", "Avila", "denisavila1510@gmail.com","Masculino",42127830,"i falchini 786",191715);
		Cliente cliente2 = new Cliente("Maxi", "Avila", "maxi2408@gmail.com","Masculino",47330521,"i falchini 989",123456);
		ase.agregarPersona(cliente);
		ase.agregarPersona(cliente2);
		Taxi taxi = new Taxi("Peugeot","304", 2000, 123, 123, "marron", 200, "ad1234",123);
		Taxi taxi1 = new Taxi("Volkswagen","Gol", 2007, 321, 321, "Amarillo", 250, "aa3212",123);	
		Autobus autobus = new Autobus("Mercedes","b200", 2017, 123, 123, "naranja", 500, "ab4567",54);
		Autobus autobus1 = new Autobus("Volkswagen","d800", 2010, 321, 321, "Azul", 380, "aa1212",40);
		Autobus autobus2 = new Autobus("Scania","3000", 2019, 1234, 1234, "Verde", 600, "af2222",60);
		ase.agregarVehiculo(taxi);
		ase.agregarVehiculo(taxi1);
		ase.agregarVehiculo(autobus);
		ase.agregarVehiculo(autobus1);
		ase.agregarVehiculo(autobus2);
		Poliza poliza = new Poliza(taxi, cliente, "11/7/23", "11/7/24", 12, FormaDePago.EFECTIVO, 2000000, false, 0, TipoCobertura.TERCEROS, 1200);
		Poliza poliza1 = new Poliza(autobus, cliente2, "11/7/23", "11/7/24", 3, FormaDePago.DEBITO, 5000000, true, 100000, TipoCobertura.TOTAL, 5000);
		Poliza poliza2 = new Poliza(autobus1, cliente2, "11/7/23", "11/7/24", 6, FormaDePago.TRANSFERENCIA, 3500000, false, 0, TipoCobertura.PARCIAL, 3500);
		Poliza poliza3 = new Poliza(taxi1, cliente, "11/7/23", "11/7/24", 6, FormaDePago.EFECTIVO, 2500000, true, 100000, TipoCobertura.PARCIAL, 1500);
		ase.registrarPoliza(poliza);
		ase.registrarPoliza(poliza1);
		ase.registrarPoliza(poliza2);
		ase.registrarPoliza(poliza3);
		while (!eleccion.equals("q"))
			 {
				mostrarMenu();	
				switch (eleccion){
				case "1":
					ase.agregarPersona();
					break;
				case "2":
					ase.listarPersonas();
					break;
				case "3":
					ase.buscarPorDocumentoYMostrar();
					break;
				case "4":
					ase.registrarVehiculo();
					break;
				case "5":
					ase.listarVehiculos();
					break;
				case "6":
					ase.listarVehiculosPor();
					break;
				case "7":
					ase.buscarVehiculoPorMatriculaYMostrar();
					break;
				case "8":
					ase.registrarPoliza();
					break;
				case "9":
					ase.pagarCuota();
					break;
				case "10":
					ase.listarPolizas();
					break;
				case "11":
					ase.buscarPolizaPorVehiculoYMostrar();
					break;
				case "12":
					ase.datosEstadisticos();
					break;	
				case "q":
					System.out.println("Saliendo del sistema...");
					break;
					default:
						System.out.println("Ingreso opcion incorrecta.");
				}  
			}		
		}
	}