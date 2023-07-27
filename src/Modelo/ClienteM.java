package Modelo;

import com.sun.rowset.CachedRowSetImpl;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.sql.rowset.CachedRowSet;

public class ClienteM {
    private int idDoc;
    private String tipo;
    private String nombre;
    private String apellido;
    private int telefono;
    private String email;
    private String direccion;
    private boolean estado;

    public ClienteM() {
    }

    public ClienteM(int idDoc, String tipo, String nombre, String apellido, int telefono, String email, String direccion, boolean estado) {
        this.idDoc = idDoc;
        this.tipo = tipo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.email = email;
        this.direccion = direccion;
        this.estado = estado;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public int getIdDoc() {
        return idDoc;
    }

    public void setIdDoc(int idDoc) {
        this.idDoc = idDoc;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    public CachedRowSet buscarClienteActivo() throws Exception{
        PreparedStatement pst;
        pst = Conexion.open().prepareCall("{CALL spBuscarClienteAct(?)}");
        pst.setInt(1, idDoc);
        ResultSet rs = pst.executeQuery();
        
        CachedRowSet crs = new CachedRowSetImpl();
        crs.populate(rs);
        Conexion.open().close();
        return crs;
    }
    
    public String registrarCliente() throws Exception {
        PreparedStatement pst;
        pst = Conexion.open().prepareCall("CALL spRegistrarCliente(?,?,?,?,?,?,?,?)");
        pst.setInt(1, idDoc);
        pst.setString(2, tipo);
        pst.setString(3, nombre);
        pst.setString(4, apellido );
        pst.setInt(5, telefono);
        pst.setString(6, email );
        pst.setString(7, direccion );
        pst.setBoolean(8, estado);
        ResultSet rs = pst.executeQuery();
        rs.next();
        String msj = rs.getString(1);
        Conexion.open().close();
        return msj;
    }


    public CachedRowSet buscarCliente(int id) throws Exception {
        PreparedStatement pst;
        pst = Conexion.open().prepareCall("CALL spBuscarCliente(?)");
        pst.setInt(1, id);
        ResultSet rs = pst.executeQuery();
        CachedRowSet crs = new CachedRowSetImpl();
        crs.populate(rs);
        Conexion.open().close();
        return crs;
    }

    public String modificarCliente() throws Exception {
        PreparedStatement pst;
        pst = Conexion.open().prepareCall("CALL spModificarCliente(?,?,?,?,?,?,?,?)");
        pst.setInt(1, idDoc);
        pst.setString(2, tipo);
        pst.setString(3, nombre);
        pst.setString(4, apellido );
        pst.setInt(5, telefono);
        pst.setString(6, email );
        pst.setString(7, direccion );
        pst.setBoolean(8, estado);
        ResultSet rs = pst.executeQuery();
        rs.next();
        String msj = rs.getString(1);
        Conexion.open().close();
        return msj;
    }
    
    public CachedRowSet buscarTodosClientes() throws Exception{
        PreparedStatement pst;
        pst = Conexion.open().prepareCall("Call spBuscarTodosClientes");
        ResultSet rs = pst.executeQuery();
        CachedRowSet crs = new CachedRowSetImpl();
        crs.populate(rs);
        Conexion.open().close();
        return crs;
    }
}
