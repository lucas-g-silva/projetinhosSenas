#1) Selecione todos os empregados e suas funções
SELECT NM_EMPREGADO, FUNCAO FROM EMPREGADO;

#2) Liste todos os departamentos e suas localizações
SELECT NM_DEPARTAMENTO, LOCALIZACAO FROM DEPARTAMENTO;
 
#3) Encontre todos os empregados com salário maior que 3000
select nm_empregado from empregado where SALARIO > 3000;
 
#4) Mostre o nome e a função dos empregados que trabalham no departamento de Vendas 
select nm_empregado, funcao from empregado where ID_DEPARTAMENTO = 30;

#5) Liste os empregados contratados antes de 1982
select nm_empregado from empregado where DATA_CONTRATACAO < '1982-01-01';
 
#6) Encontre o empregado que tem a maior comissão
select nm_empregado from empregado order by salario desc limit 1;
 
#7) Liste os empregados que são gerentes
select nm_empregado from empregado where funcao like 'gerente';
 
#8) Mostre os empregados que não têm líder
select nm_empregado from empregado where lider is null;
 
#9) Exiba os empregados que ganham um salário dentro da faixa salarial de 1201 a 1400
select nm_empregado from empregado where salario between 1201 and 1400;

#10) Mostre o empregado mais recente (último contratado)
select NM_EMPREGADO from empregado order by DATA_CONTRATACAO desc limit 1;
