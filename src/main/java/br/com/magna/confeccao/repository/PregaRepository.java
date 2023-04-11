package br.com.magna.confeccao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.magna.confeccao.entities.domain.modelagem.PregaDomain;

public interface PregaRepository extends JpaRepository<PregaDomain, Long>{

}
