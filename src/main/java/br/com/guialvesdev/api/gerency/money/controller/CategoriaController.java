package br.com.guialvesdev.api.gerency.money.controller;


import br.com.guialvesdev.api.gerency.money.model.Categoria;
import br.com.guialvesdev.api.gerency.money.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaRepository categoriaRepository;



    @GetMapping
    public List<Categoria> listar(){
        return categoriaRepository.findAll();

    }


    @PostMapping
    public ResponseEntity<Categoria> criar (@Valid @RequestBody Categoria categoria, HttpServletResponse response) {
        Categoria categoriaSalva = categoriaRepository.save(categoria);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{codigo}")
                .buildAndExpand(categoriaSalva.getCodigo()).toUri();
        response.setHeader("Location", uri.toASCIIString());

        return ResponseEntity.created(uri).body(categoriaSalva);

    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Categoria> buscarPeloCodigo(@PathVariable  Long codigo){
        Categoria categoria = categoriaRepository.getReferenceById(codigo);
        return categoria != null ? ResponseEntity.ok(categoria) : ResponseEntity.notFound().build();
    }


}