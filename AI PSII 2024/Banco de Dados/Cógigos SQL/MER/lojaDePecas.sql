-- Migrations will appear here as you chat with AI

create table Cliente (
  id int primary key not null,
  cpf varchar(14) unique not null,
  nome varchar(45) not null,
  endereco varchar(150)
);

create table Fornecedor (
  id int primary key not null,
  codigo int unique not null,
  nome varchar(45) not null,
  endereco varchar(150),
  telefone varchar(16),
  tipo varchar(45) not null
);

create table Mercadoria (
  id int primary key not null,
  codigo int unique not null,
  descricao varchar(250) not null,
  preco decimal(10, 2) not null,
  quantidade_estoque int not null
);

create table Pedido (
  id int primary key not null,
  numero_nota_fiscal int unique not null,
  preco_total decimal(10, 2) not null,
  data datetime not null,
  Cliente_id int references Cliente (id)
);

create table Pedido_Mercadoria (
  Pedido_id int references Pedido (id),
  Mercadoria_id int references Mercadoria (id),
  quantidade int not null,
  primary key (Pedido_id, Mercadoria_id)
);