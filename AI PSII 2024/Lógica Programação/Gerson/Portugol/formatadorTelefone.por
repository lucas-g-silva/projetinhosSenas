programa{
	inclua biblioteca Util --> u
	inclua biblioteca Texto --> t

	cadeia numero
	inteiro tamanho
	
	funcao inicio(){
		faca{
			escreva("Escreva a seguir seu número com o código de sua cidade(somente números):\n")
			leia(numero)
			tamanho = t.numero_caracteres(numero)
			se(tamanho != 10){
				escreva("\nO NÚMERO DEVE CONTER 10 CARACTERES!")
				u.aguarde(2000)
				limpa()
			}
		}enquanto(tamanho != 10)
		escreva("\n")
		para(inteiro i = 0; i < tamanho; i++){
			escolha(i){
				caso 0:
					escreva("(")
					pare
				caso 2:
					escreva(") ")
					pare
				caso 6:
					escreva("-")
					pare
			}
			escreva(t.obter_caracter(numero, i))
		}
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 617; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */