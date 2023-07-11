package Entidades;
import java.util.*;
public class Cliente {
	private String nombre;
	private String apellido;
	private String género;
	private int documento;
	private String mail;
	private String domicilio;
	private int teléfono;
	
	public Cliente(String nombre, String apellido, String género, int documento, String mail, String domicilio,
			int teléfono) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.género = género;
		this.documento = documento;
		this.mail = mail;
		this.domicilio = domicilio;
		this.teléfono = teléfono;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getGénero() {
		return género;
	}

	public void setGénero(String género) {
		this.género = género;
	}

	public int getDocumento() {
		return documento;
	}

	public void setDocumento(int documento) {
		this.documento = documento;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public int getTeléfono() {
		return teléfono;
	}

	public void setTeléfono(int teléfono) {
		this.teléfono = teléfono;
	}

}
