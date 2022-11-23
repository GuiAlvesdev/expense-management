package com.guialvesdev.cost.management.service;

import com.guialvesdev.cost.management.model.Lancamento;
import com.guialvesdev.cost.management.model.Pessoa;
import com.guialvesdev.cost.management.repository.LancamentoRepository;
import com.guialvesdev.cost.management.repository.PessoaRepository;
import com.guialvesdev.cost.management.service.exception.PessoaInexistenteOuInativaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LancamentoService {


    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private LancamentoRepository lancamentoRepository;

    public Lancamento salvar(Lancamento lancamento) {
        Optional<Pessoa> pessoa = pessoaRepository.findById(lancamento.getPessoa().getCodigo());
        if (pessoa.isEmpty() || pessoa.get().isInativo()) {
            throw new PessoaInexistenteOuInativaException();
        }

        return lancamentoRepository.save(lancamento);
    }


}
