package Modelo;

import com.sun.rowset.CachedRowSetImpl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.sql.rowset.CachedRowSet;
import javax.swing.table.DefaultTableModel;

public class PedidoM {

    private int idPedido;
    private String idEmpleado;
    private int idCliente;
    private String fechaPedido;
    private String fechaEntrega;
    private String formaPago;
    private int estado;
    private DefaultTableModel dtm;

    public PedidoM() {
    }

    public PedidoM(int idPedido, String idEmpleado, int idCliente, String fechaPedido, String fechaEntrega, String formaPago, int estado) {
        this.idPedido = idPedido;
        this.idEmpleado = idEmpleado;
        this.idCliente = idCliente;
        this.fechaPedido = fechaPedido;
        this.fechaEntrega = fechaEntrega;
        this.formaPago = formaPago;
        this.estado = estado;
    }

    public int isEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public String getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(String idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(String fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public String getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(String fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public String getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }

    public DefaultTableModel getDtf() {
        return dtm;
    }

    public void setDtf(DefaultTableModel dtm) {
        this.dtm = dtm;
    }

    public int obtenerCodigo() throws Exception {
        PreparedStatement pst;
        pst = Conexion.open().prepareCall("CALL spMaxCodigo");
        ResultSet rs = pst.executeQuery();
        rs.next();
        int cod = rs.getInt(1);
        Conexion.open().close();
        return cod;
    }

    public String registrarPedido() throws Exception {
        
        PreparedStatement pst;
        Connection con;
        con = Conexion.open();
        pst = con.prepareCall("CAll spRegistrarPedido (?,?,?,?,?,?,?)");
        pst.setInt(1, idPedido);
        pst.setString(2, idEmpleado);
        pst.setInt(3, idCliente);
        pst.setString(4, fechaPedido);
        pst.setString(5, fechaEntrega);
        pst.setString(6, formaPago);
        pst.setInt(7, estado);
        
        con.setAutoCommit(false);
        
        ResultSet rs = pst.executeQuery();
        rs.next();
        String m = rs.getString(1);
        
        pst = null;
        if (m.equals("Pedido registrado")) {
            pst = con.prepareCall("call spRegistrarDetalle(?,?,?,?,?)");
            int filas = dtm.getRowCount();
            
            for (int i = 0; i < filas; i++) {
                pst.setInt(1, idPedido);
                pst.setInt(2,Integer.parseInt(dtm.getValueAt(i, 0).toString()));
                pst.setInt(3,Integer.parseInt(dtm.getValueAt(i, 3).toString()));
                pst.setInt(4,Integer.parseInt(dtm.getValueAt(i, 2).toString()));
                pst.setDouble(5,Double.parseDouble(dtm.getValueAt(i, 4).toString()));
                pst.addBatch();
            }
            if (pst.executeBatch().length > 0) {
                con.commit();
                m = "Registro Exitoso";
            } else {
                m= "NO se Registro la lista de productos";
            }
            
        } else {
            m="No se Registro pedido";
        }

        Conexion.open().close();
        return m;
    }
    
    public CachedRowSet buscarPedido(int cod) throws Exception{
        PreparedStatement pst;
        pst = Conexion.open().prepareCall("Call spBuscarPedido(?)");
        pst.setInt(1,cod);
        ResultSet rs = pst.executeQuery();
        CachedRowSet crs = new CachedRowSetImpl();
        crs.populate(rs);
        Conexion.open().close();
        return crs;
    }

}
