package com.totvs.agridatagenerator.vo.enums;

public enum TipoGrupoOperativoEnum {

	PRINCIPAL("Principal"), AUXILIAR("Auxiliar");

	private String value;

	private TipoGrupoOperativoEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public TipoGrupoOperativoEnum findByValue(String value) {
		for (TipoGrupoOperativoEnum tipoGrupoOperativo : TipoGrupoOperativoEnum.values()) {
			if (value.equalsIgnoreCase(tipoGrupoOperativo.getValue())) {
				return tipoGrupoOperativo;
			}
		}

		return null;
	}

}
