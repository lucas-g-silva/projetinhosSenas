programa
{
	inclua biblioteca Util --> u
	inclua biblioteca Mouse --> mo
	inclua biblioteca Matematica --> m
	inclua biblioteca Teclado --> t
	inclua biblioteca Graficos --> g

	logico trava_caixa_texto[3] = {falso, falso, falso}
	inteiro caixa_texto[3] = {1, -3, -54}
	real x1 = 0.0, x2 = 0.0, xv = 0.0, yv = 0.0, a = caixa_texto[0], b = caixa_texto[1], c = caixa_texto[2], xf = 0.0 yf = 0.0
	real delta = 0.0

	funcao eixo(){
		//definir marcações eixo x
		g.definir_cor(g.COR_VERMELHO)
		para(inteiro i = 500; i < 1000; i += 5){
			se(i % 50 == 0){
				g.desenhar_linha(i, 325, i, 345)
			}senao se(i != 0){
				g.desenhar_linha(i, 332, i, 338)
			}
		}
		//definir marcações eixo y
		para(inteiro i = 100; i < 570; i += 5){
			se((i + 15) % 50 == 0){
				g.desenhar_linha(740, i, 760, i)
			}senao se(i != 0){
				g.desenhar_linha(747, i, 753, i)
			}
		}
		g.definir_cor(g.COR_VERMELHO)
		//definir eixo x
		g.desenhar_linha(500, 335, 1000, 335)
		//definir eixo y
		g.desenhar_linha(750, 100, 750, 570)
	}
	
	funcao grade(){
		//definir cores grades
		inteiro cinza1 = g.criar_cor(210, 210, 210)
		inteiro cinza2 = g.criar_cor(230, 230, 230)

		//definir grades y
		para(inteiro i = 500; i < 1000; i += 5){
			se(i % 50 == 0){
				g.definir_cor(cinza1)
			}senao se(i != 0){
				g.definir_cor(cinza2)
			}
			g.desenhar_linha(i, 100, i, 570)
		}
		//definir grades x
		para(inteiro i = 100; i < 570; i += 5){
			se((i + 15) % 50 == 0){
				g.definir_cor(cinza1)
			}senao se(i != 0){
				g.definir_cor(cinza2)
			}
			g.desenhar_linha(500, i, 1000, i)
		}
	}

	funcao texto(){
		//Exibição do
		inteiro auxiliar = 30
		caixaTexto(auxiliar, 110, 0)
		auxiliar += 50

		g.definir_cor(g.COR_PRETO)
		g.definir_tamanho_texto(30.0)
		se(caixa_texto[1] < 0){
			g.desenhar_texto(auxiliar, 115, "x² -")
			auxiliar += g.largura_texto("x² -") + 10
		} senao{
			g.desenhar_texto(auxiliar, 115, "x² +")
			auxiliar += g.largura_texto("x² +") + 10
		}
		
		caixaTexto(auxiliar, 110, 1)
		auxiliar += 50

		g.definir_cor(g.COR_PRETO)
		g.definir_tamanho_texto(30.0)
		se(caixa_texto[2] < 0){
			g.desenhar_texto(auxiliar, 115, "x -")
			auxiliar += g.largura_texto("x -") + 10
		} senao {
			g.desenhar_texto(auxiliar, 115, "x +")
			auxiliar += g.largura_texto("x +") + 10
		}

		caixaTexto(auxiliar, 110, 2)
		auxiliar += 50

		g.definir_cor(g.COR_PRETO)
		g.definir_tamanho_texto(30.0)
		g.desenhar_texto(auxiliar, 115, "= 0")
	}

	funcao caixaTexto(inteiro x, inteiro y, inteiro indice){
		se(esta_clicado(x, y, 40, 40)){
			trava_caixa_texto[indice] = verdadeiro
		} senao se(mo.botao_pressionado(0)){
			trava_caixa_texto[indice] = falso
		}
		se(trava_caixa_texto[indice]){
			g.definir_cor(g.COR_VERMELHO)
			se(t.tecla_pressionada(t.TECLA_ADICAO) e caixa_texto[indice] < 99){
				caixa_texto[indice]++
				u.aguarde(100)
				calcularPontos()
			}
			se(t.tecla_pressionada(t.TECLA_SUBTRACAO) e caixa_texto[indice] > -99){
				caixa_texto[indice]--
				u.aguarde(100)
				calcularPontos()
			}
			se(t.tecla_pressionada(t.TECLA_0_NUM)){
				caixa_texto[indice] = 0
				u.aguarde(100)
				calcularPontos()
			}
			
		}senao{
			g.definir_cor(g.COR_PRETO)
		}
		g.desenhar_retangulo(x, y, 40, 40, falso, falso)
		g.definir_tamanho_texto(25.0)
		g.definir_cor(g.COR_PRETO)
		se(caixa_texto[indice] > 0 ou indice == 0)
			g.desenhar_texto(x + 20 - g.largura_texto(caixa_texto[indice]+"")/2, y + 20 - 25/2, caixa_texto[indice]+"")
		senao
			g.desenhar_texto(x + 20 - g.largura_texto((-1*caixa_texto[indice])+"")/2, y + 20 - 25/2, (-1*caixa_texto[indice])+"")

	}
	
	funcao logico esta_clicado(inteiro x, inteiro y, inteiro largura, inteiro altura){
		se(mo.posicao_x() > x e mo.posicao_x() < x + largura e mo.posicao_y() > y e mo.posicao_y() < y + altura e mo.botao_pressionado(0)){
			retorne verdadeiro
		}
		retorne falso
	}

	funcao calcularPontos(){
		a = caixa_texto[0]
		b = caixa_texto[1]
		c = caixa_texto[2]
		real delta = m.potencia(b, 2) - 4*a*c
		x1 = (-b + m.raiz(delta, 2))/2*a
		x2 = (-b - m.raiz(delta, 2))/2*a

		xv = -b/2*a
		yv = -delta/4*a

		xf = xv
		yf = yv - m.potencia(base, expoente)

		g.definir_cor(g.COR_PRETO)
		
		limpa()
		escreva(delta+"\n"+x1+"\n"+x2+"\n"+xv+"\n"+yv)
	}
	
	funcao parabula(){
		
	}

	funcao desenhar(){
		g.definir_cor(g.COR_BRANCO)
		g.limpar()

		grade()
		eixo()
		
		g.definir_cor(g.COR_PRETO)
		//Definir Retângulo do título
		g.desenhar_retangulo(20, 10, 980, 80, falso, falso)
		//Definir retângulo da equação
		g.desenhar_retangulo(20, 100, 450, 470, falso, falso)
		//Definir retângulo do eixo
		g.desenhar_retangulo(500, 100, 500, 470, falso, falso)

		g.desenhar_elipse(500 + 500/2 + x1*5 - 4, 100 + 470/2 - 4, 8, 8, verdadeiro)

		g.desenhar_elipse(500 + 500/2 + x2*5 - 4, 100 + 470/2 - 4, 8, 8, verdadeiro)

		g.desenhar_elipse(500 + 500/2 + xv*5 - 4, 100 + 470/2 + yv - 4, 8, 8, verdadeiro)

		g.desenhar_elipse(500 + 500/2 - 4, 100 + 470/2 + pc - 4, 8, 8, verdadeiro)

		inteiro x = xv
		inteiro y = yv
		enquanto(x < 50 e y < 47){
			
			g.desenhar_elipse(500 + 500/2 + x*5 - 4, 100 + 470/2 + y - 4, 8, 8, verdadeiro)
		}

		texto()
		
		g.renderizar()
	}
	
	funcao inicio(){
		g.iniciar_modo_grafico(verdadeiro)
		g.definir_dimensoes_janela(1024, 600)
		g.definir_titulo_janela("Traçador Gráfico de Funções")
		enquanto(nao t.tecla_pressionada(t.TECLA_ESC)){
			desenhar()
		}
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 3561; 
 * @DOBRAMENTO-CODIGO = [13, 38, 63, 137, 164];
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */