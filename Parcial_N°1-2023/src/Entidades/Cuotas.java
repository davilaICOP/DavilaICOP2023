package Entidades;
import java.util.*;
public class Cuotas{
	private int nroCuotas;
	private int montoTotalCuota;
	private boolean pagado;
	private String fechaVenc;
	private FormaDePago formaPago;	
    Scanner sc= new Scanner(System.in);

	public Cuotas(int nroCuotas2,int montoTotalCuota,boolean pagado, String fechaVenc, FormaDePago formaPago2) {
		this.nroCuotas = nroCuotas2;
		this.montoTotalCuota = montoTotalCuota;
		this.pagado = pagado;
		this.fechaVenc = fechaVenc;
		formaPago = formaPago2;
	}

	public Cuotas() {	
		
		System.out.println("¿Pagará en este momento? 1)Si - 2)No" );
		int pag = sc.nextInt();
		switch(pag) {
		case 1: this.pagado = true;
		break;
		case 2: this.pagado = false;
		break;
		default: this.pagado = false;
		}			
	}
	
	public void mostrar() {
		System.out.println(" Número de cuotas: "+this.nroCuotas+" Monto total por cuota: "+this.montoTotalCuota+ " ¿Está pagado? "+this.pagado+" Vencimiento: "+this.fechaVenc);
	}
	
	public void cuotaPagada(FormaDePago pago,String fecha) {
		this.pagado = true;
		this.formaPago = pago;
		this.fechaVenc = fecha;
	}

	public boolean setPago() {
		return this.pagado = true;
	}
	public boolean Pagado(){
		return true;
	}

	public int getNroCuotas() {
		return nroCuotas;
	}

	public void setNroCuotas(int nroCuotas) {
		this.nroCuotas = nroCuotas;
	}

	public int getMontoTotalCuota() {
		return montoTotalCuota;
	}

	public void setMontoTotalCuota(int montoTotalCuota) {
		this.montoTotalCuota = montoTotalCuota;
	}

	public boolean isPagado() {
		return pagado;
	}

	public void setPagado(boolean pagado) {
		this.pagado = pagado;
	}

	public String getFechaVenc() {
		return fechaVenc;
	}

	public void setFechaVenc(String fechaVenc) {
		this.fechaVenc = fechaVenc;
	}

	public FormaDePago getFormaPago() {
		return formaPago;
	}

	public void setFormaPago(FormaDePago formaPago) {
		this.formaPago = formaPago;
	}

}

//private int nroCuota;
//private double montoTotalCuota;
//private boolean estáPagada;
//private int díaVencimiento;
//private int mesVencimiento;
//private int añoVencimiento;
//private FormaDePago formaPago;