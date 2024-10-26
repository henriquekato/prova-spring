package com.henriquekato.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record VeiculoDTO(
        @NotBlank
        String marca,
        @NotBlank
        String modelo,
        @NotNull @Pattern(regexp = "^(\\d){4}$")
        String ano,
        String cor
) {
    public VeiculoDTO(Veiculo veiculo) {
        this(veiculo.getMarca(), veiculo.getModelo(), veiculo.getAno(), veiculo.getCor());
    }
}
