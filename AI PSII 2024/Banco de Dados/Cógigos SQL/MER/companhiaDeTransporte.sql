-- Migrations will appear here as you chat with AI

create table Armazem (
  id int primary key not null,
  numero int not null unique,
  endereco varchar(150) not null
);

create table Deposito (
  id int primary key not null,
  numero int not null unique,
  endereco varchar(150) not null
);

create table Caminhao (
  id int primary key not null,
  placa varchar(7) not null unique,
  capacidade_volume decimal not null,
  capacidade_peso decimal not null
);

create table Viagem (
  id int primary key not null,
  Caminhao_id int not null references Caminhao (id),
  origem_id int not null,
  destino_id int not null,
  data_partida datetime not null,
  data_chegada datetime,
  constraint origem_destino_check check (origem_id <> destino_id)
);

create table Remessa (
  id int primary key not null,
  Viagem_id int not null references Viagem (id),
  volume decimal not null,
  peso decimal not null
);