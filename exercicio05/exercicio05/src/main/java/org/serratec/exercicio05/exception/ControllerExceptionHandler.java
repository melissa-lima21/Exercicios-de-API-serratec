package org.serratec.exercicio05.exception;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
            HttpHeaders headers, HttpStatusCode status, WebRequest request) {

        List<String> erros = new ArrayList<>();
        
        for (FieldError f : ex.getBindingResult().getFieldErrors()) {
            erros.add(f.getField() + ": " + f.getDefaultMessage());
        }

        RespostaErro respostaErro = new RespostaErro(
                status.value(),
                "Erro de validação: verifique se todos os campos foram preenchidos corretamente.",
                LocalDateTime.now(),
                erros
        );

        return ResponseEntity.status(status).body(respostaErro);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
            HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        
        String mensagemCustomizada = "Erro: verifique se os campos foram preenchidos corretamente.";
        
        Throwable causaErro = ex.getCause();
        while (causaErro != null) {
            if (causaErro instanceof EnumValidationException) {
                mensagemCustomizada = causaErro.getMessage();
                break;
            }
            causaErro = causaErro.getCause();
        }

        RespostaErro respostaErro = new RespostaErro(
                HttpStatus.BAD_REQUEST.value(), 
                mensagemCustomizada,
                LocalDateTime.now(),
                new ArrayList<>() 
        );

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(respostaErro);
    }
    @ExceptionHandler(RecursoNaoEncontradoException.class)
    public ResponseEntity<RespostaErro> handleRecursoNaoEncontrado(RecursoNaoEncontradoException ex) {
        
        RespostaErro erro = new RespostaErro(
                404, 
                ex.getMessage(),
                LocalDateTime.now(),
                new ArrayList<>()
        );

        return ResponseEntity.status(404).body(erro);
    }
    
    @ExceptionHandler(EnumValidationException.class)
    public ResponseEntity<RespostaErro> handleEnumValidationException(EnumValidationException ex) {
        RespostaErro erro = new RespostaErro(
                HttpStatus.BAD_REQUEST.value(),
                ex.getMessage(),
                LocalDateTime.now(),
                new ArrayList<>()
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
    }
}