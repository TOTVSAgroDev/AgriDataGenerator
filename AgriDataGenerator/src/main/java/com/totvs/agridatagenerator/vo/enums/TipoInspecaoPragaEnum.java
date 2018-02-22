package com.totvs.agridatagenerator.vo.enums;

public enum TipoInspecaoPragaEnum {

	PRESENCA("Presença"), PLANTAS_ATACADAS("Plantas Atacadas"), NUMERO_INDIVIDUOS("Números de Indivíduos");

	private String value;

	private TipoInspecaoPragaEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public TipoInspecaoPragaEnum findByValue(String value) {
		for (TipoInspecaoPragaEnum tipoInspecaoPraga : TipoInspecaoPragaEnum.values()) {
			if (value.equalsIgnoreCase(tipoInspecaoPraga.getValue())) {
				return tipoInspecaoPraga;
			}
		}

		return null;
	}

}
