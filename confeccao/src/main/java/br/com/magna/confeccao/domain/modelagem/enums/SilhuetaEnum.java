package br.com.magna.confeccao.domain.modelagem.enums;

public enum SilhuetaEnum {
	AJUSTADA("Justa"),
	RETA("Reta"),
	BAGGY("Larga");
	
	
	private String value;

	SilhuetaEnum(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
	
}
