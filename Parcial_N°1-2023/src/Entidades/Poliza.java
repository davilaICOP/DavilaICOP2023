package Entidades;
import java.util.*;
import java.util.ArrayList;
public class Poliza {
    	private int nroPoliza;
    	private int nro = 1000;
    	private String fechaInicio;
    	private String fechaFin;
    	private int nroCuotas;
    	private FormaDePago formaPago;
    	private int montoTotal;
    	private boolean incluyeGranizo;
    	private int montoMaxGranizo;
    	private TipoDeCobertura cobertura;
        Scanner sc= new Scanner(System.in);
        private Cliente clientes;
        private Vehículo vehiculos;
        private Aseguradora Seguro;
        private ArrayList<Cuotas> cuota;

    	public Poliza(int nroPoliza, int nro, String fechaInicio, String fechaFin, int nroCuotas, FormaDePago formaPago,
    			int montoTotal, boolean incluyeGranizo, int montoMaxGranizo, TipoDeCobertura cobertura, Cliente clientes,
    			Vehículo vehiculos, Aseguradora seguro, ArrayList<Cuotas> cuota) {
    		super();
    		this.nroPoliza = nroPoliza;
    		this.nro = nro;
    		this.fechaInicio = fechaInicio;
    		this.fechaFin = fechaFin;
    		this.nroCuotas = nroCuotas;
    		this.formaPago = formaPago;
    		this.montoTotal = montoTotal;
    		this.incluyeGranizo = incluyeGranizo;
    		this.montoMaxGranizo = montoMaxGranizo;
    		this.cobertura = cobertura;
    		this.clientes = clientes;
    		this.vehiculos = vehiculos;
    		this.Seguro = seguro;
    		this.cuota = cuota;
    	}
 	
    	
    	
    	public int getNroPoliza() {
    		return nroPoliza;
    	}

    	public void setNroPoliza(int nroPoliza) {
    		this.nroPoliza = nroPoliza;
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

    	public int getNroCuotas() {
    		return nroCuotas;
    	}

    	public void setNroCuotas(int nroCuotas) {
    		this.nroCuotas = nroCuotas;
    	}

    	public FormaDePago getFormaPago() {
    		return formaPago;
    	}

    	public void setFormaPago(FormaDePago formaPago) {
    		this.formaPago = formaPago;
    	}

    	public int getMontoTotal() {
    		return montoTotal;
    	}

    	public void setMontoTotal(int montoTotal) {
    		this.montoTotal = montoTotal;
    	}

    	public boolean isIncluyeGranizo() {
    		return incluyeGranizo;
    	}

    	public void setIncluyeGranizo(boolean incluyeGranizo) {
    		this.incluyeGranizo = incluyeGranizo;
    	}

    	public int getMontoMaxGranizo() {
    		return montoMaxGranizo;
    	}

    	public void setMontoMaxGranizo(int montoMaxGranizo) {
    		this.montoMaxGranizo = montoMaxGranizo;
    	}

    	public TipoDeCobertura getCobertura() {
    		return cobertura;
    	}

    	public void setCobertura(TipoDeCobertura cobertura) {
    		this.cobertura = cobertura;
    	}

    	public int getNro() {
    		return nro;
    	}

    	public void setNro(int nro) {
    		this.nro = nro;
    	}

    	public Cliente getClientes() {
    		return clientes;
    	}

    	public void setClientes(Cliente clientes) {
    		this.clientes = clientes;
    	}

    	public Vehículo getVehiculos() {
    		return vehiculos;
    	}

    	public void setVehiculos(Vehículo vehiculos) {
    		this.vehiculos = vehiculos;
    	}

    	public Aseguradora getSeguro() {
    		return Seguro;
    	}

    	public void setSeguro(Aseguradora seguro) {
    		this.Seguro = seguro;
    	}
    	
}


//private static int nroPolizaAct = 1000;
//private int nroPoliza;
//private int añoInicioPoliza;
//private int mesInicioPoliza;
//private int díaInicioPoliza;
//private int añoFinPoliza;
//private int mesFinPoliza;
//private int díaFinPoliza;
//private int cantidadCuotas;
//private FormaDePago formaPago;
//private double montoTotalAsegurado;
//private boolean incluyeGranizo;
//private double montoMaximoGranizo;
//private TipoDeCobertura cobertura;
//private Cliente cliente;
//private Vehículo vehiculo;
//private ArrayList<Cuota> cuotas;