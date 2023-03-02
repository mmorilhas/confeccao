package br.com.magna.confeccao.domain.fibra;

public enum NomeFibra {
	ALGODAO("Algodão"),
	LA("Lã"),
	LINHO("Linho"),
	SEDA("Seda"),
	COURO("Couro"),
	
	VISCOSE("Viscose"),
	MODAL("Modal"),
	LIOCEL("Liocel"),
	ACETATO("Acetato"),
	
	ACRILICO("Acrílico"),
	POLIAMIDA("Poliamida"),
	POLIESTER("Poliéster"),
	ELASTANO("Elastano");
	
	private String value;

	private NomeFibra(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
}
