CREATE DATABASE springdb;
USE springdb;

CREATE TABLE produto (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    descricao VARCHAR(255),
    preco DOUBLE
);

CREATE TABLE pedido (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    data_pedido DATE,
    produto_id BIGINT,
    CONSTRAINT FK_produto_pedido FOREIGN KEY (produto_id) REFERENCES produto(id)
);