package Entidades;
import java.util.*;
public class Autobus extends Vehículo {
    private int nroPlazas;

    public Autobus(String marca, String modelo, int año, int nroMotor, String chasis, String color, int potenciaCV, String matricula, int nroPlazas) {
        super(marca, modelo, año, nroMotor, chasis, color, potenciaCV, matricula);
        this.nroPlazas = nroPlazas;
    }

    public int getNroPlazas() {
        return nroPlazas;
    }

    public void setNroPlazas(int nroPlazas) {
        this.nroPlazas = nroPlazas;
    }
}
