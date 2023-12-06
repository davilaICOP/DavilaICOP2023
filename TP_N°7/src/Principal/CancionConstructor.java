package Principal;
import Entidad.Cancion;
public class CancionConstructor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cancion otraCancion = new Cancion("Deadlocked","F-777");
		System.out.println(otraCancion.getTitulo());
		System.out.println(otraCancion.getAutor());
		
		Cancion unaCancion = new Cancion();
		unaCancion.cargarCancion();
		unaCancion.mostrarCancion();
	}

}
