package com.henriquekato.model.conserto;

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
    private String ano;
    private String cor;

    public Veiculo(VeiculoDTO veiculoDTO){
        marca = veiculoDTO.marca();
        modelo = veiculoDTO.modelo();
        ano = veiculoDTO.ano();
        cor = veiculoDTO.cor();
    }
}
