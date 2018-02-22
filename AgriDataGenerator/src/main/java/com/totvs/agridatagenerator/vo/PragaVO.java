package com.totvs.agridatagenerator.vo;

import com.totvs.agridatagenerator.framework.vo.AbstractVO;
import com.totvs.agridatagenerator.vo.enums.TipoInspecaoPragaEnum;
import com.totvs.agridatagenerator.vo.enums.TipoPragaEnum;

public class PragaVO extends AbstractVO {

	private long codigo;
	private String descricao;
	private String nomeCientifico;

	private TipoPragaEnum tipoPraga;

	private TipoInspecaoPragaEnum tipoInspecaoPraga;

	private long criticidade;

	public PragaVO(long codigo, String descricao, String nomeCientifico, TipoPragaEnum tipoPraga, TipoInspecaoPragaEnum tipoInspecaoPraga, long criticidade) {
		super();

		this.codigo = codigo;
		this.descricao = descricao;
		this.nomeCientifico = nomeCientifico;
		this.tipoPraga = tipoPraga;
		this.tipoInspecaoPraga = tipoInspecaoPraga;
		this.criticidade = criticidade;
	}

	public long getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public String getNomeCientifico() {
		return nomeCientifico;
	}

	public TipoPragaEnum getTipoPraga() {
		return tipoPraga;
	}

	public TipoInspecaoPragaEnum getTipoInspecaoPraga() {
		return tipoInspecaoPraga;
	}

	public long getCriticidade() {
		return criticidade;
	}

	@Override
	public String toString() {
		return "PragaVO [codigo=" + codigo + ", descricao=" + descricao + ", nomeCientifico=" + nomeCientifico + ", tipoPraga=" + tipoPraga + ", tipoInspecaoPraga=" + tipoInspecaoPraga + ", criticidade=" + criticidade + "]";
	}

}
