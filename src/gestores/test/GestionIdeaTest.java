package gestores.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.Calendar;

import gestores.exception.DAOExcepcion;
import gestores.modelo.Idea;
import gestores.modelo.TipoEstadoIdea;
import gestores.negocio.GestionIdea;

import org.junit.Assert;
import org.junit.Test;

public class GestionIdeaTest {

	@Test
	public void ideaDebeCrearseConLosDatosIndicados(){
				
		Idea idea = new Idea();
		
		String tituloIdea = "Titulo Idea 1";
		String descripcionIdea = "Descripción de la idea 1";
		
		// Uso de la libreria Calendar para el manejo de fechas
		Calendar cal = Calendar.getInstance();
		cal.set(2014, Calendar.DECEMBER, 12, 12, 8, 3);
		Date fechaCreacion = cal.getTime();
		
		TipoEstadoIdea tipoEstado = new TipoEstadoIdea();
		tipoEstado.setIdEstadoIdea(1); // Creado
		
		ArrayList<String> palabrasClave = new ArrayList<String>();
		palabrasClave.add("tag1");
		palabrasClave.add("tag2");
		palabrasClave.add("tag3");
		palabrasClave.add("tag4");
		
		idea.setTitulo(tituloIdea);
		idea.setDescripcion(descripcionIdea);
		idea.setPalabrasClave(palabrasClave);
		idea.setFechaCreacion(fechaCreacion);
		idea.setTipoEstado(tipoEstado);
		
		assertNotNull(idea);
		assertEquals(tituloIdea, idea.getTitulo());
		assertEquals(descripcionIdea, idea.getDescripcion());
		assertEquals(palabrasClave, idea.getPalabrasClave());
		assertEquals(fechaCreacion, idea.getFechaCreacion());
		assertEquals(tipoEstado, idea.getTipoEstado());	
	}
}
