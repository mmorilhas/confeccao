package br.com.magna.confeccao.dto;

import br.com.magna.confeccao.entities.modelagem.Modelagem;
import br.com.magna.confeccao.entities.partecima.ParteDeCima;
import br.com.magna.confeccao.entities.roupa.Roupa;
import br.com.magna.confeccao.entities.roupa.enums.Genero;
import br.com.magna.confeccao.entities.tecido.Tecido;

public record DadosDetalhamentoRoupaDTO(
	
		
		Long id,
		String nome,
		String colecao,
		String tipoRoupa,
		Integer tamanhoInicial,
		Integer tamanhoFinal,
		Genero genero,
		String cor,
		Boolean temEstampa,
		Boolean temBordado,
	    Modelagem modelagem,
		Tecido tecido,
		ParteDeCima parteDecima
	
		
		) {

	public DadosDetalhamentoRoupaDTO(Roupa roupa) {
		this(roupa.getId(),
				roupa.getNome(),
				roupa.getColecao(),
				roupa.getTipoRoupa(),
				roupa.getTamanhoInicial(),
				roupa.getTamanhoFinal(),
				roupa.getGenero(),
				roupa.getCor(),
				roupa.getTemEstampa(),
				roupa.getTemBordado(),
				roupa.getModelagem(),
				roupa.getTecido(),
				roupa.getParteDeCima());
	}
	
}
