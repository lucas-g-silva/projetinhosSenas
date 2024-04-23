programa
{
	inclua biblioteca Texto --> txt
	inclua biblioteca Calendario --> c
	inclua biblioteca Teclado --> t
	inclua biblioteca Arquivos --> a
	inclua biblioteca Graficos --> g
	inclua biblioteca Util --> u
	inclua biblioteca Mouse --> m

	const inteiro XY = 80, IMG_XY = 72
	const inteiro PEAO_B = 11, TORRE_B = 9, CAVALO_B = 10, BISPO_B = 8, RAINHA_B = 12, REI_B = 13
	const inteiro PEAO_P = 3, TORRE_P = 1, CAVALO_P = 2, BISPO_P = 0, RAINHA_P = 4, REI_P = 5
	inteiro logoImg = g.carregar_imagem("/logo.png")
	const cadeia nmPecas[] = {"b", "t", "c", "p", "q", "r", ""}
	inteiro imgPecasBrancas[6], imgPecasPretas[6]
	inteiro corTab[] = {g.criar_cor(232, 237, 249), g.criar_cor(183, 192, 216), g.criar_cor(153, 144, 236), g.criar_cor(52, 54, 76), g.criar_cor(244, 247, 250)}
	inteiro corBtns[] = {g.criar_cor(255, 100, 100), g.criar_cor(100, 255, 100)}
	inteiro posicoes[8][8]
	inteiro possibilidades[8][8]
	inteiro clicado[2]
	cadeia vez = ""
	logico chequeB, chequeP
	inteiro segundoAnterior = c.segundo_atual()
	inteiro minP = 10, segP = 0
	inteiro minB = 10, segB = 0
	cadeia mB, mP, sB, sP
	
	funcao inicio(){
		g.iniciar_modo_grafico(verdadeiro)
		g.definir_dimensoes_janela(1000, 660)
		g.definir_titulo_janela("Xadrez")
		recomecar()
		para(inteiro i = 0; i < 6; i++){
			imgPecasBrancas[i] = g.carregar_imagem("/pecas/" + nmPecas[i] + "-white.jpg")
			imgPecasPretas[i] = g.carregar_imagem("/pecas/" + nmPecas[i] + "-black.jpg")
		}
		enquanto(nao t.tecla_pressionada(t.TECLA_ESC)){
			inteiro segundoAtual = c.segundo_atual()
			temporizador(segundoAtual)
			tela()
			tabuleiro()
			pecas()
			ctrl()
			g.renderizar()
		}
	}
	funcao temporizador(inteiro segundoAtual){
		se(segundoAtual != segundoAnterior){
			segundoAnterior = segundoAtual
			se(vez == "branco"){
				se(segB > 0){
					segB--
				} senao{
					segB = 59
					minB--
				}
			} senao{
				se(segP > 0){
					segP--
				} senao{
					segP = 59
					minP--
				}
			}
		}
		mB = ""
		mP = "" 
		sB = ""
		sP = ""
		se(txt.numero_caracteres(minB + "") == 1){
			mB += "0"
		}
		mB += minB
		se(txt.numero_caracteres(minP + "") == 1){
			mP += "0"
		}
		mP += minP
		se(txt.numero_caracteres(segB + "") == 1){
			sB += "0"
		}
		sB += segB
		se(txt.numero_caracteres(segP + "") == 1){
			sP += "0"
		}
		sP += segP
	}
	funcao tela(){
		g.definir_cor(corTab[3])
		g.limpar()
		g.desenhar_imagem(660+97, 40, logoImg)
		g.definir_estilo_texto(falso, falso, falso)

		se(vez == "branco")
			g.definir_cor(corTab[4])
		senao{
			g.definir_cor(corTab[3])
		}
		g.definir_opacidade(15)
		g.desenhar_retangulo(660, 120, 330, 90, verdadeiro, verdadeiro)
		g.definir_opacidade(255)
		g.definir_cor(corTab[4])
		g.definir_tamanho_texto(20.0)
		g.desenhar_texto(750, 120+90/2-20/2, "Jogador 1")
		g.definir_tamanho_texto(30.0)
		g.desenhar_texto(890, 120+90/2-30/2, mB + ":" + sB)
		g.desenhar_imagem(669, 129, imgPecasBrancas[3])

		se(vez == "preto")
			g.definir_cor(corTab[4])
		senao
			g.definir_cor(corTab[3])
		g.definir_opacidade(15)
		g.desenhar_retangulo(660, 220, 330, 90, verdadeiro, verdadeiro)
		g.definir_opacidade(255)
		g.definir_cor(corTab[4])
		g.definir_tamanho_texto(20.0)
		g.desenhar_texto(750, 220+90/2-20/2, "Jogador 2")
		g.definir_tamanho_texto(30.0)
		g.desenhar_texto(890, 220+90/2-30/2, mP + ":" + sP)
		g.desenhar_imagem(669, 229, imgPecasPretas[3])

		se(esta_em_hover(660, 520, 330, 60)){
			g.definir_cor(corBtns[1])
		} senao {
			g.definir_cor(corTab[4])
		}
		g.definir_tamanho_texto(20.0)
		g.definir_opacidade(75)
		g.desenhar_retangulo(660, 520, 330, 60, verdadeiro, verdadeiro)
		g.definir_opacidade(255)
		g.definir_cor(corTab[4])
		g.desenhar_texto(660+330/2-g.largura_texto("Recomeçar")/2, 520+60/2-20/2, "Recomeçar")
		
		se(esta_em_hover(660, 590, 330, 60)){
			g.definir_cor(corBtns[0])
		} senao {
			g.definir_cor(corTab[4])
		}
		g.definir_opacidade(75)
		g.desenhar_retangulo(660, 590, 330, 60, verdadeiro, verdadeiro)
		g.definir_cor(corTab[4])
		g.definir_opacidade(255)
		g.desenhar_texto(660+330/2-g.largura_texto("Sair do Jogo")/2, 590+60/2-20/2, "Sair do Jogo")
	}
	funcao tabuleiro(){
		cadeia letras[] = {"A", "B", "C", "D", "E", "F", "G", "H"}
		g.definir_estilo_texto(falso, verdadeiro, falso)
		g.definir_tamanho_texto(10.0)
		para(inteiro j = 0; j < 8; j++){
     		para(inteiro i = 0; i < 8; i++){
     			se(((j+1) % 2) == ((i+1) % 2)){
     				se(j == clicado[0] e i == clicado[1]){
     					g.definir_cor(corTab[2])
     				} senao{
     					g.definir_cor(corTab[0])
     				}
     				se(i == 0 e j == 0){
     					g.desenhar_retangulo(XY*i+10, XY*j+10, XY, XY, verdadeiro, verdadeiro)
     					g.desenhar_retangulo(XY*i+50, XY*j+10, XY/2, XY, falso, verdadeiro)
     					g.desenhar_retangulo(XY*i+10, XY*j+50, XY, XY/2, falso, verdadeiro)
     				}
     				senao se(i == 7 e j == 7){
     					g.desenhar_retangulo(XY*i+10, XY*j+10, XY, XY, verdadeiro, verdadeiro)
     					g.desenhar_retangulo(XY*i+10, XY*j+10, XY/2, XY, falso, verdadeiro)
     					g.desenhar_retangulo(XY*i+10, XY*j+10, XY, XY/2, falso, verdadeiro)
     				}senao{
     					g.desenhar_retangulo(XY*i+10, XY*j+10, XY, XY, falso, verdadeiro)
     				}
     				g.definir_cor(corTab[1])
     				se(i == 0){
     					g.desenhar_texto(XY*i + 12, XY*j + 12, j+1 + "")
     				}
     				se(j == 7){
     					g.desenhar_texto(XY*(i+1)-2, XY*(j+1)-8 + 4, letras[i])
     				}
     			} senao{
     				se(j == clicado[0] e i == clicado[1]){
     					g.definir_cor(corTab[2])
     				} senao{
     					g.definir_cor(corTab[1])
     				}
     				se(i == 7 e j == 0){
     					g.desenhar_retangulo(XY*i+10, XY*j+10, XY, XY, verdadeiro, verdadeiro)
     					g.desenhar_retangulo(XY*i+10, XY*j+10, XY/2, XY, falso, verdadeiro)
     					g.desenhar_retangulo(XY*i+10, XY*j+50, XY, XY/2, falso, verdadeiro)
     				}
     				senao se(i == 0 e j == 7){
     					g.desenhar_retangulo(XY*i+10, XY*j+10, XY, XY, verdadeiro, verdadeiro)
     					g.desenhar_retangulo(XY*i+50, XY*j+10, XY/2, XY, falso, verdadeiro)
     					g.desenhar_retangulo(XY*i+10, XY*j+10, XY, XY/2, falso, verdadeiro)
     				}senao{
     					g.desenhar_retangulo(XY*i+10, XY*j+10, XY, XY, falso, verdadeiro)
     				}
     				g.definir_cor(corTab[0])
     				se(i == 0){
     					g.desenhar_texto(XY*i + 12, XY*j + 12, j+1 + "")
     				}
     				se(j == 7){
     					g.desenhar_texto(XY*(i+1)-2, XY*(j+1)-8 + 4, letras[i])
     				}
     			}
     			se(esta_em_hover(XY*i+10, XY*j+10, XY, XY)){
					g.definir_cor(corTab[2])
					g.definir_opacidade(75)
					g.desenhar_retangulo(XY*i+10, XY*j+10, XY, XY, falso, verdadeiro)
					g.definir_opacidade(255)
				}
     		}
     	}
     	g.definir_cor(g.COR_PRETO)
     	g.desenhar_texto(0, 0, clicado[0] +"; "+ clicado[1])
	}
	funcao pecas(){
		para(inteiro j = 0; j < 8; j++){
			para(inteiro i = 0; i < 8; i++){
				se(possibilidades[j][i] == 1){
					se(posicoes[j][i] == 7){
						botao(i, j, falso)
					} senao {
						botao(i, j, verdadeiro)
					}
					
				}
				escolha(posicoes[j][i]){
					caso 3:
						peao(i, j, "preto", estaClicado(j, i))
						pare
					caso 11:
						peao(i, j, "branco", estaClicado(j, i))
						pare
					caso 1:
						torre(i, j, "preto", estaClicado(j, i))
						pare
					caso 9:
						torre(i, j, "branco", estaClicado(j, i))
						pare
					caso 2:
						cavalo(i, j, "preto", estaClicado(j, i))
						pare
					caso 10:
						cavalo(i, j, "branco", estaClicado(j, i))
						pare
					caso 0:
						bispo(i, j, "preto", estaClicado(j, i))
						pare
					caso 8:
						bispo(i, j, "branco", estaClicado(j, i))
						pare
					caso 5:
						rei(i, j, "preto", estaClicado(j, i))
						pare
					caso 13:
						rei(i, j, "branco", estaClicado(j, i))
						pare
					caso 4:
						rainha(i, j, "preto", estaClicado(j, i))
						pare
					caso 12:
						rainha(i, j, "branco", estaClicado(j, i))
						pare
				}
			}
		}
	}
	funcao logico estaClicado(inteiro j, inteiro i){
		se(clicado[0] == j e clicado[1] == i){
			retorne verdadeiro
		}senao{
			retorne falso
		}
	}
	funcao ctrl(){
		para(inteiro j = 0; j < 8; j++){
			para(inteiro i = 0; i < 8; i++){
				se(esta_clicado(i*XY, j*XY, XY, XY, m.BOTAO_ESQUERDO)){
				   	se(possibilidades[j][i] == 1){
				   		posicoes[j][i] = posicoes[clicado[0]][clicado[1]]
				   		posicoes[clicado[0]][clicado[1]] = 7
				   		clicado[0] = -1
				   		clicado[1] = -1
				   		se(vez == "branco"){
				   			vez = "preto"
				   		} senao{
				   			vez = "branco"
				   		}
				   	}
				   	senao se(posicoes[j][i] != 7){
				   		se(vez == "branco"){
				   			se(posicoes[j][i] > 7){
				   				clicado[0] = j
				   				clicado[1] = i
				   			} senao{
				   				clicado[0] = -1
				   				clicado[1] = -1
				   			}
				   		}
				   		senao{
				   			se(posicoes[j][i] < 7){
				   				clicado[0] = j
				   				clicado[1] = i
				   			} senao{
				   				clicado[0] = -1
				   				clicado[1] = -1
				   			}
				   		}
				   	} senao{
				   		clicado[0] = -1
				   		clicado[1] = -1
				   	}
				}
				se(m.posicao_x() > i*XY e
				   m.posicao_x() < (i+1)*XY e
				   m.posicao_y() > j*XY e
				   m.posicao_y() < (j+1)*XY e
				   m.botao_pressionado(m.BOTAO_DIREITO)){
				   	g.definir_tamanho_texto(30.0)
				   	g.definir_cor(corTab[2])
				   	g.desenhar_texto(i*XY+ 25, j*XY + 25, posicoes[j][i]+"")
				   }
			}
		}
		se(m.botao_pressionado(m.BOTAO_ESQUERDO)){
			cheque(x_rei(8), y_rei(8))
			para(inteiro j = 0; j < 8; j++){
				para(inteiro i = 0; i < 8; i++){
					se(possibilidades[j][i] == 1){
						possibilidades[j][i] = 0
					}
				}
			}
		}
		se(esta_clicado(660, 520, 330, 60, m.BOTAO_ESQUERDO)){
			recomecar()
		} se(esta_clicado(660, 590, 330, 60, m.BOTAO_ESQUERDO)){
			g.encerrar_modo_grafico()
		}
	}
	funcao peao(inteiro x, inteiro y, cadeia cor, logico click){
		se(cor == "branco"){
			g.desenhar_imagem(x*XY+14, y*XY+14, imgPecasBrancas[3])
		} senao{
			g.desenhar_imagem(x*XY+14, y*XY+14, imgPecasPretas[3])
		}
		se(click == verdadeiro){
			se(cor == "branco"){
				se(y == 6){
					se(posicoes[y-1][x] == 7){
						possibilidades[y-1][x] = 1
						se(posicoes[y-2][x] == 7){
							possibilidades[y-2][x] = 1
						}
					}
				} senao se (y > 0){
					se(posicoes[y-1][x] == 7){
						possibilidades[y-1][x] = 1
					}
				}
				se(y > 0){
					se(x > 0){
						se(posicoes[y-1][x-1] < 7){
							possibilidades[y-1][x-1] = 1
						}
					}
					se(x < 7){
						se(posicoes[y-1][x+1] < 7){
							possibilidades[y-1][x+1] = 1
						}
					}
				}
			} senao {
				se(y == 1){
					se(posicoes[y+1][x] == 7){
						possibilidades[y+1][x] = 1
						se(posicoes[y+2][x] == 7){
							possibilidades[y+2][x] = 1
						}
					}
				} senao se (y < 7){
					se(posicoes[y+1][x] == 7){
						possibilidades[y+1][x] = 1
					}
				}
				se(y < 7){
					se(x > 0){
						se(posicoes[y+1][x-1] > 7){
							possibilidades[y+1][x-1] = 1
						}
					}
					se(x < 7){
						se(posicoes[y+1][x+1] > 7){
							possibilidades[y+1][x+1] = 1
						}
					}
				}
			}
		}
	}
	funcao torre(inteiro x, inteiro y, cadeia cor, logico click){
		se(cor == "branco"){
			g.desenhar_imagem(x*XY+14, y*XY+14, imgPecasBrancas[1])
		} senao{
			g.desenhar_imagem(x*XY+14, y*XY+14, imgPecasPretas[1])
		}
		se(click == verdadeiro){
			inteiro i = y-1
			logico auxiliar = verdadeiro
			enquanto(i > -1){
				se(cor == "branco"){
					se(posicoes[i][x] != 7 e posicoes[i][x] > 7){
						auxiliar = falso
					}
					se(posicoes[i][x] < 7 e auxiliar == verdadeiro){
						possibilidades[i][x] = 1
						auxiliar = falso
					}
				} senao {
					se(posicoes[i][x] != 7 e posicoes[i][x] < 7){
						auxiliar = falso
					}
					se(posicoes[i][x] > 7 e auxiliar == verdadeiro){
						possibilidades[i][x] = 1
						auxiliar = falso
					}
				}
				se(auxiliar == verdadeiro){
					possibilidades[i][x] = 1
				}
				i--
			}
			i = y+1
			auxiliar = verdadeiro
			enquanto(i < 8){
				se(cor == "branco"){
					se(posicoes[i][x] != 7 e posicoes[i][x] > 7){
						auxiliar = falso
					}
					se(posicoes[i][x] < 7 e auxiliar == verdadeiro){
						possibilidades[i][x] = 1
						auxiliar = falso
					}
				} senao {
					se(posicoes[i][x] != 7 e posicoes[i][x] < 7){
						auxiliar = falso
					}
					se(posicoes[i][x] > 7 e auxiliar == verdadeiro){
						possibilidades[i][x] = 1
						auxiliar = falso
					}
				}
				se(auxiliar == verdadeiro){
					possibilidades[i][x] = 1
				}
				i++
			}
			i = x-1
			auxiliar = verdadeiro
			enquanto(i > -1){
				se(cor == "branco"){
					se(posicoes[y][i] != 7 e posicoes[y][i] > 7){
						auxiliar = falso
					}
					se(posicoes[y][i] < 7 e auxiliar == verdadeiro){
						possibilidades[y][i] = 1
						auxiliar = falso
					}
				} senao {
					se(posicoes[y][i] != 7 e posicoes[y][i] < 7){
						auxiliar = falso
					}
					se(posicoes[y][i] > 7 e auxiliar == verdadeiro){
						possibilidades[y][i] = 1
						auxiliar = falso
					}
				}
				se(auxiliar == verdadeiro){
					possibilidades[y][i] = 1
				}
				i--
			}
			i = x+1
			auxiliar = verdadeiro
			enquanto(i < 8){
				se(cor == "branco"){
					se(posicoes[y][i] != 7 e posicoes[y][i] > 7){
						auxiliar = falso
					}
					se(posicoes[y][i] < 7 e auxiliar == verdadeiro){
						possibilidades[y][i] = 1
						auxiliar = falso
					}
				} senao {
					se(posicoes[y][i] != 7 e posicoes[y][i] < 7){
						auxiliar = falso
					}
					se(posicoes[y][i] > 7 e auxiliar == verdadeiro){
						possibilidades[y][i] = 1
						auxiliar = falso
					}
				}
				se(auxiliar == verdadeiro){
					possibilidades[y][i] = 1
				}
				i++
			}
		}
	}
	funcao cavalo(inteiro x, inteiro y, cadeia cor, logico click){
		se(cor == "branco"){
			g.desenhar_imagem(x*XY+14, y*XY+14, imgPecasBrancas[2])
		} senao{
			g.desenhar_imagem(x*XY+14, y*XY+14, imgPecasPretas[2])
		}
		se(click == verdadeiro){
			se(x > 0 e y > 1){
				se(cor == "branco" e posicoes[y-2][x-1] <= 7){
					possibilidades[y-2][x-1] = 1
				}
				se(cor == "preto" e posicoes[y-2][x-1] >= 7){
					possibilidades[y-2][x-1] = 1
				}
			}
			se(x < 7 e y > 1){
				se(cor == "branco" e posicoes[y-2][x+1] <= 7){
					possibilidades[y-2][x+1] = 1
				}
				se(cor == "preto" e posicoes[y-2][x+1] >= 7){
					possibilidades[y-2][x+1] = 1
				}
			}
			se(x > 0 e y < 6){
				se(cor == "branco" e posicoes[y+2][x-1] <= 7){
					possibilidades[y+2][x-1] = 1
				}
				se(cor == "preto" e posicoes[y+2][x-1] >= 7){
					possibilidades[y+2][x-1] = 1
				}
			}
			se(x < 7 e y < 6){
				se(cor == "branco" e posicoes[y+2][x+1] <= 7){
					possibilidades[y+2][x+1] = 1
				}
				se(cor == "preto" e posicoes[y+2][x+1] >= 7){
					possibilidades[y+2][x+1] = 1
				}
			}
			se(x > 1 e y > 0){
				se(cor == "branco" e posicoes[y-1][x-2] <= 7){
					possibilidades[y-1][x-2] = 1
				}
				se(cor == "preto" e posicoes[y-1][x-2] >= 7){
					possibilidades[y-1][x-2] = 1
				}
			}
			se(x > 1 e y < 7){
				se(cor == "branco" e posicoes[y+1][x-2] <= 7){
					possibilidades[y+1][x-2] = 1
				}
				se(cor == "preto" e posicoes[y+1][x-2] >= 7){
					possibilidades[y+1][x-2] = 1
				}
			}
			se(x < 6 e y > 0){
				se(cor == "branco" e posicoes[y-1][x+2] <= 7){
					possibilidades[y-1][x+2] = 1
				}
				se(cor == "preto" e posicoes[y-1][x+2] >= 7){
					possibilidades[y-1][x+2] = 1
				}
			}
			se(x < 6 e y < 7){
				se(cor == "branco" e posicoes[y+1][x+2] <= 7){
					possibilidades[y+1][x+2] = 1
				}
				se(cor == "preto" e posicoes[y+1][x+2] >= 7){
					possibilidades[y+1][x+2] = 1
				}
			}
		}
	}
	funcao bispo(inteiro x, inteiro y, cadeia cor, logico click){
		se(cor == "branco"){
			g.desenhar_imagem(x*XY+14, y*XY+14, imgPecasBrancas[0])
		} senao{
			g.desenhar_imagem(x*XY+14, y*XY+14, imgPecasPretas[0])
		}
		se(click == verdadeiro){
			inteiro i = y-1
			inteiro j = x-1
			logico auxiliar = verdadeiro
			enquanto(i > -1 e j > -1){
				se(cor == "branco"){
					se(posicoes[i][j] != 7 e posicoes[i][j] > 7){
						auxiliar = falso
					}
					se(posicoes[i][j] < 7 e auxiliar == verdadeiro){
						possibilidades[i][j] = 1
						auxiliar = falso
					}
				} senao {
					se(posicoes[i][j] != 7 e posicoes[i][j] < 7){
						auxiliar = falso
					}
					se(posicoes[i][j] > 7 e auxiliar == verdadeiro){
						possibilidades[i][j] = 1
						auxiliar = falso
					}
				}
				se(auxiliar == verdadeiro){
					possibilidades[i][j] = 1
				}
				i--
				j--
			}
			i = y+1
			j = x-1
			auxiliar = verdadeiro
			enquanto(i < 8 e j > -1){
				se(cor == "branco"){
					se(posicoes[i][j] != 7 e posicoes[i][j] > 7){
						auxiliar = falso
					}
					se(posicoes[i][j] < 7 e auxiliar == verdadeiro){
						possibilidades[i][j] = 1
						auxiliar = falso
					}
				} senao {
					se(posicoes[i][j] != 7 e posicoes[i][j] < 7){
						auxiliar = falso
					}
					se(posicoes[i][j] > 7 e auxiliar == verdadeiro){
						possibilidades[i][j] = 1
						auxiliar = falso
					}
				}
				se(auxiliar == verdadeiro){
					possibilidades[i][j] = 1
				}
				i++
				j--
			}
			i = y-1
			j = x+1
			auxiliar = verdadeiro
			enquanto(i > -1 e j < 8){
				se(cor == "branco"){
					se(posicoes[i][j] != 7 e posicoes[i][j] > 7){
						auxiliar = falso
					}
					se(posicoes[i][j] < 7 e auxiliar == verdadeiro){
						possibilidades[i][j] = 1
						auxiliar = falso
					}
				} senao {
					se(posicoes[i][j] != 7 e posicoes[i][j] < 7){
						auxiliar = falso
					}
					se(posicoes[i][j] > 7 e auxiliar == verdadeiro){
						possibilidades[i][j] = 1
						auxiliar = falso
					}
				}
				se(auxiliar == verdadeiro){
					possibilidades[i][j] = 1
				}
				i--
				j++
			}
			i = y+1
			j = x+1
			auxiliar = verdadeiro
			enquanto(i < 8 e j < 8){
				se(cor == "branco"){
					se(posicoes[i][j] != 7 e posicoes[i][j] > 7){
						auxiliar = falso
					}
					se(posicoes[i][j] < 7 e auxiliar == verdadeiro){
						possibilidades[i][j] = 1
						auxiliar = falso
					}
				} senao {
					se(posicoes[i][j] != 7 e posicoes[i][j] < 7){
						auxiliar = falso
					}
					se(posicoes[i][j] > 7 e auxiliar == verdadeiro){
						possibilidades[i][j] = 1
						auxiliar = falso
					}
				}
				se(auxiliar == verdadeiro){
					possibilidades[i][j] = 1
				}
				i++
				j++
			}
		}
	}
	funcao rainha(inteiro x, inteiro y, cadeia cor, logico click){
		se(cor == "branco"){
			g.desenhar_imagem(x*XY+14, y*XY+14, imgPecasBrancas[4])
		} senao{
			g.desenhar_imagem(x*XY+14, y*XY+14, imgPecasPretas[4])
		}
		se(click == verdadeiro){
			inteiro i = y-1
			inteiro j = x-1
			logico auxiliar = verdadeiro
			enquanto(i > -1 e j > -1){
				se(cor == "branco"){
					se(posicoes[i][j] != 7 e posicoes[i][j] > 7){
						auxiliar = falso
					}
					se(posicoes[i][j] < 7 e auxiliar == verdadeiro){
						possibilidades[i][j] = 1
						auxiliar = falso
					}
				} senao {
					se(posicoes[i][j] != 7 e posicoes[i][j] < 7){
						auxiliar = falso
					}
					se(posicoes[i][j] > 7 e auxiliar == verdadeiro){
						possibilidades[i][j] = 1
						auxiliar = falso
					}
				}
				se(auxiliar == verdadeiro){
					possibilidades[i][j] = 1
				}
				i--
				j--
			}
			i = y+1
			j = x-1
			auxiliar = verdadeiro
			enquanto(i < 8 e j > -1){
				se(cor == "branco"){
					se(posicoes[i][j] != 7 e posicoes[i][j] > 7){
						auxiliar = falso
					}
					se(posicoes[i][j] < 7 e auxiliar == verdadeiro){
						possibilidades[i][j] = 1
						auxiliar = falso
					}
				} senao {
					se(posicoes[i][j] != 7 e posicoes[i][j] < 7){
						auxiliar = falso
					}
					se(posicoes[i][j] > 7 e auxiliar == verdadeiro){
						possibilidades[i][j] = 1
						auxiliar = falso
					}
				}
				se(auxiliar == verdadeiro){
					possibilidades[i][j] = 1
				}
				i++
				j--
			}
			i = y-1
			j = x+1
			auxiliar = verdadeiro
			enquanto(i > -1 e j < 8){
				se(cor == "branco"){
					se(posicoes[i][j] != 7 e posicoes[i][j] > 7){
						auxiliar = falso
					}
					se(posicoes[i][j] < 7 e auxiliar == verdadeiro){
						possibilidades[i][j] = 1
						auxiliar = falso
					}
				} senao {
					se(posicoes[i][j] != 7 e posicoes[i][j] < 7){
						auxiliar = falso
					}
					se(posicoes[i][j] > 7 e auxiliar == verdadeiro){
						possibilidades[i][j] = 1
						auxiliar = falso
					}
				}
				se(auxiliar == verdadeiro){
					possibilidades[i][j] = 1
				}
				i--
				j++
			}
			i = y+1
			j = x+1
			auxiliar = verdadeiro
			enquanto(i < 8 e j < 8){
				se(cor == "branco"){
					se(posicoes[i][j] != 7 e posicoes[i][j] > 7){
						auxiliar = falso
					}
					se(posicoes[i][j] < 7 e auxiliar == verdadeiro){
						possibilidades[i][j] = 1
						auxiliar = falso
					}
				} senao {
					se(posicoes[i][j] != 7 e posicoes[i][j] < 7){
						auxiliar = falso
					}
					se(posicoes[i][j] > 7 e auxiliar == verdadeiro){
						possibilidades[i][j] = 1
						auxiliar = falso
					}
				}
				se(auxiliar == verdadeiro){
					possibilidades[i][j] = 1
				}
				i++
				j++
			}
			i = y-1
			auxiliar = verdadeiro
			enquanto(i > -1){
				se(cor == "branco"){
					se(posicoes[i][x] != 7 e posicoes[i][x] > 7){
						auxiliar = falso
					}
					se(posicoes[i][x] < 7 e auxiliar == verdadeiro){
						possibilidades[i][x] = 1
						auxiliar = falso
					}
				} senao {
					se(posicoes[i][x] != 7 e posicoes[i][x] < 7){
						auxiliar = falso
					}
					se(posicoes[i][x] > 7 e auxiliar == verdadeiro){
						possibilidades[i][x] = 1
						auxiliar = falso
					}
				}
				se(auxiliar == verdadeiro){
					possibilidades[i][x] = 1
				}
				i--
			}
			i = y+1
			auxiliar = verdadeiro
			enquanto(i < 8){
				se(cor == "branco"){
					se(posicoes[i][x] != 7 e posicoes[i][x] > 7){
						auxiliar = falso
					}
					se(posicoes[i][x] < 7 e auxiliar == verdadeiro){
						possibilidades[i][x] = 1
						auxiliar = falso
					}
				} senao {
					se(posicoes[i][x] != 7 e posicoes[i][x] < 7){
						auxiliar = falso
					}
					se(posicoes[i][x] > 7 e auxiliar == verdadeiro){
						possibilidades[i][x] = 1
						auxiliar = falso
					}
				}
				se(auxiliar == verdadeiro){
					possibilidades[i][x] = 1
				}
				i++
			}
			i = x-1
			auxiliar = verdadeiro
			enquanto(i > -1){
				se(cor == "branco"){
					se(posicoes[y][i] != 7 e posicoes[y][i] > 7){
						auxiliar = falso
					}
					se(posicoes[y][i] < 7 e auxiliar == verdadeiro){
						possibilidades[y][i] = 1
						auxiliar = falso
					}
				} senao {
					se(posicoes[y][i] != 7 e posicoes[y][i] < 7){
						auxiliar = falso
					}
					se(posicoes[y][i] > 7 e auxiliar == verdadeiro){
						possibilidades[y][i] = 1
						auxiliar = falso
					}
				}
				se(auxiliar == verdadeiro){
					possibilidades[y][i] = 1
				}
				i--
			}
			i = x+1
			auxiliar = verdadeiro
			enquanto(i < 8){
				se(cor == "branco"){
					se(posicoes[y][i] != 7 e posicoes[y][i] > 7){
						auxiliar = falso
					}
					se(posicoes[y][i] < 7 e auxiliar == verdadeiro){
						possibilidades[y][i] = 1
						auxiliar = falso
					}
				} senao {
					se(posicoes[y][i] != 7 e posicoes[y][i] < 7){
						auxiliar = falso
					}
					se(posicoes[y][i] > 7 e auxiliar == verdadeiro){
						possibilidades[y][i] = 1
						auxiliar = falso
					}
				}
				se(auxiliar == verdadeiro){
					possibilidades[y][i] = 1
				}
				i++
			}
		}
	}
	funcao rei(inteiro x, inteiro y, cadeia cor, logico click){
		se(cor == "branco"){
			g.desenhar_imagem(x*XY+14, y*XY+14, imgPecasBrancas[5])
		} senao{
			g.desenhar_imagem(x*XY+14, y*XY+14, imgPecasPretas[5])
		}
		se(click == verdadeiro){
			se(y > 0){
				se(cor == "branco"){
					se(posicoes[y-1][x] <= 7)
						possibilidades[y-1][x] = 1
					se(x > 0 e posicoes[y-1][x-1] <=7)
						possibilidades[y-1][x-1] = 1
					se(x < 7 e posicoes[y-1][x+1] <=7)
						possibilidades[y-1][x+1] = 1
				} senao {
					se(posicoes[y-1][x] >= 7)
						possibilidades[y-1][x] = 1
					se(x > 0 e posicoes[y-1][x-1] >=7)
						possibilidades[y-1][x-1] = 1
					se(x < 7 e posicoes[y-1][x+1] >=7)
						possibilidades[y-1][x+1] = 1
				}
			}
			se(y < 7){
				se(cor == "branco"){
					se(posicoes[y+1][x] <= 7)
						possibilidades[y+1][x] = 1
					se(x > 0 e posicoes[y+1][x-1] <=7)
						possibilidades[y+1][x-1] = 1
					se(x < 7 e posicoes[y+1][x+1] <=7)
						possibilidades[y+1][x+1] = 1
				} senao{
					se(posicoes[y+1][x] >= 7)
						possibilidades[y+1][x] = 1
					se(x > 0 e posicoes[y+1][x-1] >=7)
						possibilidades[y+1][x-1] = 1
					se(x < 7 e posicoes[y+1][x+1] >=7)
						possibilidades[y+1][x+1] = 1
				}
			}
			se(cor == "branco"){
				se(x > 0 e posicoes[y][x-1] <= 7)
					possibilidades[y][x-1] = 1
				se(x < 7 e posicoes[y][x+1] <= 7)
					possibilidades[y][x+1] = 1
			} senao{
				se(x > 0 e posicoes[y][x-1] >= 7)
					possibilidades[y][x-1] = 1
				se(x < 7 e posicoes[y][x+1] >= 7)
					possibilidades[y][x+1] = 1
			}
		}
	}
	funcao botao(inteiro x, inteiro y, logico possivelMorte){
		g.definir_cor(corTab[2])
		se(possivelMorte == falso){
			g.desenhar_elipse(x*XY+40, y*XY+40, 20, 20, verdadeiro)
		} senao{
			g.desenhar_elipse(x*XY+11, y*XY+12, 78, 78, verdadeiro)
		}
		
	}
	funcao recomecar(){
		chequeB = falso
		chequeP = falso
		clicado[0] = -1
		clicado[1] = -1
		minP = 10
		segP = 0
		minB = 10
		segB = 0
		vez = "branco"
		para(inteiro j = 0; j < 8; j++){
			para(inteiro i = 0; i < 8; i++){
				se(j == 0){
					se(i == 0 ou i == 7)
						posicoes[j][i] = TORRE_P
					se(i == 1 ou i == 6)
						posicoes[j][i] = CAVALO_P
					se(i == 2 ou i == 5)
						posicoes[j][i] = BISPO_P
					se(i == 3)
						posicoes[j][i] = RAINHA_P
					se(i == 4)
						posicoes[j][i] = REI_P
				}
				se(j == 1)
					posicoes[j][i] = PEAO_P
				se(j > 1 e j < 6)
					posicoes[j][i] = 7
				se(j == 6)
					posicoes[j][i] = PEAO_B
				se(j == 7){
					se(i == 0 ou i == 7)
						posicoes[j][i] = TORRE_B
					se(i == 1 ou i == 6)
						posicoes[j][i] = CAVALO_B
					se(i == 2 ou i == 5)
						posicoes[j][i] = BISPO_B
					se(i == 3)
						posicoes[j][i] = RAINHA_B
					se(i == 4)
						posicoes[j][i] = REI_B
				}
				possibilidades[j][i] = 0
			}
		}
	}
	funcao logico esta_em_hover(inteiro x, inteiro y, inteiro largura, inteiro altura){
		se(m.posicao_x() > x e
		   m.posicao_x() < x + largura e
		   m.posicao_y() > y e
		   m.posicao_y() < y + altura){
		   	retorne verdadeiro
		} senao {
			retorne falso
		}
	}
	funcao logico esta_clicado(inteiro x, inteiro y, inteiro largura, inteiro altura, inteiro btn){
		se(m.posicao_x() > x e
		   m.posicao_x() < x + largura e
		   m.posicao_y() > y e
		   m.posicao_y() < y + altura e
		   m.botao_pressionado(btn)){
		   	retorne verdadeiro
		} senao {
			retorne falso
		}
	}	
	funcao cheque(inteiro x, inteiro y){
		limpa()
		inteiro indiceDirecoes = 0
		inteiro direcoes[8]
		inteiro indicex, indicey
		para(inteiro j = -1; j < 2; j++){
			para(inteiro i = -1; i < 2; i++){
				indicex = x
				indicey = y
				faca{
					se(indicex < 7 e indicex > 0 e indicey < 7 e indicey > 0){
						indicex += i
						indicey += j
					}
				}enquanto(posicoes[indicey][indicex] == 7
						e indicex < 7 e indicex > 0 e indicey < 7 e indicey > 0)
				botao(indicex, indicey, falso)
			}
		}
	}
	funcao inteiro x_rei(inteiro cor){
		inteiro x = 0
		para(inteiro j = 0; j < 8; j++){
			para(inteiro i = 0; i < 8; i++){
				se(posicoes[j][i] == REI_P + cor)
					x = i
			}
		}
		retorne x
	}
	funcao inteiro y_rei(inteiro cor){
		inteiro y = 0
		para(inteiro j = 0; j < 8; j++){
			para(inteiro i = 0; i < 8; i++){
				se(posicoes[j][i] == REI_P + cor)
					y = j
			}
		}
		retorne y
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 27050; 
 * @DOBRAMENTO-CODIGO = [28, 47, 87, 145, 213, 265, 338, 398, 507, 580, 697, 914, 968, 977, 1023, 1033, 1064, 1074];
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */