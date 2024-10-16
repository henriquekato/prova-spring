package com.henriquekato.model;

import jakarta.persistence.*;
import lombok.*;

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
    private String dataEntrada;
    private String dataSaida;
    @Embedded
    private Veiculo veiculo;
    @Embedded
    private Mecanico mecanico;

    public Conserto(ConsertoDTO conserto) {
        dataEntrada = conserto.dataEntrada();
        dataSaida = conserto.dataSaida();
        veiculo = new Veiculo(conserto.veiculo());
        mecanico = new Mecanico(conserto.mecanico());
    }
}
