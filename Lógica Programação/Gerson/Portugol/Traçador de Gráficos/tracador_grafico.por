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
	inteiro chevronIcon = g.carregar_imagem("/src/chevronIcon.png")

	logico trava_caixa_texto[3] = {falso, falso, falso}
	logico trava_formulas[3] = {falso, falso, falso}
	logico formula_ativa = verdadeiro
	
	inteiro caixa_texto[3] = {1, 6, 5}
	real x1 = 0.0, x2 = 0.0, xv = 0.0, yv = 0.0, a = caixa_texto[0], b = caixa_texto[1], c = caixa_texto[2]
	real delta = 0.0

	real xt[10000], fx[10000]

	inteiro zoom = 10

	inteiro org_x = 750
	inteiro org_y = 350

	inteiro cinza1 = g.criar_cor(190, 190, 190)
	inteiro cinza2 = g.criar_cor(210, 210, 210)

	inteiro bg1 = g.criar_cor(231, 231, 231)
	inteiro bg2 = g.criar_cor(217, 217, 217)

	inteiro destaque = g.criar_cor(21, 138, 12)

	funcao eixo(){
		g.definir_cor(g.COR_PRETO)
		inteiro intervalo = 0
		g.definir_tamanho_texto(10.0)
		para(inteiro i = org_x; i <= 1000; i += zoom){
			se(intervalo % 5 == 0 ou intervalo == 0){
				g.desenhar_linha(i, org_y - 10, i, org_y + 10)
				g.desenhar_texto(i - g.largura_texto(intervalo+"")/2, 600 + 5, intervalo+"")
			}senao{
				g.desenhar_linha(i, org_y - 3, i, org_y + 3)
			}
			intervalo++
		}
		intervalo = 0
		para(inteiro i = org_x; i >= 500; i -= zoom){
			se(intervalo % 5 == 0 ou intervalo == 0){
				g.desenhar_linha(i, org_y - 10, i, org_y + 10)
				g.desenhar_texto(i - g.largura_texto(intervalo+"")/2, 600 + 5, intervalo+"")
			}senao{
				g.desenhar_linha(i, org_y - 3, i, org_y + 3)
			}
			intervalo++
		}
		intervalo = 0
		para(inteiro i = org_y; i <= 600; i += zoom){
			se(intervalo % 5 == 0 ou intervalo == 0){
				g.desenhar_linha(org_x - 10, i, org_x + 10, i)
				g.desenhar_texto(495 - g.largura_texto(intervalo+"")/2, i - 5, intervalo+"")
			}senao{
				g.desenhar_linha(org_x - 3, i, org_x + 3, i)
			}
			intervalo++
		}
		intervalo = 0
		para(inteiro i = org_y; i >= 100; i -= zoom){
			se(intervalo % 5 == 0 ou intervalo == 0){
				g.desenhar_linha(org_x - 10, i, org_x + 10, i)
				g.desenhar_texto(495 - g.largura_texto(intervalo+"")/2, i - 5, intervalo+"")
			}senao{
				g.desenhar_linha(org_x - 3, i, org_x + 3, i)
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
		para(inteiro i = org_x; i <= 1000; i += zoom){
			se(intervalo == 4){
				g.definir_cor(cinza1)
				intervalo = 0
			}senao{
				g.definir_cor(cinza2)
				intervalo++
			}
			g.desenhar_linha(i, 100, i, 600)
		}
		intervalo = 4
		para(inteiro i = org_x; i >= 500; i -= zoom){
			se(intervalo == 4){
				g.definir_cor(cinza1)
				intervalo = 0
			}senao{
				g.definir_cor(cinza2)
				intervalo++
			}
			g.desenhar_linha(i, 100, i, 600)
		}
		intervalo = 4
		para(inteiro i = org_y; i <= 600; i += zoom){
			se(intervalo == 4){
				g.definir_cor(cinza1)
				intervalo = 0
			}senao{
				g.definir_cor(cinza2)
				intervalo++
			}
			g.desenhar_linha(500, i, 1000, i)
		}
		intervalo = 4
		para(inteiro i = org_y; i >= 100; i -= zoom){
			se(intervalo == 4){
				g.definir_cor(cinza1)
				intervalo = 0
			}senao{
				g.definir_cor(cinza2)
				intervalo++
			}
			g.desenhar_linha(500, i, 1000, i)
		}
	}

	funcao texto(){
		g.definir_tamanho_texto(20.0)

		cadeia textos[3] = {"x² +", "x +", "= 0"}
		cadeia textos_alternativos[2] = {"x²  -", "x  -"}
		
		inteiro largura_texto = g.largura_texto(textos[0]) + g.largura_texto(textos[1]) + 170 + g.largura_texto(textos[2])

		inteiro x_ret = 239 - (largura_texto + 20) / 2
		inteiro y_ret = 120

		g.definir_cor(bg2)
		g.desenhar_retangulo(x_ret, y_ret, largura_texto + 20, 50, verdadeiro, verdadeiro)

		inteiro auxiliar = 100
		para(inteiro i = 0; i < 3; i++){
			caixaTexto(auxiliar, y_ret + 5, i)
			auxiliar += 50
			g.definir_cor(g.COR_PRETO)
			se(i < 2){
				se(caixa_texto[i+1] >= 0) g.desenhar_texto(auxiliar, y_ret + 15, textos[i])
				senao g.desenhar_texto(auxiliar, y_ret + 15, textos_alternativos[i])
			} senao {
				g.desenhar_texto(auxiliar, y_ret + 15, "= 0")
			}
			auxiliar += g.largura_texto(textos[i]) + 10
		}
	}

	funcao formulas(){
		g.definir_cor(cinza1)
		g.desenhar_linha(44, 200, 430, 200)
		g.definir_tamanho_texto(12.0)
		cadeia titulos[3] = {"Delta", "Vértice", "Raízes"}
		inteiro py = 210
		para(inteiro i = 0; i < 3; i++){
			se(esta_hover(24, py, 430, 50) ou trava_formulas[i]) g.definir_cor(bg2)
			senao g.definir_cor(bg1)
			se(trava_formulas[i]){
				g.desenhar_retangulo(24, py, 430, 200, verdadeiro, verdadeiro)
				escolha(i){
					caso 0:
						g.desenhar_imagem(74, py + 100 - g.altura_imagem(deltaFormImg)/2, deltaFormImg)
						g.definir_tamanho_texto(24.0)
						g.definir_cor(g.COR_PRETO)
						g.desenhar_texto(134 + g.largura_imagem(deltaFormImg), py + 88, (m.arredondar(delta, 2)+""))
						g.definir_tamanho_texto(12.0)
						pare
				}
			}senao{
				g.desenhar_retangulo(24, py, 430, 50, verdadeiro, verdadeiro)
			}
			g.definir_cor(g.COR_PRETO)
			g.desenhar_texto(74, py + 18, titulos[i])
			se(trava_formulas[i]) g.definir_rotacao(180)
			senao g.definir_rotacao(0)
			g.desenhar_imagem(44, py + 22, chevronIcon)
			g.definir_rotacao(0)

			se(esta_clicado(34, py + 12, g.largura_imagem(chevronIcon) + 20, g.altura_imagem(chevronIcon) + 20)){
				se(trava_formulas[i]) trava_formulas[i] = falso
				senao{
					para(inteiro c = 0; c < 3; c++) trava_formulas[c] = falso
					trava_formulas[i] = verdadeiro
				}
				u.aguarde(200)
			}
			se(esta_clicado(24, py, 430, 50)){
				para(inteiro c = 0; c < 3; c++) trava_formulas[c] = falso
				trava_formulas[i] = verdadeiro
				u.aguarde(200)
			}
			se(trava_formulas[i]) py += 210
			senao py += 60
		}
		
		/*inteiro auxiliarX, auxiliarY
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
		g.desenhar_texto(50, 480, "X2 = "+ m.arredondar(x2, 2))*/
	}
	
	funcao caixaTexto(inteiro x, inteiro y, inteiro indice){
		se(esta_clicado(x, y, 40, 40)){
			trava_caixa_texto[indice] = verdadeiro
		} senao se(mo.botao_pressionado(0)){
			trava_caixa_texto[indice] = falso
		}
		se(trava_caixa_texto[indice]){
			g.definir_cor(destaque)
			g.desenhar_retangulo(x-3, y-3, 45, 45, verdadeiro, falso)
			g.definir_cor(g.criar_cor(240, 240, 240))
			se(nao t.tecla_pressionada(t.TECLA_CONTROL)){
				se(t.tecla_pressionada(t.TECLA_ADICAO) e caixa_texto[indice] < 99){
					caixa_texto[indice]++
					u.aguarde(200)
				}
				se(t.tecla_pressionada(t.TECLA_SUBTRACAO) e caixa_texto[indice] > -99){
					caixa_texto[indice]--
					u.aguarde(200)
				}
			}
			se(t.tecla_pressionada(t.TECLA_0_NUM)){
				caixa_texto[indice] = 0
				u.aguarde(200)
			}
			se(t.tecla_pressionada(t.TECLA_ENTER) ou t.tecla_pressionada(t.TECLA_TAB)){
				se(indice < 2){
					trava_caixa_texto[indice] = falso
					trava_caixa_texto[indice+1] = verdadeiro
				}senao{
					trava_caixa_texto[indice] = falso
					trava_caixa_texto[0] = verdadeiro
				}
				u.aguarde(200)
				
			}
		}senao{
			g.definir_cor(bg1)
		}
		g.desenhar_retangulo(x, y, 40, 40, verdadeiro, verdadeiro)
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
	
	funcao logico esta_hover(inteiro x, inteiro y, inteiro largura, inteiro altura){
		se(mo.posicao_x() > x e mo.posicao_x() < x + largura e mo.posicao_y() > y e mo.posicao_y() < y + altura){
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
		real valorX = -50.0
		real xAnt, yAnt

		g.definir_cor(destaque)
		
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
			
			se(xt[x]*zoom+org_x <= 1000 e xt[x]*zoom+org_x >= 500 e fx[x]*-zoom+org_y <= 600 e fx[x]*-zoom+org_y >= 100
			   e xAnt*zoom+org_x <= 1000 e xAnt*zoom+org_x >= 500 e yAnt*-zoom+org_y <= 600 e yAnt*-zoom+org_y >= 100){
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
		parabula()
		texto()
		formulas()
		
		g.renderizar()
	}

	funcao controle(){
		se(t.tecla_pressionada(t.TECLA_CONTROL) e t.tecla_pressionada(t.TECLA_ADICAO) e zoom < 30){
			zoom++
			u.aguarde(200)
		}
		se(t.tecla_pressionada(t.TECLA_CONTROL) e t.tecla_pressionada(t.TECLA_SUBTRACAO) e zoom > 5){
			zoom--
			u.aguarde(200)
		}
		inteiro pxAuxiliar = mo.posicao_x()
		inteiro pyAuxiliar = mo.posicao_y()
		inteiro diferencaX = pxAuxiliar - org_x
		inteiro diferencaY = pyAuxiliar - org_y
		se(esta_clicado(500, 100, 500, 500)){
			enquanto(mo.botao_pressionado(0)){
				org_x = mo.posicao_x() - diferencaX
				org_y = mo.posicao_y() - diferencaY
				se(org_x < 550) org_x = 550
				se(org_x > 950) org_x = 950
				se(org_y < 150) org_y = 150
				se(org_y > 550) org_y = 550
				desenhar()
				calcularPontos()
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
			controle()
		}
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 1115; 
 * @DOBRAMENTO-CODIGO = [37, 86, 134, 236, 284, 291, 298, 318, 347, 359, 386];
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */