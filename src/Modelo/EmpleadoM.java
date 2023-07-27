package Modelo;

import com.sun.rowset.CachedRowSetImpl;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.sql.rowset.CachedRowSet;

public class EmpleadoM {
    private int idEmpleado;
    private String tipo;
    private String cargo;
    private String nombre;
    private String apellido;
    private String genero;
    private String fechaNac;
    private boolean estado;

    public EmpleadoM() {
    }

    public EmpleadoM(int idEmpleado, String idTipo, String idCargo, String nombre, String apellido, String genero, String fechaNac, boolean estado) {
        this.idEmpleado = idEmpleado;
        this.tipo = idTipo;
        this.cargo = idCargo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.genero = genero;
        this.fechaNac = fechaNac;
        this.estado = estado;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
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

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(String fechaNac) {
        this.fechaNac = fechaNac;
    }
    
    public CachedRowSet poblarEmpleado() throws Exception{
        PreparedStatement pst;
        pst = Conexion.open().prepareCall("call spEmpleados");
        ResultSet rs = pst.executeQuery();
        CachedRowSet crs = new CachedRowSetImpl();
        crs.populate(rs);
        Conexion.open().close();
        return crs;
    }
    
    public CachedRowSet poblarId() throws Exception{
        PreparedStatement pst;
        pst = Conexion.open().prepareCall("call spIdentificacion");
        ResultSet rs = pst.executeQuery();
        CachedRowSet crs = new CachedRowSetImpl();
        crs.populate(rs);
        Conexion.open().close();
        return crs;
    }
    
    public CachedRowSet poblarCargos() throws Exception{
        PreparedStatement pst;
        pst = Conexion.open().prepareCall("call spCargo");
        ResultSet rs = pst.executeQuery();
        CachedRowSet crs = new CachedRowSetImpl();
        crs.populate(rs);
        Conexion.open().close();
        return crs;
    }
    
    public String registrarEmpleado() throws Exception {
        PreparedStatement pst;
        pst = Conexion.open().prepareCall("CALL spRegistrarEmpleado(?,?,?,?,?,?,?,?)");
        pst.setInt(1, idEmpleado);
        pst.setString(2, tipo);
        pst.setString(3, cargo);
        pst.setString(4, nombre );
        pst.setString(5, apellido);
        pst.setString(6, genero );
        pst.setString(7, fechaNac );
        pst.setBoolean(8, estado);
        ResultSet rs = pst.executeQuery();
        rs.next();
        String msj = rs.getString(1);
        Conexion.open().close();
        return msj;
    }
    
    public CachedRowSet buscarEmpleado(int id) throws Exception {
        PreparedStatement pst;
        pst = Conexion.open().prepareCall("CALL spBuscarEmpleado(?)");
        pst.setInt(1, id);
        ResultSet rs = pst.executeQuery();
        CachedRowSet crs = new CachedRowSetImpl();
        crs.populate(rs);
        Conexion.open().close();
        return crs;
    }

    public String modificarEmpleado() throws Exception {
        PreparedStatement pst;
        pst = Conexion.open().prepareCall("CALL spModificarEmpleado(?,?,?,?,?,?,?,?)");
         pst.setInt(1, idEmpleado);
        pst.setString(2, tipo);
        pst.setString(3, cargo);
        pst.setString(4, nombre );
        pst.setString(5, apellido);
        pst.setString(6, genero );
        pst.setString(7, fechaNac );
        pst.setBoolean(8, estado);
        ResultSet rs = pst.executeQuery();
        rs.next();
        String msj = rs.getString(1);
        Conexion.open().close();
        return msj;
    }

}
