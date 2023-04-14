package br.com.magna.confeccao.controller.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.magna.confeccao.dto.domain.DadosListagemComprimentoDTO;
import br.com.magna.confeccao.repository.domain.ComprimentoDomainRepository;
import jakarta.persistence.Cacheable;

@RestController
@RequestMapping("comprimentos")
public class ComprimentosDomainController {

	@Autowired
	ComprimentoDomainRepository repository;

	@GetMapping
	public ResponseEntity<List<DadosListagemComprimentoDTO>> listar() {
		List<DadosListagemComprimentoDTO> comprimentos = repository.findAll().stream().map(DadosListagemComprimentoDTO::new).toList();

		return ResponseEntity.status(HttpStatus.OK).body(comprimentos);
	}

}
