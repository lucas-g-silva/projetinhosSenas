-- Migrations will appear here as you chat with AI

create table Categoria (
  id int primary key not null,
  nome varchar(45) not null,
  preco_diaria decimal(10, 2) not null,
  descricao varchar(250)
);

create table Usuario (
  id int primary key not null,
  cpf varchar(14) unique not null,
  nome varchar(45) not null,
  endereco varchar(150) not null,
  cnh varchar(11) unique not null,
  data_nascimento date not null
);

create table Carro (
  id int primary key not null,
  chassi varchar(17) unique not null,
  placa varchar(7) unique not null,
  marca varchar(45) not null,
  modelo varchar(45) not null,
  ano int not null,
  cor varchar(45) not null,
  Categoria_id int references Categoria (id)
);

create table Locacao (
  id int primary key not null,
  Usuario_id int references Usuario (id),
  Carro_id int references Carro (id),
  data_hora_inicio datetime not null
);