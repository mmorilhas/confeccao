package br.com.magna.confeccao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.magna.confeccao.dto.DadosListagemDecoteDTO;
import br.com.magna.confeccao.dto.DadosListagemFechamentoDTO;
import br.com.magna.confeccao.repository.DecoteRepository;
import br.com.magna.confeccao.repository.FechamentoRepository;

@RestController
@RequestMapping("fechamentos")
public class FechamentoController {

	@Autowired
	FechamentoRepository repository;

	@GetMapping
	public ResponseEntity listar() {
		List<DadosListagemFechamentoDTO> fechamentos = repository.findAll().stream().map(DadosListagemFechamentoDTO::new).toList();

		return ResponseEntity.status(HttpStatus.OK).body(fechamentos);
	}

}
