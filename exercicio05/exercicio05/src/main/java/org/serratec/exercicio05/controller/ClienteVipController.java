package org.serratec.exercicio05.controller;

import java.util.List;
import java.util.Optional;

import org.serratec.exercicio05.domain.ClienteVip;
import org.serratec.exercicio05.repository.ClienteVipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/clientes-vip")
public class ClienteVipController {

	@Autowired
	private ClienteVipRepository clienteVipRepository;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ClienteVip inserir(@Valid @RequestBody ClienteVip clienteVip) { 
	    return clienteVipRepository.save(clienteVip);
	}
	
	@GetMapping
	public ResponseEntity<List<ClienteVip>> listar() {
		List<ClienteVip> clientes = clienteVipRepository.findAll();
		return ResponseEntity.ok(clientes);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ClienteVip> buscar(@PathVariable Long id) {
		Optional<ClienteVip> clienteVip = clienteVipRepository.findById(id);
		
		if(clienteVip.isPresent()) {
			return ResponseEntity.ok(clienteVip.get());
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ClienteVip> atualizar(@PathVariable Long id, @RequestBody ClienteVip clienteVip) {
		if (!clienteVipRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		
		clienteVip.setId(id); 
		ClienteVip clienteAtualizado = clienteVipRepository.save(clienteVip);
		
		return ResponseEntity.ok(clienteAtualizado);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id) {
		if (!clienteVipRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		
		clienteVipRepository.deleteById(id);
		return ResponseEntity.noContent().build(); 
	}
}
