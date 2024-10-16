package com.henriquekato.model;

import jakarta.validation.constraints.NotBlank;

public record MecanicoDTO(
        @NotBlank
        String nome,
        int anosExperiencia
) { }