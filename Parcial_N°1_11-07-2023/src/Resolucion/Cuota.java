package Resolucion;
import java.util.Date;
import java.util.Calendar;

public class Cuota {
	private int nroCuota;
	private int montoTotalCuota;
	private boolean estaPaga;
	private String fecha_pago;
	private FormaDePago formaPago;
	public Cuota(int nroCuota, int montoTotalCuota, boolean estaPaga, String fecha_vencimiento, FormaDePago formaPago) {
		super();
		this.nroCuota = nroCuota;
		this.montoTotalCuota = montoTotalCuota;
		this.estaPaga = estaPaga;
		this.fecha_pago = fecha_vencimiento;
		this.formaPago = formaPago;
	}
	public Cuota() {
		
	}
	public void mostrar() {
		System.out.println("NRO CUOTA: "+this.nroCuota+", MONTO DE CUOTA: "+this.montoTotalCuota
				+"\nFECHA_PAGO: "+this.fecha_pago);
		if(estaPaga==true) {
			System.out.println("CUOTA PAGADA, MEDIO DE PAGO:"+this.formaPago);
		}else {
			System.out.println("CUOTA IMPAGA");
		}
	}
	public void cuotaPaga(FormaDePago forma, String fecha){
		this.estaPaga=true;
		this.formaPago=forma;
		this.fecha_pago=fecha;
	}
	//gettes y setters
	public int getNroCuota() {
		return nroCuota;
	}
	public void setNroCuota(int nroCuota) {
		this.nroCuota = nroCuota;
	}
	public int getMontoTotalCuota() {
		return montoTotalCuota;
	}
	public void setMontoTotalCuota(int montoTotalCuota) {
		this.montoTotalCuota = montoTotalCuota;
	}
	public boolean isEstaPaga() {
		return estaPaga;
	}
	public void setEstaPaga(boolean estaPaga) {
		this.estaPaga = estaPaga;
	}
	public String getFecha_vencimiento() {
		return fecha_pago;
	}
	public void setFecha_vencimiento(String fecha_vencimiento) {
		this.fecha_pago = fecha_vencimiento;
	}
	public FormaDePago getFormaPago() {
		return formaPago;
	}
	public void setFormaPago(FormaDePago formaPago) {
		this.formaPago = formaPago;
	}
	
}