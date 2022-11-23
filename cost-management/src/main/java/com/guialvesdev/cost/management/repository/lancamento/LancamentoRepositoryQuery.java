package com.guialvesdev.cost.management.repository.lancamento;

import com.guialvesdev.cost.management.model.Lancamento;
import com.guialvesdev.cost.management.repository.filter.LancamentoFilter;
import com.guialvesdev.cost.management.repository.projection.ResumoLancamento;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface LancamentoRepositoryQuery {

    public Page<Lancamento> filtrar(LancamentoFilter lancamentoFilter, Pageable pageable);
    public Page<ResumoLancamento> resumir(LancamentoFilter lancamentoFilter, Pageable pageable);


}
