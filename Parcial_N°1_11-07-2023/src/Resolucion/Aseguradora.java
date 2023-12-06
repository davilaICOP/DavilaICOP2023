package Resolucion;
import java.util.Scanner;
import java.util.ArrayList;
public class Aseguradora {
	private String nombre;
	private String domicilio;
	private ArrayList<Cliente>clientes;
	private ArrayList<Vehiculo>vehiculos;
	private ArrayList<Poliza>polizas;
	
	Scanner scanner = new Scanner(System.in);
	
	public Aseguradora(String nombre, String domicilio) {
		super();
		this.nombre = nombre;
		this.domicilio = domicilio;
		this.clientes=new ArrayList();
		this.polizas=new ArrayList();
		this.vehiculos=new ArrayList();
	}
	public Aseguradora() {
		System.out.println("NUEVA ASEGURADORA");
		System.out.println("Ingrese nombre:");
		this.nombre=scanner.nextLine();
		System.out.println("Ingrese domicilio");
		this.domicilio=scanner.nextLine();
		this.clientes=new ArrayList();
		this.polizas=new ArrayList();
		this.vehiculos=new ArrayList();
	}
//mostrar
	public void mostrar() {
		System.out.println("-------------------");
		System.out.println("ASEGURADORA "+this.nombre);
		System.out.println("-------------------");
		System.out.println("DOMICILIO: "+this.domicilio);
	}
//agregar persona:
	public void agregarPersona() {
		clientes.add(new Cliente());
	}
	public void agregarPersona(Cliente cliete) {
		clientes.add(cliete);
	}
//listar clientes
	public void listarPersonas() {
		for (int i = 0; i<clientes.size();i++) {
			clientes.get(i).mostrar();
		}
	}
//Buscar cliente por documento:
	public void buscarPorDocumentoYMostrar() {
		System.out.println("Ingrese DNI:");
		int dni = scanner.nextInt();
		for(int i=0;i<clientes.size();i++) {
			if(dni==clientes.get(i).getDni()) {
				clientes.get(i).mostrar();
			}
		}
	}
	public int buscarPorDocumento(int dni) {
		for(int i=0;i<clientes.size();i++) {
			if(dni==clientes.get(i).getDni()) {
				return i;
			}
		}
		return -1;
	}
//registrar vehiculo
	public void registrarVehiculo() {
		System.out.println("¿Qué desea registrar? 1)Taxi, 2)Autobus");
		int opcion = scanner.nextInt();
		switch(opcion) {
		case 1: 
			vehiculos.add(new Taxi());
			break;
		case 2:
			vehiculos.add(new Autobus());
			break;
		default:
			System.out.println("No ingreso opcion valida");
		}
	}
	public void agregarVehiculo(Vehiculo vehiculo) {
		vehiculos.add(vehiculo);
	}
//listar vehiculos
	public void listarVehiculos() {
		for(int i=0;i<vehiculos.size();i++) {
			vehiculos.get(i).mostrar();
		}
	}
	public void listarVehiculosPor() {
		System.out.println("Ingrese filtro: 1)Tipo, 2)Cobertura");
		int opcion=scanner.nextInt();
		switch(opcion) {
		case 1:
			System.out.println("Ingrese filtro: 1)TAXI, 2)AUTOBUS");
				int o=scanner.nextInt();
				if(o==1) {
					for(int i=0;i<vehiculos.size();i++) {
						if(vehiculos.get(i)instanceof Taxi){
							vehiculos.get(i).mostrar();
						}				
					}
				}else if(o==2) {
					for(int i=0;i<vehiculos.size();i++) {
						if(vehiculos.get(i)instanceof Autobus){
							vehiculos.get(i).mostrar();
						}				
					}
				}else {
					System.out.println("Opcion no valida");
				}
			break;
		case 2:
			System.out.println("Ingrese filtro: 1)TOTAL, 2)CONTRA TERCEROS, 3)PARCIAL");
			o=scanner.nextInt();
			switch(o) {
			case 1:
				for(int i=0;i<polizas.size();i++) {
					if(polizas.get(i).getTipoCobertura().equals(TipoCobertura.TOTAL)) {
						polizas.get(i).getVehiculo().mostrar();
					}
				}
				break;
			case 2:
				for(int i=0;i<polizas.size();i++) {
					if(polizas.get(i).getTipoCobertura().equals(TipoCobertura.TERCEROS)) {
						polizas.get(i).getVehiculo().mostrar();
					}
				}
				break;
			case 3:
				for(int i=0;i<polizas.size();i++) {
					if(polizas.get(i).getTipoCobertura().equals(TipoCobertura.PARCIAL)) {
						polizas.get(i).getVehiculo().mostrar();
					}
				}
				break;
			default:
				System.out.println("No ingreso opcion valida.");
			}
			break;
		default:
			System.out.println("No ingreso opcion valida.");
		}
	}
//buscar vehiculo por matricula
	public void buscarVehiculoPorMatriculaYMostrar() {
		System.out.println("Ingrese matricula");
		String matricula = scanner.nextLine();
		for(int i=0;i<clientes.size();i++) {
			if(matricula.equals(vehiculos.get(i).getMatricula())) {
				vehiculos.get(i).mostrar();
			}
		}
	}
	public int buscarVehiculoPorMatricula(String matricula) {
		for(int i=0;i<clientes.size();i++) {
			if(matricula.equals(vehiculos.get(i).getMatricula())) {
				return i;
			}
		}
		return -1;
	}
//registrar poliza
	public void registrarPoliza() {
		System.out.println("Ingrese DNI de persona: ");
		int dni = scanner.nextInt();
		//System.out.println("Ingrese matricula de vehiculo:");
		//String matri = scanner.nextLine();
		Cliente cliente;
		if (buscarPorDocumento(dni)==-1) {
			System.out.println("No se encontro");
			cliente = new Cliente();
			clientes.add(cliente);
			
		}else {
			cliente=clientes.get(buscarPorDocumento(dni));
		}
		System.out.println("Ingrese matricula de vehiculo: ");
		scanner.nextLine();
		String matri = scanner.nextLine();
		Vehiculo vehiculo;
		int indice= buscarVehiculoPorMatricula(matri);
		if (indice==-1) {
			System.out.println("NO SE ENCONTRO, A CONTINUACION CARGAR NUEVO");
			System.out.println("¿Que desea cargar?: 1)Taxi, 2)Autobus");
			int o=scanner.nextInt();
			switch(o) {
			case 1: 
				vehiculo= new Taxi();
				vehiculos.add(vehiculo);
				break;
			case 2: 
				vehiculo=new Autobus();
				vehiculos.add(vehiculo);
				break;
				default:
					System.out.println("Opcion no valida, por defecto taxi.");
					vehiculo= new Taxi();
					vehiculos.add(vehiculo);
			}
		}else {
			vehiculo=vehiculos.get(indice);
		}
		Poliza poliza = new Poliza(vehiculo,cliente);
		polizas.add(poliza);
	}
	public void registrarPoliza(Poliza poliza) {
		polizas.add(poliza);
	}
//Buscar poliza
	public int buscarPolizaPorVehiculo(Vehiculo vehiculo){
		for(int i=0;i<polizas.size();i++) {
			if(polizas.get(i).getVehiculo().equals(vehiculo)) {
				return i;
			}
		}
		return -1;
	}
	public void buscarPolizaPorVehiculoYMostrar() {
		System.out.println("Ingrese matricula del vehiculo: ");
		String matricula = scanner.nextLine();
		int indiceVehiculo=buscarVehiculoPorMatricula(matricula);
		polizas.get(buscarPolizaPorVehiculo(vehiculos.get(indiceVehiculo))).mostrar();
		polizas.get(buscarPolizaPorVehiculo(vehiculos.get(indiceVehiculo))).mostrarCuotas();;
	}
//pagar cuota
	public void pagarCuota() {
		System.out.println("Ingrese matricula del vehiculo: ");
		String matri=scanner.nextLine();
		int indiceVehiculo=buscarVehiculoPorMatricula(matri);
		if (indiceVehiculo!=-1) {
			int indicePoliza=buscarPolizaPorVehiculo(vehiculos.get(indiceVehiculo));
			if (indicePoliza!=-1) {
				System.out.println("Cuotas: ");
				polizas.get(indicePoliza).mostrarCuotas();
				int indiceProximaCuota=polizas.get(indicePoliza).siguienteCuotaImpaga();
				System.out.println("Ingrese forma de pago: 1)EFECTIVO, 2)TRANSFERENCIA, 3)DEBITO");
				int opcion = scanner.nextInt();
				FormaDePago fPago;
				switch (opcion) {
				case 1: 
					fPago=FormaDePago.EFECTIVO;
					break;
				case 2:
					fPago=FormaDePago.TRANSFERENCIA;
					break;
				case 3:
					fPago=FormaDePago.DEBITO;
					break;
					default:
						System.out.println("OPCION INCORRECTA, PREDETERMINADO EFECTIVO");
						fPago=FormaDePago.EFECTIVO;
				}
				System.out.println("Ingrese fecha de pago: ");
				scanner.nextLine();
				String fecha=scanner.nextLine();
				polizas.get(indicePoliza).cuotaPagada(indiceProximaCuota, fPago, fecha);
			}else {
				System.out.println("No se encontro poliza registrada a ese vhiculo!");
			}
		}else {
			System.out.println("No se encontro vehiculo con esa matricula!!");
		}
	}
//listar cuotas por cobertura
	public void listarPolizas() {
		System.out.println("Ingrese filtro: 1)TOTAL, 2)CONTRA TERCEROS, 3)PARCIAL");
		int o=scanner.nextInt();
		switch(o) {
		case 1:
			for(int i=0;i<polizas.size();i++) {
				if(polizas.get(i).getTipoCobertura().equals(TipoCobertura.TOTAL)) {
					polizas.get(i).mostrar();
				}
			}
			break;
		case 2:
			for(int i=0;i<polizas.size();i++) {
				if(polizas.get(i).getTipoCobertura().equals(TipoCobertura.TERCEROS)) {
					polizas.get(i).mostrar();
				}
			}
			break;
		case 3:
			for(int i=0;i<polizas.size();i++) {
				if(polizas.get(i).getTipoCobertura().equals(TipoCobertura.PARCIAL)) {
					polizas.get(i).mostrar();
				}
			}
			break;
		default:
			System.out.println("No ingresó opcion valida.");
		}
	}
//datos estadisticos
	public void datosEstadisticos() {
		mostrar();
		int totalCL=0;
		for(int i=0;i<clientes.size();i++) {
			totalCL=totalCL+1;
		}
		int totalVH=0;
		int totalTAX=0;
		int totalAUT=0;
		for(int i=0;i<vehiculos.size();i++) {
			totalVH=totalVH+1;
			if(vehiculos.get(i) instanceof Taxi) {
				totalTAX=totalTAX+1;
			}else if (vehiculos.get(i) instanceof Autobus) {
				totalAUT=totalAUT+1;
			}
		}
		int totalPOL = 0;
		int totalMONTO =0;
		int totalCUOTAS=0;
		int totalCPAR=0;
		int totalCTOT=0;
		int totalCTER=0;
		for(int i=0;i<polizas.size();i++) {
			totalPOL=totalPOL+1;
			totalMONTO=totalMONTO+polizas.get(i).getMontoTotalAsegurado();
			totalCUOTAS=totalCUOTAS+polizas.get(i).getCantidadCuotas();
			if(polizas.get(i).getTipoCobertura().equals(TipoCobertura.PARCIAL)){
				totalCPAR=totalCPAR+1;
			}else if(polizas.get(i).getTipoCobertura().equals(TipoCobertura.TOTAL)) {
				totalCTOT=totalCTOT+1;
			}else if(polizas.get(i).getTipoCobertura().equals(TipoCobertura.TERCEROS)) {
				totalCTER=totalCTER+1;
			}
		}
		int promedioMONTO=totalMONTO/totalPOL;
		int promedioCUOTAS=totalCUOTAS/totalPOL;
		System.out.println("TOTAL DE CLIENTES: "+totalCL+", TOTAL VEHICULOS: "+totalVH
				+"\nTAXIS: "+ totalTAX +", AUTOUBUSES: "+totalAUT
				+"\nTOTAL MONTOS ASEGURADOS: "+totalMONTO+", TOTAL POLIZAS: "+totalPOL
				+"\nPROMEDIO CUOTAS: "+ promedioCUOTAS+", PROMEDIO MONTO ASEGURADO: "+promedioMONTO
				+"\nCOBERTURAS: "
				+"\nPARCIAL: "+totalCPAR+", TOTAL "+totalCTOT+", CONTRA TERCEROS: "+totalCTER);
		
	}
//getters && setters
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDomicilio() {
		return domicilio;
	}
	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}
	
	
	
}