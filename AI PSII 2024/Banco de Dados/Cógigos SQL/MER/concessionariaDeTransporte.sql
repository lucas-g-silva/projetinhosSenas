-- Migrations will appear here as you chat with AI

create table Montadora (
  id int primary key not null,
  nome varchar(45) not null
);

create table Carro (
  id int primary key not null,
  marca_id int references Montadora (id),
  numero_chassi varchar(17) not null unique,
  placa varchar(7) not null unique,
  modelo varchar(45) not null,
  ano int not null,
  cor varchar(45) not null
);

create table Cliente (
  id int primary key not null,
  nome varchar(45) not null,
  cpf varchar(14) not null unique,
  telefone varchar(16)
);

create table Vendedor (
  id int primary key not null,
  cpf varchar(14) not null unique,
  nome varchar(45) not null,
  data_contratacao date not null,
  anos_experiencia int not null,
  telefone varchar(16)
);

create table Venda (
  id int primary key not null,
  Cliente_id int references Cliente (id),
  Vendedor_id int references Vendedor (id),
  numero_nota_fiscal int not null unique,
  valor_total decimal(10, 2) not null,
  forma_pagamento varchar(45) not null,
  Carro_id int references Carro (id),
  data_venda date not null
);