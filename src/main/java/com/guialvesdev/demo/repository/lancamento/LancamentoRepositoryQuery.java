package com.guialvesdev.demo.repository.lancamento;

import com.guialvesdev.demo.model.Lancamento;
import com.guialvesdev.demo.repository.filter.LancamentoFilter;
import com.guialvesdev.demo.repository.projecao.ResumoLancamento;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface LancamentoRepositoryQuery {

    public Page<Lancamento> filtrar(LancamentoFilter lancamentoFilter, Pageable pageable);
    public Page<ResumoLancamento> resumir(LancamentoFilter lancamentoFilter, Pageable pageable);
}
