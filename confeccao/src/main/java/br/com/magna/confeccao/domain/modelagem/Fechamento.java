package br.com.magna.confeccao.domain.modelagem;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name= "fechamentos")
@Entity(name = "Fechamento")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Fechamento {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String aviamento;
	
	private String local;
}
