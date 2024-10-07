package com.henriquekato.model;

import java.time.LocalDate;

public record ConsertoDTO(LocalDate dataEntrada, LocalDate dataSaida, VeiculoDTO veiculo, MecanicoDTO mecanico) {
}
