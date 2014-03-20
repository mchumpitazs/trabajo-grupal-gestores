
package gestores.negocio;

import gestores.dao.IdeaDAO;
import gestores.exception.DAOExcepcion;
import gestores.modelo.Idea;
import gestores.modelo.Usuario;

import java.util.Date;
import java.util.List;

/**
 * @author Marco Chumpitaz.
 */
public class GestionIdea {
	
	public List<Idea> listaIdeasporCF(Usuario evaluador, Idea ideab, Date fecha_ini, Date fecha_fin) 
			throws DAOExcepcion {
		IdeaDAO dao = new IdeaDAO();
		return dao.listaIdeasporCF(evaluador, ideab, fecha_ini, fecha_fin);
	}

}
