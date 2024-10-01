-- Criar banco
create database exemploprogramador;
use exemploprogramador;

-- Criar tabela
create table departamento (
	id_departamento int primary key not null,
    nm_departamento varchar(30) not null unique,
    localizacao varchar(20) not null
);

create table empregado (
	id_empregado int primary key not null,
    nm_empregado varchar(45) not null,
    funcao varchar(45) not null,
    data_contratacao date not null,
    salario decimal(10,2) not null,
    comissao decimal(10,2),
    lider int,
    id_departamento int not null,
    
    constraint empregado_id_departamento_fk
    foreign key (id_departamento)
    references departamento(id_departamento),
    
    constraint empregado_lider_fk
    foreign key (lider)
    references empregado(id_empregado)
);

create table grade_salarial (
	id_grade_salarial int primary key not null,
    menor_salario decimal(10,2) not null,
    maior_salario decimal(10,2) not null
);

create table pessoa (
	cd_pessoa int primary key not null,
    nm_pessoa varchar(45) not null
);

-- Mostrar tabelas
desc departamento;
desc empregado;
desc grade_salarial;
desc pessoa;

-- Excluir tabelas
drop table departamento;
drop table empregado;
drop table grade_salarial;
drop table pessoa;

-- Alterar tabela
alter table pessoa
	add sexo char(1);
alter table pessoa
	modify column nm_pessoa varchar(100);

-- Inserção de valores
insert into pessoa values (1, "Lucas");

select * from pessoa;

-- Remover valores
truncate table pessoa