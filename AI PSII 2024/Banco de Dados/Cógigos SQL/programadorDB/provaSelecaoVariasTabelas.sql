#1) Recuperar o nome, o número do empregado e o nome do departamento de todos os empregados;
select e.nm_empregado Empregado, e.id_empregado Número, d.nm_departamento Departamento 
	from empregado e, departamento d 
	where e.ID_DEPARTAMENTO = d.id_departamento;

#2) Recuperar o nome e a localização dos departamentos e o nome, a atividade e o salário dos empregados que trabalham em NEW YORK;
select d.nm_departamento Departamento, d.localizacao Localização, e.nm_empregado Empregado, e.funcao Atividade, e.salario Salário
	from empregado e, departamento d
    where e.ID_DEPARTAMENTO = d.ID_DEPARTAMENTO
    and d.LOCALIZACAO like "NEW YORK";

#3) Recuperar o nome do empregado, o nome do departamento e a localização de todos os empregados que recebem comissão;
select e.nm_empregado Empregado, d.nm_departamento Departamento, d.localizacao Localização
	from empregado e, departamento d
    where e.ID_DEPARTAMENTO = d.ID_DEPARTAMENTO
    and e.COMISSAO is not null;

#4) Recuperar o nome, salário e data de contratação de todos os empregados que trabalham no departamento de Pesquisa e Desenvolvimento, ordenados pelo maior salário. 
select e.NM_EMPREGADO Empregado, e.SALARIO Salário, e.DATA_CONTRATACAO "Data Contratação"
	from empregado e, departamento d
    where e.ID_DEPARTAMENTO = d.ID_DEPARTAMENTO
    and d.nm_departamento like "PESQUISA E DESENVOLVIMENTO"
    order by e.salario desc;

#5) Recuperar todos os dados dos empregados que trabalham em Chicago e não tem comissão.
select e.*
	from empregado e left join departamento d 
	on e.ID_DEPARTAMENTO = d.ID_DEPARTAMENTO
    where d.LOCALIZACAO = "CHICAGO"
    and e.COMISSAO is null;

#6) Recuperar o número e o nome dos empregados, o número e o nome do departamento dos empregados que recebam na faixa de R$ 1.000 e R$ 2.300.
select e.ID_EMPREGADO "ID Empregado", e.NM_EMPREGADO Empregado, d.ID_DEPARTAMENTO "ID Departamento", d.NM_DEPARTAMENTO Departamento
	from empregado e, departamento d
    where e.ID_DEPARTAMENTO = d.ID_DEPARTAMENTO
    and e.SALARIO between 1000 and 2300;

#7) Recuperar o nome e a função do empregado, o nome do departamento, o salário do empregado e a grade salarial (ID_GRADE_SALARIAL) de todos os empregados; 
select e.NM_EMPREGADO Empregado, e.FUNCAO Função, d.NM_DEPARTAMENTO Departamento, e.SALARIO Salário, g.ID_GRADE_SALARIAL "Grade Salarial" 
	from empregado e, departamento d, grade_salarial g
    where e.ID_DEPARTAMENTO = d.id_departamento
    and e.salario between g.MENOR_SALARIO and g.MAIOR_SALARIO;

#8) Recuperar o nome e o número do empregado junto com o nome e o número do líder; coloque um apelido nas colunas ID Empregado, Nome Empregado, ID Líder e Nome Líder;
select e.NM_EMPREGADO Empregado, e.ID_EMPREGADO "ID Empregado", l.NM_EMPREGADO Líder, l.ID_EMPREGADO "ID Líder"
	from empregado e left join empregado l
    on e.lider = l.id_empregado;

#9) Recuperar o nome do empregado, o nome do departamento e a classificação salarial.
select e.NM_EMPREGADO Empregado, d.NM_DEPARTAMENTO Departamento, g.ID_GRADE_SALARIAL "Grade Salarial"
	from empregado e, departamento d, grade_salarial g
    where e.ID_DEPARTAMENTO = d.id_departamento
    and e.salario between g.MENOR_SALARIO and g.MAIOR_SALARIO;

#10) Recuperar nome, salário e data de contratação do empregado, o nome do departamento que o funcionário trabalha e o nome, o salário e data de contratação do líder, ordenados pelo nome do funcionário. Utilize apelidos para as colunas para facilitar a leitura.
select e.NM_EMPREGADO Empregado, e.SALARIO Salário, e.DATA_CONTRATACAO "Data Contatação", d.NM_DEPARTAMENTO Departamento,
	l.NM_EMPREGADO "Líder", l.SALARIO "Salário Líder", l.DATA_CONTRATACAO "Data Contratação do Líder"
	from departamento d, empregado e left join empregado l
    on e.lider = l.ID_EMPREGADO
    where e.ID_DEPARTAMENTO = d.ID_DEPARTAMENTO
    order by e.NM_EMPREGADO;

