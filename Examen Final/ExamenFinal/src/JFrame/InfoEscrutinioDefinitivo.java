package JFrame;

import javax.swing.*;
import java.awt.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import Modelo.*;

public class InfoEscrutinioDefinitivo {
    private JFrame framePrincipal;

    public InfoEscrutinioDefinitivo(Sistema sistema, JFrame frame) {
        this.framePrincipal = frame;

        // Generar el contenido del escrutinio definitivo
        String contenidoEscrutinio = generarContenidoEscrutinio(sistema);

        // Etiqueta para el título centrado
        JLabel lblTitulo = new JLabel("Escrutinio Definitivo:");
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);

        // Configurar JTextArea y JScrollPane
        JTextArea textArea = new JTextArea(10, 30); // Ajustar el segundo número para cambiar el ancho
        textArea.setText(contenidoEscrutinio);
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);

        JPanel panelEscrutinio = new JPanel(new BorderLayout());
        panelEscrutinio.add(lblTitulo, BorderLayout.NORTH);
        panelEscrutinio.add(scrollPane, BorderLayout.CENTER);

        // Botón para salir
        JButton btnSalir = new JButton("Salir");
        btnSalir.addActionListener(e -> {
            framePrincipal.setContentPane(new JPanel());
            framePrincipal.revalidate();
            framePrincipal.repaint();
        });

        framePrincipal.getContentPane().removeAll();
        framePrincipal.getContentPane().add(panelEscrutinio, BorderLayout.CENTER);
        framePrincipal.getContentPane().add(btnSalir, BorderLayout.SOUTH);

        // Configurar las dimensiones del frame principal
        framePrincipal.setSize(400, 300);
        framePrincipal.revalidate();
        framePrincipal.repaint();
    }

    private String generarContenidoEscrutinio(Sistema sistema) {
        StringBuilder sb = new StringBuilder();

        // Guardar el flujo de salida estándar original
        PrintStream originalOut = System.out;

        // Crear un flujo de salida para capturar la salida estándar
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream newOut = new PrintStream(baos);
        System.setOut(newOut);

        // Generar los datos para el escrutinio definitivo y la terna de ganadores
        sistema.emitirEscrutinioDefinitivoYTernaGanadores();

        // Restaurar la salida estándar original
        System.setOut(originalOut);

        // Convertir el contenido del ByteArrayOutputStream a String
        String resultado = baos.toString();

        // Agregar el resultado al StringBuilder
        sb.append(resultado);
        return sb.toString();
    }
}