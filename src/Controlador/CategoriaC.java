package Controlador;

import Modelo.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class CategoriaC {
    private int idCategoria;
    private String nombre;
    private String descripcion;

    public CategoriaC() {
    }

    public CategoriaC(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public ArrayList<String> buscarCategoria() throws Exception{
        CategoriaM objcategoriaM = new CategoriaM();
        
        return objcategoriaM.buscarCategoria();
    }
}
