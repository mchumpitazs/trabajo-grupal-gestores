/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gestores.modelo;

/**
 *
 * @author Lino Espinoza
 */
public class Tarifa {
    
    private int idTarifa;
    private String descripcion;
    private double precio;

    public int getIdTarifa() {
        return idTarifa;
    }

    public void setIdTarifa(int idTarifa) {
        this.idTarifa = idTarifa;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
}
