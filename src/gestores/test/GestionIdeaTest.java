package gestores.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import gestores.enums.EstadoIdea;
import gestores.exception.DAOExcepcion;
import gestores.modelo.CentroFormacion;
import gestores.modelo.Idea;
import gestores.modelo.Reunion;
import gestores.modelo.Usuario;
import gestores.negocio.GestionIdea;
import gestores.negocio.GestionReunion;
import gestores.util.FechaUtil;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Lino Espinoza.
 */
public class GestionIdeaTest {

	//@Test
	public void ideaDebeCrearseConLosDatosIndicados() {
		Idea idea = new Idea();

		String tituloIdea = "Titulo Idea 1";
		String descripcionIdea = "Descripción de la idea 1";

		// Uso de la libreria Calendar para el manejo de fechas
		// Date fechaSinHora = FechaUtil.establecerFecha(1, Calendar.DECEMBER,
		// 2014);
		Date fechaCreacion = FechaUtil.establecerFechaHora(1,
				Calendar.DECEMBER, 2014, 23, 11, 59);

		String palabrasClave = "tag1,tag2,tag3,tag4";
		String terceraPalabra = "tag3";
		String[] palabraClaveArray = palabrasClave.split(",");

		idea.setTitulo(tituloIdea);
		idea.setDescripcion(descripcionIdea);
		idea.setPalabrasClave(palabrasClave);
		idea.setFechaCreacion(fechaCreacion);
		idea.setEstadoIdea(EstadoIdea.Creada); // Creada

		assertNotNull(idea);
		assertEquals(tituloIdea, idea.getTitulo());
		assertEquals(descripcionIdea, idea.getDescripcion());
		assertEquals(palabrasClave, idea.getPalabrasClave());
		assertEquals(terceraPalabra, palabraClaveArray[2]);
		assertEquals(fechaCreacion, idea.getFechaCreacion());
		assertEquals(EstadoIdea.Creada, idea.getEstadoIdea());
	}

@Test
/**
 * @author Marco Ch.
 */
public void listarIdeasporCentroInformacionEvaluadoryCondicionesTest() {
	GestionIdea negocio = new GestionIdea();
	try {
		Date fechaInicio = null;
		Date fechaFin = null;

		CentroFormacion centroFormacion = new CentroFormacion();
		centroFormacion.setCodigo("10406048417");
			
		Usuario evaluador = new Usuario();
		evaluador.setCentroFormacion(centroFormacion);
		
		Idea idea = new Idea();
		idea.setTitulo(null);
		idea.setDescripcion(null);
		idea.setPalabrasClave(null);
		idea.setEstadoIdea(null);
			
	
		List<Idea> listado = negocio.listaIdeasporCF(evaluador, idea, fechaInicio, fechaFin);
		//System.out.println("Total de registros: " + listado.size());

		for (Idea vo : listado) {
			System.out.println(vo.getTitulo() + " | "
					+ vo.getDescripcion() +  " | "
					+ vo.getPalabrasClave() + " | "
					+ vo.getArchivo() + " | "
					+ vo.getEstudiante().getApellidoPaterno() + " | "
					+ vo.getEstudiante().getApellidoMaterno() + " | "
					+ vo.getEstudiante().getNombre() + " | "
					+ vo.getEstadoIdea().getCodigo() + " | "
					+ vo.getFechaCreacion());
		}
		Assert.assertTrue(listado.size() > 0);
	} catch (DAOExcepcion e) {
		Assert.fail("Falló la búsqueda: " + e.getMessage());
	}
}
}