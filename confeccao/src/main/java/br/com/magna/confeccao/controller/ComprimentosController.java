package br.com.magna.confeccao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.magna.confeccao.dto.DadosListagemComprimentoDTO;
import br.com.magna.confeccao.dto.DadosListagemSilhuetaDTO;
import br.com.magna.confeccao.repository.ComprimentoRepository;
import br.com.magna.confeccao.repository.SilhuetaRepository;

@RestController
@RequestMapping("comprimentos")
public class ComprimentosController {

	@Autowired
	ComprimentoRepository repository;

	@GetMapping
	public ResponseEntity listar() {
		List<DadosListagemComprimentoDTO> comprimentos = repository.findAll().stream().map(DadosListagemComprimentoDTO::new).toList();

		return ResponseEntity.status(HttpStatus.OK).body(comprimentos);
	}

}
