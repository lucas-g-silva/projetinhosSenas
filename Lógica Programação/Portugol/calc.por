programa
{
	inclua biblioteca Util --> u
	inclua biblioteca Texto --> txt
	inclua biblioteca Graficos --> g
	inclua biblioteca Mouse --> m
	inclua biblioteca Teclado --> t

	inteiro y = 86, x = 100
	
	inteiro corDisplay = g.criar_cor(76, 76, 76)
	inteiro corHeader[] = {g.criar_cor(255, 85, 78), g.criar_cor(255, 189, 46), g.criar_cor(42, 209, 67)}
	inteiro corBotao1 = g.criar_cor(224, 224, 224)
	inteiro corBotao2 = g.criar_cor(247, 146, 49)
	cadeia titulos[][] = {{"7", "8", "9", "+"},
					  {"4", "5", "6", "-"},
					  {"1", "2", "3", "*"},
					  {".", "0", "=", "/"}}
	cadeia display = ""
	
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
		g.definir_cor(g.COR_BRANCO)
		g.definir_tamanho_texto(y - 5.0)
		g.desenhar_texto(10, y, display)
		
		desenharBotao("AC", 0, y*2, x*4, y, corBotao1, g.COR_PRETO)

		para(inteiro j = 0; j < 4; j++){
			para(inteiro i = 0; i < 4; i++){
				se(i == 3){
					desenharBotao(titulos[j][i], x*(i), y*(j+3), x, y, corBotao2, g.COR_BRANCO)
				}senao{
					desenharBotao(titulos[j][i], x*(i), y*(j+3), x, y, corBotao1, g.COR_PRETO)
				}
			}
		}
		g.renderizar()
	}
	funcao desenharBotao(cadeia titulo, inteiro posicaoX, inteiro posicaoY, inteiro largura, inteiro altura, inteiro cor, inteiro corTitulo){
		g.definir_cor(cor)
		g.desenhar_retangulo(posicaoX, posicaoY, largura , altura, falso, verdadeiro)
		se(m.posicao_x() > posicaoX e
		   m.posicao_x() < posicaoX + largura e
		   m.posicao_y() > posicaoY e
		   m.posicao_y() < posicaoY + altura){
			g.definir_cor(g.COR_PRETO)
			g.definir_opacidade(30)
			g.desenhar_retangulo(posicaoX, posicaoY, largura , altura, falso, verdadeiro)
			g.definir_opacidade(255)
		}
		g.definir_cor(corDisplay)
		g.desenhar_retangulo(posicaoX, posicaoY, largura , altura, falso, falso)
		g.definir_cor(corTitulo)
		g.definir_tamanho_texto(20.0)
		g.desenhar_texto(posicaoX + (largura / 2) -7, posicaoY + (altura / 2) - 10, titulo)
		
		se(m.posicao_x() > posicaoX e
		   m.posicao_x() < posicaoX + largura e
		   m.posicao_y() > posicaoY e
		   m.posicao_y() < posicaoY + altura e
		   m.botao_pressionado(0)){
		   	se(titulo == "AC"){
		   		
		   	}senao se(titulo == "="){
		   		
		   	}
		}
	}
	funcao calcular(){
		
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 1804; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */