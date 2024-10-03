create database db_cad_lucas;
use db_cad_lucas;

create table produto (
	cod int primary key auto_increment,
    descricao varchar(150) not null,
    unidade varchar(45) not null,
    qtd decimal(10, 2) not null,
    preco decimal(10, 2) not null
);