/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gestores.modelo;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Lino Espinoza
 */
public class Factura {
    
    private int idFactura;
    private double subTotal;
    private Date fechaFacturacion;
    private CentroFormacion centroFormacion;
    private ArrayList<Tarifa> tarifas;

    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    public CentroFormacion getCentroFormacion() {
        return centroFormacion;
    }

    public void setCentroFormacion(CentroFormacion centroFormacion) {
        this.centroFormacion = centroFormacion;
    }

    public ArrayList<Tarifa> getTarifas() {
        return tarifas;
    }

    public void setTarifas(ArrayList<Tarifa> tarifas) {
        this.tarifas = tarifas;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public Date getFechaFacturacion() {
        return fechaFacturacion;
    }

    public void setFechaFacturacion(Date fechaFacturacion) {
        this.fechaFacturacion = fechaFacturacion;
    }
    
    
}
