programa{
	inclua biblioteca Util --> u
	funcao inicio(){
		inteiro vetor[5], tamanho = 5, j, elementoAtual, indice
		para(inteiro i = 0; i < tamanho; i++){
			vetor[i] = u.sorteia(0, 10)
		}
		escreva("Vetor original :")
		para(inteiro i = 0; i < tamanho; i++){
			escreva(vetor[i], " ")
		}
		escreva("\n")
		para(inteiro i = 0; i < tamanho; i++){
			elementoAtual = vetor[i]
			indice = i
			enquanto(indice > 0 e vetor[indice-1] < elementoAtual){
				vetor[indice] = vetor[indice-1]
				indice--
			}
			vetor[indice] = elementoAtual
		}
		escreva("Vetor ordenado: ")
		para(inteiro i = 0; i < tamanho; i++){
			escreva(vetor[i], " ")
		}
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 504; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = {vetor, 4, 10, 5};
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */