programa
{
	inclua biblioteca Util --> u
	
	funcao inicio(){
		inteiro vetor[10], tam = 10, index, auxiliar
		
		escreva("Valores originais: ")
		para(inteiro i = 0; i < tam; i++){
			vetor[i] = u.sorteia(0,10)
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
		escreva("\nValores ordenados: ")
		para(inteiro i = 0; i < tam; i++){
			escreva(vetor[i], " ")
		}
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 80; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = {vetor, 6, 10, 5};
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */