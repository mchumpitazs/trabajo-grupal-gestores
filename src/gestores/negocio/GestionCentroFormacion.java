package gestores.negocio;

import gestores.dao.CentroFormacionDAO;
import gestores.exception.DAOExcepcion;
import gestores.modelo.CentroFormacion;

import java.util.List;

/**
 * @author Harry Bravo.
 */
public class GestionCentroFormacion {

	public List<CentroFormacion> listar(CentroFormacion centroFormacion)
			throws DAOExcepcion {
		CentroFormacionDAO dao = new CentroFormacionDAO();
		return dao.listar(centroFormacion);
	}

	public CentroFormacion insertar(CentroFormacion centroFormacion)
			throws DAOExcepcion {
		CentroFormacionDAO dao = new CentroFormacionDAO();
		return dao.insertar(centroFormacion);
	}

	public CentroFormacion obtener(String idCentroFormacion)
			throws DAOExcepcion {
		CentroFormacionDAO dao = new CentroFormacionDAO();
		return dao.obtener(idCentroFormacion);
	}

	public void eliminar(String idCentroFormacion) throws DAOExcepcion {
		CentroFormacionDAO dao = new CentroFormacionDAO();
		dao.eliminar(idCentroFormacion);
	}

	public CentroFormacion actualizar(CentroFormacion centroFormacion)
			throws DAOExcepcion {
		CentroFormacionDAO dao = new CentroFormacionDAO();
		return dao.actualizar(centroFormacion);
	}
}