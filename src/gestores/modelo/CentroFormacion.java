package gestores.modelo;

import java.util.List;

/**
 * 
 * @author Lino Espinoza
 */
public class CentroFormacion {

	private String idCentroFormacion;
	private String nombre;
	private String urlCentroFormacion;
	private String urlLogo;
	private TipoCentroFormacion tipoCentroFormacion;
	private List<Factura> facturas;

	// Getters / Setters
	public String getIdCentroFormacion() {
		return idCentroFormacion;
	}

	public void setIdCentroFormacion(String idCentroFormacion) {
		this.idCentroFormacion = idCentroFormacion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUrlCentroFormacion() {
		return urlCentroFormacion;
	}

	public void setUrlCentroFormacion(String urlCentroFormacion) {
		this.urlCentroFormacion = urlCentroFormacion;
	}

	public String getUrlLogo() {
		return urlLogo;
	}

	public void setUrlLogo(String urlLogo) {
		this.urlLogo = urlLogo;
	}

	public TipoCentroFormacion getTipoCentroFormacion() {
		return tipoCentroFormacion;
	}

	public void setTipoCentroFormacion(TipoCentroFormacion tipoCentroFormacion) {
		this.tipoCentroFormacion = tipoCentroFormacion;
	}

	public List<Factura> getFacturas() {
		return facturas;
	}

	public void setFacturas(List<Factura> facturas) {
		this.facturas = facturas;
	}
}