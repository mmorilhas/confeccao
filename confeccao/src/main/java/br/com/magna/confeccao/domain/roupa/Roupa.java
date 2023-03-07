package br.com.magna.confeccao.domain.roupa;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.com.magna.confeccao.domain.modelagem.Modelagem;
import br.com.magna.confeccao.domain.roupa.partecima.ParteDeCima;
import br.com.magna.confeccao.domain.tecido.Tecido;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Table(name = "roupas")
@Entity (name = "Roupa")
@Inheritance(strategy = InheritanceType.JOINED)

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Roupa{

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	
	private Integer tamanho;
	
	@Enumerated(EnumType.STRING)
	private Genero genero;
	
	private String cor;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "modelagem_id")
	private Modelagem modelagem;
	
	private Boolean temEstampa;
	
	private Boolean temBordado;
	
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "tecido_id")
	private Tecido tecido;
	
	@Embedded
	private ParteDeCima parteDeCima;

	
	
}
