package Modelo;

import com.sun.rowset.CachedRowSetImpl;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.sql.rowset.CachedRowSet;

public class ProductoM {
    private int codigo;
    private String tipoProducto;
    private String nombre;
    private int precio;
    private int stock;
    private String fVencimiento;
    private float pDescuento;
    private boolean estado;

    public ProductoM() {
    }

    public ProductoM(int codigo, String tipoProducto, String nombre, int precio, int stock, String fVencimiento, float pDescuento, boolean estado) {
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
        PreparedStatement pst;
        pst = Conexion.open().prepareCall("{call spRegistrarProducto(?,?,?,?,?,?,?,?)}");
        pst.setInt(1, codigo);
        pst.setString(2, tipoProducto);
        pst.setString(3, nombre);
        pst.setInt(4, precio);
        pst.setInt(5, stock);
        pst.setString(6, fVencimiento);
        pst.setFloat(7, pDescuento);
        pst.setBoolean(8, estado);
        
        ResultSet rs = pst.executeQuery();
        rs.next();
        String msj = rs.getString(1);
        Conexion.open().close();
        return msj;
    }
    
    public CachedRowSet mostrarProductos() throws Exception{
        PreparedStatement pst;
        pst = Conexion.open().prepareCall("call spBuscarTodosProductos");
        ResultSet rs = pst.executeQuery();
        CachedRowSet crs = new CachedRowSetImpl();
        crs.populate(rs);
        Conexion.open().close();
        return crs;
    }
    
    public String eliminarProducto(int cod) throws Exception{
         PreparedStatement pst;
        pst = Conexion.open().prepareCall("call spEliminarProducto (?)");
        pst.setInt(1, cod);
        ResultSet rs = pst.executeQuery();
        rs.next();
        String msj = rs.getString(1);
        Conexion.open().close();
        return msj;
    }
    
    public CachedRowSet buscarProducto(String nom) throws Exception{
        PreparedStatement pst;
        pst = Conexion.open().prepareCall("call spBuscarxNom(?)");
        pst.setString(1, nom);
        ResultSet rs = pst.executeQuery();
        CachedRowSet crs = new CachedRowSetImpl();
        crs.populate(rs);
        Conexion.open().close();
        return crs;
    }

public CachedRowSet buscarProducto(int id) throws Exception{
        PreparedStatement pst;
        pst = Conexion.open().prepareCall("call spBuscarxId(?)");
        pst.setInt(1, id);
        ResultSet rs = pst.executeQuery();
        CachedRowSet crs = new CachedRowSetImpl();
        crs.populate(rs);
        Conexion.open().close();
        return crs;
    }
    
    public String modificarProducto() throws Exception{
        PreparedStatement pst;
        pst = Conexion.open().prepareCall("{CALL spModificarProducto(?,?,?,?,?,?,?,?)}");
        pst.setInt(1, codigo);
        pst.setString(2, tipoProducto);
        pst.setString(3, nombre);
        pst.setInt(4, precio);
        pst.setInt(5, stock);
        pst.setString(6, fVencimiento);
        pst.setFloat(7, pDescuento);
        pst.setBoolean(8, estado);
        
        ResultSet rs = pst.executeQuery();
        rs.next();
        String msj = rs.getString(1);
        Conexion.open().close();
        return msj;
    }
    
    
}
