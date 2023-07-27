package Modelo;

import com.sun.rowset.CachedRowSetImpl;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.sql.rowset.CachedRowSet;

public class ConfigM {
    private int codigo;//Revisar si de verdad se necesita
    private String nombre;
    private String descripcion;

    public ConfigM() {
    }

    public ConfigM(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public int obtenerCodigoCat() throws Exception{
        PreparedStatement pst;
        pst = Conexion.open().prepareCall("CALL spObtCodCat");
        ResultSet rs = pst.executeQuery();
        rs.next();
        int cod = rs.getInt(1);
        Conexion.open().close();
        return cod;
    }
    
    public int obtenerCodigoTipo() throws Exception{
        PreparedStatement pst;
        pst = Conexion.open().prepareCall("CALL spObtCodTipo");
        ResultSet rs = pst.executeQuery();
        rs.next();
        int cod = rs.getInt(1);
        Conexion.open().close();
        return cod;
    }
    
    public void obtenerCodigoCargo() throws Exception{
        PreparedStatement pst;
        pst = Conexion.open().prepareCall("CALL spObtCodCargo");
        ResultSet rs = pst.executeQuery();
        rs.next();
        codigo = rs.getInt(1);
        Conexion.open().close();
    }
    
    public String guardarCategotria() throws Exception{
        PreparedStatement pst;
        pst = Conexion.open().prepareCall("{CALL spGuardarCategoria (?,?)}");
        pst.setString(1, nombre);
        pst.setString(2, descripcion);
        ResultSet rs = pst.executeQuery();
        rs.next();
        String msj = rs.getString(1);
        Conexion.open().close();
        return msj;
    }
    
    public String guardarTdocumento() throws Exception{
        PreparedStatement pst;
        pst = Conexion.open().prepareCall("{CALL spGuardarTdocumento (?,?)}");
        pst.setString(1, nombre);
        pst.setString(2, descripcion);
        ResultSet rs = pst.executeQuery();
        rs.next();
        String msj = rs.getString(1);
        Conexion.open().close();
        return msj;
    }
    
    public String guardarCargo() throws Exception{
        PreparedStatement pst;
        pst = Conexion.open().prepareCall("{CALL spGuardarCargos (?,?)}");
        pst.setString(1, nombre);
        pst.setString(2, descripcion);
        ResultSet rs = pst.executeQuery();
        rs.next();
        String msj = rs.getString(1);
        Conexion.open().close();
        return msj;
    }
    
    public CachedRowSet buscarCategoria(String nom) throws Exception{
        PreparedStatement pst;
        pst = Conexion.open().prepareCall("{CALL spConsultarCat (?)}");
        pst.setString(1, nom);
        ResultSet rs = pst.executeQuery();
        CachedRowSet crs = new CachedRowSetImpl();
        crs.populate(rs);
        Conexion.open().close();
        return crs;
    }
    
    public CachedRowSet buscarTipo(String nom) throws Exception{
        PreparedStatement pst;
        pst = Conexion.open().prepareCall("{CALL spConsultarTipo (?)}");
        pst.setString(1, nom);
        ResultSet rs = pst.executeQuery();
        CachedRowSet crs = new CachedRowSetImpl();
        crs.populate(rs);
        Conexion.open().close();
        return crs;
    }
    
    public CachedRowSet buscarCargo(String nom) throws Exception{
        PreparedStatement pst;
        pst = Conexion.open().prepareCall("{CALL spConsultarCargo (?)}");
        pst.setString(1, nom);
        ResultSet rs = pst.executeQuery();
        CachedRowSet crs = new CachedRowSetImpl();
        crs.populate(rs);
        Conexion.open().close();
        return crs;
    }
    
    public String modificarCategotria(int cod) throws Exception{
        PreparedStatement pst;
        pst = Conexion.open().prepareCall("{CALL spModificarCat (?,?,?)}");
        pst.setInt(1, cod);
        pst.setString(2, nombre);
        pst.setString(3, descripcion);
        ResultSet rs = pst.executeQuery();
        rs.next();
        String msj = rs.getString(1);
        Conexion.open().close();
        return msj;
    }
    
    public String modificarTdocumento(int cod) throws Exception{
        PreparedStatement pst;
        pst = Conexion.open().prepareCall("{CALL spModificarTipo (?,?)}");
        pst.setInt(1, cod);
        pst.setString(2, nombre);
        pst.setString(3, descripcion);
        ResultSet rs = pst.executeQuery();
        rs.next();
        String msj = rs.getString(1);
        Conexion.open().close();
        return msj;
    }
    
    public String modificarCargo(int cod) throws Exception{
        PreparedStatement pst;
        pst = Conexion.open().prepareCall("{CALL spModificarCargo (?,?,?)}");
        pst.setInt(1, cod);
        pst.setString(2, nombre);
        pst.setString(3, descripcion);
        ResultSet rs = pst.executeQuery();
        rs.next();
        String msj = rs.getString(1);
        Conexion.open().close();
        return msj;
    }
    
    public List<String> poblarCargo() throws Exception{
        
        PreparedStatement pst = Conexion.open().prepareCall("{call spTraerCargo()}");
        ResultSet rs = pst.executeQuery();
        List<String> lista = new ArrayList();
        
        while(rs.next()){
            lista.add(rs.getString("Nombre"));
        }
        
        return lista; 
    }
    
}
