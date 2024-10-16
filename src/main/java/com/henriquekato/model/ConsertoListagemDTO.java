package com.henriquekato.model;

public record ConsertoListagemDTO(
        String dataEntrada,
        String dataSaida,
        String nomeMecanico,
        String marcaVeiculo,
        String modeloVeiculo
) {
    public ConsertoListagemDTO(Conserto conserto){
        this(
            conserto.getDataEntrada(),
            conserto.getDataSaida(),
            conserto.getMecanico().getNome(),
            conserto.getVeiculo().getMarca(),
            conserto.getVeiculo().getModelo()
        );
    }
}
