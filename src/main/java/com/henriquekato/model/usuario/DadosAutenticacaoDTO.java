package com.henriquekato.model.usuario;

import jakarta.validation.constraints.NotBlank;

public record DadosAutenticacaoDTO (
    @NotBlank
    String login,
    @NotBlank
    String senha) {}
