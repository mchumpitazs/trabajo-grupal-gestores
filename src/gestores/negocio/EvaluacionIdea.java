package gestores.negocio;

import gestores.bean.Puntaje;
import gestores.dao.IdeaDAO;
import gestores.exception.DAOExcepcion;
import gestores.modelo.Idea;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Harry Bravo.
 */
public class EvaluacionIdea {

	public List<Idea> listarEvaluacion(Idea idea) throws DAOExcepcion {
		IdeaDAO dao = new IdeaDAO();
		return dao.listarEvaluacion(idea);
	}

	public Idea obtenerEvaluacion(Integer codigo) throws DAOExcepcion {
		IdeaDAO dao = new IdeaDAO();
		return dao.obtenerEvaluacion(codigo);
	}

	public Idea actualizarEstado(Idea idea) throws DAOExcepcion {
		IdeaDAO dao = new IdeaDAO();
		boolean esPublicada = dao.esPublicada(idea.getCodigo());
		boolean esIdeaVotada = dao.esIdeaVotada(idea.getCodigo());

		if (esPublicada && esIdeaVotada) {
			return dao.actualizarEstado(idea);
		} else if (!esPublicada) {
			throw new DAOExcepcion(
					"No puede aprobar o rechazar la idea si no es publicada");
		} else {
			throw new DAOExcepcion(
					"No puede aprobar o rechazar la idea si no fue votada");
		}
	}

	public Idea asignarAsesor(Idea idea) throws DAOExcepcion {
		IdeaDAO dao = new IdeaDAO();
		boolean flagAprobada = dao.esAprobada(idea.getCodigo());
		boolean flagAsesorOtraIdea = dao.esAsesorOtraIdea(idea);

		if (flagAprobada && !flagAsesorOtraIdea) {
			return dao.actualizarAsesor(idea);
		} else if (!flagAprobada) {
			throw new DAOExcepcion(
					"No puede asignar asesor si la idea no está aprobada");
		} else {
			throw new DAOExcepcion(
					"No puede asignar asesor ya que es asesor de otra idea para el mismo estudiante");
		}
	}

	public List<Puntaje> listarResumenPuntaje(Integer codigo)
			throws DAOExcepcion {
		IdeaDAO dao = new IdeaDAO();
		List<Puntaje> listaPuntaje = new ArrayList<Puntaje>();
		List<Puntaje> listaPuntajeAux = dao.listarPuntaje(codigo);

		for (int valorPuntaje = 1; valorPuntaje <= 5; valorPuntaje++) {
			boolean puntajeEncontrado = false;

			for (Puntaje puntajeAux : listaPuntajeAux) {
				if (puntajeAux.getValorPuntaje().equals(valorPuntaje)) {
					listaPuntaje.add(puntajeAux);
					puntajeEncontrado = true;
					break;
				}
			}

			if (!puntajeEncontrado) {
				Puntaje puntajeAux = new Puntaje();
				puntajeAux.setValorPuntaje(valorPuntaje);
				puntajeAux.setCantidadUsuarios(0);
				listaPuntaje.add(puntajeAux);
			}
		}
		return listaPuntaje;
	}
}