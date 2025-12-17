package com.example.filas.repository;

import com.example.filas.domain.PropostaEntity;
import com.example.filas.proposta.Proposta;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PropostaRepository extends JpaRepository<PropostaEntity, Long>, JpaSpecificationExecutor<PropostaEntity> {

    List<PropostaEntity> findAll(Specification<PropostaEntity> spec);
}
