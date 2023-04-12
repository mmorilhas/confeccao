package br.com.magna.confeccao.controller.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.magna.confeccao.dto.domain.DadosListagemSilhuetaDTO;
import br.com.magna.confeccao.repository.SilhuetaDomainRepository;

@RestController
@RequestMapping("silhuetas")
public class SilhuetaDomainController {

	@Autowired
	SilhuetaDomainRepository repository;

	@GetMapping
	public ResponseEntity<List<DadosListagemSilhuetaDTO>> listar() {
		List<DadosListagemSilhuetaDTO> silhuetas = repository.findAll().stream().map(DadosListagemSilhuetaDTO::new).toList();

		return ResponseEntity.status(HttpStatus.OK).body(silhuetas);
	}

}
