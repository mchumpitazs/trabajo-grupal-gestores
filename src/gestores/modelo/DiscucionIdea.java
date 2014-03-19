package gestores.modelo;

public class DiscucionIdea {

	private Integer codigo;
	private UsuarioPermitido usuarioPermitido;
	private String comentario;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public UsuarioPermitido getUsuarioPermitido() {
		return usuarioPermitido;
	}

	public void setUsuarioPermitido(UsuarioPermitido usuarioPermitido) {
		this.usuarioPermitido = usuarioPermitido;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
}