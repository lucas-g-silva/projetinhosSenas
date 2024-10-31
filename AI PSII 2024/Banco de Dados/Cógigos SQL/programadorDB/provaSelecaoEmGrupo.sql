#1) Recuperar o número de empregados que exercem a função de Analista.
select count(funcao)  "Número de Empregados"
	from empregado
    where funcao = "Analista";

#2) Exibir o menor e o maior salário entre os empregados, assim como a média e a soma de todos os salários de todos os empregados. Coloque apelidos nas colunas Máximo, Mínimo, Soma e Média, respectivamente.
select min(salario) "Mínimo", max(salario) "Máximo", avg(salario) "Média", sum(salario) "Soma"
	from empregado;

#3) Exibir o menor e o maior salário dentre os empregados, assim como a média e a soma de todos os salários de todos os empregados agrupados por função.
select funcao "Função", min(salario) "Mínimo", max(salario) "Máximo", avg(salario) "Média", sum(salario) "Soma"
	from empregado 
    group by 1;

#4) Exibir o nome e o número de empregados com o mesmo cargo.
select funcao "Função", count(funcao) "Número de Empregados"
	from empregado
	group by 1;

#5) Exibir o nome do departamento, o nome do local, o número de empregados e o salário médio de todos os empregados que atuam no departamento.
select d.nm_departamento "Departamento", d.localizacao "Localização", count(e.id_empregado) "Número de Empregados", coalesce(avg(e.salario),0) "Média Salarial"
	from departamento d left join empregado e on d.ID_DEPARTAMENTO = e.ID_DEPARTAMENTO
    group by 1;

#6) Recuperar o nome do departamento onde o salário médio for superior a R$ 2.500.
select d.nm_departamento "Departamento"
	from departamento d right join empregado e on d.ID_DEPARTAMENTO = e.ID_DEPARTAMENTO
    group by 1
    having avg(e.salario) > 2500;

#7) Exibir o nome do departamento e o local onde o número de empregados for igual ou menor a 5 (deve listar o departamento que não tem ninguém).
select d.nm_departamento "Departamento", d.localizacao "Localização"
	from empregado e right join departamento d on d.ID_DEPARTAMENTO = e.ID_DEPARTAMENTO
    group by 1
    having coalesce(count(e.id_empregado),0) <= 5;
    
#8) Recuperar o nome e a quantidade de liderados que o funcionário possui. 
select l.nm_empregado "Líder", count(e.id_empregado) "Número de Liderados"
	from empregado l join empregado e on l.ID_EMPREGADO = e.lider
    group by 1;

#9) Recuperar o nome do departamento, salário mínimo, salário máximo do departamento
select d.nm_departamento "Departamento", coalesce(min(e.salario),0), coalesce(max(e.salario),0)
	from departamento d left join empregado e on d.ID_DEPARTAMENTO = e.ID_DEPARTAMENTO
    group by 1;

#10) Recuperar a quantidade de cada grade salarial por departamento.
select d.nm_departamento "Departamento", count(e.id_empregado) "Número Empregados", g.id_grade_salarial "Grade Salarial"
	from departamento d, empregado e, grade_salarial g
    where d.ID_DEPARTAMENTO = e.ID_DEPARTAMENTO and e.salario between g.MENOR_SALARIO and g.MAIOR_SALARIO
    group by g.ID_GRADE_SALARIAL, d.NM_DEPARTAMENTO
    order by d.NM_DEPARTAMENTO;

