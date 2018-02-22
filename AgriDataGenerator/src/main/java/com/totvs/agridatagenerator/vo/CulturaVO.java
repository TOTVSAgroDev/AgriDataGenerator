package com.totvs.agridatagenerator.vo;

import com.totvs.agridatagenerator.framework.vo.AbstractVO;

public class CulturaVO extends AbstractVO {

	private String codigo;
	private String descricao;

	public CulturaVO(String codigo, String descricao) {
		super();

		this.codigo = codigo;
		this.descricao = descricao;
	}

	public String getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	@Override
	public String toString() {
		return "CulturaVO [codigo=" + codigo + ", descricao=" + descricao + "]";
	}

}
