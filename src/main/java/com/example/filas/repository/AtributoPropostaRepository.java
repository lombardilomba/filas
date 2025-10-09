package com.example.filas.repository;

import com.example.filas.domain.AtributoProposta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AtributoPropostaRepository extends JpaRepository<AtributoProposta, Long> {
}
