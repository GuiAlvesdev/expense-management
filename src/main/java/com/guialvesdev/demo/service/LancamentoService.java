package com.guialvesdev.demo.service;


import com.guialvesdev.demo.model.Lancamento;
import com.guialvesdev.demo.model.Pessoa;
import com.guialvesdev.demo.repository.LancamentoRepository;
import com.guialvesdev.demo.repository.PessoaRepository;
import com.guialvesdev.demo.service.exception.PessoaInexistenteOuInativaException;
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
