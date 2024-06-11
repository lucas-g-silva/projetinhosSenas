programa
{
	inclua biblioteca Mouse --> mo
	inclua biblioteca Matematica --> m
	inclua biblioteca Calendario --> c
	inclua biblioteca Util --> u
	inclua biblioteca Graficos --> g
	inclua biblioteca Teclado --> t

	inteiro segundoAnterior = c.segundo_atual()
	
	logico meteoro = verdadeiro
	logico disparo = verdadeiro

	inteiro nave = g.carregar_imagem("/nave.png")
	inteiro tiro = g.carregar_imagem("/tiro.png")
	inteiro mete = g.carregar_imagem("/meteoro.png")
	inteiro gmov = g.carregar_imagem("/gameover.png")
	inteiro fogo = g.carregar_imagem("/fogo.gif")

	inteiro lMete = g.largura_imagem(mete), aMete = g.altura_imagem(mete)
	inteiro lTiro = g.largura_imagem(tiro), aTiro = g.altura_imagem(tiro)
	inteiro lNave = g.largura_imagem(nave), aNave = g.altura_imagem(nave)
	inteiro lGmov = g.largura_imagem(gmov), aGmov = g.altura_imagem(gmov)
	inteiro lFogo = g.largura_imagem(fogo), aFogo = g.altura_imagem(fogo)
	
	const inteiro lJane = 800, aJane = 600 //definida na funcao inicio

	inteiro px = 150, py = 300 - aNave/2
	inteiro vidas = 3
	inteiro score = 0

	inteiro tx[200], ty[200]
	inteiro mx[200], my[200]

	real segms = 0.0
	inteiro  min = 0, seg = 0
	inteiro segundos = 0

	real segundoMeteoro = 0.0, segundoNave = 0.0

	funcao controle(){
		se(t.tecla_pressionada(t.TECLA_A) ou t.tecla_pressionada(t.TECLA_SETA_ESQUERDA) e px > 0){
			px-=5
		}
		se(t.tecla_pressionada(t.TECLA_D) ou t.tecla_pressionada(t.TECLA_SETA_DIREITA) e px < lJane - lNave){
			px+=5
		}
		se(t.tecla_pressionada(t.TECLA_W) ou t.tecla_pressionada(t.TECLA_SETA_ACIMA) e py > 0 ){
			py-=5
		}
		se(t.tecla_pressionada(t.TECLA_S) ou t.tecla_pressionada(t.TECLA_SETA_ABAIXO) e py < aJane - aNave){
			py+=5
		}
	}
	funcao controleTiro(){
		se(t.tecla_pressionada(t.TECLA_ESPACO) e disparo == verdadeiro){
			segundoNave = segms
			disparo = falso
			inteiro index = 0
			para(inteiro i = 0; tx[i] != -1; i++){
				index++
			}
			tx[index] = px + lNave - lTiro
			ty[index] = py + aNave/2 - aTiro/2
		}
		se(segms ==  segundoNave + 0.5){ 
			disparo = verdadeiro
		}
		
	}
	funcao geracaoMeteoro(){
		se(meteoro == verdadeiro e segundos != 0){
			segundoMeteoro = segundos
			inteiro index = 0
			para(inteiro i = 0; my[i] != -1; i++){
				index++
			}
			mx[index] = lJane
			my[index] = u.sorteia(0, aJane - aMete)
			meteoro = falso
		}
		se(segundos == segundoMeteoro + 4 ){
			meteoro = verdadeiro
		}
	}
	funcao desenhar(){
		g.definir_cor(g.COR_PRETO)
		g.limpar()
		desenharTiro()
		g.desenhar_imagem(px, py, nave)
		se(nao t.tecla_pressionada(t.TECLA_A) e nao t.tecla_pressionada(t.TECLA_SETA_ESQUERDA)){
			g.definir_rotacao(-90)
			g.desenhar_imagem(px-lFogo, py+14, fogo)
			g.desenhar_imagem(px-lFogo, py+aNave-14-aFogo, fogo)
			g.definir_rotacao(0)
		}
		desenharMeteoro()
		g.definir_cor(g.COR_BRANCO)
		g.definir_tamanho_texto(12.0)
		g.desenhar_texto(750, 5, px + "; " + py)
		g.desenhar_texto(750, 20, min + ":" + segms)
		g.desenhar_texto(750, 35, segundos+"")
		g.desenhar_texto(750, 50, score+"")
		g.desenhar_texto(5, 5, vidas+"")
	}
	funcao desenharTiro(){
		para(inteiro i = 0; i < 200; i++){
			se(tx[i] != -1){
				se(tx[i] < lJane){
					g.desenhar_imagem(tx[i], ty[i], tiro)
					tx[i] += 10
				}
				senao{
					tx[i] = -1
					ty[i] = -1
				}
			}
		}
	}
	funcao desenharMeteoro(){
		para(inteiro i = 0; i < 200; i++){
			se(mx[i] != -1){
				se(mx[i] > -70){
					se(px + lNave > mx[i] e
					   px < mx[i] + lMete e
					   py + aNave > my[i] e
					   py < my[i] + aMete){
					   	vidas--
					   	mx[i] = -lMete + 1

						se(vidas > 0){
							px = 150
							py = 300 - aNave/2
						} senao{
							px = -lNave
						}
					}
					para(inteiro j = 0; j < 200; j++){
						se(tx[j] != -1){
							se(tx[j] > mx[i] e
							   tx[j] < mx[i] + lMete e
							   ty[j] + aTiro > my[i] e
							   ty[j] < my[i] + aMete){
						   		mx[i] = -lMete + 1
								tx[j] = lJane - 1
								score++
							}
						}	
					}
				   	g.definir_cor(g.COR_PRETO)
				   	g.desenhar_imagem(mx[i], my[i], mete)
					mx[i] -= 5
				}
				senao{
					mx[i] = -1
					my[i] = -1
				}
			}
		}
	}
	funcao cronometro(){
		inteiro segundoAtual = c.segundo_atual()
		real ms = c.milisegundo_atual()
		se(segundoAtual != segundoAnterior){
			segundoAnterior = segundoAtual
				se(seg < 59){
					seg++
				} senao{
					seg = 0
					min++
				}
				segundos++
		}
		segms = m.arredondar(seg + ms/1000, 1)
	}
	funcao desenharTelaPerdeu(){
		g.desenhar_imagem(lJane/2 - lGmov/2, aJane/2 - aGmov/2, gmov)
		g.definir_cor(g.COR_BRANCO)
		g.definir_tamanho_texto(30.0)
		g.desenhar_texto(lJane/2 - g.largura_texto("Postuação: "+score)/2, aJane/2 + aGmov/2, "Postuação: "+score)
		se(mo.botao_pressionado(mo.BOTAO_ESQUERDO)){
			vidas = 3
			px = 150
			py = 300 - aNave/2
			min = 0
			seg = 0
			segms = 0.0
			segundos = 0
			segundoAnterior = c.segundo_atual()
			meteoro = verdadeiro
		}
	}
	funcao inicio(){
		g.iniciar_modo_grafico(verdadeiro)
		g.definir_dimensoes_janela(lJane, aJane)
		para(inteiro i = 0; i < 200; i++){
			tx[i] = -1
			ty[i] = -1
			mx[i] = -1
			my[i] = -1
		}
		enquanto(nao t.tecla_pressionada(t.TECLA_ESC)){
			se(vidas > 0){
				cronometro()
				geracaoMeteoro()
				controle()
				controleTiro()
				desenhar()
				g.renderizar()
				u.aguarde(10)
			}senao{
				desenhar()
				desenharTelaPerdeu()
				g.renderizar()
				u.aguarde(10)
			}
		}
	}	
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 2549; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */