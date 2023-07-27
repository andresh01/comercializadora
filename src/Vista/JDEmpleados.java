/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.EmpleadoC;
import com.sun.rowset.CachedRowSetImpl;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.rowset.CachedRowSet;
import javax.swing.JOptionPane;



/**
 *
 * @author Andres
 */
public class JDEmpleados extends javax.swing.JDialog {

    /**
     * Creates new form JDEmpleados
     */
    public JDEmpleados(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        identificacion();
        cargos();
    }
    
    private void limpiarGestionCliente(){
       txtDocumento.setText("");
       txtApellido.setText("");
       txtNombre.setText("");
       cbxCargo.setSelectedIndex(0);
       cbxGenero.setSelectedIndex(0);
       jdcNac.setDate(null);
       cbEstado.setSelected(false);
       cbTipoDoc.setSelectedIndex(0);
    }
    
    private void habilitarCampos(boolean estado){
        
        btnRegistrar.setEnabled(estado);
        cbEstado.setEnabled(estado);
        cbTipoDoc.setEnabled(estado);
        cbxCargo.setEnabled(estado);
        cbxGenero.setEnabled(estado);
        txtNombre.setEnabled(estado);
        txtApellido.setEnabled(estado);
        btnModificar.setEnabled(estado);
    }
    private void identificacion(){
        try {
            EmpleadoC obj = new EmpleadoC();
            CachedRowSet crs = new CachedRowSetImpl();
            crs = obj.poblarId();
            
            while(crs.next()){
            cbTipoDoc.addItem(crs.getString(2));
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,ex.toString());
        }
        
    }
    
    private void cargos(){
        try {
            EmpleadoC obj = new EmpleadoC();
            CachedRowSet crs = new CachedRowSetImpl();
            crs = obj.poblarCargos();
            
            while(crs.next()){
            cbxCargo.addItem(crs.getString(2));
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,ex.toString());
        }
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
        jLabel3 = new javax.swing.JLabel();
        cbEstado = new javax.swing.JCheckBox();
        txtDocumento = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        btnSalir = new javax.swing.JButton();
        btnRegistrar = new javax.swing.JButton();
        btnBuscarCli = new javax.swing.JButton();
        cbTipoDoc = new javax.swing.JComboBox<>();
        btnLimpiar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtApellido = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cbxGenero = new javax.swing.JComboBox<>();
        jdcNac = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        cbxCargo = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "Gestion Empleados", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BELOW_TOP, new java.awt.Font("Lucida Grande", 0, 13), new java.awt.Color(51, 204, 0))); // NOI18N

        jLabel1.setText("Documento:");

        jLabel2.setText("Tipo Documento");

        jLabel3.setText("Nombre");

        cbEstado.setText("Estado");
        cbEstado.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        cbEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbEstadoActionPerformed(evt);
            }
        });

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        btnBuscarCli.setText("Buscar");
        btnBuscarCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarCliActionPerformed(evt);
            }
        });

        cbTipoDoc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione" }));

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        jLabel5.setText("Apellido");

        jLabel6.setText("Fecha de Nacimiento");

        jLabel8.setText("Genero:");

        cbxGenero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "Masculino", "Femenino" }));

        jLabel4.setText("Cargo");

        cbxCargo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel8)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel5))
                                .addGap(91, 91, 91)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(66, 66, 66)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbTipoDoc, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbxGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnBuscarCli)
                        .addGap(14, 14, 14))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnSalir)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(cbEstado)
                                    .addComponent(jLabel6))
                                .addComponent(jLabel4))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jdcNac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cbxCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnRegistrar)
                    .addComponent(btnLimpiar, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(49, 49, 49)
                .addComponent(btnModificar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarCli))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbTipoDoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cbxGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jdcNac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbEstado))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(cbxCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegistrar)
                    .addComponent(btnModificar))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLimpiar)
                    .addComponent(btnSalir))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbEstadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbEstadoActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        try {
            int id = Integer.parseInt(txtDocumento.getText());
            String tipo = cbTipoDoc.getSelectedItem().toString();
            String cargo = cbxCargo.getSelectedItem().toString();
            String nom = txtNombre.getText();
            String ape = txtApellido.getText();
            String gen = cbxGenero.getSelectedItem().toString();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
            String fecha = sdf.format(jdcNac.getDate());
            boolean estado = cbEstado.isSelected();
            
            EmpleadoC obj = new EmpleadoC(id, tipo, cargo, nom, ape, gen, fecha, estado);
            JOptionPane.showMessageDialog(this, obj.registrarEmpleado());
            limpiarGestionCliente();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,ex.toString());
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnBuscarCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarCliActionPerformed
        EmpleadoC obj = new EmpleadoC();
        try {
            CachedRowSet crs = obj.buscarEmpleado(Integer.parseInt(txtDocumento.getText()));
            crs.next();
            txtDocumento.setText(String.valueOf(crs.getInt(1)));
            txtNombre.setText(crs.getString(4));
            txtApellido.setText(crs.getString(5));
            cbTipoDoc.setSelectedItem(crs.getString(2));
            cbxCargo.setSelectedItem(crs.getString(3));
            cbxGenero.setSelectedItem(crs.getString(6));
            cbEstado.setSelected(crs.getBoolean(8));
            jdcNac.setDate(Date.valueOf(crs.getString(7)));
            habilitarCampos(true);
            btnRegistrar.setEnabled(false);
           
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.toString());
        }
    }//GEN-LAST:event_btnBuscarCliActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        limpiarGestionCliente();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        try {
            int id = Integer.parseInt(txtDocumento.getText());
            String tipo = cbTipoDoc.getSelectedItem().toString();
            String cargo = cbxCargo.getSelectedItem().toString();
            String nom = txtNombre.getText();
            String ape = txtApellido.getText();
            String gen = cbxGenero.getSelectedItem().toString();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
            String fecha = sdf.format(jdcNac.getDate());
            boolean estado = cbEstado.isSelected();

            EmpleadoC obj = new EmpleadoC(id,tipo, cargo, nom, ape, gen, fecha, estado);
            JOptionPane.showMessageDialog(this, obj.modificarEmpleado());
            limpiarGestionCliente();
            habilitarCampos(false);
            btnBuscarCli.setEnabled(true);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,ex.toString());
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JDEmpleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDEmpleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDEmpleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDEmpleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDEmpleados dialog = new JDEmpleados(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btnBuscarCli;
    private javax.swing.JButton btnLimpiar;
    public static javax.swing.JButton btnModificar;
    public static javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnSalir;
    public static javax.swing.JCheckBox cbEstado;
    public static javax.swing.JComboBox<String> cbTipoDoc;
    private javax.swing.JComboBox<String> cbxCargo;
    private javax.swing.JComboBox<String> cbxGenero;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private com.toedter.calendar.JDateChooser jdcNac;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtDocumento;
    public static javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}