package com.totvs.agridatagenerator.vo.enums;

public enum TipoEquipamentoEnum {

	PROPRIO("Próprio"), TERCEIRO("Terceiro");

	private String value;

	private TipoEquipamentoEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public TipoEquipamentoEnum findByValue(String value) {
		for (TipoEquipamentoEnum tipoEquipamento : TipoEquipamentoEnum.values()) {
			if (value.equalsIgnoreCase(tipoEquipamento.getValue())) {
				return tipoEquipamento;
			}
		}

		return null;
	}

}
