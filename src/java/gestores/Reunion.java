/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gestores;

import java.util.Date;

/**
 *
 * @author Lino Espinoza
 */
public class Reunion {
    
    private int idReunion;
    private Date fechaReunion;
    private String observacion;
    private String calificacion;
    
    // Una reunión pertenece a una idea
    private Idea idea;

    // Constructor
    
    // Getters / Setters
    
    public int getIdReunion() {
        return idReunion;
    }

    public void setIdReunion(int idReunion) {
        this.idReunion = idReunion;
    }

    public Date getFechaReunion() {
        return fechaReunion;
    }

    public void setFechaReunion(Date fechaReunion) {
        this.fechaReunion = fechaReunion;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(String calificacion) {
        this.calificacion = calificacion;
    }

    public Idea getIdea() {
        return idea;
    }

    public void setIdea(Idea idea) {
        this.idea = idea;
    }
     
}
