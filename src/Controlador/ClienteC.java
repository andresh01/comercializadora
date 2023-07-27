package Controlador;

import Modelo.*;
import com.sun.rowset.CachedRowSetImpl;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.sql.rowset.CachedRowSet;

public class ClienteC {
    private int idDoc;
    private String tipo;
    private String nombre;
    private String apellido;
    private int telefono;
    private String email;
    private String direccion;
    private boolean estado;

    public ClienteC() {
    }

    public ClienteC(int idDoc, String tipo, String nombre, String apellido, int telefono, String email, String direccion, boolean estado) {
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
        ClienteM obj = new ClienteM();
        obj.setIdDoc(idDoc);
        return obj.buscarClienteActivo();
    }
    
    public String registrarCliente() throws Exception {
        ClienteM obj = new ClienteM(idDoc, tipo, nombre, apellido, telefono, email, direccion, estado);
        return obj.registrarCliente();
    }

    
    public CachedRowSet buscarCliente(int id) throws Exception{
        ClienteM obj = new ClienteM(); 
        return obj.buscarCliente(id);
    }
    
    public String modificarCliente() throws Exception {
        ClienteM obj = new ClienteM(idDoc, tipo, nombre, apellido, telefono, email, direccion, estado);
        return obj.modificarCliente();
    }
    
    public CachedRowSet buscarTodosClientes() throws Exception{
        ClienteM obj = new ClienteM();
        return obj.buscarTodosClientes();
    }
}
