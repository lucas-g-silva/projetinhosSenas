-- Migrations will appear here as you chat with AI

create table Cleinte (
  id int primary key not null,
  cpf varchar(14) unique not null,
  nome varchar(45) not null,
  telefone varchar(16) not null,
  sexo char not null
);

create table Quarto (
  id int primary key not null,
  numero int unique not null,
  andar int not null,
  tipo varchar(45) not null,
  descricao varchar(250),
  preco decimal(10, 2) not null
);

create table Reserva (
  id int primary key not null,
  Cleinte_id int references Cleinte (id),
  Quarto_id int references Quarto (id),
  data_entrada date not null,
  data_saida date not null
);

create table Ocupacao (
  id int primary key not null,
  reserva_id int references Reserva (id),
  data_entrada date not null,
  data_saida date not null
);

create table Servico (
  id int primary key not null,
  nome varchar(45) not null,
  descricao varchar(250),
  preco decimal(10, 2) not null
);

create table solicitacao_Servico (
  id int primary key not null,
  Cleinte_id int references Cleinte (id),
  Quarto_id int references Quarto (id),
  Servico_id int references Servico (id),
  data_solicitacao datetime
);