programa
{
	inclua biblioteca Util --> u
	
	funcao inicio()
	{
		inteiro vetor[15], tam = 15, index, auxiliar, pares[15], impares[15], cont_p = 0, cont_i = 0

		escreva("Valores Originias: ")
		para(inteiro i = 0; i < tam; i++){
			vetor[i] = u.sorteia(1,2)
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
		para(inteiro i = 0; i < tam; i++){
			se(vetor[i] % 2 == 0){
				pares[cont_p] = vetor[i]
				cont_p++
			}senao{
				impares[cont_i] = vetor[i]
				cont_i++
			}
		}
		
		escreva("\nValores Ordenados: ")
		para(inteiro i = 0; i < tam; i++){
			escreva(vetor[i], " ")
		}
		escreva("\nPares: ")
		para(inteiro i = 0; i < cont_p; i++){
			escreva(pares[i], " ")
		}
		escreva("\nÍmpares: ")
		para(inteiro i = 0; i < cont_i; i++){
			escreva(impares[i], " ")
		}
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 945; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = {pares, 7, 48, 5}-{impares, 7, 59, 7};
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */