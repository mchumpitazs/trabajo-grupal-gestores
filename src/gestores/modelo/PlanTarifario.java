package gestores.modelo;

import java.math.BigDecimal;

/**
 * @author Harry Bravo.
 */
public class PlanTarifario {

	private Integer codigo;
	private String nombre;
	private BigDecimal precioServicio;
	private BigDecimal precioTarifa;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public BigDecimal getPrecioServicio() {
		return precioServicio;
	}

	public void setPrecioServicio(BigDecimal precioServicio) {
		this.precioServicio = precioServicio;
	}

	public BigDecimal getPrecioTarifa() {
		return precioTarifa;
	}

	public void setPrecioTarifa(BigDecimal precioTarifa) {
		this.precioTarifa = precioTarifa;
	}
}