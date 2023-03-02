package br.com.magna.confeccao.domain.modelagem.enums;

public enum BarraEnum {
	INVISIVEL("Invisível"),
	LENCO("Lenço"),
	ITALIANA("Italiana"),
	SIMPLES("Simples"),
	GALONEIRA("Galoneira"),
	VIES("Viés"),
	ORIGINAL("Original"),
	DESFIADA("Desfiada");

	private String value;

	BarraEnum(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
	
}
