package com.henriquekato.util;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class TratadorErros {
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Void> tratarErro404(){
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<DadosErrosValidacao>> tratarErro400(MethodArgumentNotValidException e){
        var erros = e.getFieldErrors();
        var lista = erros.stream().map(DadosErrosValidacao::new).toList();
        return ResponseEntity.badRequest().body(lista);
    }
}
