package org.serratec.aula06.controller;

import java.util.List;
import java.util.Optional;

import org.serratec.aula06.domain.Editora;
import org.serratec.aula06.repository.EditoraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/editoras")
public class EditoraController {

    @Autowired
    private EditoraRepository editoraRepository;
    
    @PostMapping
    public ResponseEntity<Editora> criar(@Valid @RequestBody Editora editora) {
        Editora editoraSalva = editoraRepository.save(editora);
        return ResponseEntity.status(HttpStatus.CREATED).body(editoraSalva); 
    }
   
    @GetMapping
    public ResponseEntity<List<Editora>> listar() {
        List<Editora> lista = editoraRepository.findAll();
        return ResponseEntity.ok(lista); 
    }
    @GetMapping("/{id}")
    public ResponseEntity<Editora> buscar(@PathVariable Long id) {
        Optional<Editora> editora = editoraRepository.findById(id);
        
        if (editora.isPresent()) {
            return ResponseEntity.ok(editora.get());
        }
        
        return ResponseEntity.notFound().build();
    }
}

