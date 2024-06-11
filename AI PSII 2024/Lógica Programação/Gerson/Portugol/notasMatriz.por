programa
{
	inclua biblioteca Texto --> txt
	inclua biblioteca Matematica --> m
	funcao inicio()
	{
		//Variáveis
		cadeia alunos[5][2]
		real notas[5][4]
		inteiro tamanho = 5, numNotas = 3, caracteres[5], maiorNome = 0

		para(inteiro i = 0; i < tamanho; i++){ //Repetir a cada aluno
			//Pedir e ler nome dos alunos
			escreva("Nome do aluno ", (i+1) ,": ")
			leia(alunos[i][0])
			//Gravar número de caracteres para a tabulação
			caracteres[i] = txt.numero_caracteres(alunos[i][0])
			se(caracteres[i] > maiorNome){
				maiorNome = txt.numero_caracteres(alunos[i][0])
			}
			para(inteiro c = 0; c < numNotas; c++){ //Repetir a cada nota
				//Pedir e ler notas
				escreva(" -> Nota ", (c+1), ": ")
				leia(notas[i][c])
			}
			limpa()

			//Cálculo das médias
			notas[i][3] = m.arredondar(((notas[i][0] + notas[i][1] + notas[i][2])/numNotas), 2)

			//Definição do status do aluno
			se(notas[i][3] > 7)
				alunos[i][1] = "Aprovado"
			senao se(notas[i][3] > 5)
				alunos[i][1] = "Recuperação"
			senao
				alunos[i][1] = "Reprovado"
		}
		//Apresentação das médias
		escreva("Médias Finais")
		para(inteiro i = 0; i < tamanho; i++){ //Repetir a cada aluno
			cadeia mf
			se(notas[i][3]<10){
				mf = "0" + notas[i][3]
			}
			escreva("\n--> ", alunos[i][0], ": ")
			//Aplicar tabulação
			para(inteiro t = 0; t < (maiorNome - caracteres[i]); t++){ //Repetir a cada nota
				escreva(" ")
			}
			escreva( notas[i][3], " (", alunos[i][1],")")
		}
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 1239; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = {alunos, 8, 9, 6}-{notas, 9, 7, 5}-{caracteres, 10, 37, 10}-{maiorNome, 10, 52, 9};
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */