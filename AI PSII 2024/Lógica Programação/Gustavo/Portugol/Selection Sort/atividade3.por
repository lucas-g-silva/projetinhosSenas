programa
{
	inclua biblioteca Util --> u
	
	funcao inicio(){
		inteiro vetor[12], tam = 12, index, auxiliar
		
		para(inteiro i = 0; i < tam; i++){
			escreva("Valor posição "+(i+1)+": ")
			leia(vetor[i])
			limpa()
		}
		escreva("Valores Originias: ")
		para(inteiro i = 0; i < tam; i++){
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
		escreva("\nMaior: "+vetor[tam-1])
		escreva("\nMenor: "+vetor[0])
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 320; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */