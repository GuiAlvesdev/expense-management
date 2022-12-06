package com.guialvesdev.demo.repository;

import com.guialvesdev.demo.model.Lancamento;
import com.guialvesdev.demo.repository.lancamento.LancamentoRepositoryQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LancamentoRepository extends JpaRepository<Lancamento, Long>, LancamentoRepositoryQuery {

}
