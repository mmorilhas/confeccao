package br.com.magna.confeccao.controller.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.magna.confeccao.dto.domain.DadosListagemDecoteDTO;
import br.com.magna.confeccao.repository.domain.DecoteDomainRepository;

@RestController
@RequestMapping("decotes")
public class DecoteDomainController {

	@Autowired
	DecoteDomainRepository repository;

	@GetMapping
	public ResponseEntity<Page<DadosListagemDecoteDTO>> listar(@PageableDefault(size = 10, sort = { "id" }) Pageable paginacao) {
		return ResponseEntity.ok(repository.findAll(paginacao).map(DadosListagemDecoteDTO::new)) ;
	}

}
