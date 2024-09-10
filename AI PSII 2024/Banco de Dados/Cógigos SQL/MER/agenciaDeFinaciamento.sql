-- Migrations will appear here as you chat with AI

create table Projeto (
  id int primary key not null,
  rotulo varchar(45) not null,
  duracao int not null,
  instituicao varchar(45) not null,
  area_pesquisa varchar(45) not null
);

create table Pesquisador (
  id int primary key not null,
  cpf varchar(14) unique not null,
  nome varchar(45) not null,
  sexo char not null,
  data_nascimento date not null,
  grau_cientifico varchar(45) not null
);

create table Acessor (
  id int primary key not null,
  nome varchar(45) not null
);

create table Projeto_Pesquisador (
  id int primary key not null,
  Projeto_id int references Projeto (id),
  Pesquisador_id int references Pesquisador (id)
);

create table avaliacao (
  id int primary key not null,
  Projeto_id int references Projeto (id),
  Acessor_id int references Acessor (id),
  data_envio date not null,
  data_resposta date,
  resultado varchar(100)
);