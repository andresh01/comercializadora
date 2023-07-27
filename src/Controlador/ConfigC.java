package Controlador;

import Modelo.ConfigM;
import java.util.List;
import javax.sql.rowset.CachedRowSet;

public class ConfigC {
    private int codigo;//Revisar si se necesita
    private String nombre;
    private String descripcion;

    public ConfigC() {
    }

    public ConfigC(String nombre, String descripcion) {
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
        ConfigM obj = new ConfigM();
        return (obj.obtenerCodigoCat()+1); //se le suma uno para mostrar el codigo disponible para almacenar
    }
    
    public int obtenerCodigoTipo() throws Exception{
        ConfigM obj = new ConfigM();
        return (obj.obtenerCodigoTipo()+1); //se le suma uno para mostrar el codigo disponible para almacenar
    }
    
    public void obtenerCodigoCargo() throws Exception{
        ConfigM obj = new ConfigM();
        obj.obtenerCodigoCargo();
        codigo = (obj.getCodigo()+1); //se le suma uno para mostrar el codigo disponible para almacenar
    }
    
    public String guardarCategotria() throws Exception{
        ConfigM obj = new ConfigM(nombre, descripcion);
        return obj.guardarCategotria();
    }
    
    public String guardarTdocumento() throws Exception{
        ConfigM obj = new ConfigM(nombre, descripcion);
        return obj.guardarTdocumento();
    }
    
    public String guardarCargo() throws Exception{
        ConfigM obj = new ConfigM(nombre, descripcion);
        return obj.guardarCargo();
    }
    
    public CachedRowSet buscarCategria(String nom) throws Exception{
        ConfigM obj = new ConfigM();
        return obj.buscarCategoria(nom);
    }
    
    public CachedRowSet buscarTipo(String nom) throws Exception{
        ConfigM obj = new ConfigM();
        return obj.buscarTipo(nom);
    }
    
    public CachedRowSet buscarCargo(String nom) throws Exception{
        ConfigM obj = new ConfigM();
        return obj.buscarCargo(nom);
    }
    
    public String modificarCategotria(int cod) throws Exception{
        ConfigM obj = new ConfigM(nombre, descripcion);
        return obj.modificarCategotria(cod);
    }
    
    public String modificarTdocumento(int cod) throws Exception{
        ConfigM obj = new ConfigM(nombre, descripcion);
        return obj.modificarTdocumento(cod);
    }
    
    public String modificarCargo(int cod) throws Exception{
        ConfigM obj = new ConfigM(nombre, descripcion);
        return obj.modificarCargo(cod);
    }
    
    public List<String> poblarCargo() throws Exception{
        
        ConfigM cm = new ConfigM(nombre, descripcion); 
        return cm.poblarCargo();
    }
}
