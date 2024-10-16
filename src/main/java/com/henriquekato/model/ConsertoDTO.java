package com.henriquekato.model;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record ConsertoDTO(
        @NotBlank
        @Pattern(regexp = "^(\\d{2}/){2}(\\d){4}$")
        String dataEntrada,
        @NotBlank
        @Pattern(regexp = "^(\\d{2}/){2}(\\d){4}$")
        String dataSaida,
        @NotNull
        @Valid
        VeiculoDTO veiculo,
        @NotNull
        @Valid
        MecanicoDTO mecanico
) { }
