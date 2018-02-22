package com.totvs.agridatagenerator.vo;

import com.totvs.agridatagenerator.framework.utils.StringUtil;
import com.totvs.agridatagenerator.framework.vo.AbstractVO;

public class ResultadoInspecaoVO extends AbstractVO {

	private Boolean possuiPresenca;

	private Long numeroPlantasAtacadas;
	private Long numeroPlantasInspecionadas;

	private Long numerosIndividuosAnalisados;

	public ResultadoInspecaoVO(Boolean possuiPresenca) {
		super();

		this.possuiPresenca = possuiPresenca;
	}

	public ResultadoInspecaoVO(Long numeroPlantasAtacadas, Long numeroPlantasInspecionadas) {
		super();

		this.numeroPlantasAtacadas = numeroPlantasAtacadas;
		this.numeroPlantasInspecionadas = numeroPlantasInspecionadas;
	}

	public ResultadoInspecaoVO(Long numerosIndividuosAnalisados) {
		super();

		this.numerosIndividuosAnalisados = numerosIndividuosAnalisados;
	}

	public Boolean getPossuiPresenca() {
		return possuiPresenca;
	}

	public Long getNumeroPlantasAtacadas() {
		return numeroPlantasAtacadas;
	}

	public Long getNumeroPlantasInspecionadas() {
		return numeroPlantasInspecionadas;
	}

	public Long getNumerosIndividuosAnalisados() {
		return numerosIndividuosAnalisados;
	}

	public String getResultado() {
		if (possuiPresenca != null) {
			return possuiPresenca ? "Presença" : "Ausência";
		} else if (numeroPlantasAtacadas != null && numeroPlantasInspecionadas != null) {
			return "Plantas Atacadas: " + numeroPlantasAtacadas + "/" + numeroPlantasInspecionadas;
		} else if (numerosIndividuosAnalisados != null) {
			return "Indivíduos: " + numerosIndividuosAnalisados;
		}

		return StringUtil.EMPTY;
	}

	@Override
	public String toString() {
		return "ResultadoInspecaoVO [possuiPresenca=" + possuiPresenca + ", numeroPlantasAtacadas=" + numeroPlantasAtacadas + ", numeroPlantasInspecionadas=" + numeroPlantasInspecionadas + ", numerosIndividuosAnalisados=" + numerosIndividuosAnalisados + "]";
	}

}
