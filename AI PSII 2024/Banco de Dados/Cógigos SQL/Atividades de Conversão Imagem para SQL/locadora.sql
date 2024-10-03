create database bdlocadora;
use bdlocadora;

create table Cliente (
	idCliente int primary key auto_increment,
    nome varchar(45) not null,
    rua varchar(45) not null,
    complemento varchar(45) not null,
    bairro varchar(45) not null,
    cep varchar(9) not null,
    cidade varchar(45) not null,
    uf varchar(2) not null,
    telefone varchar(16) not null
);

create table Tipo_Pagamento (
	idTipo_Pagamento int primary key auto_increment,
    nome varchar(45) not null
);

create table Midia (
	idMidia int primary key auto_increment,
    nome varchar(45) not null,
    valorMidia decimal(10, 2) not null
);

create table Classificacao (
	idClassificacao int primary key auto_increment,
    nome varchar(45) not null,
    prazoDevolucao int not null, 
    valor decimal(10, 2) not null
);

create table Ator (
	idAtor int primary key auto_increment,
    nome varchar(45) not null
);

create table Status (
	idStatus int primary key auto_increment,
    nome varchar(45) not null
);

create table Categoria (
	idCategoria int primary key auto_increment,
    nome varchar(45) not null
);

create table Dependente (
	idDependente int primary key auto_increment,
    nome varchar(45) not null,
    idCliente int not null,
    constraint Dependente_idCliente_fk foreign key (idCliente) references Cliente (idCliente)
);

create table Locacao (
	idLocacao int primary key auto_increment,
    dataLocacao date not null,
    valorTotal decimal(10, 2) not null,
    idCliente int not null,
    idTipo_Pagamento int not null,
    idDependente int,
    constraint Locacao_idCliente_fk foreign key (idCliente) references Cliente (idCliente),
    constraint Locacao_idTipo_Pagamento foreign key (idTipo_Pagamento) references Tipo_Pagamento (idTipo_Pagamento),
    constraint Locacao_idDependente foreign key (idDependente) references Dependente (idDependente)
);

create table Filme (
	idFilme int primary key auto_increment,
    nome varchar(45) not null,
    sinopse varchar(45) not null,
    duracao int not null,
    idClassificacao int not null,
    idCategoria int not null,
    constraint Filme_idClassificacao_fk foreign key (idClassificacao) references Classificacao (idClassificacao),
    constraint Filme_idCategoria_fk foreign key (idCategoria) references Categoria (idCategoria)
);

create table Exemplar (
	idExemplar int primary key auto_increment,
    idFilme int not null,
    idMidia int not null,
    idStatus int not null,
    constraint Exemplar_idFilme_fk foreign key (idFilme) references Filme (idFilme),
    constraint Exemplar_idMidia_fk foreign key (idMidia) references Midia (idMidia),
    constraint Exemplar_idStatus_fk foreign key (idStatus) references Status (idStatus)
);

create table Reserva (
	idReserva int primary key auto_increment,
    idExemplar int not null,
    dataReserva date not null,
    idCliente int not null,
    constraint Reserva_idExemplar_fk foreign key (idExemplar) references Exemplar (idExemplar),
    constraint Reserva_idCliente_fk foreign key (idCliente) references Cliente (idCliente)
);

create table Retirada (
	idRetirada int primary key auto_increment,
    idLocacao int not null,
    idExemplar int not null,
    valorUnitario decimal(10, 2) not null,
    dataDevolucaoPrevista date not null,
    constraint Retirada_idLocacao_fk foreign key (idLocacao) references Locacao (idLocacao),
    constraint Retirada_idExemplar_fk foreign key (idExemplar) references Exemplar (idExemplar)
);

create table Devolucao (
	idDevolucao int primary key auto_increment,
    dataDevolucao date not null,
    idRetirada int not null,
    constraint Devolucao_idRetirada_fk foreign key (idRetirada) references Retirada (idRetirada)
);

create table Multa (
	idMulta int primary key auto_increment,
    dataMulta date not null,
    valorMulta decimal(10, 2) not null,
    qtdDiasAtraso int not null,
    valorTotalMulta decimal(10, 2) not null,
    idDevolucao int not null,
    constraint Multa_idDevolucao_fk foreign key (idDevolucao) references Devolucao (idDevolucao)
);

create table Filme_has_Ator (
	idFilme int,
    idAtor int,
    constraint primary key (idFilme, idAtor),
    constraint Filme_has_Ator_idFilme_fk foreign key (idFilme) references Filme (idFilme),
    constraint Filme_has_Ator_idAtor_fk foreign key (idAtor) references Ator (idAtor)
);




