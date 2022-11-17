package br.com.guialvesdev.api.gerency.money.service;


import br.com.guialvesdev.api.gerency.money.model.Lancamento;
import br.com.guialvesdev.api.gerency.money.model.Pessoa;
import br.com.guialvesdev.api.gerency.money.event.repository.LancamentoRepository;
import br.com.guialvesdev.api.gerency.money.event.repository.PessoaRepository;
import br.com.guialvesdev.api.gerency.money.service.exception.PessoaInexistenteOuInativaException;
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
