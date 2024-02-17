/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package logisticaigu;

import Controladoras.ControladoraVehiculo;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import logisticalogica.Marca;
import logisticalogica.Vehiculo;

/**
 *
 * @author ULTRA
 */
public class RegistrarVehiculo extends javax.swing.JFrame {
    private  ControladoraVehiculo controladoravehiculo;

    private Marca marcaSeleccionada;
    private Set<Integer> numerosDisponibles;
    private ViajeIGU viajeIGU;
   private MarcaIGU marcaigu;
    private VehiculosTotales vehiculosTotales;
    private JFrame ventanaOrigen;
    private Object ventanaQueLlama;
    /**
     * Creates new form RegistrarVehiculo
     */ public RegistrarVehiculo(Marca marcaSeleccionada, Object ventanaQueLlama) {
        initComponents();
        this.marcaSeleccionada = marcaSeleccionada;
        this.ventanaQueLlama = ventanaQueLlama;
        controladoravehiculo = new ControladoraVehiculo();
        inicializarNumerosDisponibles();

           }
    


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Registrar Vehiculo");

        jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel2.setText("Capacidad Kg:");

        jTextField1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setText("Patente:");

        jTextField2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButton1.setText("Volver");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButton2.setText("Guardar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(200, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(93, 93, 93)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(200, 200, 200))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jButton2)
                                .addGap(30, 30, 30)
                                .addComponent(jButton1)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(100, 100, 100)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 130, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
 int capacidadCarga = Integer.parseInt(jTextField1.getText());
    String patente = jTextField2.getText();

    Vehiculo nuevoVehiculo = new Vehiculo();
    nuevoVehiculo.setCapacidad_carga(capacidadCarga);
    nuevoVehiculo.setPatente(patente);
    nuevoVehiculo.setMarca(marcaSeleccionada);

    int numeroVehiculo = obtenerNumeroVehiculo();

    nuevoVehiculo.setNro_vehiculo(numeroVehiculo);
    guardarVehiculoEnBaseDeDatos(nuevoVehiculo);

   // Verifica qué tipo de ventana llamó a RegistrarVehiculo y la hace visible nuevamente
   if (ventanaQueLlama instanceof MarcaIGU) {
    MarcaIGU marcaIGU = (MarcaIGU) ventanaQueLlama;
    marcaIGU.mostrarMarcaIGU(); // Muestra la ventana MarcaIGU
} else if (ventanaQueLlama instanceof ViajeIGU) {
    ViajeIGU viajeIGU = (ViajeIGU) ventanaQueLlama;
    viajeIGU.setVisible(true); // Muestra la ventana ViajeIGU
    viajeIGU.mostrarVentana();
} else if (ventanaQueLlama instanceof VehiculosTotales) {
    VehiculosTotales vehiculosTotales = (VehiculosTotales) ventanaQueLlama;
    vehiculosTotales.mostrarVentana(); // Muestra la ventana VehiculosTotales y actualiza la tabla de vehículos
} else {
    // Si no se puede determinar la ventana de origen, muestra un mensaje o realiza alguna acción por defecto
    System.out.println("No se puede determinar la ventana de origen");
}

// Cierra la ventana actual
dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        MarcaIGU atras = new MarcaIGU(this.marcaigu);
        atras.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
   
private void inicializarNumerosDisponibles() {
        numerosDisponibles = new HashSet<>();
        for (int i = 1; i <= 1000; i++) {
            numerosDisponibles.add(i);
        }
    }

    private int obtenerNumeroVehiculo() {
        if (numerosDisponibles.isEmpty()) {
            // Puedes tomar medidas adicionales, como reiniciar los números disponibles
            inicializarNumerosDisponibles();
        }

        Random random = new Random();
        int numero = random.nextInt(1000) + 1;

        while (!numerosDisponibles.contains(numero)) {
            // Si el número ya está en uso, genera otro
            numero = random.nextInt(1000) + 1;
        }

        numerosDisponibles.remove(numero);
        return numero;
    }
    
    private void guardarVehiculoEnBaseDeDatos(Vehiculo vehiculo) {
        // Llama a tu método para guardar el vehículo en la base de datos
        controladoravehiculo.guardarvehiculo(vehiculo);
        // Actualiza la interfaz según sea necesario
        // ...
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
