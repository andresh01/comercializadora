/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.*;
import javax.sql.rowset.CachedRowSet;

/**
 *
 * @author Andres
 */
public class PagosC {
    private int idPago;
    private int docCliente;
    private int idPedido;
    private int valorPagado;
    private String lugarPago;
    private String fecha;
    private String comprobante;

    public PagosC() {
    }

    public PagosC(int idPago, int docCliente, int idPedido, int valorPagado, String lugarPago, String fecha, String comprobante) {
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
        PagosM obj = new PagosM();
        return obj.buscarInfo(idp);
    }
    
    public CachedRowSet buscarInfDetalle(int idc) throws Exception{
       PagosM obj = new PagosM();
        return obj.buscarInfDetalle(idc);
    }
    
    public String guardarPago() throws Exception{
        PagosM obj = new PagosM(idPago, docCliente, idPedido, valorPagado, lugarPago, fecha, comprobante);
        
        return obj.guardarPago();
    }
    
    public CachedRowSet poblarLugar() throws Exception{
       PagosM obj = new PagosM();
        return obj.poblarLugar();
    }
    
    public int traerCodP() throws Exception{
        PagosM pM = new PagosM();
        //setIdPago(idPago);
        return pM.traerCodP();
    }
    
    public CachedRowSet BuscarPago() throws Exception{
        PagosM pm = new PagosM();
        pm.setIdPedido(idPedido);
        return pm.buscarPago();
    }
    
    public CachedRowSet BuscarPag() throws Exception{
        PagosM pm = new PagosM();
        pm.setIdPedido(idPedido);
        return pm.buscarPag();
    }
    
    public CachedRowSet BuscarDetallePago() throws Exception{
        PagosM pm = new PagosM();
        pm.setIdPedido(idPedido);
        return pm.buscardetallePago();
    }
    
    public String regPago() throws Exception{
        PagosM pm = new PagosM(idPago, docCliente, idPedido, valorPagado, lugarPago, fecha, comprobante);
        return pm.RegPago();
    }
    
    public CachedRowSet BuscarPago2() throws Exception{
        PagosM pm = new PagosM();
        pm.setIdPago(idPago);
        return pm.buscarPago2();
    }
    
    public CachedRowSet BuscarPago3() throws Exception{
        PagosM pm = new PagosM();
        pm.setFecha(fecha);
        return pm.buscarPago3();
    }
    
    public String ModPago() throws Exception{
        PagosM pm = new PagosM(idPago, docCliente, idPedido, valorPagado, lugarPago, fecha, comprobante);
        return pm.ModPago();
    }

}
