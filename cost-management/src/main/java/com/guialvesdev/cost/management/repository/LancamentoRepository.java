package com.guialvesdev.cost.management.repository;


import com.guialvesdev.cost.management.model.Lancamento;
import com.guialvesdev.cost.management.repository.lancamento.LancamentoRepositoryQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LancamentoRepository extends JpaRepository<Lancamento, Long>, LancamentoRepositoryQuery {
}
