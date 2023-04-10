package br.com.magna.confeccao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.magna.confeccao.dto.DadosListagemSilhuetaDTO;
import br.com.magna.confeccao.repository.SilhuetaRepository;

@RestController
@RequestMapping("silhuetas")
public class SilhuetaController {

	@Autowired
	SilhuetaRepository repository;

	@GetMapping
	public ResponseEntity<List<DadosListagemSilhuetaDTO>> listar() {
		List<DadosListagemSilhuetaDTO> silhuetas = repository.findAll().stream().map(DadosListagemSilhuetaDTO::new).toList();

		return ResponseEntity.status(HttpStatus.OK).body(silhuetas);
	}

}
