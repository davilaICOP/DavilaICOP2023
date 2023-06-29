package Proyecto;
import java.util.*;
public class Estudiantes extends Constructor {
    Scanner sc= new Scanner(System.in);	
	HashMap<Integer, String> curso = new HashMap();
	ArrayList<String> cursoEstudiante = new ArrayList<>();
	
	public Estudiantes() {
		super();
		curso.put(1,"Redes");
		curso.put(2,"Estadística");
		curso.put(3,"Administración");
		curso.put(4,"Ética");
		curso.put(5,"Programación");
		
		boolean agregar = true;
		
		while (agregar) {
			for (Integer indice : curso.keySet()) {
				System.out.println("Número del curso: "+indice+ " "+ curso.get(indice));
			}
			
			int numeroCurso;
			System.out.println("Seleccionar qué numero del curso deseas agregar: ");
			numeroCurso = sc.nextInt();
			
			if(curso.containsKey(numeroCurso)) {
				String valor = curso.get(numeroCurso);
				cursoEstudiante.add(valor);
			}
			
			System.out.println("¿Quieres agregar otro curso?");
			String siono = sc.next().toLowerCase();
			System.out.println(siono);
			
			if(siono.equals("no")) {
				agregar = false;
			}	
		}
	}
}
