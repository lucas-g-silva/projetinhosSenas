select * from empregado;

select nm_empregado, funcao, salario from empregado;

select nm_empregado Nome, funcao Função, salario "Salário Fixo" from empregado;

select nm_empregado, funcao, salario from empregado where id_empregado = 7788;

select nm_empregado, funcao, salario from empregado where id_departamento = 10 and salario >- 1300;

select nm_empregado, funcao, salario from empregado where nm_empregado like "S%";

select nm_empregado, funcao, salario from empregado where comissao is null;

select nm_empregado, funcao, salario from empregado where id_departamento in(10,30);

select nm_empregado, funcao, salario from empregado where salario between 800 and 1200;

select nm_empregado, funcao, salario from empregado order by nm_empregado desc;

select nm_empregado, funcao, salario from empregado order by funcao, nm_empregado;

select upper(nm_empregado), lower(funcao), salario from empregado;