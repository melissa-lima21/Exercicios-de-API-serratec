package org.serratec.exercicio05.domain;

import org.serratec.exercicio05.enumerated.TipoCliente;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.validation.constraints.NotNull;



@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Cliente {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private String nome;

	@Column
	private String email;
	
	@NotNull(message = "Por favor, preencha o campo Tipo Cliente.")
	@Enumerated(EnumType.STRING)
	@Column(name = "tipo_cliente")
	private TipoCliente tipoCliente;

	public Cliente() {
		super();

	}

	public Cliente(Long id, String nome, String email) {
	super();
	this.id = id;
	this.nome = nome;
	this.email = email;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public TipoCliente getTipoCliente() { 
		return tipoCliente;
	}

	public void setTipoCliente(TipoCliente tipoCliente) { 
		this.tipoCliente = tipoCliente;
	}
	
}


