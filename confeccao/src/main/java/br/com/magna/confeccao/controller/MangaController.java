package br.com.magna.confeccao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.magna.confeccao.dto.DadosListagemMangaDTO;
import br.com.magna.confeccao.repository.MangaRepository;

@RestController
@RequestMapping("mangas")
public class MangaController {

	@Autowired
	MangaRepository repository;

	@GetMapping
	public ResponseEntity listar() {
		List<DadosListagemMangaDTO> cavas = repository.findAll().stream().map(DadosListagemMangaDTO::new).toList();

		return ResponseEntity.status(HttpStatus.OK).body(cavas);
	}

}
