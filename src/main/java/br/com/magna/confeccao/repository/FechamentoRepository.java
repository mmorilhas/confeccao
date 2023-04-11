package br.com.magna.confeccao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.magna.confeccao.entities.domain.modelagem.FechamentoDomain;

public interface FechamentoRepository extends JpaRepository<FechamentoDomain, Long>{

}