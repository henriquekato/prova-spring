package com.henriquekato.model;

import jakarta.persistence.*;
import lombok.*;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Mecanico {
    private String nome;
    private int anosExperiencia;

    public Mecanico(MecanicoDTO mecanicoDTO){
        nome = mecanicoDTO.nome();
        anosExperiencia = mecanicoDTO.anosExperiencia();
    }
}
