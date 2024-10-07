package com.henriquekato.model;

import jakarta.persistence.*;
import lombok.*;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Veiculo {
    private String marca;
    private String modelo;
    private int ano;

    public Veiculo(VeiculoDTO veiculoDTO){
        marca = veiculoDTO.marca();
        modelo = veiculoDTO.modelo();
        ano = veiculoDTO.ano();
    }
}
