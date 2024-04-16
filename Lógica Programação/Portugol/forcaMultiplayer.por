programa
{
	inclua biblioteca Arquivos --> a
	inclua biblioteca Util --> u
	inclua biblioteca Texto --> txt

	//definição de variáveis
	cadeia palavra, palavraConhecida = "", status = "", letras[200], letrasConhecidas[200], palpite = "", palpites = ""
	inteiro tamanho, chances = 5

	//matriz da forca
	cadeia forca[7][7] = {
		{" ","_","_","_","_","_","_"},
		{" "," ","|"," "," "," ","|"},
		{" "," "," "," "," "," ","|"},
		{" "," "," "," "," "," ","|"},
		{" "," "," "," "," "," ","|"},
		{" "," "," "," "," "," ","|"},
		{" ","_","_","_","_","_","|"}
	}
	
	funcao inicio()
	{
		escreva("JOGO DA FORCA\n\n")
		//Entrada da palavra
		escreva("Escreva uma Palavra: ")
		leia(palavra)
		palavra = txt.caixa_alta(palavra)
		tamanho = txt.numero_caracteres(palavra) 
		limpa()
		
		para(inteiro i = 0; i < tamanho; i++){
			letras[i] = (txt.obter_caracter(palavra, i) + "") 
			se(letras[i] == " ")
				letrasConhecidas[i] = " "
			senao se(letras[i] == "-")
				letrasConhecidas[i] = "-"
			senao
				letrasConhecidas[i] = "_"
		}
		faca{
			faca{
				mostrarForca(chances, falso)
				escreverLetras()
				escreva("\n\nÚltimos Palpites: ",palpites)
				//Entrada do palpite
				escreva("\n\nPalpite: ")
				leia(palpite)
				se(txt.numero_caracteres(palpite) != 1){
					escreva("\nApenas um caracter!")
					u.aguarde(1500)
					limpa()
				} senao{
					palpites += txt.caixa_alta(palpite) + " "
				}
			} enquanto (txt.numero_caracteres(palpite) != 1)
			verificarPalpite(palpite)
			verificarStatus()
			limpa()
			
		} enquanto(status != "venceu" e status != "perdeu")
		
		se(status == "venceu"){
			mostrarForca(chances, verdadeiro)
			escreverLetras()
			escreva("\n\nVOCÊ GANHOU!\n")
		}
		senao {
			mostrarForca(chances, falso)
			escreverLetras()
			escreva("\n\nVOCÊ PERDEU!\nA plavra era: "+palavra+"\n")
		}
	}
	funcao escreverLetras(){
		para(inteiro i = 0; i < tamanho; i++){
			escreva(letrasConhecidas[i]+" ")
		}
	}
	funcao verificarPalpite(cadeia palp){
		inteiro auxiliar = 0
		para(inteiro i = 0; i < tamanho; i++){
			se(palp == letras[i]
			ou palp == txt.caixa_baixa(letras[i])
			e palp != letrasConhecidas[i]){
				letrasConhecidas[i] = txt.caixa_alta(palp)
			} senao {
				auxiliar++
			}
			se(auxiliar == tamanho){
				chances--
			}
		}
	}
	funcao verificarStatus(){
		atualizarPalavraConhecida()
		se(palavraConhecida == palavra)
			status = "venceu"
		se(chances == 0)
			status = "perdeu"
	}
	funcao atualizarPalavraConhecida(){
		palavraConhecida = ""
		para(inteiro i = 0; i < tamanho; i++)
			palavraConhecida += letrasConhecidas[i]
	}
	funcao mostrarForca(inteiro vidas, logico venceu){
		se(venceu == falso){
			escolha(vidas){
				caso 4:
				forca[2][1] = "("
				forca[2][3] = ")"
				pare
				caso 3:
				forca[3][1] = "|"
				forca[3][3] = "|"
				pare
				caso 2:
				forca[3][0] = "/"
				forca[3][4] = "\\"
				pare
				caso 1:
				forca[4][1] = "/"
				forca[5][0] = "/"
				pare
				caso 0:
				forca[4][3] = "\\"
				forca[5][4] = "\\"
				pare
			}
			para(inteiro l = 0; l<7; l++){
				para(inteiro c = 0; c<7; c++){
					escreva(forca[l][c])
				}
				escreva("\n")
			}
		} senao {
			escreva("  ( )  \n")
			escreva(" /| |\\ \n")
			escreva("  / \\ \n")
			escreva(" /   \\ \n")
		}
		escreva("\n\n")
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 721; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = {palavra, 8, 8, 7};
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */