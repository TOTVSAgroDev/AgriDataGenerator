package com.totvs.agridatagenerator.vo.enums;

public enum TipoPragaEnum {

	INSETO("Inseto"), DOENCA("Doença"), ERVA_DANINHA("Planta Daninha");

	private String value;

	private TipoPragaEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public TipoPragaEnum findByValue(String value) {
		for (TipoPragaEnum tipoPraga : TipoPragaEnum.values()) {
			if (value.equalsIgnoreCase(tipoPraga.getValue())) {
				return tipoPraga;
			}
		}

		return null;
	}

}
