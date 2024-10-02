package com.henriquekato.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Conserto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate dataEntrada;
    private LocalDate dataSaida;
    @Embedded
    private Veiculo veiculo;
    @Embedded
    private Mecanico mecanico;

    public Conserto(ConsertoDTO conserto) {
        dataEntrada = conserto.dataEntrada();
        dataSaida = conserto.dataSaida();
        veiculo = conserto.veiculo();
        mecanico = conserto.mecanico();
    }
}
