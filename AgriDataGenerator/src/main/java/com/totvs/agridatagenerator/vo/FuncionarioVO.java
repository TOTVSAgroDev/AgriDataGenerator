package com.totvs.agridatagenerator.vo;

import com.totvs.agridatagenerator.framework.vo.AbstractVO;

public class FuncionarioVO extends AbstractVO {

	private long matricula;
	private String nome;

	public FuncionarioVO(long matricula, String nome) {
		super();

		this.matricula = matricula;
		this.nome = nome;
	}

	public long getMatricula() {
		return matricula;
	}

	public String getNome() {
		return nome;
	}

	@Override
	public String toString() {
		return "FuncionarioVO [matricula=" + matricula + ", nome=" + nome + "]";
	}

}
