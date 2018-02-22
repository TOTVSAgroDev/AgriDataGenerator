package com.totvs.agridatagenerator.vo;

import java.math.BigDecimal;
import java.util.Date;
import com.totvs.agridatagenerator.framework.vo.AbstractVO;
import com.totvs.agridatagenerator.vo.enums.TipoEquipamentoEnum;

public class EquipamentoVO extends AbstractVO {

	private String codigo;

	private String modelo;
	private GrupoOperativoVO grupoOperativo;

	private TipoEquipamentoEnum tipo;

	private BigDecimal ultimoHorimetro;
	private Date dataUltimaManutencao;

	private boolean disponivel;

	public EquipamentoVO(String codigo) {
		super();

		this.codigo = codigo;
	}

	public EquipamentoVO(String codigo, String modelo, TipoEquipamentoEnum tipo, GrupoOperativoVO grupoOperativo, BigDecimal ultimoHorimetro, Date dataUltimaManutencao, boolean disponivel) {
		super();

		this.codigo = codigo;
		this.modelo = modelo;
		this.tipo = tipo;
		this.grupoOperativo = grupoOperativo;
		this.ultimoHorimetro = ultimoHorimetro;
		this.dataUltimaManutencao = dataUltimaManutencao;
		this.disponivel = disponivel;
	}

	public String getCodigo() {
		return codigo;
	}

	public String getModelo() {
		return modelo;
	}

	public GrupoOperativoVO getGrupoOperativo() {
		return grupoOperativo;
	}

	public TipoEquipamentoEnum getTipo() {
		return tipo;
	}

	public BigDecimal getUltimoHorimetro() {
		return ultimoHorimetro;
	}

	public Date getDataUltimaManutencao() {
		return dataUltimaManutencao;
	}

	public boolean isDisponivel() {
		return disponivel;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (obj == null) {
			return false;
		}

		if (!(obj instanceof EquipamentoVO)) {
			return false;
		}

		EquipamentoVO other = (EquipamentoVO) obj;

		if (codigo == null) {
			if (other.codigo != null) {
				return false;
			}
		} else if (!codigo.equals(other.codigo)) {
			return false;
		}

		return true;
	}

	@Override
	public String toString() {
		return "EquipamentoVO [codigo=" + codigo + ", modelo=" + modelo + ", grupoOperativo=" + grupoOperativo + ", tipo=" + tipo + ", ultimoHorimetro=" + ultimoHorimetro + ", dataUltimaManutencao=" + dataUltimaManutencao + ", disponivel=" + disponivel + "]";
	}

}
