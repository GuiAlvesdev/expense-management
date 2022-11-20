package br.com.guialvesdev.api.gerency.money.repository.lancamento;

import br.com.guialvesdev.api.gerency.money.model.Lancamento;
import br.com.guialvesdev.api.gerency.money.repository.LancamentoRepository;
import br.com.guialvesdev.api.gerency.money.repository.filter.LancamentoFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class LancamentoRepositoryImpl implements LancamentoRepositoryQuery {
    @Override
    public Page<Lancamento> filtrar(LancamentoFilter lancamentoFilter, Pageable pageable) {
        return null;
    }

    @Override
    public Page<ResumoLancamento> resumir(LancamentoFilter lancamentoFilter, Pageable pageable) {
        return null;
    }
}
