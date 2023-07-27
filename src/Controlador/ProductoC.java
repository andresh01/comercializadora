package Controlador;

import Modelo.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.sql.rowset.CachedRowSet;

public class ProductoC {
    private int codigo;
    private String tipoProducto;
    private String nombre;
    private int precio;
    private int stock;
    private String fVencimiento;
    private float pDescuento;
    private boolean estado;

    public ProductoC() {
    }

    public ProductoC(int codigo, String tipoProducto, String nombre, int precio, int stock, String fVencimiento, float pDescuento, boolean estado) {
        this.codigo = codigo;
        this.tipoProducto = tipoProducto;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        this.fVencimiento = fVencimiento;
        this.pDescuento = pDescuento;
        this.estado = estado;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(String tipoProducto) {
        this.tipoProducto = tipoProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getfVencimiento() {
        return fVencimiento;
    }

    public void setfVencimiento(String fVencimiento) {
        this.fVencimiento = fVencimiento;
    }

    public float getpDescuento() {
        return pDescuento;
    }

    public void setpDescuento(float pDescuento) {
        this.pDescuento = pDescuento;
    }
    
    public String registrarProducto() throws Exception{
        ProductoM objP = new ProductoM(codigo, tipoProducto, nombre, precio, stock, fVencimiento, pDescuento, estado);
        return objP.registrarProducto();
    }
    
    public CachedRowSet mostrarProductos() throws Exception{
        ProductoM objP = new ProductoM();
        CachedRowSet crs = objP.mostrarProductos();
        return crs;
    }
    
    public String eliminarProducto(int cod) throws Exception{
        ProductoM obj = new ProductoM();
        return obj.eliminarProducto(cod);
    }
    
    public CachedRowSet buscarProducto(String nom) throws Exception{
        ProductoM objP = new ProductoM();
        CachedRowSet crs = objP.buscarProducto(nom);
        return crs;
    }
    
    public CachedRowSet buscarProducto(int id) throws Exception{
        ProductoM objP = new ProductoM();
        CachedRowSet crs = objP.buscarProducto(id);
        return crs;
    }
    
    public String modificarProducto() throws Exception{
        ProductoM objP = new ProductoM(codigo, tipoProducto, nombre, precio, stock, fVencimiento, pDescuento, estado);
        return objP.modificarProducto();
    }
    
}
