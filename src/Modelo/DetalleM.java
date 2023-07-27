package Modelo;

import Vista.JDPedidos;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

public class DetalleM {
    private int idPedido;
    private int idProducto;
    private int cantidad;
    private int valUnitario;
    private int valDescuento;

    public DetalleM() {
    }

    public DetalleM(int idPedido, int idProducto, int cantidad, int valUnitario, int valDescuento) {
        this.idPedido = idPedido;
        this.idProducto = idProducto;
        this.cantidad = cantidad;
        this.valUnitario = valUnitario;
        this.valDescuento = valDescuento;
    }

    public int getValDescuento() {
        return valDescuento;
    }

    public void setValDescuento(int valDescuento) {
        this.valDescuento = valDescuento;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getValUnitario() {
        return valUnitario;
    }

    public void setValUnitario(int valUnitario) {
        this.valUnitario = valUnitario;
    }
    
    
}
