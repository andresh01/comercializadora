package Controlador;

import Modelo.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.sql.rowset.CachedRowSet;
import javax.swing.table.DefaultTableModel;

public class PedidoC {
    private int idPedido;
    private String idEmpleado;
    private int idCliente;
    private String fechaPedido;
    private String fechaEntrega;
    private String formaPago;
    private int estado;
    private DefaultTableModel dtm;

    public PedidoC() {
    }

    public PedidoC(int idPedido, String idEmpleado, int idCliente, String fechaPedido, String fechaEntrega, String formaPago, int estado) {
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
    
    public DefaultTableModel getDtm() {
        return dtm;
    }

    public void setDtm(DefaultTableModel dtm) {
        this.dtm = dtm;
    }
    
    public int obtenerCodigo() throws Exception{
        PedidoM obj = new PedidoM();
        return (obj.obtenerCodigo()); //se incrementa en una unidad desde la base de datos
    }
    
    public String registrarPedido() throws Exception{
        PedidoM obj = new PedidoM(idPedido, idEmpleado, idCliente, fechaPedido, fechaEntrega, formaPago, estado);
        obj.setDtf(dtm);
        return obj.registrarPedido();
    }

    public CachedRowSet buscarPedido(int id) throws Exception{
        PedidoM obj = new PedidoM();
        return obj.buscarPedido(id);
    }
    
}
