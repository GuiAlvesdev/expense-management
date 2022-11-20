package br.com.guialvesdev.api.gerency.money.repository;

import br.com.guialvesdev.api.gerency.money.model.Lancamento;
import br.com.guialvesdev.api.gerency.money.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LancamentoRepository extends JpaRepository<Lancamento, Long>, LancamentoRepositoryQuery  {


}
