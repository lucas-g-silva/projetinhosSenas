programa{
	inclua biblioteca Texto --> t
	inclua biblioteca Util --> u
	
	cadeia texto, textoInvertido = ""
	inteiro tamanho
	
	funcao inicio(){
		faca{
			escreva("Escreva abaixo um texto com 50 a 100 caracteres:\n")
			leia(texto)
			tamanho = t.numero_caracteres(texto)
			se (tamanho < 50 ou tamanho > 100){
				escreva("\nNÚMERO DE CARACTERES INVÁLIDO!")
				u.aguarde(2000)
				limpa()
			}
		}enquanto(tamanho < 50 ou tamanho > 100)

		para(inteiro i = tamanho-1; i >= 0; i--){
			textoInvertido += t.caixa_alta(t.obter_caracter(texto, i) + "")
		}
		escreva("\nTexto Invertido em Letras Maiúsculas:\n")
		escreva(textoInvertido)
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 643; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */