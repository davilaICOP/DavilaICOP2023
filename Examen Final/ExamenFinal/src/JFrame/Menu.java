package JFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Modelo.*;

public class Menu {
	
    public static void main(String[] args) {
    	
    	Sistema sistema = new Sistema();
    	
        // Crear el frame principal
        JFrame frame = new JFrame("Sistema de Votación");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        
        // Centrar la ventana en la pantalla
        frame.setLocationRelativeTo(null);

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
                InicioAltaVotante panelVotar = new InicioAltaVotante(sistema, frame);
                panelVotar.mostrarPanelVotacion();
            }
        }); 
        
        altaCandidatoItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	InicioAltaCandidato panelVotar = new InicioAltaCandidato(sistema, frame);
                panelVotar.mostrarPanelVotacion();
            }
        });        
        
        votarItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InicioVotar panelVotar = new InicioVotar(sistema, frame);
                panelVotar.mostrarPanelVotacion();
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
                InfoAcercaDe.mostrar(frame);
            }
        });
        
        padronItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new InfoPadron(sistema, frame);
            }
        });       

        candidatosItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new InfoCandidatos(sistema, frame);
            }
        });                

        escrutinioProvisorioItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new InfoEscrutinioProvisorio(sistema, frame);                
            }
        });

        escrutinioDefinitivoItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new InfoEscrutinioDefinitivo(sistema, frame);
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
}