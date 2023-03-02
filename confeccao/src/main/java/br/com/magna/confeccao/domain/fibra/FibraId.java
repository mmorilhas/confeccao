package br.com.magna.confeccao.domain.fibra;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode()
public class FibraId  implements Serializable{

	private static final long serialVersionUID = 1L;
	private Long id;
	private String tipoFibra;
	
	
}
