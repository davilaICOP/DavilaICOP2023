package JFrame;

import javax.swing.*;
import javax.swing.text.Caret;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import java.util.*;
import java.util.List;


import Modelo.*;
import Excepciones.*;
import Main.*;

public class Menu {
	
    public static void main(String[] args) {
    	
    	Sistema sistema = new Sistema();
    	
        // Crear el frame principal
        JFrame frame = new JFrame("Sistema de Votación");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        // Crear la barra de menú
        JMenuBar menuBar = new JMenuBar();

        // Menú Inicio
        JMenu menuInicio = new JMenu("Inicio");
        JMenuItem altaVotanteItem = new JMenuItem("Alta Votante");
        JMenuItem altaCandidatoItem = new JMenuItem("Alta Candidato");
        JMenuItem votarItem = new JMenuItem("Votar");

     // Acciones para el menú Inicio
        altaVotanteItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Pedir los datos del votante
                String apellido = JOptionPane.showInputDialog(frame, "Ingrese el apellido del votante:");
                String nombre = JOptionPane.showInputDialog(frame, "Ingrese el nombre del votante:");
                int edad = Integer.parseInt(JOptionPane.showInputDialog(frame, "Ingrese la edad del votante:"));
                String domicilio = JOptionPane.showInputDialog(frame, "Ingrese el domicilio del votante:");
                String DU = JOptionPane.showInputDialog(frame, "Ingrese el Documento Único (DU) del votante:");

                // Pedir el género del votante
                String[] generoOptions = {"Masculino", "Femenino"};
                String generoString = (String) JOptionPane.showInputDialog(frame, "Seleccione el género del votante:",
                        "Género", JOptionPane.QUESTION_MESSAGE, null, generoOptions, generoOptions[0]);

                // Convertir el string del género a la enumeración correspondiente
                Genero genero = Genero.valueOf(generoString);

                // Crear una instancia de Sufragante con los datos proporcionados
                Sufragante votante = new Sufragante(apellido, nombre, edad, genero, domicilio, DU);

                // Intentar registrar al votante en el sistema
                try {
                    sistema.registrarVotante(votante);
                    JOptionPane.showMessageDialog(frame, "Votante registrado exitosamente.");
                } catch (ExcepcionVotanteReincidente ex) {
                    JOptionPane.showMessageDialog(frame, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        altaCandidatoItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Pedir los datos del candidato
                String apellido = JOptionPane.showInputDialog(frame, "Ingrese el apellido del candidato:");
                String nombre = JOptionPane.showInputDialog(frame, "Ingrese el nombre del candidato:");
                int edad = Integer.parseInt(JOptionPane.showInputDialog(frame, "Ingrese la edad del candidato:"));
                String domicilio = JOptionPane.showInputDialog(frame, "Ingrese el domicilio del candidato:");
                String DU = JOptionPane.showInputDialog(frame, "Ingrese el Documento Único (DU) del candidato:");

                // Pedir el género del candidato
                String[] generoOptions = {"Masculino", "Femenino"};
                String generoString = (String) JOptionPane.showInputDialog(frame, "Seleccione el género del candidato:",
                        "Género", JOptionPane.QUESTION_MESSAGE, null, generoOptions, generoOptions[0]);

                // Convertir el string del género a la enumeración correspondiente
                Genero genero = Genero.valueOf(generoString);

                // Pedir el partido político del candidato
                String[] partidoOptions = {"LLA", "UXP", "JXC", "FIT"};
                String partidoString = (String) JOptionPane.showInputDialog(frame, "Seleccione el partido político del candidato:",
                        "Partido Político", JOptionPane.QUESTION_MESSAGE, null, partidoOptions, partidoOptions[0]);

                // Convertir el string del partido a la enumeración correspondiente
                PartidoPolitico partidoPolitico = PartidoPolitico.valueOf(partidoString);

                // Pedir el lema del candidato
                String lema = JOptionPane.showInputDialog(frame, "Ingrese el lema del candidato:");

                // Crear una instancia de Candidato con los datos proporcionados
                Candidato candidato = new Candidato(apellido, nombre, edad, genero, domicilio, DU, partidoPolitico, lema);

                // Intentar registrar al candidato en el sistema
                sistema.registrarCandidato(candidato);
                JOptionPane.showMessageDialog(frame, "Candidato registrado exitosamente.");
            }
        });

        votarItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Crear un array de opciones
                    String[] opciones = {"Votar en Blanco", "Impugnar Voto", "Votar a Candidato"};

                    // Pedir al usuario que elija una opción
                    int opcionElegida = JOptionPane.showOptionDialog(frame, "Seleccione una opción:", "Votar",
                            JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);

                    // Pedir el DNI del votante
                    String dniVotante = JOptionPane.showInputDialog(frame, "Ingrese el DNI del votante:");

                    // Realizar la acción correspondiente según la opción elegida
                    switch (opcionElegida) {
                        case 0:
                        	// Implementar la lógica para votar en blanco
                            sistema.votarEnBlanco(dniVotante);
                            JOptionPane.showMessageDialog(frame, "Voto en blanco registrado exitosamente.");
                            break;
                        case 1:
                            // Implementar la lógica para impugnar voto
                            sistema.impugnarVoto(dniVotante);
                            JOptionPane.showMessageDialog(frame, "Voto impugnado exitosamente.");
                            break;         
                        case 2:
                        	// Pedir el DNI del candidato
                            String dniCandidato = JOptionPane.showInputDialog(frame, "Ingrese el DNI del candidato:");
                            // Implementar la lógica para votar
                            sistema.votar(dniVotante, dniCandidato);
                            JOptionPane.showMessageDialog(frame, "Voto registrado exitosamente.");
                            break;	
                        default:
                            // No debería llegar aquí, pero manejar por si acaso
                            JOptionPane.showMessageDialog(frame, "Opción inválida.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (ExcepcionVotanteNoEncontrado | ExcepcionVotanteReincidente ex) {
                    // Manejar las excepciones
                    JOptionPane.showMessageDialog(frame, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        menuInicio.add(altaVotanteItem);
        menuInicio.add(altaCandidatoItem);
        menuInicio.add(votarItem);

        // Menú Info
        JMenu menuInfo = new JMenu("Info");
        JMenuItem acercaDeItem = new JMenuItem("Acerca De");
        JMenuItem padronItem = new JMenuItem("Padrón");
        JMenuItem candidatosItem = new JMenuItem("Candidatos");
        JMenuItem escrutinioProvisorioItem = new JMenuItem("Escrutinio Provisorio");
        JMenuItem escrutinioDefinitivoItem = new JMenuItem("Escrutinio Definitivo");

        // Acciones para el menú Info
        acercaDeItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Mostrar información acerca del desarrollador y la instancia de examen
                String mensaje = "Desarrollador: [Denis Avila]\nFecha e instancia de examen: [19/12/2023 - Regular]";
                JOptionPane.showMessageDialog(frame, mensaje, "Acerca De", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        padronItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Sufragante> padron = sistema.generarPadronVotantesOrdenado();
                StringBuilder informacionPadron = new StringBuilder("Información del Padrón:\n");

                for (Sufragante votante : padron) {
                    informacionPadron.append("Apellido: ").append(votante.getApellido()).append(", ");
                    informacionPadron.append("Nombre: ").append(votante.getNombre()).append(", ");
                    informacionPadron.append("Edad: ").append(votante.getEdad()).append("\n");
                }

                mostrarInformacion("Padrón", informacionPadron.toString());
            }
        });


        candidatosItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener la lista de candidatos ordenada
                List<Candidato> listaCandidatos = sistema.generarListaCandidatosOrdenada();

                // Crear una cadena para almacenar la información formateada
                StringBuilder informacionCandidatos = new StringBuilder();

                // Formatear la información según tus requisitos
                for (Candidato candidato : listaCandidatos) {
                    informacionCandidatos.append(candidato.getPartidoPolitico()).append(" - ")
                                        .append(candidato.getApellido()).append(", ")
                                        .append(candidato.getNombre()).append("\n");
                }

                // Mostrar la información
                mostrarInformacion("Lista de Candidatos", informacionCandidatos.toString());
            }
        });

        escrutinioProvisorioItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener la lista de candidatos ordenada
                List<Candidato> listaCandidatos = sistema.generarListaCandidatosOrdenada();

                // Crear una cadena para almacenar la información formateada
                StringBuilder informacionEscrutinioProvisorio = new StringBuilder("Escrutinio Provisorio:\n");

                // Formatear la información de cada candidato
                for (Candidato candidato : listaCandidatos) {
                    informacionEscrutinioProvisorio.append("Candidato: ")
                            .append(candidato.getNombre())
                            .append(" ")
                            .append(candidato.getApellido())
                            .append(" - Votos recibidos: ")
                            .append(candidato.getCantidadVotos())
                            .append("\n");
                }

                // Agregar información de votos en blanco y votos impugnados
                informacionEscrutinioProvisorio.append("Votos en Blanco: ")
                        .append(sistema.votosEnBlanco)
                        .append("\n")
                        .append("Votos Impugnados: ")
                        .append(sistema.votosImpugnados);

                // Mostrar la información
                mostrarInformacion("Escrutinio Provisorio", informacionEscrutinioProvisorio.toString());
            }
        });

        escrutinioDefinitivoItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implementar la lógica para mostrar el escrutinio definitivo y terna de ganadores
                validarEscrutinio();  // Ajusta según tu implementación
            }
        });
                
        menuInfo.add(acercaDeItem);
        menuInfo.add(padronItem);
        menuInfo.add(candidatosItem);
        menuInfo.add(escrutinioProvisorioItem);
        menuInfo.add(escrutinioDefinitivoItem);

        // Menú Salir
        JMenu menuSalir = new JMenu("Salir");

        JMenuItem salirItem = new JMenuItem("Salir");

        // Acción para el menú Salir
        salirItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        menuSalir.add(salirItem);

        // Agregar menús a la barra de menú
        menuBar.add(menuInicio);
        menuBar.add(menuInfo);
        menuBar.add(menuSalir);

        // Agregar la barra de menú al frame
        frame.setJMenuBar(menuBar);

        // Mostrar el frame
        frame.setVisible(true);
    }

    // Método para obtener el padrón (ajusta según tu implementación)
    private static List<Sufragante> obtenerPadron() {
        // Implementa la lógica para obtener el padrón
        return null;
    }

    // Método para obtener la información del padrón (ajusta según tu implementación)
    private static String obtenerInformacionPadron(List<Sufragante> padron) {
        // Implementa la lógica para obtener la información del padrón
        return "Información del Padrón";
    }

    // Método para obtener la lista de candidatos (ajusta según tu implementación)
    private static List<Candidato> obtenerListaCandidatos() {
        // Implementa la lógica para obtener la lista de candidatos
        return null;
    }

    // Método para obtener la información de los candidatos (ajusta según tu implementación)
    private static String obtenerInformacionCandidatos(List<Candidato> listaCandidatos) {
        // Implementa la lógica para obtener la información de los candidatos
        return "Información de los Candidatos";
    }

    // Método para mostrar información en un cuadro de diálogo
    private static void mostrarInformacion(String titulo, String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, titulo, JOptionPane.INFORMATION_MESSAGE);
    }

    // Método para mostrar el escrutinio provisorio (ajusta según tu implementación)
    private static void mostrarEscrutinioProvisorio() {
        // Implementa la lógica para mostrar el escrutinio provisorio
        JOptionPane.showMessageDialog(null, "Implementar lógica para mostrar el escrutinio provisorio");
    }
    
    // Método para validar el escrutinio
    private static boolean validarEscrutinio() {
    	// Implementa la lógica para validar el escrutinio
    	JOptionPane.showMessageDialog(null, "Implementar lógica para mostrar el escrutinio definitivo");

        // Retorna true si el escrutinio es válido, de lo contrario, false
        return false;
    }

    // Método para emitir el escrutinio definitivo y la terna de ganadores
    private void emitirEscrutinioDefinitivoYTernaGanadores() {
        // Valida el escrutinio antes de emitir el resultado definitivo
        if (validarEscrutinio()) {
            // Calcular la terna de ganadores
            List<Candidato> ternaGanadores = calcularTernaGanadores();

            // Mostrar la terna de ganadores en un cuadro de diálogo
            mostrarInformacion("Terna de Ganadores", obtenerInformacionTernaGanadores(ternaGanadores));

            // Mostrar la cantidad de votos totales por partido en la consola
            mostrarVotosTotalesPorPartido();
        } else {
            // Muestra un mensaje indicando que el escrutinio no es válido
            JOptionPane.showMessageDialog(null, "El escrutinio no es válido", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }


    // Método para calcular la terna de ganadores
    private List<Candidato> calcularTernaGanadores() {
        // Implementa la lógica para calcular la terna de ganadores
        
        // Retorna la lista de candidatos ganadores
        return null;
    }

    // Método para obtener la información de la terna de ganadores (ajusta según tu implementación)
    private String obtenerInformacionTernaGanadores(List<Candidato> ternaGanadores) {
        // Implementa la lógica para obtener la información de la terna de ganadores
        return "Información de la Terna de Ganadores";
    }

    // Método para mostrar la cantidad de votos totales por partido en la consola
    private void mostrarVotosTotalesPorPartido() {
        // Implementa la lógica para mostrar la cantidad de votos totales por partido
        // ...
    }

}
