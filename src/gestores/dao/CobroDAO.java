package gestores.dao;

import gestores.enums.TipoCentroFormacion;
import gestores.exception.DAOExcepcion;
import gestores.modelo.CentroFormacion;
import gestores.modelo.PlanTarifario;
import gestores.modelo.ReportePago;
import gestores.util.ConexionBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

/**
 * @author Marco Chumpitaz.
 */

public class CobroDAO extends BaseDAO {

	public Collection<ReportePago> listarCFparaCobro(CentroFormacion centroform, String mes, int anio) throws DAOExcepcion{
		
		Collection<ReportePago> lista = new ArrayList<ReportePago>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
				String condicion = "";
				String query = "SELECT No_Centro_Formacion, Co_Tipo_Centro_Formacion,No_Plan_Tarifario, Fe_Mes_Pago, Fe_Anio_Pago, Ss_Monto_Mensual " 
					+ "FROM centro_formacion cf inner join reporte_pago rp " 
					+ "on (cf.Co_Centro_Formacion = rp.Co_Centro_Formacion) "
					+ "left join plan_tarifario pt "
					+ "on (cf.Co_Plan_Tarifario = pt.Co_Plan_Tarifario)"
					+ "where No_Centro_Formacion like ? " + condicion;
			
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			
			stmt.setString(1, centroform.getNombre().toString());
			
			if (centroform.getTipoCentroFormacion() != null) {
				condicion = "and  Co_Tipo_Centro_Formacion like ? ";
				stmt.setString(2, centroform.getTipoCentroFormacion().getCodigo());
			}
			
			if (mes != null) {
				condicion += "AND Fe_Mes_Pago = ? ";
				stmt.setString(3, mes);
			}
			
			if (anio == 0) {
				condicion += "AND Fe_Anio_Pago = ? ";
				stmt.setInt(4, anio);
			}
			
			
			
			rs = stmt.executeQuery();
			while (rs.next()) {
				registroX = rs.getString(1) + " | " + rs.getString(2) +  " | " + rs.getString(3) +  " | " + rs.getString(4);     
				lista.add (registroX) ;
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
	
public Collection<ReportePago> listar() throws DAOExcepcion{
	
	Collection<ReportePago> c = new ArrayList<ReportePago>();
	Connection con = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;
	try {
		con = ConexionBD.obtenerConexion();
		String query = "SELECT No_Centro_Formacion, Co_Tipo_Centro_Formacion,No_Plan_Tarifario, Fe_Mes_Pago, Fe_Anio_Pago, Ss_Monto_Mensual " 
						+ "FROM centro_formacion cf inner join reporte_pago rp " 
						+ "on (cf.Co_Centro_Formacion = rp.Co_Centro_Formacion) "
						+ "left join plan_tarifario pt "
						+ "on (cf.Co_Plan_Tarifario = pt.Co_Plan_Tarifario)";
						//+ "where No_Centro_Formacion like ?";
		
		stmt = con.prepareStatement(query);
		rs = stmt.executeQuery();
		while (rs.next()) {
						
			ReportePago vo = new ReportePago();
			vo.setMesPago(rs.getString(4));
			vo.setAnioPago(rs.getInt(5));
			vo.setMontoMensual(rs.getBigDecimal(6));
			
			CentroFormacion centrof = new CentroFormacion();
			centrof.setNombre(rs.getString(1));
			centrof.setTipoCentroFormacion(TipoCentroFormacion
					.getTipoCentroFormacion(rs.getString(2)));
			vo.setCentroFormacion(centrof);
			
			PlanTarifario plant = new PlanTarifario();
			plant.setNombre(rs.getString(3));
			vo.setPlanTarifario(plant);
				
			c.add(vo);
		}

	} catch (SQLException e) {
		System.err.println(e.getMessage());
		throw new DAOExcepcion(e.getMessage());
	} finally {
		this.cerrarResultSet(rs);
		this.cerrarStatement(stmt);
		this.cerrarConexion(con);
	}
	return c;
}
}
