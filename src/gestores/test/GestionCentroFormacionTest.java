package gestores.test;

import gestores.exception.DAOExcepcion;
import gestores.modelo.CentroFormacion;
import gestores.modelo.TipoCentroFormacion;
import gestores.negocio.GestionCentroFormacion;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class GestionCentroFormacionTest {

	//@Test
	public void insertarTest() {
		GestionCentroFormacion negocio = new GestionCentroFormacion();

		try {
			TipoCentroFormacion tipoCentroFormacion = new TipoCentroFormacion();
			tipoCentroFormacion.setIdTipoCentroFormacion("U");

			CentroFormacion centroFormacion = new CentroFormacion();
			centroFormacion.setIdCentroFormacion("1");
			centroFormacion.setNombre("UPC");
			centroFormacion.setUrlCentroFormacion("http://www.upc.edu.pe");
			centroFormacion.setUrlLogo("images/logoUPC.png");
			centroFormacion.setTipoCentroFormacion(tipoCentroFormacion);

			CentroFormacion vo = negocio.insertar(centroFormacion);
			System.out
					.println("Se insertó el id: " + vo.getIdCentroFormacion());
		} catch (DAOExcepcion e) {
			Assert.fail("Fallo la inserción: " + e.getMessage());
		}
	}

	@Test
	public void obtenerTest() {
		GestionCentroFormacion negocio = new GestionCentroFormacion();

		try {
			CentroFormacion vo = negocio.obtener("1");
			Assert.assertNotNull(vo);
		} catch (DAOExcepcion e) {
			Assert.fail("Fallo la obtención: " + e.getMessage());
		}
	}

	//@Test
	public void actualizarTest() {
		GestionCentroFormacion negocio = new GestionCentroFormacion();

		try {
			TipoCentroFormacion tipoCentroFormacion = new TipoCentroFormacion();
			tipoCentroFormacion.setIdTipoCentroFormacion("U");

			CentroFormacion centroFormacion = new CentroFormacion();
			centroFormacion.setIdCentroFormacion("1");
			centroFormacion
					.setNombre("Universidad Peruana de Ciencias Aplicadas");
			centroFormacion.setUrlCentroFormacion("http://www.upc.edu.pe");
			centroFormacion.setUrlLogo("images/logoUPC.png");
			centroFormacion.setTipoCentroFormacion(tipoCentroFormacion);

			CentroFormacion vo = negocio.actualizar(centroFormacion);
			System.out.println("Se actualizó el id: "
					+ vo.getIdCentroFormacion());

		} catch (DAOExcepcion e) {
			Assert.fail("Falló la actualización: " + e.getMessage());
		}
	}

	//@Test
	public void listarTest() {
		GestionCentroFormacion negocio = new GestionCentroFormacion();

		try {
			List<CentroFormacion> listado = negocio.listar();
			System.out.println("Total de registros: " + listado.size());

			for (CentroFormacion centroFormacion : listado) {
				System.out.println(centroFormacion.getNombre());
			}
			Assert.assertTrue(listado.size() > 0);
		} catch (DAOExcepcion e) {
			Assert.fail("Falló el listado: " + e.getMessage());
		}
	}

	//@Test
	public void buscarTodosTest() {
		GestionCentroFormacion negocio = new GestionCentroFormacion();

		try {
			TipoCentroFormacion tipoCentroFormacion = new TipoCentroFormacion();
			tipoCentroFormacion.setIdTipoCentroFormacion("0");

			CentroFormacion centroFormacion = new CentroFormacion();
			centroFormacion.setNombre("");
			List<CentroFormacion> listado = negocio.buscar(centroFormacion);
			System.out.println("Total de registros: " + listado.size());

			for (CentroFormacion vo : listado) {
				System.out.println(vo.getNombre());
			}
			Assert.assertTrue(listado.size() > 0);
		} catch (DAOExcepcion e) {
			Assert.fail("Falló la búsqueda: " + e.getMessage());
		}
	}

	//@Test
	public void buscarPorNombreTipoTest() {
		GestionCentroFormacion negocio = new GestionCentroFormacion();

		try {
			TipoCentroFormacion tipoCentroFormacion = new TipoCentroFormacion();
			tipoCentroFormacion.setIdTipoCentroFormacion("U");

			CentroFormacion centroFormacion = new CentroFormacion();
			centroFormacion.setNombre("Unive");
			centroFormacion.setTipoCentroFormacion(tipoCentroFormacion);
			List<CentroFormacion> listado = negocio.buscar(centroFormacion);
			System.out.println("Total de registros: " + listado.size());

			for (CentroFormacion vo : listado) {
				System.out.println(vo.getNombre());
			}
			Assert.assertTrue(listado.size() > 0);
		} catch (DAOExcepcion e) {
			Assert.fail("Falló la búsqueda: " + e.getMessage());
		}
	}

	//@Test
	public void buscarPorTipoTest() {
		GestionCentroFormacion negocio = new GestionCentroFormacion();

		try {
			TipoCentroFormacion tipoCentroFormacion = new TipoCentroFormacion();
			tipoCentroFormacion.setIdTipoCentroFormacion("U");

			CentroFormacion centroFormacion = new CentroFormacion();
			centroFormacion.setNombre("");
			centroFormacion.setTipoCentroFormacion(tipoCentroFormacion);
			List<CentroFormacion> listado = negocio.buscar(centroFormacion);
			System.out.println("Total de registros: " + listado.size());

			for (CentroFormacion vo : listado) {
				System.out.println(vo.getNombre());
			}
			Assert.assertTrue(listado.size() > 0);
		} catch (DAOExcepcion e) {
			Assert.fail("Falló la búsqueda: " + e.getMessage());
		}
	}

	//@Test
	public void eliminarTest() {
		GestionCentroFormacion negocio = new GestionCentroFormacion();
		try {
			negocio.eliminar("1");
			CentroFormacion nuevo = negocio.obtener("1");
			Assert.assertEquals(null, nuevo.getNombre());
		} catch (DAOExcepcion e) {
			Assert.fail("Falló la eliminición: " + e.getMessage());
		}
	}
}