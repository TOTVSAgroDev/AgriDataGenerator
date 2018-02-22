package com.totvs.agridatagenerator.vo;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import com.totvs.agridatagenerator.framework.utils.ListUtil;
import com.totvs.agridatagenerator.framework.vo.AbstractVO;

public class InspecaoFitossanitariaVO extends AbstractVO {

	private Date dataInspecao;

	private FuncionarioVO funcionario;

	private List<InspecaoFitossanitariaPontoVO> pontos;

	private boolean apontamentoFinalizado;

	public InspecaoFitossanitariaVO(Date dataInspecao, FuncionarioVO funcionario, boolean apontamentoFinalizado) {
		super();

		this.dataInspecao = dataInspecao;
		this.funcionario = funcionario;
		this.apontamentoFinalizado = apontamentoFinalizado;
	}

	public Date getDataInspecao() {
		return dataInspecao;
	}

	public FuncionarioVO getFuncionario() {
		return funcionario;
	}

	public List<InspecaoFitossanitariaPontoVO> getPontos() {
		if (pontos == null) {
			pontos = new LinkedList<InspecaoFitossanitariaPontoVO>();
		}

		return pontos;
	}

	public void addPonto(InspecaoFitossanitariaPontoVO ponto) {
		this.getPontos().add(ponto);
	}

	public boolean hasPontos() {
		return ListUtil.isNotNullOrEmpty(this.getPontos());
	}

	public boolean isApontamentoFinalizado() {
		return apontamentoFinalizado;
	}

	@Override
	public String toString() {
		return "InspecaoFitossanitariaVO [dataInspecao=" + dataInspecao + ", funcionario=" + funcionario + ", pontos=" + pontos + ", apontamentoFinalizado=" + apontamentoFinalizado + "]";
	}

}
