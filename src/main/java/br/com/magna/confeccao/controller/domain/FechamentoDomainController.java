package br.com.magna.confeccao.controller.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.magna.confeccao.dto.domain.DadosListagemFechamentoDTO;
import br.com.magna.confeccao.repository.FechamentoRepository;

@RestController
@RequestMapping("fechamentos")
public class FechamentoDomainController {

	@Autowired
	FechamentoRepository repository;

	@GetMapping
	public ResponseEntity<List<DadosListagemFechamentoDTO>> listar() {
		List<DadosListagemFechamentoDTO> fechamentos = repository.findAll().stream().map(DadosListagemFechamentoDTO::new).toList();

		return ResponseEntity.status(HttpStatus.OK).body(fechamentos);
	}

}
