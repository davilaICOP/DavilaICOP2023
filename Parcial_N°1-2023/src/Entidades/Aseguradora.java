package Entidades;
import java.util.*;
import java.util.ArrayList;
import Entidades.Cliente;
import Entidades.Vehículo;
import Entidades.Poliza;
public class Aseguradora {
	Scanner scanner = new Scanner(System.in);
	private ArrayList<Cliente> clientes;
	private ArrayList<Vehículo> vehículos;
	private ArrayList<Poliza> poliza;
	
	public Aseguradora() {
        clientes = new ArrayList<>();
        vehículos = new ArrayList<>();
        poliza = new ArrayList<>();      
    }
	
	public void registrarCliente() { 
        System.out.print("Ingresar nombre del cliente: ");
        String nombre = scanner.next();        
        System.out.print("Ingresar apellido del cliente: ");
        String apellido = scanner.next();      
        System.out.print("Ingresar género del cliente: ");
        String genero = scanner.next();
        System.out.print("Ingresar documento del cliente: ");
        int documento = scanner.nextInt();
        System.out.print("Ingresar correo electrónico del cliente: ");
        String mail = scanner.next();
        System.out.print("Ingresar domicilio del cliente: ");
        String domicilio = scanner.next();
        System.out.print("Ingresar teléfono del cliente:");
        String telefono = scanner.next();
        
        Cliente nuevoCliente = new Cliente(nombre, apellido, genero, documento, mail, domicilio, telefono);
        clientes.add(nuevoCliente);
        System.out.println("¡Se ha registrado un cliente!");
	}
	
	public void listarCliente() {
        System.out.println("Lista de clientes:");
        for (Cliente cliente : clientes) {
            System.out.println("Nombre: " + cliente.getNombre());
            System.out.println("Apellido: " + cliente.getApellido());
            System.out.println("Género: " + cliente.getGenero());
            System.out.println("Documento: " + cliente.getDocumento());
            System.out.println("Correo electrónico: " + cliente.getMail());
            System.out.println("Domicilio: " + cliente.getDomicilio());
            System.out.println("Teléfono: " + cliente.getTelefono());
            System.out.println("------------");
        }
    }
	
	public void buscarClienteDocumento() {
        System.out.print("Ingrese el documento del cliente a buscar: ");
        int documento = scanner.nextInt();
        boolean encontrado = false;

        for (Cliente cliente : clientes) {
            if (cliente.getDocumento() == documento) {
                System.out.println("Cliente encontrado:");
                System.out.println("Nombre: " + cliente.getNombre());
                System.out.println("Apellido: " + cliente.getApellido());
                System.out.println("Género: " + cliente.getGenero());
                System.out.println("Documento: " + cliente.getDocumento());
                System.out.println("Correo electrónico: " + cliente.getMail());
                System.out.println("Domicilio: " + cliente.getDomicilio());
                System.out.println("Teléfono: " + cliente.getTelefono());
                System.out.println("------------");
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Cliente no encontrado.");
        }
    }
    
	public void registrarVehículo() {
	    System.out.println("Ingrese el tipo de vehículo: 1)Taxi - 2)Autobús");
	    int tipoVehiculo = scanner.nextInt();

	    System.out.print("Ingresar marca del vehículo: ");
	    String marca = scanner.next();
	    System.out.print("Ingresar modelo del vehículo: ");
	    String modelo = scanner.next();
	    System.out.print("Ingresar año del vehículo: ");
	    int año = scanner.nextInt();
	    System.out.print("Ingresar número de motor del vehículo: ");
	    int nroMotor = scanner.nextInt();
	    System.out.print("Ingresar chasis del vehículo: ");
	    String chasis = scanner.next();
	    System.out.print("Ingresar color del vehículo: ");
	    String color = scanner.next();
	    System.out.print("Ingresar potencia en CV del vehículo: ");
	    int potenciaCV = scanner.nextInt();
	    System.out.print("Ingresar matrícula del vehículo: ");
	    String matricula = scanner.next();

	    if (tipoVehiculo == 1) {
	        System.out.print("Ingresar número de licencia del Taxi: ");
	        int nroLicencia = scanner.nextInt();

	        Taxi nuevoTaxi = new Taxi(marca, modelo, año, nroMotor, chasis, color, potenciaCV, matricula, nroLicencia);
	        vehículos.add(nuevoTaxi);
	    } else if (tipoVehiculo == 2) {
	        System.out.print("Ingresar número de plazas del Autobús: ");
	        int nroPlazas = scanner.nextInt();

	        Autobus nuevoAutobus = new Autobus(marca, modelo, año, nroMotor, chasis, color, potenciaCV, matricula, nroPlazas);
	        vehículos.add(nuevoAutobus);
	    } else {
	        System.out.println("Tipo de vehículo inválido.");
	        return;
	    }

	    System.out.println("¡Se ha registrado un vehículo!");
	}
    
	public void listarVehículo() {
        System.out.println("Lista de vehículos:");
        for (Vehículo vehiculo : vehículos) {
            System.out.println("Marca: " + vehiculo.getMarca());
            System.out.println("Modelo: " + vehiculo.getModelo());
            System.out.println("Año: " + vehiculo.getAño());
            System.out.println("Número de motor: " + vehiculo.getNroMotor());
            System.out.println("Chasis: " + vehiculo.getChasis());
            System.out.println("Color: " + vehiculo.getColor());
            System.out.println("Potencia en CV: " + vehiculo.getPotenciaCV());
            System.out.println("Matrícula: " + vehiculo.getMatricula());
            System.out.println("------------");
        }
    }
    
	public void listarVehículoTipo() {
	    System.out.println("Lista de vehículos por tipo de vehículo:");
	    for (Vehículo vehiculo : vehículos) {
	        if (vehiculo instanceof Taxi) {
	            Taxi taxi = (Taxi) vehiculo;
	            System.out.println("Tipo de vehículo: Taxi");
	            System.out.println("Número de licencia: " + taxi.getNroLicencia());
	        } else if (vehiculo instanceof Autobus) {
	            Autobus autobus = (Autobus) vehiculo;
	            System.out.println("Tipo de vehículo: Autobús");
	            System.out.println("Número de plazas: " + autobus.getNroPlazas());
	        }

	        System.out.println("Marca: " + vehiculo.getMarca());
	        System.out.println("Modelo: " + vehiculo.getModelo());
	        System.out.println("Año: " + vehiculo.getAño());
	        System.out.println("Número de motor: " + vehiculo.getNroMotor());
	        System.out.println("Chasis: " + vehiculo.getChasis());
	        System.out.println("Color: " + vehiculo.getColor());
	        System.out.println("Potencia en CV: " + vehiculo.getPotenciaCV());
	        System.out.println("Matrícula: " + vehiculo.getMatricula());
	        System.out.println("-----------");
	    }
	}
	
	public void listarVehículoCobertura(TipoDeCobertura cobertura) {
		System.out.println("Lista de vehículos por tipo de cobertura " + cobertura + ":");
        for (Vehículo vehiculo : vehículos) {
            for (Poliza poliza : polizas) {
                if (poliza.getVehiculos().contains(vehiculo) && poliza.getCobertura() == cobertura) {
                    System.out.println("Marca: " + vehiculo.getMarca());
                    System.out.println("Modelo: " + vehiculo.getModelo());
                    System.out.println("Año: " + vehiculo.getAño());
                    System.out.println("Número de motor: " + vehiculo.getNroMotor());
                    System.out.println("Chasis: " + vehiculo.getChasis());
                    System.out.println("Color: " + vehiculo.getColor());
                    System.out.println("Potencia en CV: " + vehiculo.getPotenciaCV());
                    System.out.println("Matrícula: " + vehiculo.getMatricula());
                    System.out.println("-----------");
                }
            }
        }
	}
    
    public void buscarVehículoMatrícula() {
        System.out.print("Ingrese la matrícula del vehículo a buscar: ");
        String matricula = scanner.next();
        boolean encontrado = false;

        for (Vehículo vehiculo : vehículos) {
            if (vehiculo.getMatricula().equals(matricula)) {
                System.out.println("Vehículo encontrado:");
                System.out.println("Marca: " + vehiculo.getMarca());
                System.out.println("Modelo: " + vehiculo.getModelo());
                System.out.println("Año: " + vehiculo.getAño());
                System.out.println("Número de motor: " + vehiculo.getNroMotor());
                System.out.println("Chasis: " + vehiculo.getChasis());
                System.out.println("Color: " + vehiculo.getColor());
                System.out.println("Potencia en CV: " + vehiculo.getPotenciaCV());
                System.out.println("Matrícula: " + vehiculo.getMatricula());
                System.out.println("-----------");
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Vehículo no encontrado.");
        }
    }
    
    public void registrarPoliza() {
    	System.out.print("Ingrese el documento del cliente: ");
        int documento = scanner.nextInt();

        Cliente cliente = buscarClienteDocumento(documento);
        if (cliente == null) {
            System.out.println("Cliente no encontrado. Debe registrar un nuevo cliente.");
            cliente = registrarCliente();
        }

        System.out.print("Ingrese la matrícula del vehículo: ");
        String matricula = scanner.next();

        Vehículo vehiculo = buscarVehículoMatrícula(matricula);
        if (vehiculo == null) {
            System.out.println("Vehículo no encontrado. Debe registrar un nuevo vehículo.");
            vehiculo = registrarVehículo();
        }

        System.out.print("Ingrese el número de póliza: ");
        int nroPoliza = scanner.nextInt();
        System.out.print("Ingrese la fecha de inicio: ");
        String fechaInicio = scanner.next();
        System.out.print("Ingrese la fecha de fin: ");
        String fechaFin = scanner.next();
        System.out.print("Ingrese el número de cuotas: ");
        int nroCuotas = scanner.nextInt();
        System.out.print("Ingrese la forma de pago: ");
        FormaDePago formaPago = FormaDePago.valueOf(scanner.next());
        System.out.print("Ingrese el monto total: ");
        int montoTotal = scanner.nextInt();
        System.out.print("¿Incluye cobertura por granizo? (true/false): ");
        boolean incluyeGranizo = scanner.nextBoolean();
        int montoMaxGranizo = 0;
        if (incluyeGranizo) {
            System.out.print("Ingrese el monto máximo por granizo: ");
            montoMaxGranizo = scanner.nextInt();
        }
        System.out.print("Ingrese el tipo de cobertura (Contra_Terceros, Total, Parcial): ");
        TipoDeCobertura cobertura = TipoDeCobertura.valueOf(scanner.next());

        ArrayList<Cuotas> cuotas = new ArrayList<>();
        int montoTotalCuota = montoTotal / nroCuotas;
        for (int i = 0; i < nroCuotas; i++) {
            Cuotas cuota = new Cuotas(i + 1, montoTotalCuota, false, "", null);
            cuotas.add(cuota);
        }

        Poliza poliza = new Poliza(nroPoliza, montoTotalCuota, fechaInicio, fechaFin, nroCuotas, formaPago, montoTotal,
                incluyeGranizo, montoMaxGranizo, cobertura, cliente, vehiculo, null, cuotas);
        polizas.add(poliza);

        System.out.println("¡Se ha registrado una nueva póliza!");
        System.out.println(poliza.toString());
    }
    
    public void pagarCuota() {
    	System.out.print("Ingrese el número de póliza: ");
        int nroPoliza = scanner.nextInt();

        Poliza poliza = buscarPolizaPorNumero(nroPoliza);
        if (poliza == null) {
            System.out.println("Póliza no encontrada.");
            return;
        }

        if (poliza.getCuotas().isEmpty()) {
            System.out.println("No hay cuotas pendientes para esta póliza.");
            return;
        }

        Cuotas cuota = poliza.getCuotas().get(0);
        if (cuota.isPagado()) {
            System.out.println("La cuota ya ha sido pagada anteriormente.");
            return;
        }

        System.out.print("Ingrese la forma de pago: ");
        FormaDePago formaPago = FormaDePago.valueOf(scanner.next());
        System.out.print("Ingrese la fecha de vencimiento: ");
        String fechaVencimiento = scanner.next();

        cuota.setPago();
        cuota.setFormaPago(formaPago);
        cuota.setFechaVenc(fechaVencimiento);

        System.out.println("¡La cuota ha sido pagada exitosamente!");
    }
    
    
    public void listarPolizaCobertura() {
    	System.out.println("Lista de pólizas por tipo de cobertura " + cobertura + ":");
        for (Poliza poliza : polizas) {
            if (poliza.getCobertura() == cobertura) {
                System.out.println(poliza.toString());
                System.out.println("-----------");
            }
        }
	}
    
    public void listarPoliza(TipoDeCobertura cobertura) {
    	System.out.println("Lista de pólizas por tipo de cobertura " + cobertura + ":");
        for (Poliza poliza : polizas) {
            if (poliza.getCobertura() == cobertura) {
                System.out.println(poliza.toString());
                System.out.println("-----------");
            }
        }
	}
    
    public void buscarPolizaMostrarInfoListarCuotas() {
    	Poliza poliza = buscarPolizaPorNumero(nroPoliza);
        if (poliza == null) {
            System.out.println("Póliza no encontrada.");
            return;
        }

        System.out.println("Información de la póliza:");
        System.out.println(poliza.toString());

        System.out.println("Listado de cuotas:");
        for (Cuotas cuota : poliza.getCuotas()) {
            cuota.mostrar();
        }
	}
    
    public void verDatosEstadísticos() {
		
	}

}
	