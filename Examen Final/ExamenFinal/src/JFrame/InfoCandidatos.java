package JFrame;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import Modelo.*;

public class InfoCandidatos {
	private JFrame framePrincipal;

    public InfoCandidatos(Sistema sistema, JFrame frame) {
    	this.framePrincipal = frame;

        List<Candidato> listaCandidatos = sistema.generarListaCandidatosOrdenada();
        StringBuilder informacionCandidatos = new StringBuilder();
        for (Candidato candidato : listaCandidatos) {
            informacionCandidatos.append(candidato.getPartidoPolitico()).append(": ")
                                .append(candidato.getApellido()).append(", ")
                                .append(candidato.getNombre()).append("\n");
        }
        
        // Etiqueta para el título centrado
        JLabel lblTitulo = new JLabel("Lista de candidatos ordenada:");
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        
        // Configurar JTextArea y JScrollPane
        JTextArea textArea = new JTextArea(10, 30);
        textArea.setText(informacionCandidatos.toString());
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        
        JPanel panelCandidatos = new JPanel(new BorderLayout());
        panelCandidatos.add(lblTitulo, BorderLayout.NORTH);
        panelCandidatos.add(scrollPane, BorderLayout.CENTER);

        JButton btnSalir = new JButton("Salir");
        btnSalir.addActionListener(e -> {
            framePrincipal.setContentPane(new JPanel());
            framePrincipal.revalidate();
            framePrincipal.repaint();
        });

        framePrincipal.getContentPane().removeAll();
        framePrincipal.getContentPane().add(panelCandidatos, BorderLayout.CENTER);
        framePrincipal.getContentPane().add(btnSalir, BorderLayout.SOUTH);

        // Configurar las dimensiones del frame principal
        framePrincipal.setSize(400, 300);
        framePrincipal.revalidate();
        framePrincipal.repaint();
    }
}