package Main;
import Constructor.*;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        GestiónDiagnóstico gestión = new GestiónDiagnóstico();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("==== Menú ====");
            System.out.println("1. Gestión del sistema");
            System.out.println("2. Acceso Médico");
            System.out.println("3. Acceso Ciudadano");
            System.out.println("4. Salir");
            System.out.print("Ingrese una opción: ");
            int opción = scanner.nextInt();

            if (opción == 1) {
                System.out.println("=== Gestión del sistema ===");
                System.out.println("1. Dar de alta médico");
                System.out.println("2. Dar de alta ciudadano");
                System.out.println("3. Mostrar informes");
                System.out.print("Ingrese una opción: ");
                int gestiónOpción = scanner.nextInt();

                if (gestiónOpción == 1) {
                    System.out.print("Ingrese el apellido del médico: ");
                    String apellido = scanner.next();
                    System.out.print("Ingrese el nombre del médico: ");
                    String nombre = scanner.next();
                    System.out.print("Ingrese el DNI del médico: ");
                    String dni = scanner.next();
                    System.out.print("Ingrese la edad del médico: ");
                    int edad = scanner.nextInt();
                    System.out.print("Ingrese la localidad del médico: ");
                    String localidad = scanner.next();
                    System.out.print("Ingrese el número de matrícula del médico: ");
                    String númeroMatrícula = scanner.next();
                    System.out.print("Ingrese la especialidad del médico: ");
                    String especialidad = scanner.next();
                    Médico médico = new Médico(apellido, nombre, dni, edad, localidad, númeroMatrícula, especialidad);
                    gestión.agregarPersona(médico);
                    System.out.println("Médico agregado correctamente.");
                    
                } else if (gestiónOpción == 2) {
                    System.out.print("Ingrese el apellido del ciudadano: ");
                    String apellido = scanner.next();
                    System.out.print("Ingrese el nombre del ciudadano: ");
                    String nombre = scanner.next();
                    System.out.print("Ingrese el DNI del ciudadano: ");
                    String dni = scanner.next();
                    System.out.print("Ingrese la edad del ciudadano: ");
                    int edad = scanner.nextInt();
                    System.out.print("Ingrese la localidad del ciudadano: ");
                    String localidad = scanner.next();
                    System.out.print("Ingrese el domicilio del ciudadano: ");
                    String domicilio = scanner.next();
                    System.out.print("Ingrese la patente del ciudadano: ");
                    String patente = scanner.next();
                    Ciudadano ciudadano = new Ciudadano(apellido, nombre, dni, edad, localidad, domicilio, patente);
                    gestión.agregarPersona(ciudadano);
                    System.out.println("Ciudadano agregado correctamente.");
                    
                } else if (gestiónOpción == 3) {
                    gestión.mostrarInformes();
                } else {
                    System.out.println("Opción inválida.");
                }
            } else if (opción == 2) {
                System.out.print("Ingrese el DNI del médico: ");
                String dni = scanner.next();

                Médico médico = null;
                for (Persona persona : gestión.getPersonas()) {
                    if (persona instanceof Médico && persona.getDni().equals(dni)) {
                        médico = (Médico) persona;
                        break;
                    }
                }

                if (médico == null) {
                    System.out.println("Médico no encontrado.");
                } else {
                    System.out.println("=== Acceso Médico ===");
                    médico.mostrar();
                    System.out.println("Total de casos informados: " + gestión.getDiagnósticos().size());

                    int síntomasCompatibles = 0;
                    for (Diagnóstico diagnóstico : gestión.getDiagnósticos()) {
                        if (diagnóstico.getMédico() == médico && diagnóstico.getEstado().equals("DETECTABLE")) {
                            síntomasCompatibles++;
                        }
                    }
                    System.out.println("Casos con síntomas compatibles con COVID-19: " + síntomasCompatibles);

                    System.out.println("1. Realizar nueva prescripción diagnóstica");
                    System.out.println("2. Volver al menú principal");
                    System.out.print("Ingrese una opción: ");
                    int médicoOpción = scanner.nextInt();

                    if (médicoOpción == 1) {
                        System.out.print("Ingrese el DNI del ciudadano: ");
                        String ciudadanoDni = scanner.next();

                        Ciudadano ciudadano = null;
                        for (Persona persona : gestión.getPersonas()) {
                            if (persona instanceof Ciudadano && persona.getDni().equals(ciudadanoDni)) {
                                ciudadano = (Ciudadano) persona;
                                break;
                            }
                        }

                        if (ciudadano == null) {
                            System.out.println("Ciudadano no encontrado.");
                        } else {
                            Diagnóstico diagnóstico = new Diagnóstico();
                            diagnóstico.setMédico(médico);
                            diagnóstico.setCiudadano(ciudadano);

                            System.out.print("Ingrese la fecha del informe: ");
                            String fechaInforme = scanner.next();
                            diagnóstico.setFechaInforme(fechaInforme);

                            System.out.print("Ingrese la temperatura corporal actual: ");
                            double temperatura = scanner.nextDouble();
                            diagnóstico.setTemperatura(temperatura);

                            System.out.println("Responda las siguientes preguntas con SI o NO:");
                            System.out.print("¿Percibiste una marcada pérdida del olfato de manera repentina? ");
                            String respuesta = scanner.next();
                            if (respuesta.equalsIgnoreCase("SI")) {
                                diagnóstico.agregarSíntoma("Pérdida de olfato");
                            }
                            System.out.print("¿Percibiste una marcada pérdida del gusto de manera repentina? ");
                            respuesta = scanner.next();
                            if (respuesta.equalsIgnoreCase("SI")) {
                                diagnóstico.agregarSíntoma("Pérdida de gusto");
                            }
                            System.out.print("¿Tenés dolor de garganta? ");
                            respuesta = scanner.next();
                            if (respuesta.equalsIgnoreCase("SI")) {
                                diagnóstico.agregarSíntoma("Dolor de garganta");
                            }
                            System.out.print("¿Tenés tos? ");
                            respuesta = scanner.next();
                            if (respuesta.equalsIgnoreCase("SI")) {
                                diagnóstico.agregarSíntoma("Tos");
                            }
                            System.out.print("¿Tenés dificultad respiratoria o falta de aire? ");
                            respuesta = scanner.next();
                            if (respuesta.equalsIgnoreCase("SI")) {
                                diagnóstico.agregarSíntoma("Dificultad respiratoria");
                            }
                            System.out.print("¿Tenés dolor de cabeza? ");
                            respuesta = scanner.next();
                            if (respuesta.equalsIgnoreCase("SI")) {
                                diagnóstico.agregarSíntoma("Dolor de cabeza");
                            }
                            System.out.print("¿Tenés vómitos? ");
                            respuesta = scanner.next();
                            if (respuesta.equalsIgnoreCase("SI")) {
                                diagnóstico.agregarSíntoma("Vómitos");
                            }
                            System.out.print("¿Tenés diarrea? ");
                            respuesta = scanner.next();
                            if (respuesta.equalsIgnoreCase("SI")) {
                                diagnóstico.agregarSíntoma("Diarrea");
                            }
                            System.out.print("¿Tenés dolor muscular? ");
                            respuesta = scanner.next();
                            if (respuesta.equalsIgnoreCase("SI")) {
                                diagnóstico.agregarSíntoma("Dolor muscular");
                            }

                            diagnóstico.setEstado("APTO");
                            if (diagnóstico.getTemperatura() > 38 && diagnóstico.getSíntomas().size() >= 2) {
                                diagnóstico.setEstado("DETECTABLE");
                            }

                            gestión.agregarDiagnóstico(diagnóstico);
                            System.out.println("Prescripción diagnóstica realizada correctamente.");
                        }
                    }
                }
            } else if (opción == 3) {
                System.out.print("Ingrese el DNI del ciudadano: ");
                String dni = scanner.next();

                Ciudadano ciudadano = null;
                for (Persona persona : gestión.getPersonas()) {
                    if (persona instanceof Ciudadano && persona.getDni().equals(dni)) {
                        ciudadano = (Ciudadano) persona;
                        break;
                    }
                }

                if (ciudadano == null) {
                    System.out.println("Ciudadano no encontrado.");
                } else {
                    System.out.println("=== Acceso Ciudadano ===");
                    ciudadano.mostrar();

                    System.out.println("1. Mostrar diagnósticos");
                    System.out.println("2. Volver al menú principal");
                    System.out.print("Ingrese una opción: ");
                    int ciudadanoOpción = scanner.nextInt();

                    if (ciudadanoOpción == 1) {
                        boolean tieneDiagnósticos = false;
                        for (Diagnóstico diagnóstico : gestión.getDiagnósticos()) {
                            if (diagnóstico.getCiudadano() == ciudadano) {
                                diagnóstico.mostrar();
                                System.out.println();
                                tieneDiagnósticos = true;
                            }
                        }
                        if (!tieneDiagnósticos) {
                            System.out.println("No se encontraron diagnósticos para este ciudadano.");
                        }
                    }
                }
            } else if (opción == 4) {
                break;
            } else {
                System.out.println("Opción inválida.");
            }
            System.out.println();
        }

        System.out.println("¡Hasta luego!");
        scanner.close();
    }
}