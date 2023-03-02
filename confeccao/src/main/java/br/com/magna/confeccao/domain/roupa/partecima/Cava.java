package br.com.magna.confeccao.domain.roupa.partecima;

public enum Cava {
	JUSTA("Justa"),
	BAIXA("Baixa"),
	SEM_CAVA("Sem");
	
	private String value;

	Cava(String value) {
		this.value = value;
	}
}
