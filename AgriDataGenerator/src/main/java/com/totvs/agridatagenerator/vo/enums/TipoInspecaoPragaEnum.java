package com.totvs.agridatagenerator.vo.enums;

public enum TipoInspecaoPragaEnum {

	PRESENCA("Presen�a"), PLANTAS_ATACADAS("Plantas Atacadas"), NUMERO_INDIVIDUOS("N�meros de Indiv�duos");

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
