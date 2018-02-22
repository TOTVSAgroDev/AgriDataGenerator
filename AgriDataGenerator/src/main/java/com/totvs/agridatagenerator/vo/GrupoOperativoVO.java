package com.totvs.agridatagenerator.vo;

import com.totvs.agridatagenerator.framework.vo.AbstractVO;
import com.totvs.agridatagenerator.vo.enums.TipoGrupoOperativoEnum;

public class GrupoOperativoVO extends AbstractVO {

	private String codigo;
	private String descricao;

	private TipoGrupoOperativoEnum tipo;

	public GrupoOperativoVO(String codigo, String descricao, TipoGrupoOperativoEnum tipo) {
		super();

		this.codigo = codigo;
		this.descricao = descricao;
		this.tipo = tipo;
	}

	public String getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public TipoGrupoOperativoEnum getTipo() {
		return tipo;
	}

	@Override
	public String toString() {
		return "GrupoOperativoVO [codigo=" + codigo + ", descricao=" + descricao + ", tipo=" + tipo + "]";
	}

}
