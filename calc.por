programa
{
	inclua biblioteca Texto --> txt
	inclua biblioteca Graficos --> g
	inclua biblioteca Mouse --> m
	inclua biblioteca Teclado --> t

	inteiro y = 86, x = 100
	
	inteiro corDisplay = g.criar_cor(76, 76, 76)
	inteiro corHeader[] = {g.criar_cor(255, 85, 78), g.criar_cor(255, 189, 46), g.criar_cor(42, 209, 67)}
	inteiro corBotao1 = g.criar_cor(224, 224, 224)
	inteiro corBotao2 = g.criar_cor(247, 146, 49)
	
	funcao inicio()
	{
		g.iniciar_modo_grafico(verdadeiro)
          g.definir_dimensoes_janela(400, 600)
          g.definir_titulo_janela("")
          enquanto (nao t.tecla_pressionada(t.TECLA_ESC)) {
           	desenhar()
           	botoes()
          }
	}
	funcao botoes(){
		
	}
	funcao desenhar(){
		g.definir_cor(corDisplay)
		g.limpar()
		desenharBotao("AC", 0, y*2, x*4, y, corBotao1, g.COR_PRETO)
		
		desenharBotao("7", 0, y*3, x, y, corBotao1, g.COR_PRETO)
		desenharBotao("8", x, y*3, x, y, corBotao1, g.COR_PRETO)
		desenharBotao("9", x*2, y*3, x, y, corBotao1, g.COR_PRETO)
		desenharBotao("+", x*3, y*3, x, y, corBotao2, g.COR_BRANCO)

		desenharBotao("4", 0, y*4, x, y, corBotao1, g.COR_PRETO)
		desenharBotao("5", x, y*4, x, y, corBotao1, g.COR_PRETO)
		desenharBotao("6", x*2, y*4, x, y, corBotao1, g.COR_PRETO)
		desenharBotao("-", x*3, y*4, x, y, corBotao2, g.COR_BRANCO)

		desenharBotao("1", 0, y*5, x, y, corBotao1, g.COR_PRETO)
		desenharBotao("2", x, y*5, x, y, corBotao1, g.COR_PRETO)
		desenharBotao("3", x*2, y*5, x, y, corBotao1, g.COR_PRETO)
		desenharBotao("*", x*3, y*5, x, y, corBotao2, g.COR_BRANCO)

		desenharBotao(".", 0, y*6, x, y, corBotao1, g.COR_PRETO)
		desenharBotao("0", x, y*6, x, y, corBotao1, g.COR_PRETO)
		desenharBotao("=", x*2, y*6, x, y, corBotao1, g.COR_PRETO)
		desenharBotao("/", x*3, y*6, x, y, corBotao2, g.COR_BRANCO)
		g.renderizar()
	}
	funcao desenharBotao(cadeia titulo, inteiro posicaoX, inteiro posicaoY, inteiro largura, inteiro altura, inteiro cor, inteiro corTitulo){
		g.definir_cor(cor)
		g.desenhar_retangulo(posicaoX, posicaoY, largura , altura, falso, verdadeiro)
		g.definir_cor(corDisplay)
		g.desenhar_retangulo(posicaoX, posicaoY, largura , altura, falso, falso)
		g.definir_cor(corTitulo)
		g.definir_tamanho_texto(20.0)
		g.desenhar_texto(posicaoX + (largura / 2) -7, posicaoY + (altura / 2) - 10, titulo)
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 705; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */