package com.guialvesdev.cost.management.repository;


import com.guialvesdev.cost.management.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository  extends JpaRepository<Categoria, Long> {



}
