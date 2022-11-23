package com.guialvesdev.cost.management.repository;

import com.guialvesdev.cost.management.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}
