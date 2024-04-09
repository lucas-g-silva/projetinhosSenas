programa
{
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
	inteiro clicado[2] = {-1, -1}
	inteiro possiveisMortes[8][2] = {{-1,-1},
							   {-1,-1},
							   {-1,-1},
							   {-1,-1},
							   {-1,-1},
							   {-1,-1},
							   {-1,-1},
							   {-1,-1}}
	cadeia vez = "branco"
	
	funcao inicio(){
		g.iniciar_modo_grafico(verdadeiro)
		g.definir_dimensoes_janela(640, 640)
		g.definir_titulo_janela("Xadrez")
		para(inteiro i = 0; i < 6; i++){
			imgPecasBrancas[i] = g.carregar_imagem("/pecas/" + nmPecas[i] + "-white.jpg")
			imgPecasPretas[i] = g.carregar_imagem("/pecas/" + nmPecas[i] + "-black.jpg")
		}
		enquanto(verdadeiro){
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
					caso -1:
						botao(i, j)
						pare
				}
			}
			se(possiveisMortes[j][0] > -1 e possiveisMortes[j][1] > -1){
				g.desenhar_elipse(possiveisMortes[j][0], possiveisMortes[j][1], 80, 80, falso)
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
				   	se(posicoes[j][i] == -1){
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
			}
		}
		se(m.botao_pressionado(m.BOTAO_ESQUERDO)){
			para(inteiro j = 0; j < 8; j++){
				para(inteiro i = 0; i < 8; i++){
					se(posicoes[j][i] == -1){
						posicoes[j][i] = 7
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
				se(posicoes[y-1][x] == 7){
					posicoes[y-1][x] = -1
					se(y == 6){
						se(posicoes[y-2][x] == 7){
							posicoes[y-2][x] = -1
						}
					}
				}
				senao se(posicoes[y-1][x-1] < 7){
					inteiro index = 0
					enquanto(possiveisMortes[index][0] != -1 e possiveisMortes[index][1] != -1){
						index++
					}
					possiveisMortes[index][0] = x
					possiveisMortes[index][1] = y
				}
			} senao{
				se(posicoes[y+1][x] == 7){
					posicoes[y+1][x] = -1
				}
				se(y == 1){
					se(posicoes[y+2][x] == 7 e posicoes[y+1][x] == -1){
						posicoes[y+2][x] = -1
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
	}
	funcao cavalo(inteiro x, inteiro y, cadeia cor, logico click){
		se(cor == "branco"){
			g.desenhar_imagem(x*80+4, y*80+4, imgPecasBrancas[2])
		} senao{
			g.desenhar_imagem(x*80+4, y*80+4, imgPecasPretas[2])
		}
	}
	funcao bispo(inteiro x, inteiro y, cadeia cor, logico click){
		se(cor == "branco"){
			g.desenhar_imagem(x*80+4, y*80+4, imgPecasBrancas[0])
		} senao{
			g.desenhar_imagem(x*80+4, y*80+4, imgPecasPretas[0])
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
	funcao botao(inteiro x, inteiro y){
		g.definir_cor(corTab[2])
		g.desenhar_elipse(x*80+30, y*80+30, 20, 20, verdadeiro)
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 5847; 
 * @DOBRAMENTO-CODIGO = [32, 47, 137, 144, 229, 236, 243, 250, 257];
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = {posicoes, 14, 9, 8};
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */