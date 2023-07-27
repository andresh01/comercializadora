/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.ClienteC;
import Controlador.ConversorNumLetras;
import Controlador.EmpleadoC;
import Controlador.PedidoC;
import Controlador.ProductoC;
import com.sun.rowset.CachedRowSetImpl;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.Parent;
import javax.sql.rowset.CachedRowSet;
import javax.swing.JOptionPane;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Andres
 */
public class JDPedidos extends javax.swing.JDialog {

    int dcto;
    Object v[] = {"Codigo", "Nombre", "Valor", "Cantidad", "Descuento", "Subtotal"};
    DefaultTableModel dtm;

    /**
     * Creates new form JDPedidos
     */
    public JDPedidos(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        codigoPedido();
        btnModificar.setEnabled(false);
        cargarEmpleados();
        fechaActual();
//        SpinnerNumberModel snm = new SpinnerNumberModel();
//        snm.setMinimum(0);
//        snm.setMaximum(30);
        spDctoProducto.setEnabled(false);
        btnAgregarPDetalle.setEnabled(false);
        dtm = new DefaultTableModel(null, v);

    }

    private void fechaActual() {
        Calendar cal = Calendar.getInstance();
        String fecha;
        fecha = "" + cal.get(Calendar.YEAR);
        fecha += "/" + (cal.get(Calendar.MONTH) + 1);
        fecha += "/" + cal.get(Calendar.DAY_OF_MONTH);
        txtFechaPedido.setText(fecha);
    }

    private void cargarEmpleados() {
        try {
            EmpleadoC obj = new EmpleadoC();
            CachedRowSet crs = new CachedRowSetImpl();
            crs = obj.poblarEmpleado();

            while (crs.next()) {
                //cbEmpleado.addItem(crs.getInt(1)+" "+crs.getString(2) + " " + crs.getString(3));
                cbEmpleado.addItem(crs.getString(2));
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.toString());
        }
    }

    private void codigoPedido() {
        PedidoC obj = new PedidoC();
        try {
            txtCodPedido.setText(String.valueOf(obj.obtenerCodigo()));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.toString());
        }
    }

    private double calcularSubtotal(int valor, int cantidad) {
        return valor * (1 - (Integer.parseInt(spDctoProducto.getValue().toString()) / 100.0)) * cantidad;
    }

    private void limpiarProducto() {
        txtCantProducto.setText("");
        txtNomProducto.setText("");
        txtValorProducto.setText("");
        txtidProducto.setText("");
        spDctoProducto.setValue(0);
        lblStock.setText("");

    }

    private void limpiarInfo() {
        txtFechaPedido.setText("");
        txtidCliente.setText("");
        cbxEstado.setSelectedIndex(0);
        cbxFormaPago.setSelectedIndex(0);
        cbEmpleado.setSelectedIndex(0);
        jdcFentrega.setDate(null);
        txtNomCliente.setText("");
        txtTelCliente.setText("");
        txtDirCliente.setText("");
        txtValorLetras.setText("");
        txtSubtotal.setText("");
        txtTotal.setText("");
        txtTotalDescuento.setText("");
        txtIva.setText("");
    }

    private boolean comprobacionDatos() {
        if (txtFechaPedido.getText() == null || txtidCliente.getText() == null || cbxEstado.getSelectedIndex() == 0 || cbxFormaPago.getSelectedIndex() == 0 || cbEmpleado.getSelectedIndex() == 0 || dtm.getRowCount() == 0) {
            return true;
        }
        return false;
    }

    private double SubTotal(double val2) {
        double val1, suma;
        if (txtSubtotal.getText().equals("")) {
            txtSubtotal.setText("0");
            val1 = Integer.parseInt(txtSubtotal.getText());
        } else {
            val1 = Double.parseDouble(txtSubtotal.getText());
        }
        return suma = val2 + val1;
    }

    private int comprobarTablaProd(String id) {
        int fila = -1;
        for (int i = 0; i < jTableProd.getRowCount(); i++) {
            if (id.equals(jTableProd.getValueAt(i, 0).toString())) {
                fila = i;
                break;
            } 
        }
        return fila;
    }
    
    private double descuento(int val, int cant) {
        double desc = val * (Integer.parseInt(spDctoProducto.getValue().toString()) / 100.0) * cant;
        return desc;
    }
    
    private double sumarDescuento(double dcto){
        double val1, suma;
        if (txtTotalDescuento.getText().equals("")) {
            txtTotalDescuento.setText("0");
            val1 = Integer.parseInt(txtTotalDescuento.getText());
        } else {
            val1 = Double.parseDouble(txtTotalDescuento.getText());
        }
        return suma = dcto + val1;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jPanelinfCliente = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtidCliente = new javax.swing.JTextField();
        txtNomCliente = new javax.swing.JTextField();
        txtTelCliente = new javax.swing.JTextField();
        txtDirCliente = new javax.swing.JTextField();
        btnBuscarCliente = new javax.swing.JButton();
        jPanelinfPedido = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txtCodPedido = new javax.swing.JTextField();
        txtFechaPedido = new javax.swing.JTextField();
        jdcFentrega = new com.toedter.calendar.JDateChooser();
        cbxFormaPago = new javax.swing.JComboBox<>();
        cbxEstado = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        btnBuscarPedido = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        cbEmpleado = new javax.swing.JComboBox<>();
        jPanelProducto = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        spDctoProducto = new javax.swing.JSpinner();
        txtidProducto = new javax.swing.JTextField();
        txtValorProducto = new javax.swing.JTextField();
        txtNomProducto = new javax.swing.JTextField();
        txtCantProducto = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableProd = new javax.swing.JTable();
        btnAgregarPDetalle = new javax.swing.JButton();
        btnQuitarProducto = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtSubtotal = new javax.swing.JTextField();
        txtIva = new javax.swing.JTextField();
        txtTotal = new javax.swing.JTextField();
        txtValorLetras = new javax.swing.JTextField();
        lblStock = new javax.swing.JLabel();
        jButton10 = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtTotalDescuento = new javax.swing.JTextField();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Gestion de Pedidos", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Lucida Grande", 0, 13), new java.awt.Color(0, 204, 0))); // NOI18N

        jPanelinfCliente.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED), "Inf Cliente", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Lucida Grande", 0, 13), new java.awt.Color(0, 153, 0))); // NOI18N

        jLabel11.setText("Identificacion");

        jLabel12.setText("Nombre Cliente");

        jLabel13.setText("Telefono");

        jLabel14.setText("Direccion");

        txtidCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtidClienteKeyTyped(evt);
            }
        });

        txtNomCliente.setEnabled(false);

        txtTelCliente.setEnabled(false);

        txtDirCliente.setEnabled(false);

        btnBuscarCliente.setText("Buscar");
        btnBuscarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelinfClienteLayout = new javax.swing.GroupLayout(jPanelinfCliente);
        jPanelinfCliente.setLayout(jPanelinfClienteLayout);
        jPanelinfClienteLayout.setHorizontalGroup(
            jPanelinfClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelinfClienteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelinfClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelinfClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtidCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                    .addComponent(txtNomCliente)
                    .addComponent(txtTelCliente)
                    .addComponent(txtDirCliente))
                .addGap(18, 18, 18)
                .addComponent(btnBuscarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanelinfClienteLayout.setVerticalGroup(
            jPanelinfClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelinfClienteLayout.createSequentialGroup()
                .addGroup(jPanelinfClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelinfClienteLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanelinfClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(txtidCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelinfClienteLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnBuscarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)))
                .addGroup(jPanelinfClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtNomCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanelinfClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtTelCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(jPanelinfClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtDirCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        jPanelinfPedido.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED), "Inf Pedido", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Lucida Grande", 0, 13), new java.awt.Color(0, 153, 0))); // NOI18N

        jLabel15.setText("Codigo Pedido");

        jLabel16.setText("Fecha Pedido");

        jLabel17.setText("Fecha Entrega");

        jLabel18.setText("Forma Pago");

        jLabel19.setText("Estado");

        txtCodPedido.setEnabled(false);

        txtFechaPedido.setEnabled(false);

        cbxFormaPago.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "Contado", "Credito" }));

        cbxEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "Habilitado", "Inhabilitado" }));

        javax.swing.GroupLayout jPanelinfPedidoLayout = new javax.swing.GroupLayout(jPanelinfPedido);
        jPanelinfPedido.setLayout(jPanelinfPedidoLayout);
        jPanelinfPedidoLayout.setHorizontalGroup(
            jPanelinfPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelinfPedidoLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanelinfPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16)
                    .addComponent(jLabel17)
                    .addComponent(jLabel18)
                    .addComponent(jLabel19))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addGroup(jPanelinfPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCodPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelinfPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(cbxEstado, 0, 148, Short.MAX_VALUE)
                        .addComponent(cbxFormaPago, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jdcFentrega, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFechaPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        jPanelinfPedidoLayout.setVerticalGroup(
            jPanelinfPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelinfPedidoLayout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addGroup(jPanelinfPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txtCodPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelinfPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(txtFechaPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelinfPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17)
                    .addComponent(jdcFentrega, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelinfPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(cbxFormaPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(jPanelinfPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(cbxEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );

        jButton1.setText("Nuevo");

        btnBuscarPedido.setText("Buscar");
        btnBuscarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarPedidoActionPerformed(evt);
            }
        });

        btnModificar.setText("Modificar");

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        jButton5.setText("Salir");

        cbEmpleado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione Empleado" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscarPedido)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnModificar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnGuardar))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jPanelinfCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5)
                        .addGap(93, 93, 93)
                        .addComponent(cbEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                        .addComponent(jPanelinfPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(btnBuscarPedido)
                    .addComponent(btnModificar)
                    .addComponent(btnGuardar)
                    .addComponent(jButton5)
                    .addComponent(cbEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanelinfPedido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelinfCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jLabel1.setText("Id Producto");

        jLabel2.setText("Valor");

        jLabel3.setText("Nombre");

        jLabel4.setText("Cantidad");

        jLabel5.setText("Existencias");

        jLabel6.setText("% Descuento");

        txtidProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtidProductoKeyTyped(evt);
            }
        });

        txtValorProducto.setEnabled(false);

        txtNomProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNomProductoKeyTyped(evt);
            }
        });

        txtCantProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCantProductoKeyTyped(evt);
            }
        });

        jTableProd.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Nombre", "Valor", "Cantidad", "Descuento", "SubTotal"
            }
        ));
        jScrollPane2.setViewportView(jTableProd);

        btnAgregarPDetalle.setText("Agregar");
        btnAgregarPDetalle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarPDetalleActionPerformed(evt);
            }
        });

        btnQuitarProducto.setText("Quitar");

        jLabel7.setText("Sub Total");

        jLabel8.setText("IVA");

        jLabel9.setText("Total");

        txtValorLetras.setBackground(new java.awt.Color(0, 204, 204));

        lblStock.setBackground(new java.awt.Color(204, 204, 0));
        lblStock.setOpaque(true);

        jButton10.setText("Buscar");

        jLabel21.setText("Valor en Letras");

        jLabel10.setText("Descuento");

        javax.swing.GroupLayout jPanelProductoLayout = new javax.swing.GroupLayout(jPanelProducto);
        jPanelProducto.setLayout(jPanelProductoLayout);
        jPanelProductoLayout.setHorizontalGroup(
            jPanelProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelProductoLayout.createSequentialGroup()
                .addGroup(jPanelProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelProductoLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanelProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelProductoLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(txtidProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelProductoLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(58, 58, 58)
                                .addComponent(txtValorProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(38, 38, 38)
                        .addGroup(jPanelProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNomProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCantProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanelProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelProductoLayout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(jLabel5)
                                .addGap(26, 26, 26))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelProductoLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)))
                        .addGroup(jPanelProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(spDctoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanelProductoLayout.createSequentialGroup()
                                .addComponent(lblStock, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(39, 39, 39)
                                .addComponent(jButton10))))
                    .addGroup(jPanelProductoLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanelProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanelProductoLayout.createSequentialGroup()
                                .addComponent(jLabel21)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtValorLetras, javax.swing.GroupLayout.PREFERRED_SIZE, 506, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 628, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnQuitarProducto)
                            .addComponent(btnAgregarPDetalle)
                            .addGroup(jPanelProductoLayout.createSequentialGroup()
                                .addGroup(jPanelProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanelProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel7)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING))
                                    .addComponent(jLabel10))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanelProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtTotalDescuento)
                                    .addComponent(txtSubtotal)
                                    .addComponent(txtIva)
                                    .addComponent(txtTotal, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE))))))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanelProductoLayout.setVerticalGroup(
            jPanelProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelProductoLayout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addGroup(jPanelProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblStock, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jLabel3)
                        .addComponent(jLabel5)
                        .addComponent(txtidProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtNomProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton10))
                .addGap(18, 18, 18)
                .addGroup(jPanelProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(jLabel4)
                        .addComponent(txtValorProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtCantProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(spDctoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanelProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelProductoLayout.createSequentialGroup()
                        .addComponent(btnAgregarPDetalle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnQuitarProducto)
                        .addGroup(jPanelProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelProductoLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(txtTotalDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelProductoLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel10)))
                        .addGap(4, 4, 4)
                        .addGroup(jPanelProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtIva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanelProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel9)
                                .addComponent(txtValorLetras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel21))
                            .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanelProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanelProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtidProductoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtidProductoKeyTyped
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            ProductoC obj = new ProductoC();
            try {

                CachedRowSet crs = obj.buscarProducto(Integer.parseInt(txtidProducto.getText()));
                crs.next();
                txtidProducto.setText(String.valueOf(crs.getInt(1)));
                lblStock.setText(String.valueOf(crs.getInt(5)));
                txtNomProducto.setText(crs.getString(3));
                txtValorProducto.setText(String.valueOf(crs.getInt(4)));
                spDctoProducto.setValue(0);
                dcto = (int) crs.getDouble(7);
                spDctoProducto.setEnabled(true);
                SpinnerNumberModel snm = new SpinnerNumberModel(0, 0, dcto, 1);
                spDctoProducto.setModel(snm);

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.toString());
            }
        }
    }//GEN-LAST:event_txtidProductoKeyTyped

    private void txtNomProductoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomProductoKeyTyped
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            ProductoC obj = new ProductoC();
            try {
                CachedRowSet crs = obj.buscarProducto(txtNomProducto.getText());;
                crs.next();
                txtidProducto.setText(String.valueOf(crs.getInt(1)));
                lblStock.setText(String.valueOf(crs.getInt(5)));
                txtNomProducto.setText(crs.getString(3));
                txtValorProducto.setText(String.valueOf(crs.getInt(4)));
                spDctoProducto.setValue(0);
                dcto = (int) crs.getDouble(7);
                spDctoProducto.setEnabled(true);

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.toString());
            }
        }
    }//GEN-LAST:event_txtNomProductoKeyTyped

    private void txtidClienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtidClienteKeyTyped

        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            ClienteC obj = new ClienteC();
            obj.setIdDoc(Integer.parseInt(txtidCliente.getText()));
            try {
                CachedRowSet crs = obj.buscarClienteActivo();
                crs.next();
                txtidCliente.setText(String.valueOf(crs.getInt(1)));
                txtNomCliente.setText(crs.getString(3));
                txtDirCliente.setText(crs.getString(7));
                txtTelCliente.setText(String.valueOf(crs.getInt(5)));

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.toString());
            }
        }
    }//GEN-LAST:event_txtidClienteKeyTyped

    private void btnAgregarPDetalleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarPDetalleActionPerformed

        if (txtCantProducto.getText().trim().equals("") || Integer.parseInt(txtCantProducto.getText()) == 0) {
            JOptionPane.showMessageDialog(this, "Error, LA cantidad no puede estar vacia o ser Cero");
        } else {
            if (Integer.parseInt(txtCantProducto.getText()) > Integer.parseInt(lblStock.getText())) {
                JOptionPane.showMessageDialog(this, "Error la cantidad no puede ser Mayor al Stock ");
            } else {

                int valor, cant;

                int r = comprobarTablaProd(txtidProducto.getText());

                if (r == -1) {
                    v[0] = txtidProducto.getText();
                    v[1] = txtNomProducto.getText();
                    v[2] = txtValorProducto.getText();
                    v[3] = txtCantProducto.getText();
                    double valDesc = descuento(Integer.parseInt(txtValorProducto.getText()), Integer.parseInt(txtCantProducto.getText()));
                    v[4] = valDesc;
                    valor = Integer.parseInt(txtValorProducto.getText());
                    cant = Integer.parseInt(txtCantProducto.getText());
                    v[5] = calcularSubtotal(valor, cant);

                    dtm.addRow(v);
                    jTableProd.setModel(dtm);
                    
                    //SUBTOTAL IVA Y TOTAL CUANDO SE ADICIONA UN PRODUCTO
                    txtTotalDescuento.setText(String.valueOf(sumarDescuento(valDesc)));
                    
                    txtSubtotal.setText(String.valueOf(SubTotal(calcularSubtotal(valor, cant))));
                    double iva = Double.parseDouble(txtSubtotal.getText()) * 0.16;
                    txtIva.setText(String.valueOf(iva));
                    txtTotal.setText(String.valueOf(Double.parseDouble(txtSubtotal.getText()) + Double.parseDouble(txtIva.getText())));

                    txtValorLetras.setText(ConversorNumLetras.cantidadConLetra(txtTotal.getText()));

                } else {
                    int opc = JOptionPane.showConfirmDialog(this, "El producto ya esta registrado\nDesea adicionar la cantidad?");
                    if (opc == 0) {

                        double SubtAnterior = Double.parseDouble(jTableProd.getValueAt(r, 5).toString());
                        double descAnterior = Double.parseDouble(jTableProd.getValueAt(r, 4).toString());

                        int suma = Integer.parseInt(txtCantProducto.getText()) + Integer.parseInt(jTableProd.getValueAt(r, 3).toString());
                        jTableProd.setValueAt(suma, r, 3);

                        double des = descuento(Integer.parseInt(txtValorProducto.getText()), suma);
                        jTableProd.setValueAt(des, r, 4);

                        double subt = calcularSubtotal(Integer.parseInt(txtValorProducto.getText()), suma);
                        jTableProd.setValueAt(subt, r, 5);
                        
                        // SUBTOTAL IVA Y TOTAL CUANDO SE MODIFICA LA CANTIDAD DE UN PRODUCTO EN LA TABLA
                        txtTotalDescuento.setText(String.valueOf(Double.parseDouble(txtTotalDescuento.getText()) - descAnterior + des));
                        
                        txtSubtotal.setText(String.valueOf(Double.parseDouble(txtSubtotal.getText()) - SubtAnterior + subt));
                        double iva = Double.parseDouble(txtSubtotal.getText()) * 0.16;
                        txtIva.setText(String.valueOf(iva));
                        txtTotal.setText(String.valueOf(Double.parseDouble(txtSubtotal.getText()) + Double.parseDouble(txtIva.getText())));

                        txtValorLetras.setText(ConversorNumLetras.cantidadConLetra(txtTotal.getText()));

                    }
                }

                limpiarProducto();
                btnAgregarPDetalle.setEnabled(false);

            }
        }
    }//GEN-LAST:event_btnAgregarPDetalleActionPerformed

    private void txtCantProductoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantProductoKeyTyped
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            btnAgregarPDetalle.setEnabled(true);
        }
    }//GEN-LAST:event_txtCantProductoKeyTyped

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        try {
            if (comprobacionDatos()) {
                JOptionPane.showMessageDialog(this, "Ingrese Todos los datos");
            } else {

                PedidoC obj = new PedidoC();
                obj.setIdPedido(Integer.parseInt(txtCodPedido.getText()));
                obj.setIdCliente(Integer.parseInt(txtidCliente.getText()));
                obj.setFormaPago(cbxFormaPago.getSelectedItem().toString());
                obj.setEstado(cbxEstado.getSelectedIndex());
                obj.setIdEmpleado(cbEmpleado.getSelectedItem().toString());
                obj.setFechaEntrega(txtFechaPedido.getText());
                if (jdcFentrega.getDate() == null) {
                    obj.setFechaPedido(null);
                } else {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
                    obj.setFechaPedido(sdf.format(jdcFentrega.getDate()).toString());
                }

                obj.setDtm(dtm);

                JOptionPane.showMessageDialog(this, obj.registrarPedido());
                dtm.setNumRows(0);
                fechaActual();
                codigoPedido();
                limpiarInfo();

            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.toString());
        }

    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnBuscarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarPedidoActionPerformed
        txtCodPedido.setEnabled(true);
        try {
            PedidoC obj = new PedidoC();
            
            CachedRowSet crs = obj.buscarPedido(Integer.parseInt(txtCodPedido.getText()));
            crs.next();
            txtidCliente.setText(String.valueOf(crs.getInt(3)));
            txtFechaPedido.setText(crs.getString(5));
            cbEmpleado.setSelectedItem(crs.getString(2));
            
        } catch (Exception ex) {
            Logger.getLogger(JDPedidos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btnBuscarPedidoActionPerformed

    private void btnBuscarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarClienteActionPerformed
        jdBuscar obj = new jdBuscar(null,true);
        
        obj.setVisible(true);
        obj.setLocationRelativeTo(null);
        
    }//GEN-LAST:event_btnBuscarClienteActionPerformed

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
            java.util.logging.Logger.getLogger(JDPedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDPedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDPedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDPedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDPedidos dialog = new JDPedidos(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnAgregarPDetalle;
    private javax.swing.JButton btnBuscarCliente;
    private javax.swing.JButton btnBuscarPedido;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnQuitarProducto;
    private javax.swing.JComboBox<String> cbEmpleado;
    private javax.swing.JComboBox<String> cbxEstado;
    private javax.swing.JComboBox<String> cbxFormaPago;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelProducto;
    private javax.swing.JPanel jPanelinfCliente;
    private javax.swing.JPanel jPanelinfPedido;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTableProd;
    private com.toedter.calendar.JDateChooser jdcFentrega;
    private javax.swing.JLabel lblStock;
    private javax.swing.JSpinner spDctoProducto;
    private javax.swing.JTextField txtCantProducto;
    private javax.swing.JTextField txtCodPedido;
    private javax.swing.JTextField txtDirCliente;
    private javax.swing.JTextField txtFechaPedido;
    private javax.swing.JTextField txtIva;
    private javax.swing.JTextField txtNomCliente;
    private javax.swing.JTextField txtNomProducto;
    private javax.swing.JTextField txtSubtotal;
    private javax.swing.JTextField txtTelCliente;
    private javax.swing.JTextField txtTotal;
    private javax.swing.JTextField txtTotalDescuento;
    private javax.swing.JTextField txtValorLetras;
    private javax.swing.JTextField txtValorProducto;
    private javax.swing.JTextField txtidCliente;
    private javax.swing.JTextField txtidProducto;
    // End of variables declaration//GEN-END:variables
}
