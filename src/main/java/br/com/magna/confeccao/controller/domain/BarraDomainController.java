package br.com.magna.confeccao.controller.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.magna.confeccao.dto.domain.DadosListagemBarraDTO;
import br.com.magna.confeccao.repository.BarraRepository;

@RestController
@RequestMapping("barras")
public class BarraDomainController {

	@Autowired
	BarraRepository repository;

	@GetMapping
	public ResponseEntity<List<DadosListagemBarraDTO>> listar() {
		List<DadosListagemBarraDTO> barras = repository.findAll().stream().map(DadosListagemBarraDTO::new).toList();

		return ResponseEntity.status(HttpStatus.OK).body(barras);
	}

}