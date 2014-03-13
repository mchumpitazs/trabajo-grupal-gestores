package gestores.dao;

import gestores.exception.DAOExcepcion;
import gestores.modelo.CentroFormacion;
import gestores.modelo.TipoCentroFormacion;
import gestores.util.ConexionBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Harry Bravo
 */
public class CentroFormacionDAO extends BaseDAO {

	public List<CentroFormacion> buscar(CentroFormacion centroFormacion)
			throws DAOExcepcion {
		String condicion = " and cfo.TipCentroFormacion = ?";
		if (centroFormacion.getTipoCentroFormacion().getIdTipoCentroFormacion()
				.equals("0")) {
			condicion = "";
		}
		String query = "select cfo.idCentroFormacion, cfo.NoCentroFormacion, cfo.TxUrlCentroFormacion, cfo.LogoURLCentroFormacion, tcf.NoTipoCentroFormacion "
				+ "from CENTROFORMACION cfo inner join TIPOCENTROFORMACION tcf "
				+ "on (cfo.TipCentroFormacion = tcf.TipCentroFormacion) "
				+ "where NoCentroFormacion like ?" + condicion;
		List<CentroFormacion> lista = new ArrayList<CentroFormacion>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, "%" + centroFormacion.getNombre() + "%");

			if (centroFormacion.getTipoCentroFormacion()
					.getIdTipoCentroFormacion().equals("0")) {
				stmt.setString(2, centroFormacion.getTipoCentroFormacion()
						.getIdTipoCentroFormacion());
			}

			rs = stmt.executeQuery();
			while (rs.next()) {
				CentroFormacion vo = new CentroFormacion();
				vo.setIdCentroFormacion(rs.getString(1));
				vo.setNombre(rs.getString(2));
				vo.setUrlCentroFormacion(rs.getString(3));
				vo.setUrlLogo(rs.getString(4));

				TipoCentroFormacion tipoCentroFormacion = new TipoCentroFormacion();
				tipoCentroFormacion.setTipoCentroFormacion(rs.getString(5));
				vo.setTipoCentroFormacion(tipoCentroFormacion);
				lista.add(vo);
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarResultSet(rs);
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		System.out.println(lista.size());
		return lista;
	}

	public CentroFormacion insertar(CentroFormacion vo) throws DAOExcepcion {
		String query = "insert into CENTROFORMACION(idCentroFormacion, NoCentroFormacion, TxUrlCentroFormacion, LogoURLCentroFormacion, TipCentroFormacion) "
				+ "values (?,?,?,?,?)";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, vo.getIdCentroFormacion());
			stmt.setString(2, vo.getNombre());
			stmt.setString(3, vo.getUrlCentroFormacion());
			stmt.setString(4, vo.getUrlLogo());
			stmt.setString(5, vo.getTipoCentroFormacion()
					.getIdTipoCentroFormacion());
			int i = stmt.executeUpdate();
			if (i != 1) {
				throw new SQLException("No se pudo insertar");
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarResultSet(rs);
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		return vo;
	}

	public CentroFormacion obtener(String idCentroFormacion)
			throws DAOExcepcion {
		CentroFormacion vo = null;
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			String query = "select idCentroFormacion, NoCentroFormacion, TxUrlCentroFormacion, LogoURLCentroFormacion, TipCentroFormacion "
					+ "from CENTROFORMACION where idCentroFormacion=?";
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, idCentroFormacion);
			rs = stmt.executeQuery();
			if (rs.next()) {
				vo = new CentroFormacion();
				vo.setIdCentroFormacion(rs.getString(1));
				vo.setNombre(rs.getString(2));
				vo.setUrlCentroFormacion(rs.getString(3));
				vo.setUrlLogo(rs.getString(4));

				TipoCentroFormacion tipoCentroFormacion = new TipoCentroFormacion();
				tipoCentroFormacion.setIdTipoCentroFormacion(rs.getString(5));
				vo.setTipoCentroFormacion(tipoCentroFormacion);
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarResultSet(rs);
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		return vo;
	}

	public void eliminar(String idCentroFormacion) throws DAOExcepcion {
		String query = "delete from CENTROFORMACION WHERE idCentroFormacion=?";
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, idCentroFormacion);
			int i = stmt.executeUpdate();
			if (i != 1) {
				throw new SQLException("No se pudo eliminar");
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
	}

	public CentroFormacion actualizar(CentroFormacion vo) throws DAOExcepcion {
		String query = "update CENTROFORMACION set NoCentroFormacion=?, TxUrlCentroFormacion=?, LogoURLCentroFormacion=?, TipCentroFormacion=? where idCentroFormacion=?";
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, vo.getNombre());
			stmt.setString(2, vo.getUrlCentroFormacion());
			stmt.setString(3, vo.getUrlLogo());
			stmt.setString(4, vo.getTipoCentroFormacion()
					.getIdTipoCentroFormacion());
			stmt.setString(5, vo.getIdCentroFormacion());
			int i = stmt.executeUpdate();
			if (i != 1) {
				throw new SQLException("No se pudo actualizar");
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		return vo;
	}

	public List<CentroFormacion> listar() throws DAOExcepcion {
		List<CentroFormacion> lista = new ArrayList<CentroFormacion>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			String query = "select cfo.idCentroFormacion, cfo.NoCentroFormacion, cfo.TxUrlCentroFormacion, cfo.LogoURLCentroFormacion, tcf.NoTipoCentroFormacion "
					+ "from CENTROFORMACION cfo inner join TIPOCENTROFORMACION tcf "
					+ "on (cfo.TipCentroFormacion = tcf.TipCentroFormacion)";
			stmt = con.prepareStatement(query);
			rs = stmt.executeQuery();
			while (rs.next()) {
				CentroFormacion vo = new CentroFormacion();
				vo.setIdCentroFormacion(rs.getString(1));
				vo.setNombre(rs.getString(2));
				vo.setUrlCentroFormacion(rs.getString(3));
				vo.setUrlLogo(rs.getString(4));

				TipoCentroFormacion tipoCentroFormacion = new TipoCentroFormacion();
				tipoCentroFormacion.setTipoCentroFormacion(rs.getString(5));
				vo.setTipoCentroFormacion(tipoCentroFormacion);
				lista.add(vo);
			}

		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarResultSet(rs);
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		return lista;
	}
}