package br.com.magna.confeccao.domain.modelagem.enums;

public enum PregasEnum {
	SIMPLES("Simples"),
	MACHO("Macho"),
	FEMEA("Fêmea"),
	PLISSADO("Plissado"),
	NAO_POSSUI("Não_Possui");

	private String value;

	PregasEnum(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
	
}
