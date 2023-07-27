package Controlador;

import Modelo.*;
import com.sun.rowset.CachedRowSetImpl;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.sql.rowset.CachedRowSet;

public class EmpleadoC {
    private int idEmpleado;
    private String tipo;
    private String cargo;
    private String nombre;
    private String apellido;
    private String genero;
    private String fechaNac;
    private boolean estado;

    public EmpleadoC() {
    }

    public EmpleadoC(int idEmpleado, String idTipo, String idCargo, String nombre, String apellido, String genero, String fechaNac, boolean estado) {
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

    public String getIdCargo() {
        return cargo;
    }

    public void setIdCargo(String idCargo) {
        this.cargo = idCargo;
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
        EmpleadoM obj = new EmpleadoM();
        return obj.poblarEmpleado();
    }
    
    public CachedRowSet poblarId() throws Exception{
        EmpleadoM obj = new EmpleadoM();
        return obj.poblarId();
    }
    
    public CachedRowSet poblarCargos() throws Exception{
        EmpleadoM obj = new EmpleadoM();
        return obj.poblarCargos();
    }
    
    public String registrarEmpleado() throws Exception {
        EmpleadoM obj = new EmpleadoM(idEmpleado, tipo, cargo, nombre, apellido, genero, fechaNac, estado);
        return obj.registrarEmpleado();
    }

    
    public CachedRowSet buscarEmpleado(int id) throws Exception{
        EmpleadoM obj = new EmpleadoM(); 
        return obj.buscarEmpleado(id);
    }
    
    public String modificarEmpleado() throws Exception {
        EmpleadoM obj = new EmpleadoM(idEmpleado, tipo, cargo, nombre, apellido, genero, fechaNac, estado);
        return obj.modificarEmpleado();
    }
}
