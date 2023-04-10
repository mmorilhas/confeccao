package br.com.magna.confeccao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.magna.confeccao.dto.DadosListagemFibraDTO;
import br.com.magna.confeccao.repository.FibraRepository;

@RestController
@RequestMapping("fibras")
public class FibraController {

	@Autowired
	private FibraRepository repository;

	@GetMapping
	public ResponseEntity<List<DadosListagemFibraDTO>> listar() {
		List<DadosListagemFibraDTO> fibras = repository.findAll().stream().map(DadosListagemFibraDTO::new).toList();

		return ResponseEntity.status(HttpStatus.OK).body(fibras);
	}

}
