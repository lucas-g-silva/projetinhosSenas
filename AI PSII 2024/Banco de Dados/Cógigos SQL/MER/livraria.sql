-- Migrations will appear here as you chat with AI

create table Livro (
  id int primary key not null,
  codigo int not null unique,
  nome varchar(45) not null,
  lingua varchar(20) not null,
  ano_publicacao int not null
);

create table Autor (
  id int primary key not null,
  nome varchar(45) not null,
  data_nascimento date not null,
  pais_origem varchar(45) not null,
  biografia varchar(250)
);

create table Editora (
  id int primary key not null,
  nome varchar(45) not null,
  endereco varchar(200) not null,
  telefone varchar(16) not null
);

create table Edicao (
  isbn varchar(17) not null unique primary key,
  Livro_id int references Livro (id),
  Editora_id int references Editora (id),
  preco decimal(10, 2) not null,
  ano_publicacao int not null,
  numero_paginas int not null,
  quantidade_estoque int not null
);

create table Livro_Autor (
  Livro_id int references Livro (id),
  Autor_id int references Autor (id),
  primary key (Livro_id, Autor_id)
);