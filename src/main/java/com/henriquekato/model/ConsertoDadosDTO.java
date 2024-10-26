package com.henriquekato.model;

public record ConsertoDadosDTO (
        long id,
        String dataEntrada,
        String dataSaida,
        VeiculoDTO veiculo,
        MecanicoDTO mecanico,
        boolean ativo
    ){
        public ConsertoDadosDTO(Conserto conserto) {
            this(
                conserto.getId(),
                conserto.getDataEntrada(),
                conserto.getDataSaida(),
                new VeiculoDTO(conserto.getVeiculo()),
                new MecanicoDTO(conserto.getMecanico()),
                conserto.isAtivo()
            );
        }
}
