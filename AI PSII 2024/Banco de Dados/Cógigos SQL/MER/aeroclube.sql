-- Migrations will appear here as you chat with AI

create table Pessoa (
  id int primary key not null,
  matricula int unique not null,
  nome varchar(45) not null,
  endereco varchar(150) not null,
  data_nascimento date not null
);

create table Piloto (
  id int primary key not null,
  Pessoa_id int not null references Pessoa (id),
  breve varchar(6) unique not null
);

create table Instrutor (
  id int primary key not null,
  Pessoa_id int not null references Pessoa (id),
  formacao_adicional varchar(250)
);

create table Aluno (
  id int primary key not null,
  Pessoa_id int not null references Pessoa (id)
);