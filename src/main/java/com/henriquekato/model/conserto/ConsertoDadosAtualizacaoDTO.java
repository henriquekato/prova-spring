package com.henriquekato.model.conserto;

import jakarta.validation.constraints.Pattern;

public record ConsertoDadosAtualizacaoDTO(
        long id,
        @Pattern(regexp = "^(\\d{2}/){2}(\\d){4}$")
        String dataSaida,
        String nomeMecanico,
        int anosExperiencia
) { }
