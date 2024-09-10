-- Migrations will appear here as you chat with AI

create table Instrutor (
  id int primary key not null,
  cpf varchar(14) unique not null,
  nome varchar(45) not null,
  data_nascimento date not null,
  titulacao varchar(45) not null,
  telefone varchar(16) not null
);

create table Aluno (
  id int primary key not null,
  codigo_matricula int unique not null,
  data_matricula date not null,
  nome varchar(45) not null,
  endereco varchar(150) not null,
  telefone varchar(16) not null,
  data_nascimento date not null,
  altura decimal(4, 2) not null,
  peso decimal(5, 2) not null
);

create table Turma (
  id int primary key not null,
  numero_alunos int not null,
  horario time not null,
  duracao time not null,
  data_inicio date not null,
  data_termino date not null,
  tipo_atividade varchar(45) not null,
  Instrutor_id int references Instrutor (id)
);

create table Aluno_Turma (
  Aluno_id int references Aluno (id),
  Turma_id int references Turma (id),
  primary key (Aluno_id, Turma_id)
);