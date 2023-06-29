package Proyecto;
import java.util.*;
public class Profesor extends Empleado {
    Scanner sc= new Scanner(System.in);

	private Departamento depa;
	int Est;
	int Dep;
		
	public Profesor(String nom, String ape, Proyecto.EstadoCivil est, Departamento depa, int anio, int mes, int dia) {
		super(nom, ape, est, depa, anio, mes, dia);
	}
	
	public Profesor() {
		super();
		
		System.out.println("Ingresar el departamento: 1)Redes - 2)Estadística - 3)Administración - 4)Ética - 5)Programación");
		Dep = sc.nextInt();
		switch(Dep) {
		case 1: depa = Departamento.Redes;
		break;
		case 2: depa = Departamento.Estadística;
		break;
		case 3: depa = Departamento.Administración;
		break;
		case 4: depa = Departamento.Ética;
		break;
		case 5: depa = Departamento.Programación;
		break;
		}
	}

	enum Departamento{
		Redes,
		Estadística,
		Administración,
		Ética,
		Programación
	}
}