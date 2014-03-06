/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gestores;

import java.util.ArrayList;

/**
 *
 * @author Lino Espinoza
 */
public class Usuario {
    
    private int idUsuario;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String sexo;
    private String numeroDocumento;
    private String numeroCelular;
    private String email;
    
    // Un usuario puede tener una o muchas ideas
    private ArrayList<Idea> ideas;
    
    // Un usuario puede tener un tipo de documento
    private TipoDocumento tipoDocumento;
    
    // Un usuario puede tener un tipo de usuario
    private TipoUsuario tipoUsuario;
    
    // Un usuario puede pertenecer a un centro de formacion
    private CentroFormacion centroFormacion;

    // Getters / Setters
    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getNumeroCelular() {
        return numeroCelular;
    }

    public void setNumeroCelular(String numeroCelular) {
        this.numeroCelular = numeroCelular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<Idea> getIdeas() {
        return ideas;
    }

    public void setIdeas(ArrayList<Idea> ideas) {
        this.ideas = ideas;
    }

    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public CentroFormacion getCentroFormacion() {
        return centroFormacion;
    }

    public void setCentroFormacion(CentroFormacion centroFormacion) {
        this.centroFormacion = centroFormacion;
    }
    
}
