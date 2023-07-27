/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import com.sun.rowset.CachedRowSetImpl;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.sql.rowset.CachedRowSet;

/**
 *
 * @author Andres
 */
public class PagosM {
    private int idPago;
    private int docCliente;
    private int idPedido;
    private int valorPagado;
    private String lugarPago;
    private String fecha;
    private String comprobante;
    
    public PagosM() {
    }

    public PagosM(int idPago, int docCliente, int idPedido, int valorPagado, String lugarPago, String fecha, String comprobante) {
        this.idPago = idPago;
        this.docCliente = docCliente;
        this.idPedido = idPedido;
        this.valorPagado = valorPagado;
        this.lugarPago = lugarPago;
        this.fecha = fecha;
        this.comprobante = comprobante;
    }

    public int getIdPago() {
        return idPago;
    }

    public void setIdPago(int idPago) {
        this.idPago = idPago;
    }

    public int getDocCliente() {
        return docCliente;
    }

    public void setDocCliente(int docCliente) {
        this.docCliente = docCliente;
    }
    
    public String getComprobante() {
        return comprobante;
    }

    public void setComprobante(String comprobante) {
        this.comprobante = comprobante;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public int getValorPagado() {
        return valorPagado;
    }

    public void setValorPagado(int valorPagado) {
        this.valorPagado = valorPagado;
    }

    public String getLugarPago() {
        return lugarPago;
    }

    public void setLugarPago(String lugarPago) {
        this.lugarPago = lugarPago;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    public CachedRowSet buscarInfo(int idp) throws Exception{
        PreparedStatement pst;
        pst = Conexion.open().prepareCall("Call spBuscarInfoP(?)");
        pst.setInt(1, idp);
        ResultSet rs = pst.executeQuery();
        CachedRowSet crs = new CachedRowSetImpl();
        crs.populate(rs);
        Conexion.open().close();
        return crs;
    }
    
    public CachedRowSet buscarInfDetalle(int idc) throws Exception{
        PreparedStatement pst;
        pst = Conexion.open().prepareCall("Call spBuscarDetallesP(?)");
        pst.setInt(1, idc);
        ResultSet rs = pst.executeQuery();
        CachedRowSet crs = new CachedRowSetImpl();
        crs.populate(rs);
        Conexion.open().close();
        return crs;
    }
    
    public String guardarPago() throws Exception{
        PreparedStatement pst;
        pst = Conexion.open().prepareCall("Call spGuardarPago(?,?,?,?,?)");
        pst.setInt(1, idPedido);
        pst.setInt(2, valorPagado );
        pst.setString(3, lugarPago);
        pst.setString(4, fecha);
        pst.setString(5, comprobante);
        ResultSet rs = pst.executeQuery();
        rs.next();
        String m = rs.getString(1);
        Conexion.open().close();
        return m;
    }
    
    public CachedRowSet poblarLugar() throws Exception{
        PreparedStatement pst;
        pst = Conexion.open().prepareCall("Call spSedes");
        
        ResultSet rs = pst.executeQuery();
        CachedRowSet crs = new CachedRowSetImpl();
        crs.populate(rs);
        Conexion.open().close();
        return crs;
    }
    
    public int traerCodP() throws Exception{
        PreparedStatement pst;
        pst = Conexion.open().prepareCall("{call spTraerCodP()}");
        ResultSet rs = pst.executeQuery();
        rs.next();
        int cod = rs.getInt(1);
        Conexion.open().close();
        return cod;
    }
    
    public CachedRowSet buscarPago() throws Exception{
        PreparedStatement pst;
        pst = Conexion.open().prepareCall("{call spBuscarInfoPago(?)}");
        pst.setInt(1, idPedido);
        ResultSet rs = pst.executeQuery();

        CachedRowSet crs = new CachedRowSetImpl();
        crs.populate(rs);

        Conexion.open().close();
        return crs;
    }
    
    public CachedRowSet buscarPag() throws Exception{
        PreparedStatement pst;
        pst = Conexion.open().prepareCall("{call spBuscarPed(?)}");
        pst.setInt(1, idPedido);
        ResultSet rs = pst.executeQuery();

        CachedRowSet crs = new CachedRowSetImpl();
        crs.populate(rs);

        Conexion.open().close();
        return crs;
    }
    
    public CachedRowSet buscardetallePago() throws Exception{
        PreparedStatement pst;
        pst = Conexion.open().prepareCall("{call spDetallePagos(?)}");
        pst.setInt(1, idPedido);
        ResultSet rs = pst.executeQuery();

        CachedRowSet crs = new CachedRowSetImpl();
        crs.populate(rs);

        Conexion.open().close();
        return crs;
    }
    
    public String RegPago() throws Exception{
        PreparedStatement pst;
        pst = Conexion.open().prepareCall("{call spRegPago(?,?,?,?,?,?,?)}");
        pst.setInt(1, idPago);
        pst.setInt(2, idPedido);
        pst.setInt(3, docCliente);
        pst.setDouble(4, valorPagado);
        pst.setString(5, lugarPago);
        pst.setString(6, fecha);
        pst.setString(7, comprobante);
        
        ResultSet rs = pst.executeQuery();
        rs.next();
        String rta = rs.getString(1);
        Conexion.open().close();
        return rta;
    }
    
    public CachedRowSet buscarPago2() throws Exception{
        PreparedStatement pst;
        pst = Conexion.open().prepareCall("{call spBuscarInfoPg(?)}");
        pst.setInt(1, idPago);
        ResultSet rs = pst.executeQuery();

        CachedRowSet crs = new CachedRowSetImpl();
        crs.populate(rs);

        Conexion.open().close();
        return crs;
    }
    
    public CachedRowSet buscarPago3() throws Exception{
        PreparedStatement pst;
        pst = Conexion.open().prepareCall("{call spBuscarInfoPf(?)}");
        pst.setString(1, fecha);
        ResultSet rs = pst.executeQuery();

        CachedRowSet crs = new CachedRowSetImpl();
        crs.populate(rs);

        Conexion.open().close();
        return crs;
    }
    
    public String ModPago() throws Exception{
        PreparedStatement pst;
        pst = Conexion.open().prepareCall("{call spModPago(?,?,?,?,?,?)}");
        pst.setInt(1, idPedido);
        pst.setInt(2, docCliente);
        pst.setDouble(3, valorPagado);
        pst.setString(4, lugarPago);
        pst.setString(5, fecha);
        pst.setString(6, comprobante);
        
        ResultSet rs = pst.executeQuery();
        rs.next();
        String rta = rs.getString(1);
        Conexion.open().close();
        return rta;
    }
    
}
