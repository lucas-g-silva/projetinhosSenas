programa
{
	inclua biblioteca Mouse --> m
	inclua biblioteca Texto --> txt
	inclua biblioteca Teclado --> t
	inclua biblioteca Graficos --> g

	inteiro y = 86, x = 100
	cadeia titulos[][] = {{"AC", "", "%", "/"},
					  {"7", "8", "9", "*"},
					  {"4", "5", "6", "-"},
					  {"1", "2", "3", "+"},
					  {"00", "0", ".", "="}}
	cadeia operacoes[] = {"soma", "subtracao", "multiplicacao", "divisao", "porcentagem"}
	inteiro corDisplay = g.criar_cor(76, 76, 76)
	inteiro corHeader[] = {g.criar_cor(255, 85, 78), g.criar_cor(255, 189, 46), g.criar_cor(42, 209, 67)}
	inteiro corBotao1 = g.criar_cor(224, 224, 224)
	inteiro corBotao2 = g.criar_cor(247, 146, 49)
	cadeia operacao
	cadeia display
	inteiro numeros[2]
	
	funcao inicio()
	{
		g.iniciar_modo_grafico(verdadeiro)
          g.definir_dimensoes_janela(400, 600)
          g.definir_titulo_janela("")
          enquanto (nao t.tecla_pressionada(t.TECLA_ESC)) {
           	desenhar()
          }
	}
	funcao desenhar(){
		g.definir_cor(corDisplay)
		g.limpar()
		para(inteiro i = 1; i < 4; i = i++){
			g.definir_cor(corHeader[i-1])
			g.desenhar_elipse(i*20, 20, 15, 15, verdadeiro)	
		}
		g.definir_cor(g.COR_BRANCO)
		g.definir_tamanho_texto(50.0)
		g.desenhar_texto(20, 172-60, "1+1")
		para(inteiro i = 0; i < 4; i++){
			para(inteiro c = 0; c < 5; c++){
				se(i == 3){
					desenharBotao(titulos[c][i], x*(i), y*(c+2), corBotao2, g.COR_BRANCO)
					clicarBotao(x*(i), y*(c+2), verdadeiro, falso, operacoes[i])
				} senao{
					se(nao (i == 1 e c == 0)){
						desenharBotao(titulos[c][i], x*(i), y*(c+2), corBotao1, g.COR_PRETO)
					}
					se(i == 0 e c == 0){
						clicarBotao(x*(i), y*(c+2), falso, verdadeiro, "")
					} senao se (c == 0){
						clicarBotao(x*(i), y*(c+2), verdadeiro, falso, operacoes[4])
					} senao{
						clicarBotao(x*(i), y*(c+2), falso, falso, titulos[c][i])
					}
				}
			}
		}
		g.renderizar()
	}
	funcao clicarBotao(inteiro posicaoX, inteiro posicaoY, logico operador, logico input, cadeia valor){
		se(m.posicao_x() > posicaoX e
		   m.posicao_x() < posicaoX + x e
		   m.posicao_y() > posicaoY e
		   m.posicao_y() < posicaoY + y){
		   	se(operador == verdadeiro){
		   		operacao = valor
		   	} senao se(input == verdadeiro){
		   		
		   	} senao {
		   		
		   	}
		}
	}
	funcao desenharBotao(cadeia titulo, inteiro posicaoX, inteiro posicaoY, inteiro cor, inteiro corTitulo){
		
		g.definir_tamanho_texto(20.0)
		g.definir_cor(cor)
		escolha(txt.numero_caracteres(titulo)){
			caso 1:
				g.desenhar_retangulo(posicaoX, posicaoY, x, y, falso, verdadeiro)
				se(m.posicao_x() > posicaoX e
		   			m.posicao_x() < posicaoX + x e
		   			m.posicao_y() > posicaoY e
		   			m.posicao_y() < posicaoY + y){
				   	g.definir_cor(g.COR_BRANCO)
				   	g.definir_opacidade(150)
				   	g.desenhar_retangulo(posicaoX, posicaoY, x, y, falso, verdadeiro)
				   	g.definir_opacidade(255)
				}
				g.definir_cor(corDisplay)
				g.desenhar_retangulo(posicaoX, posicaoY, x, y, falso, falso)
				g.definir_cor(corTitulo)
				g.desenhar_texto(posicaoX+x/2-5, posicaoY+y/2-10, titulo)
				pare
			caso 2:
				g.desenhar_retangulo(posicaoX, posicaoY, x*2, y, falso, verdadeiro)
				se(m.posicao_x() > posicaoX e
		   			m.posicao_x() < posicaoX + x*2 e
		   			m.posicao_y() > posicaoY e
		   			m.posicao_y() < posicaoY + y){
				   	g.definir_cor(g.COR_BRANCO)
				   	g.definir_opacidade(150)
				   	g.desenhar_retangulo(posicaoX, posicaoY, x*2, y, falso, verdadeiro)
				   	g.definir_opacidade(255)
				}	
				g.definir_cor(corDisplay)
				g.desenhar_retangulo(posicaoX, posicaoY, x*2, y, falso, falso)
				g.definir_cor(corTitulo)
				g.desenhar_texto(posicaoX+x/2-10, posicaoY+y/2-10, titulo)
				pare
		}
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 145; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */