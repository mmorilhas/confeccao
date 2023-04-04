package br.com.magna.confeccao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.magna.confeccao.dto.DadosListagemCavaDTO;
import br.com.magna.confeccao.repository.CavaRepository;

@RestController
@RequestMapping("cavas")
public class CavaController {

	@Autowired
	CavaRepository repository;

	@GetMapping
	public ResponseEntity<List<DadosListagemCavaDTO>> listar() {
		List<DadosListagemCavaDTO> cavas = repository.findAll().stream().map(DadosListagemCavaDTO::new).toList();

		return ResponseEntity.status(HttpStatus.OK).body(cavas);
	}

}
