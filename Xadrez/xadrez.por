programa
{
	inclua biblioteca Teclado --> t
	inclua biblioteca Arquivos --> a
	inclua biblioteca Graficos --> g
	inclua biblioteca Util --> u
	inclua biblioteca Mouse --> m

	const inteiro XY = 80, IMG_XY = 72
	inteiro pxBrancas[16], pyBrancas[16]
	inteiro pxPretas[16], pyPretas[16]
	cadeia nmPecas[] = {"b", "t", "c", "p", "q", "r", ""}
	inteiro imgPecasBrancas[6], imgPecasPretas[6]
	inteiro corTab[3] = {g.criar_cor(232, 237, 249), g.criar_cor(183, 192, 216), g.criar_cor(153, 144, 236)}
	inteiro posicoes[][] = {{1,2,0,5,4,0,2,1},
					    {3,3,3,3,3,3,3,3},
					    {7,7,7,7,7,7,7,7},
					    {7,7,7,7,7,7,7,7},
					    {7,7,7,7,7,7,7,7},
					    {7,7,7,7,7,7,7,7},
					    {11,11,11,11,11,11,11,11},
					    {9,10,8,13,12,8,10,9}}
	inteiro possibilidades[][] = {{0,0,0,0,0,0,0,0},
							{0,0,0,0,0,0,0,0},
							{0,0,0,0,0,0,0,0},
							{0,0,0,0,0,0,0,0},
							{0,0,0,0,0,0,0,0},
							{0,0,0,0,0,0,0,0},
							{0,0,0,0,0,0,0,0},
							{0,0,0,0,0,0,0,0}}
	inteiro clicado[2] = {-1, -1}
	cadeia vez = "branco"
	logico chequeB = falso, chequeP = falso
	
	funcao inicio(){
		g.iniciar_modo_grafico(verdadeiro)
		g.definir_dimensoes_janela(640, 640)
		g.definir_titulo_janela("Xadrez")
		para(inteiro i = 0; i < 6; i++){
			imgPecasBrancas[i] = g.carregar_imagem("/pecas/" + nmPecas[i] + "-white.jpg")
			imgPecasPretas[i] = g.carregar_imagem("/pecas/" + nmPecas[i] + "-black.jpg")
		}
		enquanto(nao t.tecla_pressionada(t.TECLA_ESC)){
			tabuleiro()
			pecas()
			ctrl()
			g.renderizar()
		}
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
     				g.desenhar_retangulo(XY*i, XY*j, XY, XY, falso, verdadeiro)
     				g.definir_cor(corTab[1])
     				se(i == 0){
     					g.desenhar_texto(XY*i + 2, XY*j + 2, j+1 + "")
     				}
     				se(j == 7){
     					g.desenhar_texto(XY*(i+1)-12, XY*(j+1)-18 + 4, letras[i])
     				}
     			} senao{
     				se(j == clicado[0] e i == clicado[1]){
     					g.definir_cor(corTab[2])
     				} senao{
     					g.definir_cor(corTab[1])
     				}
     				g.desenhar_retangulo(XY*i, XY*j, XY, XY, falso, verdadeiro)
     				g.definir_cor(corTab[0])
     				se(i == 0){
     					g.desenhar_texto(XY*i + 2, XY*j + 2, j+1 + "")
     				}
     				se(j == 7){
     					g.desenhar_texto(XY*(i+1)-12, XY*(j+1)-18 + 4, letras[i])
     				}
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
				se(m.posicao_x() > i*80 e
				   m.posicao_x() < (i+1)*80 e
				   m.posicao_y() > j*80 e
				   m.posicao_y() < (j+1)*80 e
				   m.botao_pressionado(m.BOTAO_ESQUERDO)){
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
				   			}
				   		}
				   		senao{
				   			se(posicoes[j][i] < 7){
				   				clicado[0] = j
				   				clicado[1] = i
				   			}
				   		}
				   	} senao{
				   		clicado[0] = -1
				   		clicado[1] = -1
				   	}
				}
				se(m.posicao_x() > i*80 e
				   m.posicao_x() < (i+1)*80 e
				   m.posicao_y() > j*80 e
				   m.posicao_y() < (j+1)*80 e
				   m.botao_pressionado(m.BOTAO_DIREITO)){
				   	g.definir_tamanho_texto(30.0)
				   	g.definir_cor(corTab[2])
				   	g.desenhar_texto(i*80+ 25, j*80 + 25, posicoes[j][i]+"")
				   }
			}
		}
		se(m.botao_pressionado(m.BOTAO_ESQUERDO)){
			para(inteiro j = 0; j < 8; j++){
				para(inteiro i = 0; i < 8; i++){
					se(possibilidades[j][i] == 1){
						possibilidades[j][i] = 0
					}
				}
			}
		}
	}
	funcao peao(inteiro x, inteiro y, cadeia cor, logico click){
		se(cor == "branco"){
			g.desenhar_imagem(x*80+4, y*80+4, imgPecasBrancas[3])
		} senao{
			g.desenhar_imagem(x*80+4, y*80+4, imgPecasPretas[3])
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
			g.desenhar_imagem(x*80+4, y*80+4, imgPecasBrancas[1])
		} senao{
			g.desenhar_imagem(x*80+4, y*80+4, imgPecasPretas[1])
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
			g.desenhar_imagem(x*80+4, y*80+4, imgPecasBrancas[2])
		} senao{
			g.desenhar_imagem(x*80+4, y*80+4, imgPecasPretas[2])
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
			g.desenhar_imagem(x*80+4, y*80+4, imgPecasBrancas[0])
		} senao{
			g.desenhar_imagem(x*80+4, y*80+4, imgPecasPretas[0])
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
				i--
				j++
			}
			i = y+1
			j = x+1
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
				j++
			}
		}
	}
	funcao rainha(inteiro x, inteiro y, cadeia cor, logico click){
		se(cor == "branco"){
			g.desenhar_imagem(x*80+4, y*80+4, imgPecasBrancas[4])
		} senao{
			g.desenhar_imagem(x*80+4, y*80+4, imgPecasPretas[4])
		}
	}
	funcao rei(inteiro x, inteiro y, cadeia cor, logico click){
		se(cor == "branco"){
			g.desenhar_imagem(x*80+4, y*80+4, imgPecasBrancas[5])
		} senao{
			g.desenhar_imagem(x*80+4, y*80+4, imgPecasPretas[5])
		}
	}
	funcao botao(inteiro x, inteiro y, logico possivelMorte){
		g.definir_cor(corTab[2])
		se(possivelMorte == falso){
			g.desenhar_elipse(x*80+30, y*80+30, 20, 20, verdadeiro)
		} senao{
			g.desenhar_elipse(x*80+1, y*80+2, 78, 78, verdadeiro)
		}
		
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 13478; 
 * @DOBRAMENTO-CODIGO = [14, 22, 38, 42, 34, 56, 58, 63, 66, 55, 70, 72, 77, 80, 69, 54, 53, 49, 93, 95, 92, 100, 91, 90, 89, 142, 144, 141, 161, 163, 156, 169, 168, 175, 174, 167, 180, 155, 189, 150, 149, 199, 198, 197, 196, 148, 207, 209, 217, 215, 214, 222, 221, 228, 227, 233, 232, 226, 213, 242, 240, 239, 247, 246, 253, 252, 258, 257, 251, 238, 212, 206, 376, 378, 383, 386, 382, 391, 394, 390, 399, 402, 398, 407, 410, 406, 415, 418, 414, 423, 426, 422, 431, 434, 430, 439, 442, 438, 381, 375, 566, 568, 565, 573, 575, 572, 581, 583, 579];
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */