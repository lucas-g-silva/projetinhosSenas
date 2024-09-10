-- Migrations will appear here as you chat with AI
create table Sala (
  id int primary key not null,
  nome varchar(45) not null,
  capacidade int not null
);

create table Filme (
  id int primary key not null,
  nome varchar(45) not null,
  diretor varchar(45) not null,
  ano_lancamento int not null,
  tipo varchar(45) not null
);

create table Funcionario (
  id int primary key not null,
  numero_carteira_trabalho int not null unique,
  nome varchar(45) not null,
  data_admissao date not null,
  funcao varchar(45) not null
);

create table Sessao (
  id int primary key not null,
  Sala_id int not null references Sala (id),
  Filme_id int not null references Filme (id),
  horario time not null
);