create database bdlojacds;
use bdlojacds;

create table Categoria (
	idCategoria int primary key auto_increment,
    nome varchar(45) not null
);

create table Genero (
	idGenero int primary key auto_increment,
    nome varchar(45) not null
);

create table Gravadora (
	idGravadora int primary key auto_increment,
    nome varchar(45) not null,
    endereco varchar(150) not null
);

create table Autor (
	idAutor int primary key auto_increment,
    nome varchar(45) not null,
    cpf varchar(14) not null
);

create table Telefone (
	idTelefone int primary key auto_increment,
    telefone varchar(16) not null,
    idGravadora int not null,
    constraint Telefone_idGravadora_fk foreign key (idGravadora) references Gravadora (idGravadora) 
);

create table Vendedor (
	idVendedor int primary key auto_increment,
    nome varchar(45) not null,
    idGravadora int not null,
    constraint Vendedor_idGravadora_fk foreign key (idGravadora) references Gravadora (idGravadora) 
);

create table Artista (
	idArtista int primary key auto_increment,
    nome varchar(45) not null,
    dataVascimento date not null,
    idGenero int not null,
    idArtistaInspiracao int,
    idGravadora int not null,
    constraint Artista_idGenero_fk foreign key (idGenero) references Genero (idGenero),
    constraint Artista_idArtistaInspiracao_fk foreign key (idArtistaInspiracao) references Artista (idArtista),
	constraint Artista_idGravadora_fk foreign key (idGravadora) references Gravadora (idGravadora) 
);

create table CD (
	idCD int primary key auto_increment,
    titulo varchar(45) not null,
    idCategoria int not null,
    idArtista int not null,
    quantidade int not null,
    constraint CD_idCategoria_fk foreign key (idCategoria) references Categoria (idCategoria),
    constraint CD_idArtista_fk foreign key (idArtista) references Artista (idArtista)
);

create table Musica (
	idMusica int primary key auto_increment,
    titulo varchar(45) not null,
    idCD int not null,
    faixa int not null,
    idGenero int not null,
    constraint Musica_idCD_fk foreign key (idCD) references CD (idCD),
    constraint Musica_idGenero_fk foreign key (idGenero) references Genero (idGenero)
);

create table Musica_has_Autor (
	idMusica int,
    idAutor int,
    constraint primary key (idMusica, idAutor),
    constraint Musica_has_Autor_idMusica_fk foreign key (idMusica) references Musica (idMusica),
    constraint Muisca_has_Autor_idAutor_fk foreign key (idAutor) references Autor (idAutor)
);