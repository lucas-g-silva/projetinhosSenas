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

	logico trava_caixa_texto[3] = {falso, falso, falso}
	
	inteiro caixa_texto[3] = {1, 6, 5}
	real x1 = 0.0, x2 = 0.0, xv = 0.0, yv = 0.0, a = caixa_texto[0], b = caixa_texto[1], c = caixa_texto[2]
	real delta = 0.0

	//real xt[8000], fx[8000]

	inteiro zoom = 15

	real xAnt = 0.01
	real yAnt = (a*m.potencia(0.01, 2.0) + b*0.01 + c)

	const inteiro org_x = 750
	const inteiro org_y = 350

	funcao eixo(){
		g.definir_cor(g.COR_VERMELHO)
		inteiro intervalo = 0
		g.definir_tamanho_texto(10.0)
		para(inteiro i = 0; i <= 250; i += zoom){
			se(intervalo % 5 == 0 ou intervalo == 0){
				g.desenhar_linha(i + org_x, 340, i + org_x, 360)
				g.desenhar_linha(org_x - i, 340, org_x - i, 360)
				
				g.desenhar_linha(740, i + org_y, 760, i + org_y)
				g.desenhar_linha(740, org_y - i, 760, org_y - i)

				g.desenhar_texto(495 - g.largura_texto(-intervalo+""), i + org_y - 5, -intervalo+"")
				g.desenhar_texto(495 - g.largura_texto(intervalo+""), org_y - i - 5, intervalo+"")
				
			}senao{
				g.desenhar_linha(i + org_x, 347, i + org_x, 353)
				g.desenhar_linha(org_x - i, 347, org_x - i, 353)

				g.desenhar_linha(747, i + org_y, 753, i + org_y)
				g.desenhar_linha(747, org_y - i, 753, org_y - i)
			}
			intervalo++
		}
		g.definir_cor(g.COR_VERMELHO)
		//definir eixo x
		g.desenhar_linha(500, org_y, 1000, org_y)
		//definir eixo y
		g.desenhar_linha(org_x, 100, org_x, 600)
	}
	
	funcao grade(){
		//definir cores grades
		inteiro cinza1 = g.criar_cor(210, 210, 210)
		inteiro cinza2 = g.criar_cor(230, 230, 230)

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
		se(esta_clicado(x, y, 40, 40)){
			trava_caixa_texto[indice] = verdadeiro
		} senao se(mo.botao_pressionado(0)){
			trava_caixa_texto[indice] = falso
		}
		se(trava_caixa_texto[indice]){
			g.definir_cor(g.COR_VERMELHO)
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
		real valorX = -zoom*2.5

		real xt, fx
		
		para(inteiro x = 0; x < 10000; x++){
			valorX += 0.01
			
			xt = valorX
			fx = (a*m.potencia(xt, 2.0) + b*xt + c)
			
			se(xt*zoom <= 250 e xt*zoom >= -250 e fx*-zoom <= 250 e fx*-zoom >= -250
			   /*e xAnt*zoom+org_x <= 1000 e xAnt*zoom+org_x >= 500 e yAnt*zoom+org_y <= 600 e yAnt*zoom+org_y >= 100*/){
				g.desenhar_linha(xt*zoom+org_x, fx*-zoom+org_y, xAnt*zoom+org_x, yAnt*-zoom+org_y)
			}
			xAnt = xt
			yAnt = fx
		}
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
		g.desenhar_retangulo(20, 100, 450, 500, falso, falso)
		//Definir retângulo do eixo
		g.desenhar_retangulo(500, 100, 500, 500, falso, falso)
		
		parabula()
		texto()
		formulas()

		controle()

		g.desenhar_texto(50, 575, "Zoom: "+ zoom)
		
		g.renderizar()
	}

	funcao controle(){
		se(t.tecla_pressionada(t.TECLA_CONTROL) e t.tecla_pressionada(t.TECLA_ADICAO) e zoom < 30){
			zoom++
			u.aguarde(150)
		}
		se(t.tecla_pressionada(t.TECLA_CONTROL) e t.tecla_pressionada(t.TECLA_SUBTRACAO) e zoom > 5){
			zoom--
			u.aguarde(150)
		}
	}
	
	funcao inicio(){
		g.iniciar_modo_grafico(verdadeiro)
		g.definir_dimensoes_janela(1024, 630)
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
 * @POSICAO-CURSOR = 1342; 
 * @DOBRAMENTO-CODIGO = [59, 82, 119, 146, 191, 198];
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */