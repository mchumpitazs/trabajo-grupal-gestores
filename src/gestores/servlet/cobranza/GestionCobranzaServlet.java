package gestores.servlet.cobranza;

import gestores.enums.EstadoIdea;
import gestores.enums.TipoCentroFormacion;
import gestores.modelo.CentroFormacion;
import gestores.modelo.Idea;
import gestores.modelo.PlanTarifario;
import gestores.modelo.ReportePago;
import gestores.modelo.Usuario;
import gestores.negocio.GestionCobro;
import gestores.negocio.GestionEvaluador;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GestionCobranzaServlet
 */
@WebServlet("/GestionCobranzaServlet")
public class GestionCobranzaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GestionCobranzaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy");
		String nombrei = request.getParameter("txtnombre");
		String tipo = request.getParameter("optipo");
		String mes = request.getParameter("opmes");
		String anio = request.getParameter("opanio");
		Date fecha_ini = null;//formatter.parse(desde);
		Date fecha_fin = null;//formatter.parse(hasta);
		
		
		CentroFormacion cf1 = new CentroFormacion();
		cf1.setNombre(nombrei);
		switch(tipo) {
			case "Todos":
				cf1.setTipoCentroFormacion(null);
			break;
			case "Universidad":
				cf1.setTipoCentroFormacion(TipoCentroFormacion.Universidad);
				break;
			case "Instituto":
				cf1.setTipoCentroFormacion(TipoCentroFormacion.Instituto);
				break;
		}
		
		ReportePago rp = new ReportePago();		
	
		rp.setCentroFormacion(cf1);
		
		switch(estado) {
			case "Creada":
				ideab.setEstadoIdea(EstadoIdea.Creada);	
			break;
			case "Aprobada":
				ideab.setEstadoIdea(EstadoIdea.Aprobada);	
			break;
			case "Rechazada":
				ideab.setEstadoIdea(EstadoIdea.Rechazada);	
			break;
			case "Publicada":
				ideab.setEstadoIdea(EstadoIdea.Publicada);	
			break;
		}
		
	
		GestionCobro negocio = new GestionCobro();
		
		try {
		List<Idea> lista = negocio.listaIdeasporCF(evaluador, ideab, fecha_ini, fecha_fin);
			
		// Guardar en el ambiente de request
			request.setAttribute("listax", lista);
			
		RequestDispatcher rd = request.getRequestDispatcher("evaluador_listado_ideas.jsp");
		rd.forward(request, response);
		} catch (gestores.exception.DAOExcepcion e) {
			System.out.println(e.getMessage());
		}
	}

}
