programa
{
	inclua biblioteca Arquivos --> a
	inclua biblioteca Util --> u
	inclua biblioteca Texto --> txt
	cadeia palavra, palavraConhecida = "", status = "", letras[200], letrasConhecidas[200], palpite = "", palpites = "", palavras[245365]
	inteiro tamanho, chances = 5
	inteiro arquivo = a.abrir_arquivo("./palavras.txt", a.MODO_LEITURA)
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
		//cadeia auxiliar
		//escreva("JOGO DA FORCA\n\n")
		//escreva("Escreva uma Palavra: ")
		//leia(auxiliar)
		//palavra = txt.caixa_alta(auxiliar)
		//tamanho = txt.numero_caracteres(palavra)
		para (inteiro i = 0; i < 245365; i++){
      		palavras[i] = a.ler_linha(arquivo)
    		}
		palavra = txt.caixa_alta(palavras[u.sorteia(0, 245365)])
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
				escreva("\n\nPalpite: ")
				leia(palpite)
				palpites += txt.caixa_alta(palpite) + " "
				se(txt.numero_caracteres(palpite) != 1){
					escreva("\nApenas um caracter!")
					u.aguarde(1500)
					limpa()
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
			escreva("\t ( )  \n")
			escreva("\t/| |\\ \n")
			escreva("\t / \\ \n")
			escreva("\t/   \\ \n")
		}
		escreva("\n\n")
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 3437; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = {palavra, 6, 8, 7};
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */