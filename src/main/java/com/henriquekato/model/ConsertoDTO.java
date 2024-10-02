package com.henriquekato.model;

import java.time.LocalDate;

public record ConsertoDTO(LocalDate dataEntrada, LocalDate dataSaida, Veiculo veiculo, Mecanico mecanico) {
}
