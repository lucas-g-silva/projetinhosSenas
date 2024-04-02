programa
{
	inclua biblioteca Util

	
	funcao inicio()
	{
		//inteiro vetor[] = {1,5,6,9,7,10,598,218,55}, tamanho = 9, j, auxiliar, indice
		inteiro vetor[] = {58,15,2,0,1,8,30,100}, tamanho = 8, j, auxiliar, indice

		//para(inteiro i = 0; i < tamanho; i++){
			//vetor[i] = Util.sorteia(1, 5)
		//}
		escreva("Vetor Original: ")
		para(inteiro i = 0; i < tamanho; i++){
			escreva(vetor[i], " ")
		}
		escreva("\n\n")
		para(j = 0; j < tamanho; j++){
			para(inteiro i = 0; i < tamanho - 1; i++){
				se(vetor[i] > vetor[i+1]){
					auxiliar = vetor[i]
					vetor[i] = vetor[i+1]
					vetor[i+1] = auxiliar
				}
			}
		}
		escreva("Vetor Crescente: ")
		para(inteiro i = 0; i < tamanho; i++){
			escreva(vetor[i], " ")
		}
		escreva("\n\n")
		para(j = 0; j < tamanho; j++){
			para(inteiro i = 0; i < tamanho - 1; i++){
				se(vetor[i] < vetor[i+1]){
					auxiliar = vetor[i]
					vetor[i] = vetor[i+1]
					vetor[i+1] = auxiliar
				}
			}
		}
		escreva("Vetor Decrescente: ")
		para(inteiro i = 0; i < tamanho; i++){
			escreva(vetor[i], " ")
		}
		escreva("\n\n")
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 195; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */