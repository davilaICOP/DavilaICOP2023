package JFrame;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import Modelo.*;

public class InfoPadron {
    private JFrame framePrincipal;

    public InfoPadron(Sistema sistema, JFrame frame) {
        this.framePrincipal = frame;

        List<Sufragante> padron = sistema.generarPadronVotantesOrdenado();
        StringBuilder informacionPadron = new StringBuilder();
        for (Sufragante votante : padron) {
            informacionPadron.append(votante.getApellido()).append(", ")
                             .append(votante.getNombre()).append(" - ")
                             .append(votante.getEdad()).append(" años\n");
        }

        // Etiqueta para el título centrado
        JLabel lblTitulo = new JLabel("Padrón de sufragantes ordenado:");
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);

        // Configurar JTextArea y JScrollPane
        JTextArea textArea = new JTextArea(10, 30);
        textArea.setText(informacionPadron.toString());
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);

        JPanel panelPadron = new JPanel(new BorderLayout());
        panelPadron.add(lblTitulo, BorderLayout.NORTH);
        panelPadron.add(scrollPane, BorderLayout.CENTER);

        JButton btnSalir = new JButton("Salir");
        btnSalir.addActionListener(e -> {
            framePrincipal.setContentPane(new JPanel());
            framePrincipal.revalidate();
            framePrincipal.repaint();
        });

        framePrincipal.getContentPane().removeAll();
        framePrincipal.getContentPane().add(panelPadron, BorderLayout.CENTER);
        framePrincipal.getContentPane().add(btnSalir, BorderLayout.SOUTH);

        // Configurar las dimensiones del frame principal
        framePrincipal.setSize(400, 300);
        framePrincipal.revalidate();
        framePrincipal.repaint();
    }
}