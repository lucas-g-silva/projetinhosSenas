programa
{
	inclua biblioteca Arquivos --> a
	inclua biblioteca Graficos --> g
	inclua biblioteca Util --> u
	inclua biblioteca Mouse --> m

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
	
	funcao inicio(){
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
	}
	funcao pecas(){
		para(inteiro i = 0; i < 8; i++){
			g.desenhar_imagem(XY*i+4, 4, imgPecasPretas[posicoes[0][i]])
			g.desenhar_imagem(XY*i+4, XY + 4, imgPecasPretas[3])

			g.desenhar_imagem(XY*i+4, XY*7 + 4, imgPecasBrancas[posicoes[0][i]])
			g.desenhar_imagem(XY*i+4, XY*6 + 4, imgPecasBrancas[3])
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
				   	se(posicoes[j][i] != 7){
				   		clicado[0] = j
				   		clicado[1] = i
				   		escolha(posicoes[j][i]){
				   			caso 3:
				   				peao(i, j, "preto")
				   				pare
				   			caso 7:
				   				peao(i, j, "branco")
				   		}
				   	} senao{
				   		clicado[0] = -1
				   		clicado[1] = -1
				   	}
				   }
			}
		}
	}
	funcao peao(inteiro x, inteiro y, cadeia cor){
		se(cor == "branco"){
			se(y == 6){
				g.definir_cor(corTab[2])
				g.desenhar_elipse(x*80+30, (y-1)*80+30, 20, 20, verdadeiro)
				g.desenhar_elipse(x*80+30, (y-2)*80+30, 20, 20, verdadeiro)
			}
		} senao{
			se(y == 1){
				g.definir_cor(corTab[2])
				g.desenhar_elipse(x*80+30, (y+1)*80+30, 20, 20, verdadeiro)
				g.desenhar_elipse(x*80+30, (y+2)*80+30, 20, 20, verdadeiro)
			}
		}
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 3617; 
 * @DOBRAMENTO-CODIGO = [38];
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */