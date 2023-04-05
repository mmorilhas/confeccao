package br.com.magna.confeccao.domain.modelagem;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name= "fechamentos")
@Entity(name = "Fechamento")
//@Getter
//@NoArgsConstructor
//@AllArgsConstructor
//@EqualsAndHashCode(of = "id")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Fechamento {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String aviamento;
	
	private String local;

	public Long getId() {
		return id;
	}

	public String getAviamento() {
		return aviamento;
	}

	public String getLocal() {
		return local;
	}
	
	
}
