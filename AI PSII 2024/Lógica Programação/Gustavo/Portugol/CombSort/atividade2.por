programa{
	
	inclua biblioteca Util --> u
	
	funcao inicio(){
		inteiro vetor[10], tamanho = 10, auxiliar, i, j, indice, gap
		real fator
		logico trocado

		para(i=0; i<tamanho; i++){
			escreva("Nº ",(i+1), ": ")
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
				se(vetor[i] > vetor[i + gap]){
					auxiliar = vetor[i]
					vetor[i] = vetor[i + gap]
					vetor[i + gap] = auxiliar
					trocado = verdadeiro
				}
				i = i + 1
			}
		}
		escreva("Vetor ordenado: ")
		para(i=0; i<tamanho; i++){
			escreva(vetor[i], " ")
		}
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 232; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */