package br.com.guialvesdev.api.gerency.money.event.repository;

import br.com.guialvesdev.api.gerency.money.model.Lancamento;
import br.com.guialvesdev.api.gerency.money.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LancamentoRepository extends JpaRepository<Lancamento, Long> {


}
