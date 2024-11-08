package com.henriquekato.util;

import org.springframework.validation.FieldError;

public record DadosErrosValidacao(String campo, String msgErro){
    public DadosErrosValidacao(FieldError erro){
        this(erro.getField(), erro.getDefaultMessage());
    }
}
