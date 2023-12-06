package resoI.Parcial1.ÁvilaD;

import java.util.*;

public class ObraSocial {
	private String direccion;
	private String localidad;
	private String razonSocial;
	private ArrayList<Persona>personas;
	private HashMap<Integer, String>localidades;
	private ArrayList<Domicilio>domicilios;
	Scanner scanner = new Scanner(System.in);
	public ObraSocial(String direccion, String localidad, String razonSocial) {
		this.direccion = direccion;
		this.localidad = localidad;
		this.razonSocial = razonSocial;
		this.personas = new ArrayList();
		this.localidades = new HashMap();
		this.domicilios = new ArrayList();
	}
	//localidades
	public void mostrarLocalidades() {
		for (Map.Entry<Integer, String> entry : localidades.entrySet()) {
			String loc=entry.getValue();
			int codPostal=entry.getKey();
			System.out.println("Código de área: " + codPostal + " - Localidad: "+loc);
		}	
	}
	public boolean validarLocalidad(int codigo) {
		if(localidades.containsKey(codigo)) {
			return true;
		}else {
			return false;
		}
	}
	public void agregarLocalidad(int codArea, String localidad) {
		localidades.put(codArea, localidad);
	}
	public void agregarLocalidad() {
		System.out.println("-------------------");
		scanner.nextLine();
		System.out.println("Ingrese nombre de la localidad: ");
		String nom = scanner.nextLine();
		System.out.println("Ingrese código de área: ");
		int cod = scanner.nextInt();
		localidades.put(cod, nom);
	}
	//persona
	public Persona buscarPersonaDni(int dni) {
		for (int i=0; i<personas.size();i++) {
			if (personas.get(i).getDni()==dni) {
				return personas.get(i);
			}
		}
		System.out.println("No se encontró persona.");
		return null;
	}
	public void mostrarPersona() {
		System.out.println("----------------------------");
		System.out.println("Ingrese que desea listar: ");
		System.out.println("1)Afiliados\n2)Empleados\n3)TODOS");
		System.out.print("Opcion: ");
		int o = scanner.nextInt();
		switch(o) {
		case 1:
			for (int i=0;i<personas.size();i++) {
				if (personas.get(i)instanceof Afiliado){
					personas.get(i).mostrar();
				}
			}
			break;
		case 2: 
			for (int i=0;i<personas.size();i++) {
				if (personas.get(i)instanceof Empleado){
					personas.get(i).mostrar();
				}
			}
			break;
		case 3:
			for (int i=0;i<personas.size();i++) {
					personas.get(i).mostrar();
			}
			break;
		default:
			System.out.println("No ingreso opcion valida");
		}
		System.out.println();
	}
	public void agregarPersona(Persona persona) {
		personas.add(persona);
	}
	public void mismoDomicilio() {
		Persona persona1;
		Persona persona2;
		System.out.println("Ingrese DNI de la primera persona: ");
		int dni = scanner.nextInt();
		persona1=buscarPersonaDni(dni);
		System.out.println("Ingrese DNI de la segunda persona: ");
		int dni2= scanner.nextInt();
		persona2=buscarPersonaDni(dni2);
		if (persona1!=null && persona2!=null) { 
			if(persona1.getDomicilio().equals(persona2.getDomicilio())) {
				System.out.println(persona1.getNombre()+" "+persona1.getApellido()+" comparte el domicilio con " +persona2.getNombre()+" "+ persona2.getApellido());
			}else {
				System.out.println(persona1.getNombre()+" "+persona1.getApellido()+" no comparte el domicilio con " +persona2.getNombre()+" "+ persona2.getApellido());
			}
		}else {
			System.out.println("No se encontro una/las dos personas");
			}		
	}
	//Empleado
	public void cargarEmpleado() {
		Empleado empleado = new Empleado();
		System.out.println("Carga de domicilio");
		cargarDomicilio(empleado);
		personas.add(empleado);
	}
	public void mostrarAgentesAfiliadores() {
		for (int i=0; i<personas.size();i++) {
			if (personas.get(i) instanceof Empleado) {
				Empleado empleado = (Empleado)personas.get(i);
				if(empleado.getCargo()==Cargo.AGENTE_AFILIADOR) {
					System.out.println(empleado.getNroLegajo()+" "+empleado.getNombre()+" "+empleado.getApellido());;
				}
			}
		}
	}
	//Afiliado
	public void cargarAfiliado() {
		Afiliado afiliado=new Afiliado();
		System.out.println("Empleados disponibles: ");
		mostrarAgentesAfiliadores();
		System.out.println("Ingrese Nro del agente afiliador: ");
		int nroLeg=scanner.nextInt();
		for (int i=0;i<personas.size();i++) {
			if (personas.get(i) instanceof Empleado) {
				Empleado empleado = (Empleado)personas.get(i);
				if (empleado.getNroLegajo()==nroLeg) {
					afiliado.setAgenteAfiliador(empleado);
				}
			}
		}
		System.out.println("Carga de domicilio");
		cargarDomicilio(afiliado);
		personas.add(afiliado);
	}
	//domicilios
	public void agregarDomicilio(Domicilio domicilio) {
		domicilios.add(domicilio);
	}
	public int buscarDomicilio(String barrio, String calle, int nro, int cod) {
		for(int i=0;i<domicilios.size();i++) {
			if (domicilios.get(i).getBarrio().equalsIgnoreCase(barrio) && domicilios.get(i).getCalle().equalsIgnoreCase(calle) && domicilios.get(i).getNro()==nro && domicilios.get(i).getLocalidad()==cod) {
				return i;
			}
		}
			return -1;
	}
	public void cargarDomicilio(Persona persona) {
		System.out.println("-----------------------");
		scanner.nextLine();
		System.out.println("Ingrese barrio: ");
		String barrio=scanner.nextLine().toLowerCase();;
		System.out.println("Ingrese calle: ");
		String calle=scanner.nextLine().toLowerCase();
		System.out.println("Ingrese nro: ");
		int nro=scanner.nextInt();
		System.out.println("-----------------------");
		System.out.println("Localidad:");
		System.out.println("Localidades con cobertura: ");
		mostrarLocalidades();
		int cod=0;
		do {
		System.out.println("Ingrese codigo de area: ");
		cod = scanner.nextInt();
		}while(validarLocalidad(cod)!=true);
		System.out.println("Validacion correcta!");
		int o=buscarDomicilio(barrio, calle, nro, cod);
		if (o>=0) {
			persona.setDomicilio(domicilios.get(o));
		}else {
			Domicilio domicilio = new Domicilio(barrio, calle, nro ,cod);
			persona.setDomicilio(domicilio);
			domicilios.add(domicilio);
		}
	}
	public void mostrarDomicilios() {
		for(int i=0;i<domicilios.size();i++) {
			domicilios.get(i).mostrar();
		}
	}
	//mostrar obra social
	public void mostrar() {
		System.out.println("--------------------");
		System.out.println("- "+this.razonSocial+" -");
		System.out.println("--------------------");
		System.out.println("Direccion: "+this.direccion);
		System.out.println("Localidad: "+this.localidad);
		System.out.println("Localidades con cobertura: ");
		mostrarLocalidades();
		System.out.println("--------------------");
	}
	//getters & setters
	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public ArrayList<Persona> getPersonas() {
		return personas;
	}

	public void setPersonas(ArrayList<Persona> personas) {
		this.personas = personas;
	}

	public HashMap<Integer, String> getLocalidades() {
		return localidades;
	}

	public void setLocalidades(HashMap<Integer, String> localidades) {
		this.localidades = localidades;
	}
	public ArrayList<Domicilio> getDomicilios() {
		return domicilios;
	}
	public void setDomicilios(ArrayList<Domicilio> domicilios) {
		this.domicilios = domicilios;
	}

	

}

