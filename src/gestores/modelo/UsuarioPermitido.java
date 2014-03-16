package gestores.modelo;

import java.util.List;

/**
 * @author Harry Bravo.
 */
public class UsuarioPermitido {

	private Usuario usuario;
	private Idea idea;
	private Integer puntaje;
	private List<DiscucionIdea> listaDiscucionIdea;

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Idea getIdea() {
		return idea;
	}

	public void setIdea(Idea idea) {
		this.idea = idea;
	}

	public Integer getPuntaje() {
		return puntaje;
	}

	public void setPuntaje(Integer puntaje) {
		this.puntaje = puntaje;
	}

	public List<DiscucionIdea> getListaDiscucionIdea() {
		return listaDiscucionIdea;
	}

	public void setListaDiscucionIdea(List<DiscucionIdea> listaDiscucionIdea) {
		this.listaDiscucionIdea = listaDiscucionIdea;
	}
}