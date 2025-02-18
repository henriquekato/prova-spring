# prova-spring

- api de consertos de carros

# tecnologias
- jwt e spring security
- banco de dados h2

# rotas

## login
- /login
  - usado para realizar login
  - retorna token jwt se bem sucedido

## conserto
- POST /conserto
  - criar um conserto
- GET /conserto
  - lista todos os consertos
- GET /conserto/{id}
  - mostra o conserto
- GET /conserto/principais
  - lista os consertos, apresentando apenas as principais informações (dataEntrada, dataSaida, nomeMecanico, marcaVeiculo, modeloVeiculo)
- PUT /conserto
  - edita o conserto
- DELETE /conserto/{id}
  - deleta o conserto
