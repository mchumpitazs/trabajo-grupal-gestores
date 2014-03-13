package gestores.dao;

import gestores.exception.DAOExcepcion;
import gestores.modelo.CentroFormacion;
import gestores.modelo.Idea;
import gestores.modelo.TipoCentroFormacion;

import gestores.util.ConexionBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class IdeasDAO extends BaseDAO{
	
	public List<Idea> listar() throws DAOExcepcion {
		List<Idea> lista = new ArrayList<Idea>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			con = ConexionBD.obtenerConexion();
			String query = "select * from IDEA";
			//"select cfo.idCentroFormacion, cfo.NoCentroFormacion, cfo.TxUrlCentroFormacion, cfo.LogoURLCentroFormacion, tcf.NoTipoCentroFormacion "
				//	+ "from CENTROFORMACION cfo inner join TIPOCENTROFORMACION tcf "
					//+ "on (cfo.TipCentroFormacion = tcf.TipCentroFormacion)";
			stmt = con.prepareStatement(query);
			rs = stmt.executeQuery();
			while (rs.next()) {
				Idea vo = new Idea();
				vo.setIdIdea(rs.getInt(1));
				
				
				//vo.setIdCentroFormacion(rs.getString(1));
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
