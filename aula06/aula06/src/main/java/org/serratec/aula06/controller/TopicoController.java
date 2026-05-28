package org.serratec.aula06.controller;

import java.util.List;

import org.serratec.aula06.domain.Topico;
import org.serratec.aula06.repository.TopicoRepository;
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
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;

    @PostMapping
    public ResponseEntity<Topico> criar(@Valid @RequestBody Topico topico) {
        return ResponseEntity.status(HttpStatus.CREATED).body(topicoRepository.save(topico));
    }

    @GetMapping
    public List<Topico> listar() {
        return topicoRepository.findAll();
    }
}
