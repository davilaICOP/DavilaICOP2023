package Entidades;

import java.util.Scanner;

public class _6_Curso {
    private String nombreCurso;
    private int cantidadHorasPorDia;
    private int cantidadDiasPorSemana;
    private String turno;
    private double precioPorHora;
    private String[] alumnos;

    // Constructor por defecto
    public _6_Curso() {
        alumnos = new String[5];
    }

    // Constructor con todos los atributos como parámetro
    public _6_Curso(String nombreCurso, int cantidadHorasPorDia, int cantidadDiasPorSemana,
                 String turno, double precioPorHora) {
        this.nombreCurso = nombreCurso;
        this.cantidadHorasPorDia = cantidadHorasPorDia;
        this.cantidadDiasPorSemana = cantidadDiasPorSemana;
        this.turno = turno;
        this.precioPorHora = precioPorHora;
        this.alumnos = new String[5];
    }

    // Métodos getters y setters
    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public int getCantidadHorasPorDia() {
        return cantidadHorasPorDia;
    }

    public void setCantidadHorasPorDia(int cantidadHorasPorDia) {
        this.cantidadHorasPorDia = cantidadHorasPorDia;
    }

    public int getCantidadDiasPorSemana() {
        return cantidadDiasPorSemana;
    }

    public void setCantidadDiasPorSemana(int cantidadDiasPorSemana) {
        this.cantidadDiasPorSemana = cantidadDiasPorSemana;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public double getPrecioPorHora() {
        return precioPorHora;
    }

    public void setPrecioPorHora(double precioPorHora) {
        this.precioPorHora = precioPorHora;
    }

    // Método para cargar los nombres de los alumnos
    public void cargarAlumnos() {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < alumnos.length; i++) {
            System.out.print("Ingrese el nombre del alumno " + (i + 1) + ": ");
            alumnos[i] = scanner.nextLine();
        }
    }

    // Método para crear un nuevo curso
    public void crearCurso() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el nombre del curso: ");
        nombreCurso = scanner.nextLine();

        System.out.print("Ingrese la cantidad de horas por día: ");
        cantidadHorasPorDia = scanner.nextInt();

        System.out.print("Ingrese la cantidad de días por semana: ");
        cantidadDiasPorSemana = scanner.nextInt();
        scanner.nextLine(); // Consume la nueva línea pendiente

        System.out.print("Ingrese el turno (mañana o tarde): ");
        turno = scanner.nextLine();

        System.out.print("Ingrese el precio por hora: ");
        precioPorHora = scanner.nextDouble();

        cargarAlumnos();
    }

    // Método para calcular la ganancia semanal
    public double calcularGananciaSemanal() {
        return cantidadHorasPorDia * precioPorHora * alumnos.length * cantidadDiasPorSemana;
    }

    public static void main(String[] args) {
        _6_Curso curso = new _6_Curso();
        curso.crearCurso();

        System.out.println("\nResumen del curso:");
        System.out.println("Nombre del curso: " + curso.getNombreCurso());
        System.out.println("Turno: " + curso.getTurno());
        System.out.println("Precio por hora: $" + curso.getPrecioPorHora());
        System.out.println("Ganancia semanal: $" + curso.calcularGananciaSemanal());
    }
}
