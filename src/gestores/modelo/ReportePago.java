package gestores.modelo;

import java.math.BigDecimal;

/**
 * 
 * @author Harry Bravo
 */
public class ReportePago {

	private Integer anioPago;
	private String mesPago;
	private CentroFormacion centroFormacion;
	private PlanTarifario planTarifario;
	private Integer cantidadIdeas;
	private BigDecimal montoMensual;

	public Integer getAnioPago() {
		return anioPago;
	}

	public void setAnioPago(Integer anioPago) {
		this.anioPago = anioPago;
	}

	public String getMesPago() {
		return mesPago;
	}

	public void setMesPago(String mesPago) {
		this.mesPago = mesPago;
	}

	public CentroFormacion getCentroFormacion() {
		return centroFormacion;
	}

	public void setCentroFormacion(CentroFormacion centroFormacion) {
		this.centroFormacion = centroFormacion;
	}

	public PlanTarifario getPlanTarifario() {
		return planTarifario;
	}

	public void setPlanTarifario(PlanTarifario planTarifario) {
		this.planTarifario = planTarifario;
	}

	public Integer getCantidadIdeas() {
		return cantidadIdeas;
	}

	public void setCantidadIdeas(Integer cantidadIdeas) {
		this.cantidadIdeas = cantidadIdeas;
	}

	public BigDecimal getMontoMensual() {
		return montoMensual;
	}

	public void setMontoMensual(BigDecimal montoMensual) {
		this.montoMensual = montoMensual;
	}
}