create database db_cad_lucas;
use db_cad_lucas;

create table produto (
	cod int primary key auto_increment,
    descricao varchar(150) not null,
    unidade varchar(45) not null,
    qtd decimal(10, 2) not null,
    preco decimal(10, 2) not null
);

create table cliente (
	cod int primary key auto_increment,
	nome varchar(250) not null,
    fone varchar(16) not null,
    email varchar(250) not null,
    endereco varchar(250) not null
);

create table fornecedor (
	cod int primary key auto_increment,
    contato varchar(250) not null,
    email varchar(250) not null,
    fone varchar(16) not null,
    empresa varchar(250) not null
);

INSERT INTO produto (descricao, unidade, qtd, preco) VALUES
('Caderno 100 folhas', 'unidade', 50, 12.99),
('Lápis HB', 'unidade', 200, 1.50),
('Borracha escolar', 'unidade', 150, 0.75),
('Caneta esferográfica azul', 'unidade', 120, 2.50),
('Tesoura escolar', 'unidade', 80, 6.99),
('Marcador de texto', 'unidade', 90, 3.20),
('Cola branca 200ml', 'unidade', 70, 4.99),
('Régua 30cm', 'unidade', 110, 3.00),
('Caderno de desenho', 'unidade', 40, 14.50),
('Apontador de lápis', 'unidade', 95, 1.75);

INSERT INTO cliente (nome, fone, email, endereco) VALUES
('Lucas Silva', '(47) 99999-1234', 'lucas.silva@example.com', 'Rua A, 123, Timbó, SC'),
('Ana Souza', '(47) 98888-2345', 'ana.souza@example.com', 'Rua B, 456, Blumenau, SC'),
('Carlos Pereira', '(47) 97777-3456', 'carlos.pereira@example.com', 'Rua C, 789, Indaial, SC'),
('Fernanda Costa', '(47) 96666-4567', 'fernanda.costa@example.com', 'Rua D, 101, Pomerode, SC'),
('Marcos Lima', '(47) 95555-5678', 'marcos.lima@example.com', 'Rua E, 202, Rio dos Cedros, SC'),
('Paula Santos', '(47) 94444-6789', 'paula.santos@example.com', 'Rua F, 303, Jaraguá do Sul, SC'),
('João Almeida', '(47) 93333-7890', 'joao.almeida@example.com', 'Rua G, 404, Brusque, SC'),
('Beatriz Nunes', '(47) 92222-8901', 'beatriz.nunes@example.com', 'Rua H, 505, Gaspar, SC'),
('Pedro Mendes', '(47) 91111-9012', 'pedro.mendes@example.com', 'Rua I, 606, Balneário Camboriú, SC'),
('Clara Martins', '(47) 90000-0123', 'clara.martins@example.com', 'Rua J, 707, Itajaí, SC');

INSERT INTO fornecedor (contato, email, fone, empresa) VALUES
('José Oliveira', 'jose.oliveira@fornecedora.com', '(47) 99988-0011', 'Fornecedora LTDA'),
('Maria Borges', 'maria.borges@distribuidora.com', '(47) 98877-1122', 'Distribuidora ABC'),
('Antônio Lopes', 'antonio.lopes@suprimentos.com', '(47) 97766-2233', 'Suprimentos & Cia'),
('Renata Silva', 'renata.silva@produtosbr.com', '(47) 96655-3344', 'Produtos BR'),
('Joaquim Souza', 'joaquim.souza@papelariaxyz.com', '(47) 95544-4455', 'Papelaria XYZ'),
('Sérgio Gonçalves', 'sergio.goncalves@officeplus.com', '(47) 94433-5566', 'Office Plus'),
('Amanda Costa', 'amanda.costa@maxsuprimentos.com', '(47) 93322-6677', 'Max Suprimentos'),
('Roberta Lima', 'roberta.lima@escritoriocentral.com', '(47) 92211-7788', 'Escritório Central'),
('Fábio Ribeiro', 'fabio.ribeiro@techfor.com', '(47) 91100-8899', 'Techfor'),
('Camila Martins', 'camila.martins@mercantilnova.com', '(47) 90099-9900', 'Mercantil Nova');
