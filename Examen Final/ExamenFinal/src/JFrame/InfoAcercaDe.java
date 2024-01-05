package JFrame;

import javax.swing.*;

public class InfoAcercaDe {

    public static void mostrar(JFrame frame) {
        String mensaje = "Desarrollador: Denis Avila \nFecha de examen: 19/12/2023 \nInstancia: Regular";
        JOptionPane.showMessageDialog(frame, mensaje, "Acerca De", JOptionPane.INFORMATION_MESSAGE);
    }
}