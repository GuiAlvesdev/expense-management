package br.com.guialvesdev.api.gerency.money.repository;

import br.com.guialvesdev.api.gerency.money.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {


}
