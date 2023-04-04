package br.com.magna.confeccao.domain.modelagem;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode()
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Modelagem {

	@ManyToOne(cascade = CascadeType.ALL
			//, fetch = FetchType.EAGER
			)
	@JoinColumn(name = "silhueta_id")
	private Silhueta silhueta;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "fechamento_id")
	private Fechamento fechamento;
	
	private Boolean cinto;
	private Boolean passantes;
	
	private Boolean pences;
	
	private Boolean pala;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "prega_id")
	private Prega prega;

	private Boolean babado;
	
	private Boolean fenda;
	
	@Positive
	private Integer bolsos;

	private Boolean forro;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "barra_id")
	private Barra barra;
	
	
	



	
}
