package br.com.magna.confeccao.domain.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.magna.confeccao.domain.roupa.partecima.DadosCadastroParteDeCima;
import br.com.magna.confeccao.domain.roupa.partecima.ParteCimaService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("confeccao")
public class ParteDeCimaController {

	
	@Autowired private ParteCimaService parteCimaService;
	
	@PostMapping
	@Transactional
	public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroParteDeCima dados) {
		parteCimaService.criarParteDeCima(dados);
		return ResponseEntity.status(HttpStatus.CREATED).build();
		
	}
	
	
	@GetMapping
	public ResponseEntity listar(){
		return ResponseEntity.status(HttpStatus.OK).body(parteCimaService.listagem());
	}
}
