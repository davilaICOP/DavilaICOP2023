package resoI.Parcial1.ÁvilaD;

import java.util.Scanner;

public class Principal {
	private static String eleccion="";
	private static void mostrarMenu()
	{
		System.out.println("Menu: ");
		System.out.println("1: Mostrar Informacion Obra Social");
		System.out.println("2: Registrar nuevo afiliado");
		System.out.println("3: Registrar nuevo empleado");
		System.out.println("4: ¿Son estas 2 personas familiares?");
		System.out.println("5: Mostrar persona");
		System.out.println("6: Agregar localidad");
		System.out.println("7: Mostrar domicilios existentes");
		System.out.println("q: Salir");	
		System.out.println("");
		Scanner scanner = new Scanner(System.in);
		System.out.print("Opción: ");
		eleccion = scanner.nextLine();

	}
	public static void main(String[] args) {
		ObraSocial obrasoc = new ObraSocial("San Martin 1550", "Santa Fe", "Inmaculada Care");
		obrasoc.agregarLocalidad(3000, "Santa Fe");
		obrasoc.agregarLocalidad(3016, "Santo Tome");
		obrasoc.agregarLocalidad(3018, "Recreo");
		Domicilio domicilio = new Domicilio ("Guadalupe", "Sarmiento", 2365, 3000);
		Domicilio domicilio1 = new Domicilio ("Centenario", "San martin", 4232, 3000);
		Domicilio domicilio2 = new Domicilio ("Los Hornos", "Guemes", 777, 3016);
		Domicilio domicilio3 = new Domicilio ("Mariano Comas", "Mariano Comas", 2917, 3000);
		obrasoc.agregarDomicilio(domicilio);
		obrasoc.agregarDomicilio(domicilio1);
		obrasoc.agregarDomicilio(domicilio2);
		obrasoc.agregarDomicilio(domicilio3);
		Empleado empleado1 = new Empleado("Perez", "Juan", "Masculino", 20123123, "10/10/88", domicilio, "10/10/2000", Cargo.ESPECIALIZADO);
		Empleado empleado2 = new Empleado("Alves", "Daniel", "Masculino", 1988523, "10/10/99", domicilio1, "10/10/2000", Cargo.AGENTE_AFILIADOR);
		Empleado empleado3 = new Empleado("Lujan", "Lara", "Femenino", 40252698, "25/03/2000", domicilio2, "10/10/2000", Cargo.AGENTE_AFILIADOR);
		Empleado empleado4 = new Empleado("Denis", "Avila", "Masculino", 42127830, "15/10/1999", domicilio3, "15/10/2019", Cargo.ESPECIALIZADO);
		Afiliado afiliado1 = new Afiliado("Lujan", "Carlos", "Masculino", 12555555, "25/08/1965", domicilio2, true, "12/01/2023", PlanCobertura.PMO, empleado3);
		Afiliado afiliado2 = new Afiliado("Suarez", "Jose", "Masculino", 19888555, "25/08/1978", domicilio, false, "12/01/2023", PlanCobertura.PMI, empleado2);
		Afiliado afiliado3 = new Afiliado("Maxi", "Avila", "Masculino", 47330521, "24/08/2006", domicilio3, false, "24/08/2023", PlanCobertura.PME, empleado4);
		obrasoc.agregarPersona(empleado1);
		obrasoc.agregarPersona(empleado2);
		obrasoc.agregarPersona(empleado3);
		obrasoc.agregarPersona(empleado4);
		obrasoc.agregarPersona(afiliado1);
		obrasoc.agregarPersona(afiliado2);
		obrasoc.agregarPersona(afiliado3);
		while (!eleccion.equals("q"))
		 {
			mostrarMenu();	
			switch(eleccion) {
			case "1":
				obrasoc.mostrar();
				break;
			case "2":
				obrasoc.cargarAfiliado();
				break;
			case "3": 
				obrasoc.cargarEmpleado();
				break;
			case "4":
				obrasoc.mismoDomicilio();
				break;
			case "5":
				obrasoc.mostrarPersona();
				break;
			case "6":
				obrasoc.agregarLocalidad();
				break;
			case "7":
				obrasoc.mostrarDomicilios();
				break;
			case "q":
				System.out.println("Chau!");
				break;
				default:
					System.out.println("Ingrese opcion valida!");
			}
		 }
	}
}
