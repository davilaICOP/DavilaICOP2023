package Constructor;

import java.util.ArrayList;

public class Diagnóstico {
    private String fechaInforme;
    private double temperatura;
    private ArrayList<String> síntomas;
    private ArrayList<String> patologías;
    private String estado;
    private Médico médico;
    private Ciudadano ciudadano;

    public Diagnóstico() {
        síntomas = new ArrayList<>();
        patologías = new ArrayList<>();
    }

    public String getFechaInforme() {
        return fechaInforme;
    }

    public void setFechaInforme(String fechaInforme) {
        this.fechaInforme = fechaInforme;
    }

    public double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
    }

    public ArrayList<String> getSíntomas() {
        return síntomas;
    }

    public void agregarSíntoma(String síntoma) {
        síntomas.add(síntoma);
    }

    public ArrayList<String> getPatologías() {
        return patologías;
    }

    public void agregarPatología(String patología) {
        patologías.add(patología);
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Médico getMédico() {
        return médico;
    }

    public void setMédico(Médico médico) {
        this.médico = médico;
    }

    public Ciudadano getCiudadano() {
        return ciudadano;
    }

    public void setCiudadano(Ciudadano ciudadano) {
        this.ciudadano = ciudadano;
    }

    public void mostrar() {
        System.out.println("Fecha de Informe: " + fechaInforme);
        System.out.println("Temperatura: " + temperatura);
        System.out.println("Síntomas: " + síntomas);
        System.out.println("Patologías: " + patologías);
        System.out.println("Estado: " + estado);
        System.out.println("Médico: " + médico.getApellido() + ", " + médico.getNombre());
        System.out.println("Ciudadano: " + ciudadano.getApellido() + ", " + ciudadano.getNombre());
    }
}