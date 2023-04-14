package br.com.magna.confeccao.controller.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.magna.confeccao.dto.domain.DadosListagemMangaDTO;
import br.com.magna.confeccao.repository.domain.MangaDomainRepository;

@RestController
@RequestMapping("mangas")
public class MangaDomainController {

	@Autowired
	MangaDomainRepository repository;

	@GetMapping
	public ResponseEntity<List<DadosListagemMangaDTO>> listar() {
		List<DadosListagemMangaDTO> cavas = repository.findAll().stream().map(DadosListagemMangaDTO::new).toList();

		return ResponseEntity.status(HttpStatus.OK).body(cavas);
	}

}
