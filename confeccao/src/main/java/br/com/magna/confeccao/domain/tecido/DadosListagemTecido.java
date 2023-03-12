package br.com.magna.confeccao.domain.tecido;

public record DadosListagemTecido(
		
		Long id,
		String tipoDeTecido,
		String tempoSecagem,
		Boolean respiravel,
		String absorcaoAgua,
		String elasticidade,
		String comportamentoTermico,
		String resistencia
		
		) {
	
	
	public DadosListagemTecido(Tecido tecido) {
		this(tecido.getId(),
				tecido.getTipoDeTecido(),
				tecido.getTempoSecagem(),
				tecido.getRespiravel(),
				tecido.getAbsorcaoAgua(),
				tecido.getElasticidade(),
				tecido.getComportamentoTermico(),
				tecido.getResistencia());
	}
	

}
