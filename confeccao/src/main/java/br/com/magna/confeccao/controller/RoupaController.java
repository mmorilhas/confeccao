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

import br.com.magna.confeccao.domain.roupa.DadosAtualizaRoupa;
import br.com.magna.confeccao.domain.roupa.DadosCadastroRoupa;
import br.com.magna.confeccao.domain.roupa.DadosListagemRoupa;
import br.com.magna.confeccao.domain.roupa.RoupaService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("confeccao")
public class RoupaController {

	@Autowired
	private RoupaService roupaService;

	@PostMapping
	@Transactional
	public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroRoupa dados) {
		roupaService.criarRoupa(dados);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	
	/*
	 * @GetMapping public ResponseEntity listar() {
	 * 
	 * return ResponseEntity.status(HttpStatus.OK).body(roupaService.listagem()); }
	 */

	
	  @GetMapping public ResponseEntity<Page<DadosListagemRoupa>> listar(@PageableDefault (size = 3, sort = {"id", "nome", "tamanho"}) Pageable
	  paginacao) {
	  
	  return ResponseEntity.ok(roupaService.listar(paginacao)); 
	  }
	 

	@PutMapping
	@Transactional
	public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizaRoupa dados) {
		return ResponseEntity.ok(roupaService.atualizar(dados));
	}

	@GetMapping("/{id}")
	public ResponseEntity buscarPorId(@PathVariable Long id) {
		return ResponseEntity.ok(roupaService.detalharPorId(id));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity deletar(@PathVariable Long id) {
		roupaService.deletar(id);
		return ResponseEntity.noContent().build();
	}

}
