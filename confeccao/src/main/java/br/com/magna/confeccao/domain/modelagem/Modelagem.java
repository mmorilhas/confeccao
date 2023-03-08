package br.com.magna.confeccao.domain.modelagem;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
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

	private Integer bolsos;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "fechamento_id")
	private Fechamento fechamento;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "barra_id")
	private Barra barra;

	private Boolean pala;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "prega_id")
	private Prega prega;

	private Boolean pences;
	private Boolean fenda;
	private Boolean forro;
	private Boolean babado;
	private Boolean cinto;
	private Boolean passantes;

	@ManyToOne(cascade = CascadeType.ALL
			//, fetch = FetchType.EAGER
			)
	@JoinColumn(name = "silhueta_id")
	private Silhueta silhueta;



	
}
