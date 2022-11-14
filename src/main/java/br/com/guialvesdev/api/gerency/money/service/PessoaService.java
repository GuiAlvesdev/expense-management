package br.com.guialvesdev.api.gerency.money.service;


import br.com.guialvesdev.api.gerency.money.model.Pessoa;
import br.com.guialvesdev.api.gerency.money.repository.PessoaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;



    public Pessoa atualizar(Long codigo, Pessoa pessoa){
        Pessoa pessoaSalva = pessoaRepository.findOne(codigo);
        if (pessoaSalva == null){
            throw  new EmptyResultDataAccessException(1);
        }
        BeanUtils.copyProperties(pessoa, pessoaSalva, "codigo");
        return pessoaRepository.save(pessoaSalva);

    }






}
