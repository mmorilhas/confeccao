package br.com.magna.confeccao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.magna.confeccao.entities.domain.fibra.FibraDomain;

public interface FibraRepository extends JpaRepository<FibraDomain, Long>{

}