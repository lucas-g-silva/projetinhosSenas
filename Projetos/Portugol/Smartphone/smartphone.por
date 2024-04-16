programa
{
	inclua biblioteca Texto --> txt
	inclua biblioteca Calendario --> c
	inclua biblioteca Teclado --> t
	inclua biblioteca Graficos --> g

	const inteiro LARGURA_JANELA = 400, ALTURA_JANELA = 800
	inteiro wallpaper = g.carregar_imagem("/wallpaper.png")
	logico tela_bloqueio = verdadeiro, tela_inicial = falso
	
	funcao inicio()
	{
		g.iniciar_modo_grafico(verdadeiro)
		g.definir_dimensoes_janela(LARGURA_JANELA, ALTURA_JANELA)
		g.definir_titulo_janela("Smartphone")
		enquanto(nao t.tecla_pressionada(t.TECLA_ESC)){
			g.definir_fonte_texto("Arial")
			se(tela_bloqueio == verdadeiro){
				desenharTelaDeBloqueio()
			} senao se (tela_inicial == verdadeiro){
				desenharTelaInicial()
			}
			g.renderizar()
		}
	}
	funcao desenharTelaDeBloqueio(){
		g.desenhar_imagem(0, 0, wallpaper)
		relogioTelaInicial()
	}
	funcao relogioTelaInicial(){
		inteiro hora = c.hora_atual(falso)
		inteiro minuto = c.minuto_atual()

		cadeia h = ""
		cadeia m = ""

		se(txt.numero_caracteres(hora+"") == 1)
			h += "0"
		h += hora
		se(txt.numero_caracteres(minuto+"") == 1)
			m += "0"
		m += minuto

		g.definir_tamanho_texto(60.0)
		g.definir_cor(g.COR_BRANCO)
		g.desenhar_texto(LARGURA_JANELA/2 - g.largura_texto(h+":"+m)/2, 120, h+":"+m)
	}
	funcao desenharTelaInicial(){
		g.desenhar_imagem(0, 0, wallpaper)
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 1244; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */