package br.com.magna.confeccao.domain.fibra;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "fibras")
@Entity(name = "Fibra")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Fibra {
	
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique = true)
	private String nomeFibra;
	
	private String tipoFibra;
	
	private String tempoSecagem;
	private Boolean respiravel;
	private String absorcaoAgua;
	private String elasticidade;
	private String comportamentoTermico;
	private String resistencia;

}
