package br.com.magna.confeccao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.magna.confeccao.dto.DadosAtualizaRoupaDTO;
import br.com.magna.confeccao.dto.DadosCadastroRoupaDTO;
import br.com.magna.confeccao.dto.DadosDetalhamentoRoupaDTO;
import br.com.magna.confeccao.dto.domain.DadosListagemRoupaDTO;
import br.com.magna.confeccao.entities.roupa.Roupa;
import br.com.magna.confeccao.service.RoupaService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("confeccao")
public class RoupaController {

	@Autowired
	private RoupaService roupaService;

	@PostMapping
	@Transactional
	public ResponseEntity<Roupa> cadastrar(@RequestBody @Valid DadosCadastroRoupaDTO dados) {
		roupaService.criarRoupaECadastrar(dados);
		return ResponseEntity.status(HttpStatus.CREATED).build();
		
	}


	@GetMapping(value = "/listagem")
	public ResponseEntity<Page<DadosListagemRoupaDTO>> listar(
			@PageableDefault(size = 3, sort = { "id", "nome", "tamanho" }) Pageable paginacao) {

		return ResponseEntity.ok(roupaService.listar(paginacao));
	}

	@PutMapping(value = "/atualizar")
	@Transactional
	public ResponseEntity<DadosDetalhamentoRoupaDTO> atualizar(@RequestBody @Valid DadosAtualizaRoupaDTO dados) {
		return ResponseEntity.ok(roupaService.atualizar(dados));
	}

	@GetMapping(value = "/listagem/{id}")
	public ResponseEntity<DadosDetalhamentoRoupaDTO> buscarPorId(@PathVariable Long id) {
		return ResponseEntity.ok(roupaService.detalharPorId(id));
	}
	

	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<Roupa> deletar(@PathVariable Long id) {
		roupaService.tornarInativo(id);
		return ResponseEntity.noContent().build();
	}

}
