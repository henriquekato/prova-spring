package com.henriquekato.model.conserto;

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
    private long id;
    private String dataEntrada;
    private String dataSaida;
    @Embedded
    private Veiculo veiculo;
    @Embedded
    private Mecanico mecanico;
    private boolean ativo;

    public Conserto(ConsertoCadastroDTO conserto) {
        dataEntrada = conserto.dataEntrada();
        dataSaida = conserto.dataSaida();
        veiculo = new Veiculo(conserto.veiculo());
        mecanico = new Mecanico(conserto.mecanico());
        ativo = true;
    }

    public void atualizarDados(ConsertoDadosAtualizacaoDTO dados){
        if (dados.dataSaida() != null) this.dataSaida = dados.dataSaida();
        if (dados.nomeMecanico() != null) this.mecanico.setNome(dados.nomeMecanico());
        if (dados.anosExperiencia() > 0) this.mecanico.setAnosExperiencia(dados.anosExperiencia());
    }

    public void excluir(){
        ativo = false;
    }
}
