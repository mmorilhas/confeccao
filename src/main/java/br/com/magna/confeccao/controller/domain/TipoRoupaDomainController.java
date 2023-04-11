package br.com.magna.confeccao.controller.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.magna.confeccao.dto.domain.DadosListagemBarraDTO;
import br.com.magna.confeccao.dto.domain.DadosListagemTipoRoupaDTO;
import br.com.magna.confeccao.repository.BarraRepository;
import br.com.magna.confeccao.repository.TipoRoupaDomainRepository;

@RestController
@RequestMapping("tipos")
public class TipoRoupaDomainController {

	@Autowired
	TipoRoupaDomainRepository repository;

	@GetMapping
	public ResponseEntity<List<DadosListagemTipoRoupaDTO>> listar() {
		List<DadosListagemTipoRoupaDTO> tipoRoupas = repository.findAll().stream().map(DadosListagemTipoRoupaDTO::new).toList();

		return ResponseEntity.status(HttpStatus.OK).body(tipoRoupas);
	}

}