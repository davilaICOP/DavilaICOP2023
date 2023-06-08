package Principal;
import Entidad.Cuenta;
public class CuentaConstructor {

	// Ejemplo de uso
    public static void main(String[] args) {
        // Crear una cuenta con un titular y saldo inicial
        Cuenta cuenta = new Cuenta("Denis", 800.0);

        // Realizar retiros de dinero de la cuenta
        cuenta.retirar_dinero();
        cuenta.retirar_dinero();
    }
}
