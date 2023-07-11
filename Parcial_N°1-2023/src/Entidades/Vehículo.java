package Entidades;
import java.util.*;
public class Vehículo {
	private String marca;
	private String modelo;
	private int año;
	private int nroMotor;
	private String chasis;
	private String color;
	private int potenciaCV;
	private String matrícula;
	
	public Vehículo(String marca, String modelo, int año, int nroMotor, String chasis, String color, int potenciaCV,
			String matrícula) {
		super();
		this.marca = marca;
		this.modelo = modelo;
		this.año = año;
		this.nroMotor = nroMotor;
		this.chasis = chasis;
		this.color = color;
		this.potenciaCV = potenciaCV;
		this.matrícula = matrícula;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getAño() {
		return año;
	}

	public void setAño(int año) {
		this.año = año;
	}

	public int getNroMotor() {
		return nroMotor;
	}

	public void setNroMotor(int nroMotor) {
		this.nroMotor = nroMotor;
	}

	public String getChasis() {
		return chasis;
	}

	public void setChasis(String chasis) {
		this.chasis = chasis;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getPotenciaCV() {
		return potenciaCV;
	}

	public void setPotenciaCV(int potenciaCV) {
		this.potenciaCV = potenciaCV;
	}

	public String getMatrícula() {
		return matrícula;
	}

	public void setMatrícula(String matrícula) {
		this.matrícula = matrícula;
	}

}
