package JFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import Modelo.*;
import Excepciones.*;
import Persistencia.CandidatoPersistencia;
import Persistencia.SufragantePersistencia;
import Persistencia.VotosEspecialesPersistencia;

public class InicioVotar extends JPanel {
	
	private SufragantePersistencia sufragantePersistencia;
    private CandidatoPersistencia candidatoPersistencia;
    private VotosEspecialesPersistencia votosEspecialesPersistencia;
    private JTextField txtDni;
    private JButton btnValidar, btnCancelar;
    private Sistema sistema;
    private JFrame framePrincipal;
    
    public InicioVotar(Sistema sistema, JFrame frame) {
    	this.sufragantePersistencia = new SufragantePersistencia();
        this.candidatoPersistencia = new CandidatoPersistencia();
        this.votosEspecialesPersistencia = new VotosEspecialesPersistencia();
        this.sistema = sistema;
        this.framePrincipal = frame;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS)); // Cambio en el layout del panel principal
        buscarVotante();
    }

    private void buscarVotante() {
        // Panel para el DNI
        JPanel panelDni = new JPanel();
        panelDni.setLayout(new FlowLayout());
        JLabel lblDni = new JLabel("Ingrese el número de documento del votante:");
        txtDni = new JTextField(20);
        panelDni.add(lblDni);
        panelDni.add(txtDni);
        
        // Añadir el panel DNI al panel principal
        add(panelDni);

        // Espacio entre panelDni y botón validar
        add(Box.createRigidArea(new Dimension(0, 10)));
        
        // Panel para el botón Validar
        JPanel panelValidar = new JPanel();
        panelValidar.setLayout(new FlowLayout(FlowLayout.CENTER));
        btnValidar = new JButton("Validar DU");
        panelValidar.add(btnValidar);
        
        // Añadir el panelValidar al panel principal
        add(panelValidar);

        // Espacio entre botón validar y botón salir
        add(Box.createVerticalGlue()); // Este espaciador empuja el siguiente componente al fondo

        // Panel para el botón Salir
        JPanel panelSalir = new JPanel();
        panelSalir.setLayout(new FlowLayout(FlowLayout.CENTER));
        btnCancelar = new JButton("Salir");
        panelSalir.add(btnCancelar);

        // Añadir el panelSalir al fondo del panel principal
        add(panelSalir);

        // Acciones de los botones
        btnValidar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int dni = Integer.parseInt(txtDni.getText());
                    validarVotante(dni);
                    // Continuar con el proceso de votación si no hay excepciones
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(InicioVotar.this, "Por favor, ingrese un número de DNI válido.", "Error de formato", JOptionPane.ERROR_MESSAGE);
                } catch (ExcepcionVotanteNoEncontrado | ExcepcionVotanteReincidente ex) {
                    JOptionPane.showMessageDialog(InicioVotar.this, ex.getMessage(), "Error de validación", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int respuesta = JOptionPane.showConfirmDialog(
                    InicioVotar.this,
                    "¿Desea salir de 'Votar'?",
                    "Cancelar votación",
                    JOptionPane.YES_NO_OPTION
                );
                if (respuesta == JOptionPane.YES_OPTION) {
                    // Aquí, volver al menú principal o cerrar este panel
                    framePrincipal.setContentPane(new JPanel());
                    framePrincipal.revalidate();
                    framePrincipal.repaint();
                }
                // Si es NO_OPTION, no hace nada y se queda en la pantalla
            }
        });
    }
    
    private void validarVotante(int dni) throws ExcepcionVotanteNoEncontrado, ExcepcionVotanteReincidente {
        Candidato candidato = sistema.buscarCandidatoPorDni(dni);
        
        // Verificar si el DNI pertenece a un candidato
        if (candidato != null) {
            throw ExcepcionVotanteNoEncontrado.votanteEsCandidato();
        }
        Sufragante votante = sistema.buscarVotante(dni);
        // Si no es un candidato, buscarlo como votante
        if (votante == null) {
            throw ExcepcionVotanteNoEncontrado.votanteNoRegistrado();
        }       
        // Si el sufragante ya emitió su voto
        if (votante.haEmitidoVoto()) {
            throw ExcepcionVotanteReincidente.votoEmitido();
        }
        
        sistema.listaCandidatos = candidatoPersistencia.obtenerTodosLosCandidatosOrdenados();
        List<Candidato> candidatosOrdenados = new ArrayList<>(sistema.listaCandidatos);
        Collections.sort(candidatosOrdenados, Candidato.comparadorPorPartidoApellidoNombre());

        removeAll(); // Limpiar el panel antes de agregar nuevos componentes
        
        // Crear y configurar el JLabel para el texto "Seleccione su voto:"
        JLabel labelTitulo = new JLabel("Seleccione su voto:");
        labelTitulo.setAlignmentX(Component.CENTER_ALIGNMENT); // Centrar horizontalmente

        // Crear un nuevo panel para el título y configurarlo para centrar el JLabel
        JPanel panelTitulo = new JPanel();
        panelTitulo.setLayout(new BoxLayout(panelTitulo, BoxLayout.X_AXIS));
        panelTitulo.add(Box.createHorizontalGlue()); // Espacio a la izquierda
        panelTitulo.add(labelTitulo);               // Añadir el JLabel
        panelTitulo.add(Box.createHorizontalGlue()); // Espacio a la derecha

        // Añadir el panel del título al panel principal
        add(panelTitulo);
        add(Box.createRigidArea(new Dimension(0, 10))); // Espacio después del título

        for (Candidato votarCandidato : candidatosOrdenados) {
        	
        JButton btnCandidato = new JButton(votarCandidato.getPartidoPolitico()+": "
        +votarCandidato.getApellido()+" "+votarCandidato.getNombre());
        btnCandidato.setAlignmentX(Component.CENTER_ALIGNMENT); // Centrar botón
        btnCandidato.addActionListener(e -> {
            // Acciones al hacer clic en el botón
        	votarCandidato.incrementarCantidadVotos();       	
        	sufragantePersistencia.actualizarVotoEmitido(votante.getDU(), true);
        	candidatoPersistencia.actualizarCantidadVotos(votarCandidato.getDU());
            JOptionPane.showMessageDialog(this, "Voto registrado correctamente para " 
            + votarCandidato.getNombre()+" "+votarCandidato.getApellido()+" de "+votarCandidato.getPartidoPolitico());
            volverAPantallaDeIngreso();
        });
        add(btnCandidato);
        add(Box.createRigidArea(new Dimension(0, 10))); // Espacio entre botones
        }

        JButton btnBlanco = new JButton("Votar en Blanco");
        btnBlanco.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnBlanco.addActionListener(e -> {
            // Acciones al hacer clic en el botón
        	sufragantePersistencia.actualizarVotoEmitido(votante.getDU(), true);
            votosEspecialesPersistencia.incrementarVotosEnBlanco();
            JOptionPane.showMessageDialog(this, "Voto en blanco registrado correctamente.");
            volverAPantallaDeIngreso();
        	
        });
        add(btnBlanco);
        add(Box.createRigidArea(new Dimension(0, 10))); // Espacio

        JButton btnImpugnado = new JButton("Impugnar Voto");
        btnImpugnado.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnImpugnado.addActionListener(e -> {
            // Acciones al hacer clic en el botón
        	sufragantePersistencia.actualizarVotoEmitido(votante.getDU(), true);
            votosEspecialesPersistencia.incrementarVotosImpugnados();
            JOptionPane.showMessageDialog(this, "Voto impugnado correctamente.");
            volverAPantallaDeIngreso();
            
        });
        add(btnImpugnado);
        revalidate(); // Actualizar el panel para mostrar los nuevos componentes
        repaint();
        
    }
    
    private void volverAPantallaDeIngreso() {
        removeAll(); // Elimina todos los componentes del panel
        buscarVotante(); // Vuelve a añadir los componentes iniciales
        revalidate(); // Actualiza el panel
        repaint(); // Repinta el panel
    }
    
    public void mostrarPanelVotacion() {
        framePrincipal.setContentPane(this);
        framePrincipal.revalidate();
        framePrincipal.repaint();
    }
}