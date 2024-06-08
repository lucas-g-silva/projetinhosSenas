programa{
	
	inclua biblioteca Util --> u
	
	funcao inicio(){
		inteiro tamanho = 2, i, j, indice,  gap
		real vetor[2], auxiliar
		real fator
		logico trocado
		cadeia idades[2]

		para(i=0; i<tamanho; i++){
			escreva("Nome: ")
			leia(nomes[i])
			escreva("\\-> Idade: ")
			leia(vetor[i])
			limpa()
		}

		fator = 1.3
		trocado = verdadeiro
		gap = tamanho
		enquanto(gap > 1 ou trocado){
			gap = (gap / fator)
			se(gap < 1){
				gap = 1
			}
			trocado = falso
			i = 0
			enquanto(i + gap < tamanho){
				se(vetor[i] < vetor[i + gap]){
					auxiliar = vetor[i]
					vetor[i] = vetor[i + gap]
					vetor[i + gap] = auxiliar
					trocado = verdadeiro
				}
				i = i + 1
			}
		}
		escreva("Ranking: \n")
		para(i=0; i<tamanho; i++){
			escreva(nomes[i], ": ")
			escreva(vetor[i], "\n")
		}
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 292; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */