package Modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class CategoriaM {
    private int idCategoria;
    private String nombre;
    private String descripcion;

    public CategoriaM() {
    }

    public CategoriaM(String nombre, String descripcion) {
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
        PreparedStatement pst;
        pst = Conexion.open().prepareCall("call spCategoria");
        ResultSet rs = pst.executeQuery();
        ArrayList<String> lista = new ArrayList();
        
        while (rs.next()) {
            lista.add(rs.getString("Nombre"));
        }
        
        return lista;
    }
}
