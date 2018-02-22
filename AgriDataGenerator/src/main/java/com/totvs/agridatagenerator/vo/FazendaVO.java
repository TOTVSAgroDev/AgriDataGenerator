package com.totvs.agridatagenerator.vo;

import java.util.LinkedList;
import java.util.List;
import com.google.common.collect.ImmutableList;
import com.totvs.agridatagenerator.framework.vo.AbstractVO;

public class FazendaVO extends AbstractVO {

	private String codigo;
	private String descricao;

	private List<TalhaoVO> talhoes;

	private List<EquipamentoVO> equipamentos;

	public FazendaVO(String codigo, String descricao) {
		super();

		this.codigo = codigo;
		this.descricao = descricao;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public List<TalhaoVO> getTalhoes() {
		if (talhoes == null) {
			talhoes = new LinkedList<TalhaoVO>();
		}

		return talhoes;
	}

	public void clearTalhoes() {
		this.getTalhoes().clear();
	}

	public void addTalhao(TalhaoVO talhao) {
		this.getTalhoes().add(talhao);
	}

	public void addTalhoes(ImmutableList<TalhaoVO> talhoes) {
		this.clearTalhoes();
		this.getTalhoes().addAll(talhoes);
	}

	public List<EquipamentoVO> getEquipamentos() {
		if (equipamentos == null) {
			equipamentos = new LinkedList<EquipamentoVO>();
		}

		return equipamentos;
	}

	public void addEquipamento(EquipamentoVO equipamento) {
		this.getEquipamentos().add(equipamento);
	}

	@Override
	public String toString() {
		return "FazendaVO [codigo=" + codigo + ", descricao=" + descricao + "]";
	}

}
