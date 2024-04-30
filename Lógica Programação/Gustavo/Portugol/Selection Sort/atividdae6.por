programa
{
	inclua biblioteca Util --> u
	
	funcao inicio(){
		inteiro vetor[10], vetor2[10], tam = 10, index, auxiliar
		
		escreva("Valores Originias: ")
		para(inteiro i = 0; i < tam; i++){
			vetor[i] = u.sorteia(1, 10)
			escreva(vetor[i], " ")
		}
		para(inteiro i = 0; i < tam - 1; i++){
			index = i
			para(inteiro c = i + 1; c < tam; c++){
				se(vetor[c] < vetor[index]){
					index = c
				}
			}
			auxiliar = vetor[i]
			vetor[i] = vetor[index]
			vetor[index] = auxiliar
		}

		para(inteiro i = tam - 1, c = 0; i >= 0 e c < tam; i--){
			vetor2[c] = vetor[i] 
			c++
		}
		
		escreva("\nValores Ordenados (crescente): ")
		para(inteiro i = 0; i < tam; i++){
			escreva(vetor[i], " ")
		}
		escreva("\nValores Ordenados (decrescente): ")
		para(inteiro i = 0; i < tam; i++){
			escreva(vetor2[i], " ")
		}
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 806; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */