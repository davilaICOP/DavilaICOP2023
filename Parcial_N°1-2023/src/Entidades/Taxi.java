package Entidades;
import java.util.*;
public class Taxi extends Vehículo {
    private int nroLicencia;

    public Taxi(String marca, String modelo, int año, int nroMotor, String chasis, String color, int potenciaCV, String matricula, int nroLicencia) {
        super(marca, modelo, año, nroMotor, chasis, color, potenciaCV, matricula);
        this.nroLicencia = nroLicencia;
    }

    public int getNroLicencia() {
        return nroLicencia;
    }

    public void setNroLicencia(int nroLicencia) {
        this.nroLicencia = nroLicencia;
    }
}
