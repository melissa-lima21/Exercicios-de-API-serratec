package org.serratec.exercicio05.exception; 

import java.time.LocalDateTime;
import java.util.List;

public class RespostaErro {
    private Integer status;
    private String titulo;
    private LocalDateTime dataHora;
    private List<String> erros;

    public RespostaErro(Integer status, String titulo, LocalDateTime dataHora, List<String> erros) {
        this.status = status;
        this.titulo = titulo;
        this.dataHora = dataHora;
        this.erros = erros;
    }

    public Integer getStatus() {
        return status;
    }
    
    public String getTitulo() { 
        return titulo; 
    }
    
    public LocalDateTime getDataHora() {
        return dataHora; 
    }
    
    public List<String> getErros() {
        return erros; 
    }
}