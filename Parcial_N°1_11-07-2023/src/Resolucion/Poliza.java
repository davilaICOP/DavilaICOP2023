package Resolucion;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
public class Poliza {
	private static int nro=1000;
	private Vehiculo vehiculo;
	private Cliente cliente;
	private int nroPoliza;
	private String fecha_inicio;
	private String fecha_fin;
	private int cantidadCuotas;
	private FormaDePago formaPago;
	private int montoTotalAsegurado;
	private boolean incluyeGranizo;
	private int montoGranizoMaximo;
	private TipoCobertura tipoCobertura;
	private int montoCuota;
	private ArrayList<Cuota>cuotas;
	
	Scanner scanner = new Scanner(System.in);
	
	public Poliza(Vehiculo vehiculo, Cliente cliente, String fecha_inicio, String fecha_fin,
			int cantidadCuotas, FormaDePago formaPago, int montoTotalAsegurado, boolean incluyeGranizo,
			int montoGranizoMaximo, TipoCobertura tipoCobertura, int montoCuota) {
		this.vehiculo = vehiculo;
		this.cliente = cliente;
		this.nroPoliza = nro++;
		this.fecha_inicio = fecha_inicio;
		this.fecha_fin = fecha_fin;
		this.cantidadCuotas = cantidadCuotas;
		this.formaPago = formaPago;
		this.montoTotalAsegurado = montoTotalAsegurado;
		this.incluyeGranizo = incluyeGranizo;
		this.montoGranizoMaximo = montoGranizoMaximo;
		this.tipoCobertura = tipoCobertura;
		this.cuotas = new ArrayList();
		this.montoCuota = montoCuota;
		for(int i=0;i<this.cantidadCuotas;i++) {
			this.cuotas.add(new Cuota(i+1,this.montoCuota,false, null, null));
		}
	}

	public Poliza(Vehiculo vehiculo, Cliente cliente) {
		System.out.println("NUEVA POLIZA:");
		this.nroPoliza = nro++;
		System.out.println("Ingrese fecha de inicio (formato dd/mm/yyyy)");
		this.fecha_inicio=scanner.nextLine();
		System.out.println("Ingrese fecha de fin (formato dd/mm/yyyy)");
		String fechaFin=scanner.nextLine();
		System.out.println("Ingrese cantidad de cuotas:");
		this.cantidadCuotas=scanner.nextInt();
		System.out.println("Ingrese forma de pago (1)EFECTIVO, 2)TRANSFERENCIA, 3)DEBITO");
		int opcion = scanner.nextInt();
		switch (opcion) {
		case 1: 
			this.formaPago=FormaDePago.EFECTIVO;
			break;
		case 2:
			this.formaPago=FormaDePago.TRANSFERENCIA;
			break;
		case 3:
			this.formaPago=FormaDePago.DEBITO;
			break;
			default:
				System.out.println("OPCION INCORRECTA, PREDETERMINADO EFECTIVO");
				this.formaPago=FormaDePago.EFECTIVO;
		}
		System.out.println("Ingrese monto total asegurado");
		this.montoTotalAsegurado=scanner.nextInt();
		System.out.println("Incluye granizo? (1)SI, 2)NO)");
		int o = scanner.nextInt();
		if (o==1) {
			this.incluyeGranizo=true;
			System.out.println("Ingrese monto maximo: ");
			this.montoGranizoMaximo=scanner.nextInt();
		}else if (o==2) {
			this.incluyeGranizo=false;
		}else {
			System.out.println("OPCION NO VALIDA, NO POR DEFECTO");
			this.incluyeGranizo=false;
		}
		System.out.println("Tipo Cobertura: (1)TOTAL, 2) CONTRA TERCEROS, 3)PARCIAL");
		opcion = scanner.nextInt();
		switch (opcion) {
		case 1: 
			this.tipoCobertura=tipoCobertura.TOTAL;
			break;
		case 2:
			this.tipoCobertura=tipoCobertura.TERCEROS;
			break;
		case 3:
			this.tipoCobertura=tipoCobertura.PARCIAL;
			break;
			default:
				System.out.println("OPCION INCORRECTA, PREDETERMINADO CONTRA TERCEROS");
				this.tipoCobertura=tipoCobertura.TERCEROS;
		}
		this.cuotas = new ArrayList();
		System.out.println("Ingrese monto de cuotas: ");
		this.montoCuota =scanner.nextInt();
		for(int i=0;i<this.cantidadCuotas;i++) {
			if(i==0) {
				this.cuotas.add(new Cuota(i+1,this.montoCuota,false,this.fecha_inicio, null));
			}else {
			this.cuotas.add(new Cuota(i+1,this.montoCuota,false, null, null));
			}
		}
		this.vehiculo=vehiculo;
		this.cliente=cliente;
	}
	public void mostrar() {
		System.out.println("------------------------------------------");
		System.out.println("VEHICULO: "+this.vehiculo.getMarca()+" "+this.vehiculo.getModelo()+", MATRICULA: "+this.vehiculo.getMatricula()
							+"\nCLIENTE: "+this.cliente.getNombre()+" "+this.cliente.getApellido()+" DNI: "+this.cliente.getDni()
							+"\nNRO POLIZA: "+ this.nroPoliza +", FECHA DE INICIO: "+this.fecha_inicio+", FECHA DE FIN: "+this.fecha_fin
							+"\nFORMA DE PAGO: "+this.formaPago+", MONTO TOTAL ASEGURADO: "+this.montoTotalAsegurado);
		int cuotasPagadas=0;
		for(int i=0;i<cuotas.size();i++) {
			if (cuotas.get(i).isEstaPaga()==true) {
				cuotasPagadas++;
			}
		}
		System.out.println("CANTIDAD DE CUOTAS: "+this.cantidadCuotas+", CUOTAS PAGAS: "+cuotasPagadas);
		if (this.incluyeGranizo==true) {
			System.out.println("INCLUYE GRANIZO, MONTO MAXIMO: "+this.montoGranizoMaximo);
		}else {
			System.out.println("NO INCLUYE GRANIZO");
		}
	}
	public void mostrarCuotas() {
		for (int i=0;i<cuotas.size();i++) {
			System.out.print("CUOTA N°"+(i+1)+") ");
			cuotas.get(i).mostrar();
		}
		System.out.println("-------------------------------");
	}
	public int siguienteCuotaImpaga() {
		for(int i=0;i<cuotas.size();i++) {
			if(cuotas.get(i).isEstaPaga()==false) {
				System.out.println("CUOTA A PAGAR n° "+(i+1)+" = ");
				return i;
			}
		}
		return -1;
	}
	public void cuotaPagada(int posicionCuota, FormaDePago pago, String fecha) {
		this.cuotas.get(posicionCuota).cuotaPaga(pago, fecha);
	}
	//getters y setters:

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getFecha_inicio() {
		return fecha_inicio;
	}

	public void setFecha_inicio(String fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}

	public String getFecha_fin() {
		return fecha_fin;
	}

	public void setFecha_fin(String fecha_fin) {
		this.fecha_fin = fecha_fin;
	}

	public int getCantidadCuotas() {
		return cantidadCuotas;
	}

	public void setCantidadCuotas(int cantidadCuotas) {
		this.cantidadCuotas = cantidadCuotas;
	}

	public FormaDePago getFormaPago() {
		return formaPago;
	}

	public void setFormaPago(FormaDePago formaPago) {
		this.formaPago = formaPago;
	}

	public int getMontoTotalAsegurado() {
		return montoTotalAsegurado;
	}

	public void setMontoTotalAsegurado(int montoTotalAsegurado) {
		this.montoTotalAsegurado = montoTotalAsegurado;
	}

	public boolean isIncluyeGranizo() {
		return incluyeGranizo;
	}

	public void setIncluyeGranizo(boolean incluyeGranizo) {
		this.incluyeGranizo = incluyeGranizo;
	}

	public int getMontoGranizoMaximo() {
		return montoGranizoMaximo;
	}

	public void setMontoGranizoMaximo(int montoGranizoMaximo) {
		this.montoGranizoMaximo = montoGranizoMaximo;
	}

	public TipoCobertura getTipoCobertura() {
		return tipoCobertura;
	}

	public void setTipoCobertura(TipoCobertura tipoCobertura) {
		this.tipoCobertura = tipoCobertura;
	}
	
	
	
}