package br.com.magna.confeccao.controller.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.magna.confeccao.dto.domain.DadosListagemDecoteDTO;
import br.com.magna.confeccao.repository.DecoteDomainRepository;

@RestController
@RequestMapping("decotes")
public class DecoteDomainController {

	@Autowired
	DecoteDomainRepository repository;

	@GetMapping
	public ResponseEntity<List<DadosListagemDecoteDTO>> listar() {
		List<DadosListagemDecoteDTO> decotes = repository.findAll().stream().map(DadosListagemDecoteDTO::new).toList();

		return ResponseEntity.status(HttpStatus.OK).body(decotes);
	}

}
