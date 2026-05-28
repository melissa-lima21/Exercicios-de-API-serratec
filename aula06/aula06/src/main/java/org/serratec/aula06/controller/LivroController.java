package org.serratec.aula06.controller;

import java.util.List;

import org.serratec.aula06.domain.Livro;
import org.serratec.aula06.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    private LivroRepository livroRepository;

    @PostMapping
    public ResponseEntity<Livro> criar(@Valid @RequestBody Livro livro) {
        Livro livroSalvo = livroRepository.save(livro);
        return ResponseEntity.status(HttpStatus.CREATED).body(livroSalvo); 
    }
    @GetMapping
    public ResponseEntity<List<Livro>> listar() {
        List<Livro> lista = livroRepository.findAll();
        return ResponseEntity.ok(lista); 
    }
}
