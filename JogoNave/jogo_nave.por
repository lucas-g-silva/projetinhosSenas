programa
{
	inclua biblioteca Util --> u
	inclua biblioteca Graficos --> g
	inclua biblioteca Teclado --> t

	inteiro px = 390, py = 290
	logico disparo = falso

	inteiro nave = g.carregar_imagem("/nave.png")
	inteiro tiro = g.carregar_imagem("/tiro.png")

	funcao controle(){
		se(t.tecla_pressionada(t.TECLA_A) ou t.tecla_pressionada(t.TECLA_SETA_ESQUERDA)){
			px-=5
		}
		se(t.tecla_pressionada(t.TECLA_D) ou t.tecla_pressionada(t.TECLA_SETA_DIREITA)){
			px+=5
		}
		se(t.tecla_pressionada(t.TECLA_W) ou t.tecla_pressionada(t.TECLA_SETA_ACIMA)){
			py-=5
		}
		se(t.tecla_pressionada(t.TECLA_S) ou t.tecla_pressionada(t.TECLA_SETA_ABAIXO)){
			py+=5
		}
	}
	funcao controleTiro(){
		se(t.tecla_pressionada(t.TECLA_ESPACO)){
			disparar()
		}
	}
	
	funcao desenhar(){
		g.definir_cor(g.COR_BRANCO)
		g.limpar()
		g.desenhar_imagem(px, py, nave)
		g.desenhar_imagem(0, 0, tiro)
		g.definir_cor(g.COR_PRETO)
		g.desenhar_texto(750, 5, px + "; " + py)
	}
	
	funcao disparar(){
		inteiro tx = px, ty = py + 31
		enquanto(tx < 800){
			desenhar()
			controle()
			g.desenhar_imagem(tx, ty, tiro)
			tx+=20
			g.renderizar()
			u.aguarde(10)
		}
	}
	
	funcao inicio(){
		g.iniciar_modo_grafico(verdadeiro)
		g.definir_dimensoes_janela(800, 600)
		enquanto(nao t.tecla_pressionada(t.TECLA_ESC)){
			controle()
			controleTiro()
			desenhar()
			g.renderizar()
			u.aguarde(10)
		}
	}	
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 668; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */