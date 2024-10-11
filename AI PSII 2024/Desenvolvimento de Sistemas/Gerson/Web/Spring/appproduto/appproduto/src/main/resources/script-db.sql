create database dbProduto;
use dbProduto;

create table produto (
	id int auto_increment primary key,
    descricao varchar(255) not null,
    preco float not null
);

create table pedido(
	id int primary key auto_increment,
    data_pedido date not null,
    id_produto bigint not null
);