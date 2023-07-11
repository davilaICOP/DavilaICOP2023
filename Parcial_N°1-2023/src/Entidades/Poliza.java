package Entidades;
import java.util.*;
public class Poliza {
	private static int nroPolizaAct = 1000;
	private int numeroPoliza;
	private String fechaInicio;
	private String fechaFin;
	private int cantidadCuotas;
	private Entidades.Cuota.FormaPago formaPago;
	private double montoTotalAsegurado;
	private boolean incluyeGranizo;
	private double montoMaximoGranizo;
	private String tipoCobertura;
	private Cliente cliente;
	private Vehículo vehiculo;
	private ArrayList<Cuota> cuotas;
	
	private ArrayList<Cuota> generarCuotas() {
		 ArrayList<Cuota> cuotasGeneradas = new ArrayList<>();
		 double montoCuota = montoTotalAsegurado / cantidadCuotas;
		 for (int i = 1; i <= cantidadCuotas; i++) {
			 Cuota cuota = new Cuota(i, montoCuota, false, fechaFin, formaPago);
	            cuotasGeneradas.add(cuota);
	            }
		 return cuotasGeneradas;
	    }

	public Poliza(String fechaInicio, String fechaFin, int cantidadCuotas, Entidades.Cuota.FormaPago formaPago, double montoTotalAsegurado,
			boolean incluyeGranizo, double montoMaximoGranizo, String tipoCobertura, Cliente cliente, Vehículo vehiculo,
			ArrayList<Cuota> cuotas) {
		super();
		
		this.numeroPoliza = nroPolizaAct++;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.cantidadCuotas = cantidadCuotas;
		this.formaPago = formaPago;
		this.montoTotalAsegurado = montoTotalAsegurado;
		this.incluyeGranizo = incluyeGranizo;
		this.montoMaximoGranizo = montoMaximoGranizo;
		this.tipoCobertura = tipoCobertura;
		this.cliente = cliente;
		this.vehiculo = vehiculo;
		this.cuotas = cuotas;
	}

	public int getNumeroPoliza() {
		return numeroPoliza;
	}

	public void setNumeroPoliza(int numeroPoliza) {
		this.numeroPoliza = numeroPoliza;
	}

	public String getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public String getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}

	public int getCantidadCuotas() {
		return cantidadCuotas;
	}

	public void setCantidadCuotas(int cantidadCuotas) {
		this.cantidadCuotas = cantidadCuotas;
	}

	public Entidades.Cuota.FormaPago getFormaPago() {
		return formaPago;
	}

	public void setFormaPago(Entidades.Cuota.FormaPago formaPago) {
		this.formaPago = formaPago;
	}

	public double getMontoTotalAsegurado() {
		return montoTotalAsegurado;
	}

	public void setMontoTotalAsegurado(double montoTotalAsegurado) {
		this.montoTotalAsegurado = montoTotalAsegurado;
	}

	public boolean isIncluyeGranizo() {
		return incluyeGranizo;
	}

	public void setIncluyeGranizo(boolean incluyeGranizo) {
		this.incluyeGranizo = incluyeGranizo;
	}

	public double getMontoMaximoGranizo() {
		return montoMaximoGranizo;
	}

	public void setMontoMaximoGranizo(double montoMaximoGranizo) {
		this.montoMaximoGranizo = montoMaximoGranizo;
	}

	public String getTipoCobertura() {
		return tipoCobertura;
	}

	public void setTipoCobertura(String tipoCobertura) {
		this.tipoCobertura = tipoCobertura;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Vehículo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(Vehículo vehiculo) {
		this.vehiculo = vehiculo;
	}

	public ArrayList<Cuota> getCuotas() {
		return cuotas;
	}

	public void setCuotas(ArrayList<Cuota> cuotas) {
		this.cuotas = cuotas;
	}
	
	enum FormaPago {
        Efectivo,
        Transferencia,
        Débito_Automático
    }
}
