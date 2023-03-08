package br.com.magna.confeccao.domain.modelagem;

public record DadosDetalhamentoModelagem(
		
		Silhueta silhueta, 
		Fechamento fechamento,
		
		Boolean cinto,
		Boolean passantes,
		
		Boolean pences,
		Boolean pala,
		
		Prega prega,
		
		Boolean babado,
		Boolean fenda,
		
		Integer bolsos,
		
		Boolean forro,
		Barra Barra
		
		
		) {
	
	public DadosDetalhamentoModelagem(Modelagem modelagem) {
		this(modelagem.getSilhueta(), modelagem.getFechamento(), modelagem.getCinto(), modelagem.getPassantes(), modelagem.getPences(), modelagem.getPala(), modelagem.getPrega(), modelagem.getBabado(), modelagem.getFenda(), modelagem.getBolsos(), modelagem.getForro(), modelagem.getBarra());
	}


}
