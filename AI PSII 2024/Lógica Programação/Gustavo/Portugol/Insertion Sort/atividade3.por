programa{
	inclua biblioteca Util --> u

	inteiro vetor[50], tamanho = 50, j, elementoAtual, indice
	funcao inicio(){
		para(inteiro i = 0; i < tamanho; i++){
			vetor[i] = u.sorteia(0, 10)
		}
		escreva("Vetor original :")
		para(inteiro i = 0; i < tamanho; i++){
			escreva(vetor[i], " ")
		}
		escreva("\n")

		organizar(vetor)
	}
	funcao organizar(inteiro vt[]){
		para(inteiro i = 0; i < tamanho; i++){
			elementoAtual = vt[i]
			indice = i
			enquanto(indice > 0 e vt[indice-1] < elementoAtual){
				vt[indice] = vt[indice-1]
				indice--
			}
			vt[indice] = elementoAtual
		}
		escreva("Vetor Crescente: ")
		para(inteiro i = 0; i < tamanho; i++){
			escreva(vt[i], " ")
		}

		escreva("\nVetor Decrescente: ")
		para(inteiro i = tamanho-1; i >= 0; i--){
			escreva(vt[i], " ")
		}
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 550; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */