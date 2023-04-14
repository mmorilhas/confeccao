package br.com.magna.confeccao.controller.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.magna.confeccao.dto.domain.DadosListagemPregaDTO;
import br.com.magna.confeccao.repository.domain.PregaDomainRepository;

@RestController
@RequestMapping("pregas")
public class PregaDomainController {

	@Autowired
	private PregaDomainRepository repository;

	@GetMapping
	public ResponseEntity<List<DadosListagemPregaDTO>> listar() {

		List<DadosListagemPregaDTO> pregas = repository.findAll().stream().map(DadosListagemPregaDTO::new).toList();
		return ResponseEntity.status(HttpStatus.OK).body(pregas);
	}

}
