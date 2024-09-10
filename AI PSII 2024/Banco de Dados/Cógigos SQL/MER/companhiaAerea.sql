-- Migrations will appear here as you chat with AI

create table Passageiro (
  id int primary key not null,
  cpf varchar(14) unique not null,
  nome varchar(45) not null
);

create table Aviao (
  id int primary key not null,
  numero_serie int unique not null,
  modelo varchar(45) not null
);

create table Aeroporto (
  id int primary key not null,
  nome varchar(45) not null,
  cidade varchar(45) not null
);

create table Piloto (
  id int primary key not null,
  nome varchar(45) not null,
  licenca varchar(45) unique not null
);

create table Voo (
  id int primary key not null,
  numero int unique not null,
  aviao_id int not null references Aviao (id),
  piloto_id int not null references Piloto (id),
  aeroporto_partida_id int not null references Aeroporto (id),
  aeroporto_chegada_id int not null references Aeroporto (id)
);

create table Assento (
  id bigint primary key not null,
  numero int not null,
  voo_id bigint not null references Voo (id),
  passageiro_id bigint references Passageiro (id)
);