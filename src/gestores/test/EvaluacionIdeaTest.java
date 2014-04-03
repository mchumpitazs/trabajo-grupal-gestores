package gestores.test;

import gestores.bean.Puntaje;
import gestores.enums.EstadoIdea;
import gestores.exception.DAOExcepcion;
import gestores.modelo.Idea;
import gestores.modelo.Usuario;
import gestores.negocio.EvaluacionIdea;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class EvaluacionIdeaTest {

	@Test
	public void obtenerEvaluacionTest() {
		EvaluacionIdea negocio = new EvaluacionIdea();
		try {
			Integer codigo = 2;
			Idea vo = negocio.obtenerEvaluacion(codigo);
			Assert.assertNotNull(vo);
		} catch (DAOExcepcion e) {
			Assert.fail("Fallo la obtenci�n: " + e.getMessage());
		}
	}

	@Test
	public void aprobarTest() {
		EvaluacionIdea negocio = new EvaluacionIdea();
		try {
			Idea idea = new Idea();
			idea.setCodigo(2);
			idea.setEstadoIdea(EstadoIdea.APROBADA);

			Idea vo = negocio.actualizarEstado(idea);
			System.out.println("Se aprob� el id: " + vo.getCodigo());
		} catch (DAOExcepcion e) {
			Assert.fail("Fall� la aprobaci�n: " + e.getMessage());
		}
	}

	@Test
	public void rechazarTest() {
		EvaluacionIdea negocio = new EvaluacionIdea();
		try {
			Idea idea = new Idea();
			idea.setCodigo(2);
			idea.setEstadoIdea(EstadoIdea.RECHAZADA);

			Idea vo = negocio.actualizarEstado(idea);
			System.out.println("Se rechaz� el id: " + vo.getCodigo());
		} catch (DAOExcepcion e) {
			Assert.fail("Fall� la desaprobaci�n: " + e.getMessage());
		}
	}

	@Test
	public void asignarAsesorTest() {
		EvaluacionIdea negocio = new EvaluacionIdea();
		try {
			Usuario estudiante = new Usuario();
			estudiante.setCodigo(2);

			Usuario asesor = new Usuario();
			asesor.setCodigo(7);

			Idea idea = new Idea();
			idea.setCodigo(2);
			idea.setEstudiante(estudiante);
			idea.setAsesor(asesor);

			Idea vo = negocio.asignarAsesor(idea);
			System.out.println("Se asign� el asesor "
					+ vo.getAsesor().getCodigo() + " para la idea "
					+ vo.getCodigo());
		} catch (DAOExcepcion e) {
			Assert.fail("Fall� la asignaci�n de asesor: " + e.getMessage());
		}
	}

	@Test
	public void listarEvaluacionTest() {
		EvaluacionIdea negocio = new EvaluacionIdea();
		try {
			Idea idea = new Idea();
			idea.setTitulo("");

			List<Idea> listado = negocio.listarEvaluacion(idea);
			System.out.println("Total de registros: " + listado.size());

			for (Idea vo : listado) {
				System.out.println(vo.getTitulo() + " - "
						+ vo.getEstadoIdea().getNombre());
			}
			Assert.assertTrue(listado.size() > 0);
		} catch (DAOExcepcion e) {
			Assert.fail("Fall� la b�squeda: " + e.getMessage());
		}
	}

	@Test
	public void buscarEvaluacionPorTituloTest() {
		EvaluacionIdea negocio = new EvaluacionIdea();
		try {
			Idea idea = new Idea();
			idea.setTitulo("Matricula");

			List<Idea> listado = negocio.listarEvaluacion(idea);
			System.out.println("Total de registros: " + listado.size());

			for (Idea vo : listado) {
				System.out.println(vo.getTitulo() + " - "
						+ vo.getEstadoIdea().getNombre());
			}
			Assert.assertTrue(listado.size() > 0);
		} catch (DAOExcepcion e) {
			Assert.fail("Fall� la b�squeda: " + e.getMessage());
		}
	}

	@Test
	public void listarResumenPuntajeTest() {
		EvaluacionIdea negocio = new EvaluacionIdea();
		try {
			Integer codigo = 2;

			List<Puntaje> listado = negocio.listarResumenPuntaje(codigo);
			System.out.println("Total de registros: " + listado.size());

			for (Puntaje vo : listado) {
				System.out.println(vo.getValorPuntaje() + " - "
						+ vo.getCantidadUsuarios());
			}
			Assert.assertTrue(listado.size() > 0);
		} catch (DAOExcepcion e) {
			Assert.fail("Fall� la b�squeda: " + e.getMessage());
		}
	}
}