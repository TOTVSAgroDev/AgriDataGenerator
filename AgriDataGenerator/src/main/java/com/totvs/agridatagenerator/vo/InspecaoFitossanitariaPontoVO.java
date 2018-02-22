package com.totvs.agridatagenerator.vo;

import java.util.LinkedHashMap;
import java.util.Map;
import com.totvs.agridatagenerator.framework.vo.AbstractVO;

public class InspecaoFitossanitariaPontoVO extends AbstractVO {

	private long numeroPonto;

	private Map<PragaVO, ResultadoInspecaoVO> resultadoInspecao;

	public InspecaoFitossanitariaPontoVO(long numeroPonto) {
		super();

		this.numeroPonto = numeroPonto;
	}

	public long getNumeroPonto() {
		return numeroPonto;
	}

	public Map<PragaVO, ResultadoInspecaoVO> getResultadoInspecao() {
		if (resultadoInspecao == null) {
			resultadoInspecao = new LinkedHashMap<PragaVO, ResultadoInspecaoVO>();
		}

		return resultadoInspecao;
	}

	public void addResultadoInspecao(PragaVO praga, ResultadoInspecaoVO resultadoInspecao) {
		this.getResultadoInspecao().put(praga, resultadoInspecao);
	}

}
