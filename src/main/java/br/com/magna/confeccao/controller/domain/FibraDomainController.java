package br.com.magna.confeccao.controller.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.magna.confeccao.dto.domain.DadosListagemFibraDTO;
import br.com.magna.confeccao.repository.FibraDomainRepository;

@RestController
@RequestMapping("fibras")
public class FibraDomainController {

	@Autowired
	private FibraDomainRepository repository;

	@GetMapping
	public ResponseEntity<List<DadosListagemFibraDTO>> listar() {
		List<DadosListagemFibraDTO> fibras = repository.findAll().stream().map(DadosListagemFibraDTO::new).toList();

		return ResponseEntity.status(HttpStatus.OK).body(fibras);
	}

}
