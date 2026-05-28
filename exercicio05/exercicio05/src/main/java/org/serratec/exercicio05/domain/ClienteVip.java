package org.serratec.exercicio05.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class ClienteVip extends Cliente {

   
    @Column(name = "consultor")
    private String consultor;

    public ClienteVip() {
        super();
    }

    public ClienteVip(String consultor) {
		super();
		this.consultor = consultor;
	}

	public String getConsultor() {
        return consultor;
    }

    public void setConsultor(String consultor) {
        this.consultor = consultor; 
    }
}
