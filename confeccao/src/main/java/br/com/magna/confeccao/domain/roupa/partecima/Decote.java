package br.com.magna.confeccao.domain.roupa.partecima;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Table(name= "decotes")
@Entity(name = "Decote")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Decote {

		
		@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		
		private String descricao;
		

}
