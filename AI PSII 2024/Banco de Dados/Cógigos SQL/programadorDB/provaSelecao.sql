select * from empregado;
select * from departamento;

#1) recuperar a localização do departamento de operações;
select localizacao from departamento where NM_DEPARTAMENTO like "Operações";

#2) recuperar todos os empregados que exercem a função de escriturário;
select NM_EMPREGADO from empregado where FUNCAO like "ESCRITURÁRIO";

#3) recuperar o nome, o salário e a comissão dos empregados (que possuem comissão), ordenados pelo maior salário;
select NM_EMPREGADO, SALARIO, COMISSAO from empregado where COMISSAO is not null order by SALARIO DESC;

#4) recuperar o nome, a atividade e a data de contratação dos empregados que trabalham no departamento 20 e recebem mais de R$ 1.000;
select NM_EMPREGADO, FUNCAO, DATA_CONTRATACAO from empregado where ID_DEPARTAMENTO = 20 and salario > 1000;

#5) recuperar os empregados que são gerentes;
select NM_EMPREGADO from empregado where FUNCAO like "GERENTE";

#6) recuperar as informações dos empregados que possuem a letra "o" no nome;
select * from empregado where NM_EMPREGADO like '%O%';

#7) recuperar o nome e o número do departamento de todos os empregados que trabalham nos departamentos 10 e 30 por ordem alfabética de nome do empregado;
select NM_EMPREGADO, ID_DEPARTAMENTO from empregado where ID_DEPARTAMENTO IN (10, 30) order by NM_EMPREGADO;

#8) recuperar as informações dos empregados que foram contratados no ano de 1981.
select * from empregado where DATA_CONTRATACAO like '1981%';

#9) recuperar todos os empregados com comissão maior ou igual a 1000 por ordem alfabética de nome do empregado;
select NM_EMPREGADO from empregado where COMISSAO >= 1000 order by NM_EMPREGADO;

#10) recuperar empregados que tem salário inferior a R$ 1.300 ordenados pelo salário;
select NM_EMPREGADO from empregado where salario < 1300 order by salario;