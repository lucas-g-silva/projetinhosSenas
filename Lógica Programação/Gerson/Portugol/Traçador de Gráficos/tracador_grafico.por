programa
{
	inclua biblioteca Util --> u
	inclua biblioteca Mouse --> mo
	inclua biblioteca Matematica --> m
	inclua biblioteca Teclado --> t
	inclua biblioteca Graficos --> g

	inteiro deltaFormImg = g.carregar_imagem("/src/deltaFormula.png")
	inteiro xvFormImg = g.carregar_imagem("/src/xvFormula.png")
	inteiro yvFormImg = g.carregar_imagem("/src/yvFormula.png")
	inteiro bg = g.carregar_imagem("/src/background.png")

	logico trava_caixa_texto[3] = {falso, falso, falso}
	
	inteiro caixa_texto[3] = {1, 6, 5}
	real x1 = 0.0, x2 = 0.0, xv = 0.0, yv = 0.0, a = caixa_texto[0], b = caixa_texto[1], c = caixa_texto[2]
	real delta = 0.0

	real xt[10000], fx[10000]

	inteiro zoom = 10

	const inteiro org_x = 750
	const inteiro org_y = 350

	inteiro cinza1 = g.criar_cor(190, 190, 190)
	inteiro cinza2 = g.criar_cor(210, 210, 210)

	funcao eixo(){
		g.definir_cor(g.COR_PRETO)
		inteiro intervalo = 0
		g.definir_tamanho_texto(10.0)
		para(inteiro i = 0; i <= 250; i += zoom){
			se(intervalo % 5 == 0 ou intervalo == 0){
				g.desenhar_linha(i + org_x, 340, i + org_x, 360)
				g.desenhar_linha(org_x - i, 340, org_x - i, 360)
				
				g.desenhar_linha(740, i + org_y, 760, i + org_y)
				g.desenhar_linha(740, org_y - i, 760, org_y - i)

				g.desenhar_texto(490 - g.largura_texto(-intervalo+"")/2, i + org_y - 5, -intervalo+"")
				g.desenhar_texto(490 - g.largura_texto(intervalo+"")/2, org_y - i - 5, intervalo+"")

				g.desenhar_texto(i + org_x - g.largura_texto(-intervalo+"")/2, 605, intervalo+"")
				g.desenhar_texto(org_x - i - g.largura_texto(-intervalo+"")/2, 605, -intervalo+"")
				
			}senao{
				g.desenhar_linha(i + org_x, 347, i + org_x, 353)
				g.desenhar_linha(org_x - i, 347, org_x - i, 353)

				g.desenhar_linha(747, i + org_y, 753, i + org_y)
				g.desenhar_linha(747, org_y - i, 753, org_y - i)
			}
			intervalo++
		}
		//definir eixo x
		g.desenhar_linha(500, org_y, 1000, org_y)
		//definir eixo y
		g.desenhar_linha(org_x, 100, org_x, 600)
	}
	
	funcao grade(){
		//definir grades y
		inteiro intervalo = 4
		para(inteiro i = 0; i <= 250; i += zoom){
			se(intervalo == 4){
				g.definir_cor(cinza1)
				intervalo = 0
			}senao{
				g.definir_cor(cinza2)
				intervalo++
			}
			g.desenhar_linha(i + org_x, 100, i + org_x, 600)
			g.desenhar_linha(org_x - i, 100, org_x - i, 600)

			g.desenhar_linha(500, i + org_y, 1000, i + org_y)
			g.desenhar_linha(500, org_y - i, 1000, org_y - i)
		}
	}

	funcao texto(){
		g.definir_cor(cinza2)
		g.definir_tamanho_texto(20.0)
		
		inteiro largura_texto = g.largura_texto("x² +") + g.largura_texto("x +") + 170 + g.largura_texto("= 0")

		g.desenhar_retangulo(90, 110, largura_texto + 20, 50, verdadeiro, verdadeiro)
		
		inteiro auxiliar = 100
		caixaTexto(auxiliar, 115, 0)
		auxiliar += 50
		
		se(caixa_texto[1] < 0) g.desenhar_texto(auxiliar, 125, "x² -")
		senao g.desenhar_texto(auxiliar, 125, "x² +")
		
		auxiliar += g.largura_texto("x² +") + 10
		
		caixaTexto(auxiliar, 115, 1)
		auxiliar += 50

		g.definir_cor(g.COR_PRETO)
		
		se(caixa_texto[2] < 0) g.desenhar_texto(auxiliar, 125, "x -") 
		senao g.desenhar_texto(auxiliar, 125, "x +")
		
		auxiliar += g.largura_texto("x +") + 10

		caixaTexto(auxiliar, 115, 2)
		auxiliar += 50

		g.definir_cor(g.COR_PRETO)
		g.desenhar_texto(auxiliar, 125, "= 0")
		auxiliar += g.largura_texto("= 0")
	}

	funcao formulas(){
		inteiro auxiliarX, auxiliarY
		g.definir_cor(g.COR_PRETO)
		g.definir_tamanho_texto(25.0)
		//delta
		g.desenhar_imagem(50, 190, deltaFormImg)
		auxiliarX = 65 + g.largura_imagem(deltaFormImg)
		auxiliarY = 190 + g.altura_imagem(deltaFormImg)/2 - 20
		g.desenhar_retangulo(auxiliarX,  auxiliarY, 80, 40, falso, falso)
		g.desenhar_texto(auxiliarX + 40 - g.largura_texto(m.arredondar(delta, 2)+"")/2, auxiliarY + 20 - 25/2, m.arredondar(delta, 2)+"")
		
		g.desenhar_imagem(50, 260, xvFormImg)
		auxiliarX = 65 + g.largura_imagem(xvFormImg)
		auxiliarY = 260 + g.altura_imagem(xvFormImg)/2 - 40/2
		g.desenhar_retangulo(auxiliarX,  auxiliarY, 80, 40, falso, falso)
		g.desenhar_texto(auxiliarX + 40 - g.largura_texto(m.arredondar(xv, 2)+"")/2, auxiliarY + 20 - 25/2, m.arredondar(xv, 2)+"")
		
		g.desenhar_imagem(50, 330, yvFormImg)
		auxiliarX = 65 + g.largura_imagem(yvFormImg)
		auxiliarY = 330 + g.altura_imagem(yvFormImg)/2 - 40/2
		g.desenhar_retangulo(auxiliarX,  auxiliarY, 80, 40, falso, falso)
		g.desenhar_texto(auxiliarX + 40 - g.largura_texto(m.arredondar(yv, 2)+"")/2, auxiliarY + 20 - 25/2, m.arredondar(yv, 2)+"")

		g.desenhar_texto(50, 420, "X1 = "+ m.arredondar(x1, 2))
		g.desenhar_texto(50, 480, "X2 = "+ m.arredondar(x2, 2))
	}
	
	funcao caixaTexto(inteiro x, inteiro y, inteiro indice){
		g.definir_cor(g.COR_BRANCO)
		g.definir_opacidade(150)
		g.desenhar_retangulo(x, y, 40, 40, verdadeiro, verdadeiro)
		g.definir_opacidade(255)
		
		se(esta_clicado(x, y, 40, 40)){
			trava_caixa_texto[indice] = verdadeiro
		} senao se(mo.botao_pressionado(0)){
			trava_caixa_texto[indice] = falso
		}
		se(trava_caixa_texto[indice]){
			g.definir_cor(cinza1)
			g.desenhar_retangulo(x-1, y-1, 42, 42, verdadeiro, falso)
			se(t.tecla_pressionada(t.TECLA_ADICAO) e caixa_texto[indice] < 99){
				caixa_texto[indice]++
				u.aguarde(150)
			}
			se(t.tecla_pressionada(t.TECLA_SUBTRACAO) e caixa_texto[indice] > -99){
				caixa_texto[indice]--
				u.aguarde(150)
			}
			se(t.tecla_pressionada(t.TECLA_0_NUM)){
				caixa_texto[indice] = 0
				u.aguarde(150)
			}
			se(t.tecla_pressionada(t.TECLA_ENTER) ou t.tecla_pressionada(t.TECLA_TAB)){
				se(indice < 2){
					trava_caixa_texto[indice] = falso
					trava_caixa_texto[indice+1] = verdadeiro
				}senao{
					trava_caixa_texto[indice] = falso
					trava_caixa_texto[0] = verdadeiro
				}
				u.aguarde(150)
				
			}
		}
		g.definir_tamanho_texto(20.0)
		g.definir_cor(g.COR_PRETO)
		se(caixa_texto[indice] > 0 ou indice == 0)
			g.desenhar_texto(x + 20 - g.largura_texto(caixa_texto[indice]+"")/2, y + 20 - 10, caixa_texto[indice]+"")
		senao
			g.desenhar_texto(x + 20 - g.largura_texto((-1*caixa_texto[indice])+"")/2, y + 20 - 10, (-1*caixa_texto[indice])+"")

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
		delta = m.potencia(b, 2) - 4*a*c

		se(delta >= 0){
			x1 = (-b + m.raiz(delta, 2.0))/2*a
			x2 = (-b - m.raiz(delta, 2.0))/2*a
		} senao{
			escreva("A equação não posssui raízes reais!\n")
			limpa()
		}

		xv = (-b)/(2*a)
		yv = (-delta)/(4*a)

		g.definir_cor(g.COR_PRETO)
	}
	
	funcao parabula(){
		real valorX = -50

		real xAnt, yAnt
		
		para(inteiro x = 0; x < 10000; x++){
			valorX += 0.01
			
			xt[x] = valorX
			fx[x] = (a*m.potencia(xt[x], 2.0) + b*xt[x] + c)

			se(x > 0){
				xAnt = xt[x-1]
				yAnt = fx[x-1]
			} senao {
				xAnt = xt[x]
				yAnt = fx[x]
			}
			
			se(xt[x]*zoom <= 250 e xt[x]*zoom >= -250 e fx[x]*-zoom <= 250 e fx[x]*-zoom >= -250
			   e xAnt*zoom <= 250 e xAnt*zoom >= -250 e yAnt*zoom <= 250 e yAnt*zoom >= -250){
				g.desenhar_linha(xt[x]*zoom+org_x, fx[x]*-zoom+org_y, xAnt*zoom+org_x, yAnt*-zoom+org_y)
			}
			xAnt = xt[x]
			yAnt = fx[x]
		}
	}

	funcao desenhar(){
		g.desenhar_imagem(0, 0, bg)

		grade()
		eixo()
		
		g.definir_cor(g.COR_PRETO)
		/*//Definir Retângulo do título
		g.desenhar_retangulo(20, 10, 980, 80, falso, falso)
		//Definir retângulo da equação
		g.desenhar_retangulo(20, 100, 450, 500, falso, falso)
		//Definir retângulo do eixo
		g.desenhar_retangulo(500, 100, 500, 500, falso, falso)*/
		
		parabula()
		texto()
		formulas()

		controle()
		
		g.renderizar()
	}

	funcao controle(){
		se(trava_caixa_texto[0] == falso e trava_caixa_texto[1] == falso e trava_caixa_texto[2] == falso){
			se(t.tecla_pressionada(t.TECLA_CONTROL) e t.tecla_pressionada(t.TECLA_ADICAO) e zoom < 30){
				zoom++
				u.aguarde(150)
			}
			se(t.tecla_pressionada(t.TECLA_CONTROL) e t.tecla_pressionada(t.TECLA_SUBTRACAO) e zoom > 5){
				zoom--
				u.aguarde(150)
			}
		}
	}
	
	funcao inicio(){
		g.iniciar_modo_grafico(verdadeiro)
		g.definir_dimensoes_janela(1024, 660)
		g.definir_titulo_janela("Traçador Gráfico de Funções")
		enquanto(nao t.tecla_pressionada(t.TECLA_ESC)){
			desenhar()
			calcularPontos()
		}
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 4717; 
 * @DOBRAMENTO-CODIGO = [29, 62, 116, 190, 197, 217, 245];
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */