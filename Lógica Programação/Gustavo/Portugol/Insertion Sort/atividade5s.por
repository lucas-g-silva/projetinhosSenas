programa
{
	inclua biblioteca Matematica --> m
	funcao inicio()
	{
		real notas[200], auxiliar
		real elementoAtual
		inteiro indice, index = 0
		faca{
			escreva("Pontuação do Candidato ", (index+1), ": ")
			leia(auxiliar)
			se (auxiliar != 0){
				notas[index] = auxiliar
				index++
			}
		} enquanto(auxiliar != 0.0)
		limpa()
		para(inteiro c = 0; c < index; c++){
			elementoAtual = notas[c]
			indice = c
			enquanto(indice > 0 e notas[indice-1] < elementoAtual){
				notas[indice] = notas[indice-1]
				indice--
			}
			notas[indice] = elementoAtual
		}
		escreva("<<10 Melhores Pontuações>>\n\n")
		escreva("    Colocação:\tNota:")
		para(inteiro c = 0; c<10; c++){
			escreva("\n        ",(c+1),"º\t", notas[c])
		}
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 456; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = {notas, 6, 7, 5};
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */