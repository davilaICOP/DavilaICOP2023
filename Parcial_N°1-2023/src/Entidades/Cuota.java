package Entidades;
import java.util.*;
public class Cuota {
	private int numeroCuota;
    private double montoTotalCuota;
    private boolean estaPagada;
    private String fechaVencimiento;
    private FormaPago formaPago;
	
    public Cuota(int numeroCuota, double montoTotalCuota, boolean estaPagada, String fechaVencimiento,
    		FormaPago formaPago) {
		super();
		this.numeroCuota = numeroCuota;
		this.montoTotalCuota = montoTotalCuota;
		this.estaPagada = estaPagada;
		this.fechaVencimiento = fechaVencimiento;
		this.formaPago = formaPago;
	}

	public int getNumeroCuota() {
		return numeroCuota;
	}

	public void setNumeroCuota(int numeroCuota) {
		this.numeroCuota = numeroCuota;
	}

	public double getMontoTotalCuota() {
		return montoTotalCuota;
	}

	public void setMontoTotalCuota(double montoTotalCuota) {
		this.montoTotalCuota = montoTotalCuota;
	}

	public boolean isEstaPagada() {
		return estaPagada;
	}

	public void setEstaPagada(boolean estaPagada) {
		this.estaPagada = estaPagada;
	}

	public String getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(String fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	public FormaPago getFormaPago() {
		return formaPago;
	}

	public void setFormaPago(FormaPago formaPago) {
		this.formaPago = formaPago;
	}
    
	enum FormaPago {
        Efectivo,
        Transferencia,
        Débito_Automático
    }

}
