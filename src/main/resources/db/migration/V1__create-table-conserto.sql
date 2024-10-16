create table conserto (
    id int not null primary key auto_increment,
    data_entrada varchar not null,
    data_saida varchar not null,
    marca varchar not null,
    modelo varchar not null,
    ano varchar not null,
    nome varchar not null,
    anos_experiencia int not null
)
