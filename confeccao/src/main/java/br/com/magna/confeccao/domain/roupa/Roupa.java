package br.com.magna.confeccao.domain.roupa;

import br.com.magna.confeccao.domain.modelagem.Modelagem;
import br.com.magna.confeccao.domain.tecido.DadosCadastroTecido;
import br.com.magna.confeccao.domain.tecido.Tecido;
import br.com.magna.confeccao.domain.tecido.TecidoService;
import jakarta.persistence.CascadeType;
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


@Table(name = "roupas")
@Entity (name = "Roupa")
@Inheritance(strategy = InheritanceType.JOINED)

@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public abstract class Roupa{

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id;
	
	protected String nome;
	
	protected Integer tamanho;
	
	@Enumerated(EnumType.STRING)
	protected Genero genero;
	
	protected String cor;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "modelagem_id")
	protected Modelagem modelagem;
	
	protected Boolean temEstampa;
	
	protected Boolean temBordado;
	
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "tecido_id")
	protected Tecido tecido;

	
	
}
