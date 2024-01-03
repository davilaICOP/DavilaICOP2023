package JFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Modelo.*;

public class InicioAltaVotante extends JPanel {
    private JTextField txtApellido, txtNombre, txtDomicilio, txtDU, txtEdad;
    private JComboBox<Genero> cbGenero;
    private JButton btnRegistrar, btnSalir;
    private Sistema sistema;
    private JFrame framePrincipal;

    public InicioAltaVotante(Sistema sistema, JFrame frame) {
        this.sistema = sistema;
        this.framePrincipal = frame;
        setLayout(new BorderLayout()); // Cambia el layout a BorderLayout

        // Crear el título
        JLabel lblTitulo = new JLabel("Complete el registro del votante:");
        lblTitulo.setHorizontalAlignment(JLabel.CENTER); // Alinea el texto al centro
        add(lblTitulo, BorderLayout.NORTH); // Agrega el título en la parte superior

        // Crear un panel para el formulario
        JPanel panelFormulario = new JPanel(new GridLayout(0, 2)); // Usa GridLayout para el formulario

        // Agregar campos al panelFormulario
        panelFormulario.add(new JLabel("Apellido:"));
        txtApellido = new JTextField(20);
        panelFormulario.add(txtApellido);

        panelFormulario.add(new JLabel("Nombre:"));
        txtNombre = new JTextField(20);
        panelFormulario.add(txtNombre);

        panelFormulario.add(new JLabel("Edad:"));
        txtEdad = new JTextField(20);
        panelFormulario.add(txtEdad);

        panelFormulario.add(new JLabel("Género:"));
        cbGenero = new JComboBox<>(Genero.values());
        panelFormulario.add(cbGenero);
        
        panelFormulario.add(new JLabel("Domicilio:"));
        txtDomicilio = new JTextField(20);
        panelFormulario.add(txtDomicilio);

        panelFormulario.add(new JLabel("Número de documento (DU):"));
        txtDU = new JTextField(20);
        panelFormulario.add(txtDU);        

        btnRegistrar = new JButton("Registrar votante");
        panelFormulario.add(btnRegistrar);

        btnSalir = new JButton("Salir");
        panelFormulario.add(btnSalir);

        // Agregar el panelFormulario al centro de InicioAltaVotante
        add(panelFormulario, BorderLayout.CENTER);

        // Agregar listeners a los botones
        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registrarVotante();
            }
        });

        btnSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Mostrar un diálogo de confirmación
                int confirm = JOptionPane.showConfirmDialog(
                    InicioAltaVotante.this, 
                    "¿Desea salir de 'Alta Votante'?", 
                    "Confirmar salida", 
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE);

                // Si el usuario selecciona "Sí" (YES_OPTION)
                if (confirm == JOptionPane.YES_OPTION) {
                    // Cerrar la ventana actual
                	framePrincipal.setContentPane(new JPanel());
                    framePrincipal.revalidate();
                    framePrincipal.repaint();
                }
                // Si el usuario selecciona "No" (NO_OPTION), simplemente no hace nada y la ventana permanece abierta
            }
        });      
    }    

    private void registrarVotante() {        
        String apellido = txtApellido.getText();
        String nombre = txtNombre.getText();
        int edad;
        try {
            edad = Integer.parseInt(txtEdad.getText());  // Intenta convertir el texto a un entero
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Error: Formato de edad inválido.", "Error de Validación", JOptionPane.ERROR_MESSAGE);
            return; // Sale del método para evitar más procesamiento
        }
        String domicilio = txtDomicilio.getText();
        Genero genero = (Genero) cbGenero.getSelectedItem();
        int du;
        try {
            du = Integer.parseInt(txtDU.getText());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Error: Formato de DU inválido.", "Error de Validación", JOptionPane.ERROR_MESSAGE);
            return;
        }        
        if (!Ciudadano.verificarYRegistrarDocumento(du, false)) {
            JOptionPane.showMessageDialog(this, "Error: DU ya registrado.", "Error de Registro", JOptionPane.ERROR_MESSAGE);
            return;
        }
            Sufragante sufragante = new Sufragante(apellido, nombre, edad, genero, domicilio, du);
    	    // Llama al método registrarVotante de Sistema y guarda el mensaje devuelto
    	    String mensaje = sistema.registrarVotante(sufragante);
    	    // Muestra el mensaje en un cuadro de diálogo
            JOptionPane.showMessageDialog(this, mensaje);       
    }   
    
    public void mostrarPanelVotacion() {
        framePrincipal.setContentPane(this);
        framePrincipal.revalidate();
        framePrincipal.repaint();
    }
}