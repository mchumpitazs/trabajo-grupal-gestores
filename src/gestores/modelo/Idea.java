
package gestores.modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Lino Espinoza
 */
public class Idea {
    
	private int idIdea;
    private String titulo;
    private String descripcion;
    private ArrayList<String> palabrasClave;
    private String urlArchivo;
    private String referencia;
    private Date fechaCreacion;
    private Date fechaPublicacion;
    
    // Una idea es asesorada a un usuario (Asesor)
    private Usuario usuarioAsesor;
    
    // Una idea es creada por un usuario (Estudiante)
    private Usuario usuarioEstudiante;
    
    // Una idea puede tener un estado
    private TipoEstadoIdea tipoEstado;
    
    // Una idea puede generar una o muchas reuniones
    private ArrayList<Reunion> reuniones;

	/**
	 * @return the idIdea
	 */
	public int getIdIdea() {
		return idIdea;
	}

	/**
	 * @param idIdea the idIdea to set
	 */
	public void setIdIdea(int idIdea) {
		this.idIdea = idIdea;
	}

	/**
	 * @return the titulo
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * @param titulo the titulo to set
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * @return the palabrasClave
	 */
	public List<String> getPalabrasClave() {
		return palabrasClave;
	}

	/**
	 * @param palabrasClave the palabrasClave to set
	 */
	public void setPalabrasClave(ArrayList<String> palabrasClave) {
		this.palabrasClave = palabrasClave;
	}

	/**
	 * @return the urlArchivo
	 */
	public String getUrlArchivo() {
		return urlArchivo;
	}

	/**
	 * @param urlArchivo the urlArchivo to set
	 */
	public void setUrlArchivo(String urlArchivo) {
		this.urlArchivo = urlArchivo;
	}

	/**
	 * @return the referencia
	 */
	public String getReferencia() {
		return referencia;
	}

	/**
	 * @param referencia the referencia to set
	 */
	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	/**
	 * @return the fechaCreacion
	 */
	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	/**
	 * @param fechaCreacion the fechaCreacion to set
	 */
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	/**
	 * @return the fechaPublicacion
	 */
	public Date getFechaPublicacion() {
		return fechaPublicacion;
	}

	/**
	 * @param fechaPublicacion the fechaPublicacion to set
	 */
	public void setFechaPublicacion(Date fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
	}

	/**
	 * @return the usuarioAsesor
	 */
	public Usuario getUsuarioAsesor() {
		return usuarioAsesor;
	}

	/**
	 * @param usuarioAsesor the usuarioAsesor to set
	 */
	public void setUsuarioAsesor(Usuario usuarioAsesor) {
		this.usuarioAsesor = usuarioAsesor;
	}

	/**
	 * @return the usuarioEstudiante
	 */
	public Usuario getUsuarioEstudiante() {
		return usuarioEstudiante;
	}

	/**
	 * @param usuarioEstudiante the usuarioEstudiante to set
	 */
	public void setUsuarioEstudiante(Usuario usuarioEstudiante) {
		this.usuarioEstudiante = usuarioEstudiante;
	}

	/**
	 * @return the tipoEstado
	 */
	public TipoEstadoIdea getTipoEstado() {
		return tipoEstado;
	}

	/**
	 * @param tipoEstado the tipoEstado to set
	 */
	public void setTipoEstado(TipoEstadoIdea tipoEstado) {
		this.tipoEstado = tipoEstado;
	}

	/**
	 * @return the reuniones
	 */
	public ArrayList<Reunion> getReuniones() {
		return reuniones;
	}

	/**
	 * @param reuniones the reuniones to set
	 */
	public void setReuniones(ArrayList<Reunion> reuniones) {
		this.reuniones = reuniones;
	}

    
}
