package br.com.magna.confeccao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.magna.confeccao.domain.fibra.Fibra;
import br.com.magna.confeccao.domain.roupa.Roupa;

public interface FibraRepository extends JpaRepository<Fibra, Long>{

}
