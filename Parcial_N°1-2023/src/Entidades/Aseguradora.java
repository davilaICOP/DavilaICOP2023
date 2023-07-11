package Entidades;
import java.util.*;

import entidades.estadoCivil;
public class Aseguradora {
	private ArrayList<Cliente> clientes;
	private ArrayList<Vehículo> vehículos;
	private ArrayList<Poliza> polizas;
	
	public Aseguradora() {
        clientes = new ArrayList<>();
        vehículos = new ArrayList<>();
        polizas = new ArrayList<>();
    }
	
	public void registrarCliente() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingresar nombre del cliente: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingresar apellido del cliente: ");
        String apellido = scanner.nextLine();
        System.out.print("Ingresar género del cliente: ");
        String genero = scanner.nextLine();
        System.out.print("Ingresar documento del cliente: ");
        int documento = scanner.nextInt();
        System.out.print("Ingresar correo electrónico del cliente: ");
        String mail = scanner.nextLine();
        System.out.print("Ingresar domicilio del cliente: ");
        String domicilio = scanner.nextLine();
        System.out.print("Ingresar teléfono del cliente: ");
        int telefono = scanner.nextInt();
        
        Cliente cliente = new Cliente(nombre, apellido, genero, documento, mail, domicilio, telefono);
        clientes.add(cliente);
        System.out.println("Se ha registrado un cliente");
	}
	
	public void listarClientes() {
        if (clientes.isEmpty()) {
            System.out.println("No hay clientes registrados.");
        } else {
            System.out.println("Clientes registrados:");
            for (Cliente cliente : clientes) {
                System.out.println("Nombre: " + cliente.getNombre());
                System.out.println("Apellido: " + cliente.getApellido());
                System.out.println("Género: " + cliente.getGénero());
                System.out.println("Documento: " + cliente.getDocumento());
                System.out.println("Correo electrónico: " + cliente.getMail());
                System.out.println("Domicilio: " + cliente.getDomicilio());
                System.out.println("Teléfono: " + cliente.getTeléfono());
                System.out.println("FIN");
            }
        }
    }
	public void buscarClientePorDocumento() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el documento del cliente a buscar: ");
        int documento = scanner.nextInt();
	
	boolean clienteEncontrado = false;
    for (Cliente cliente : clientes) {
        if (cliente.getDocumento().equals(int documento)) {
            System.out.println("Cliente encontrado:");
            System.out.println("Nombre: " + cliente.getNombre());
            System.out.println("Apellido: " + cliente.getApellido());
            System.out.println("Género: " + cliente.getGénero());
            System.out.println("Documento: " + cliente.getDocumento());
            System.out.println("Correo electrónico: " + cliente.getMail());
            System.out.println("Domicilio: " + cliente.getDomicilio());
            System.out.println("Teléfono: " + cliente.getTeléfono());
            System.out.println("FIN");
            clienteEncontrado = true;
            break;
        }
    }

    if (!clienteEncontrado) {
        System.out.println("Cliente no encontrado.");
    }

	
    public void registrarVehiculo() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la marca del vehículo: ");
        String marca = scanner.nextLine();
        System.out.print("Ingrese el modelo del vehículo: ");
        String modelo = scanner.nextLine();
        System.out.print("Ingrese el año del vehículo: ");
        int año = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Ingrese el número de motor del vehículo: ");
        int nroMotor = scanner.nextInt();
        System.out.print("Ingrese el chasis del vehículo: ");
        String chasis = scanner.nextLine();
        System.out.print("Ingrese el color del vehículo: ");
        String color = scanner.nextLine();
        System.out.print("Ingrese la potencia en CV del vehículo: ");
        int potenciaCV = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Ingrese la matrícula del vehículo: ");
        String matricula = scanner.nextLine();
    
        Vehículo vehiculo = new Vehículo(marca, modelo, año, nroMotor, chasis, color, potenciaCV, matricula);
        vehículos.add(vehiculo);
        System.out.println("Se ha registrado un vehículo");
    }
	

	
    public void listarVehiculos() {
        if (vehículos.isEmpty()) {
            System.out.println("No hay vehículos registrados.");
        } else {
            System.out.println("Vehículos registrados:");
            for (Vehículo vehiculo : vehículos) {
                System.out.println("Marca: " + vehiculo.getMarca());
                System.out.println("Modelo: " + vehiculo.getModelo());
                System.out.println("Año: " + vehiculo.getAño());
                System.out.println("Número de motor: " + vehiculo.getNroMotor());
                System.out.println("Chasis: " + vehiculo.getChasis());
                System.out.println("Color: " + vehiculo.getColor());
                System.out.println("Potencia en CV: " + vehiculo.getPotenciaCV());
                System.out.println("Matrícula: " + vehiculo.getMatrícula());
                System.out.println("FIN");
            }
        }
    }
    
    public void listarVehiculosPorTipoYCobertura(String tipo, String cobertura) {
        if (vehículos.isEmpty()) {
            System.out.println("No hay vehículos registrados.");
        } else {
            System.out.println("Vehículos de tipo " + tipo + " y con cobertura " + cobertura + ":");
            for (Vehículo vehiculo : vehículos) {
                if (vehiculo instanceof Taxi && tipo.equalsIgnoreCase("taxi")) {
                    Taxi taxi = (Taxi) vehiculo;
                    System.out.println("Marca: " + taxi.getMarca());
                    System.out.println("Modelo: " + taxi.getModelo());
                    System.out.println("Año: " + taxi.getAño());
                    System.out.println("Número de motor: " + taxi.getNroMotor());
                    System.out.println("Chasis: " + taxi.getChasis());
                    System.out.println("Color: " + taxi.getColor());
                    System.out.println("Potencia en CV: " + taxi.getPotenciaCV());
                    System.out.println("Matrícula: " + taxi.getMatrícula());
                    System.out.println("Número de licencia: " + taxi.getNroLicencia());
                    System.out.println("FIN");
                } else if (vehiculo instanceof Autobus && tipo.equalsIgnoreCase("autobús")) {
                    Autobus autobus = (Autobus) vehiculo;
                    System.out.println("Marca: " + autobus.getMarca());
                    System.out.println("Modelo: " + autobus.getModelo());
                    System.out.println("Año: " + autobus.getAño());
                    System.out.println("Número de motor: " + autobus.getNroMotor());
                    System.out.println("Chasis: " + autobus.getChasis());
                    System.out.println("Color: " + autobus.getColor());
                    System.out.println("Potencia en CV: " + autobus.getPotenciaCV());
                    System.out.println("Matrícula: " + autobus.getMatrícula());
                    System.out.println("Número de plazas: " + autobus.getNroPlazas());
                    System.out.println("FIN");
                }
            }
        }
    }
    
    public void buscarVehiculoPorMatricula() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la matrícula del vehículo a buscar: ");
        String matricula = scanner.nextLine();

        boolean vehiculoEncontrado = false;
        for (Vehículo vehiculo : vehículos) {
            if (vehiculo.getMatrícula().equalsIgnoreCase(matricula)) {
                if (vehiculo instanceof Taxi) {
                    Taxi taxi = (Taxi) vehiculo;
                    System.out.println("Vehículo encontrado Taxi:");
                    System.out.println("Marca: " + taxi.getMarca());
                    System.out.println("Modelo: " + taxi.getModelo());
                    System.out.println("Año: " + taxi.getAño());
                    System.out.println("Número de motor: " + taxi.getNroMotor());
                    System.out.println("Chasis: " + taxi.getChasis());
                    System.out.println("Color: " + taxi.getColor());
                    System.out.println("Potencia en CV: " + taxi.getPotenciaCV());
                    System.out.println("Matrícula: " + taxi.getMatrícula());
                    System.out.println("Número de licencia: " + taxi.getNroLicencia());
                    System.out.println("FIN");
                } else if (vehiculo instanceof Autobus) {
                    Autobus autobus = (Autobus) vehiculo;
                    System.out.println("Vehículo encontrado Autobús:");
                    System.out.println("Marca: " + autobus.getMarca());
                    System.out.println("Modelo: " + autobus.getModelo());
                    System.out.println("Año: " + autobus.getAño());
                    System.out.println("Número de motor: " + autobus.getNroMotor());
                    System.out.println("Chasis: " + autobus.getChasis());
                    System.out.println("Color: " + autobus.getColor());
                    System.out.println("Potencia en CV: " + autobus.getPotenciaCV());
                    System.out.println("Matrícula: " + autobus.getMatrícula());
                    System.out.println("Número de plazas: " + autobus.getNroPlazas());
                    System.out.println("FIN");
                }
                vehiculoEncontrado = true;
                break;
            }
        }

        if (!vehiculoEncontrado) {
            System.out.println("Vehículo no encontrado.");
        }
    }
    
    public void registrarPoliza() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la fecha de inicio de la póliza (dd/mm/yyyy): ");
        String fechaInicio = scanner.nextLine();
        System.out.print("Ingrese la fecha de fin de la póliza (dd/mm/yyyy): ");
        String fechaFin = scanner.nextLine();
        System.out.print("Ingrese la cantidad de cuotas: ");
        int cantidadCuotas = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Ingrese la forma de pago 1)efectivo, 2)transferencia o 3)débito automático): ");
        int formaPago=scanner.nextInt();
    	switch(formaPago) {
    	case 1:
    		this.formaPago=FormaPago.SOLTERO;
    		break;
    	case 2:
    		this.formaPago= FormaPago.CASADO;
    		break;
    	case 3:
    		this.formaPago= FormaPago.VIUDO;
    		break;
        System.out.print("Ingrese el monto total asegurado: ");
        double montoTotalAsegurado = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Incluye cobertura contra granizo (S/N): ");
        String incluyeGranizoStr = scanner.nextLine();
        boolean incluyeGranizo = incluyeGranizoStr.equalsIgnoreCase("S");
        double montoMaximoGranizo = 0.0;
        if (incluyeGranizo) {
            System.out.print("Ingrese el monto máximo para cobertura de granizo: ");
            montoMaximoGranizo = scanner.nextDouble();
            scanner.nextLine();
        }
        System.out.print("Ingrese el tipo de cobertura (total, contra terceros o parcial): ");
        String tipoCobertura = scanner.nextLine();

        System.out.print("Ingrese el documento del cliente: ");
        String documento = scanner.nextLine();
        Cliente cliente = buscarClientePorDocumento(documento);
        if (cliente == null) {
            cliente = registrarClienteNuevo();
        }

        System.out.print("Ingrese la matrícula del vehículo: ");
        String matricula = scanner.nextLine();
        Vehículo vehiculo = buscarVehiculoPorMatricula(matricula);
        if (vehiculo == null) {
            vehiculo = registrarVehiculoNuevo();
        }

        Poliza poliza = new Poliza(fechaInicio, fechaFin, cantidadCuotas, formaPago, montoTotalAsegurado, incluyeGranizo, montoMaximoGranizo, tipoCobertura, cliente, vehiculo, null);
        polizas.add(poliza);
        System.out.println("Póliza registrada con éxito.");
    }
    public void pagarCuota() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el número de póliza: ");
        int numeroPoliza = scanner.nextInt();

        Poliza poliza = buscarPolizaPorNumero(numeroPoliza);
        if (poliza == null) {
            System.out.println("Póliza no encontrada.");
            return;
        }

        ArrayList<Cuota> cuotas = poliza.getCuotas();
        boolean todasCuotasPagadas = true;
        for (Cuota cuota : cuotas) {
            if (!cuota.isEstaPagada()) {
                todasCuotasPagadas = false;
                break;
            }
        }

        if (todasCuotasPagadas) {
            System.out.println("Todas las cuotas de esta póliza ya han sido pagadas.");
            return;
        }

        System.out.print("Ingrese el número de cuota a pagar: ");
        int numeroCuota = scanner.nextInt();

        boolean cuotaEncontrada = false;
        for (Cuota cuota : cuotas) {
            if (cuota.getNumeroCuota() == numeroCuota) {
                if (cuota.isEstaPagada()) {
                    System.out.println("La cuota ya ha sido pagada anteriormente.");
                } else {
                    cuota.setEstaPagada(true);
                    System.out.println("Cuota pagada con éxito.");
                }
                cuotaEncontrada = true;
                break;
            }
        }

        if (!cuotaEncontrada) {
            System.out.println("Cuota no encontrada.");
        }
    }
    
    public void listarPolizasPorTipoCobertura(String tipoCobertura) {
        if (polizas.isEmpty()) {
            System.out.println("No hay pólizas registradas.");
        } else {
            System.out.println("Pólizas con tipo de cobertura " + tipoCobertura + ":");
            for (Poliza poliza : polizas) {
                if (poliza.getTipoCobertura().equalsIgnoreCase(tipoCobertura)) {
                    System.out.println("Número de póliza: " + poliza.getNumeroPoliza());
                    System.out.println("Fecha de inicio: " + poliza.getFechaInicio());
                    System.out.println("Fecha de fin: " + poliza.getFechaFin());
                    System.out.println("Cantidad de cuotas: " + poliza.getCantidadCuotas());
                    System.out.println("Forma de pago: " + poliza.getFormaPago());
                    System.out.println("Monto total asegurado: " + poliza.getMontoTotalAsegurado());
                    System.out.println("Incluye cobertura de granizo: " + poliza.isIncluyeGranizo());
                    System.out.println("Monto máximo de cobertura de granizo: " + poliza.getMontoMaximoGranizo());
                    System.out.println("Tipo de cobertura: " + poliza.getTipoCobertura());
                    System.out.println("Cliente: " + poliza.getCliente().getNombre() + " " + poliza.getCliente().getApellido());
                    System.out.println("Vehículo: " + poliza.getVehiculo().getMarca() + " " + poliza.getVehiculo().getModelo());
                    System.out.println("FIN");
                }
            }
        }
    }
    
    public void buscarPoliza(int numeroPoliza) {
        Poliza poliza = buscarPolizaPorNumero(numeroPoliza);
        if (poliza == null) {
            System.out.println("Póliza no encontrada.");
        } else {
            System.out.println("Póliza encontrada:");
            System.out.println("Número de póliza: " + poliza.getNumeroPoliza());
            System.out.println("Fecha de inicio: " + poliza.getFechaInicio());
            System.out.println("Fecha de fin: " + poliza.getFechaFin());
            System.out.println("Cantidad de cuotas: " + poliza.getCantidadCuotas());
            System.out.println("Forma de pago: " + poliza.getFormaPago());
            System.out.println("Monto total asegurado: " + poliza.getMontoTotalAsegurado());
            System.out.println("Incluye cobertura de granizo: " + poliza.isIncluyeGranizo());
            System.out.println("Monto máximo de cobertura de granizo: " + poliza.getMontoMaximoGranizo());
            System.out.println("Tipo de cobertura: " + poliza.getTipoCobertura());
            System.out.println("Cliente: " + poliza.getCliente().getNombre() + " " + poliza.getCliente().getApellido());
            System.out.println("Vehículo: " + poliza.getVehiculo().getMarca() + " " + poliza.getVehiculo().getModelo());
            System.out.println("Cuotas:");
            ArrayList<Cuota> cuotas = poliza.getCuotas();
            for (Cuota cuota : cuotas) {
                System.out.println("Número de cuota: " + cuota.getNumeroCuota());
                System.out.println("Monto total de cuota: " + cuota.getMontoTotalCuota());
                System.out.println("Cuota pagada: " + cuota.isEstaPagada());
                System.out.println("Fecha de vencimiento: " + cuota.getFechaVencimiento());
                System.out.println("Forma de pago: " + cuota.getFormaPago());
                System.out.println("FIN");
            }
        }
    }
    public void verDatosEstadisticos() {
        System.out.println("Datos estadísticos:");
        System.out.println("Cantidad de clientes: " + clientes.size());
        System.out.println("Cantidad de vehículos: " + vehículos.size());
        System.out.println("Cantidad de pólizas: " + polizas.size());

      
    }

    private Cliente buscarClientePorDocumento(int documento) {
        for (Cliente cliente : clientes) {
            if (cliente.getDocumento().equals(documento)) {
                return cliente;
            }
        }
        return null;
    }

    private Cliente registrarClienteNuevo() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Cliente no encontrado. Se requiere registrar los datos del nuevo cliente.");
        System.out.print("Ingrese el nombre del cliente: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el apellido del cliente: ");
        String apellido = scanner.nextLine();
        System.out.print("Ingrese el género del cliente: ");
        String genero = scanner.nextLine();
        System.out.print("Ingrese el documento del cliente: ");
        int documento = scanner.nextInt();
        System.out.print("Ingrese el correo electrónico del cliente: ");
        String mail = scanner.nextLine();
        System.out.print("Ingrese el domicilio del cliente: ");
        String domicilio = scanner.nextLine();
        System.out.print("Ingrese el teléfono del cliente: ");
        int telefono = scanner.nextInt();

        Cliente cliente = new Cliente(nombre, apellido, genero, documento, mail, domicilio, telefono);
        clientes.add(cliente);
        System.out.println("Cliente registrado con éxito.");
        return cliente;
    }

    private Vehículo buscarVehiculoPorMatricula(String matricula) {
        for (Vehículo vehiculo : vehículos) {
            if (vehiculo.getMatrícula().equalsIgnoreCase(matricula)) {
                return vehiculo;
            }
        }
        return null;
    }

    
    private Vehículo registrarVehiculoNuevo() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Vehículo no encontrado. Se requiere registrar los datos del nuevo vehículo.");
        System.out.print("Ingrese la marca del vehículo: ");
        String marca = scanner.nextLine();
        System.out.print("Ingrese el modelo del vehículo: ");
        String modelo = scanner.nextLine();
        System.out.print("Ingrese el año del vehículo: ");
        int año = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Ingrese el número de motor del vehículo: ");
        int nroMotor = scanner.nextInt();
        System.out.print("Ingrese el chasis del vehículo: ");
        String chasis = scanner.nextLine();
        System.out.print("Ingrese el color del vehículo: ");
        String color = scanner.nextLine();
        System.out.print("Ingrese la potencia en CV del vehículo: ");
        int potenciaCV = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Ingrese la matrícula del vehículo: ");
        String matricula = scanner.nextLine();

        Vehículo vehiculo = new Vehículo(marca, modelo, año, nroMotor, chasis, color, potenciaCV, matricula);
        vehículos.add(vehiculo);
        System.out.println("Vehículo registrado con éxito.");
        return vehiculo;
    }

    private Poliza buscarPolizaPorNumero(int numeroPoliza) {
        for (Poliza poliza : polizas) {
            if (poliza.getNumeroPoliza() == numeroPoliza) {
                return poliza;
            }
        }
        return null;
    }
}
}
