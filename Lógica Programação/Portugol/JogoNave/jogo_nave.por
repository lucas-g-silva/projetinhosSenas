programa
{
	inclua biblioteca Matematica --> m
	inclua biblioteca Calendario --> c
	inclua biblioteca Util --> u
	inclua biblioteca Graficos --> g
	inclua biblioteca Teclado --> t

	inteiro segundoAnterior = c.segundo_atual()

	const inteiro lNave = 57, aNave = 71
	const inteiro lTiro = 24, aTiro = 8

	inteiro px = 150, py = 300 - aNave/2
	inteiro vidas = 3
	
	logico meteoro = verdadeiro
	logico disparo = verdadeiro

	inteiro nave = g.carregar_imagem("/nave.png")
	inteiro tiro = g.carregar_imagem("/tiro.png")
	inteiro mete = g.carregar_imagem("/meteoro.png")

	inteiro tx[200], ty[200]
	inteiro mx[200], my[200]

	real segms = 0.0
	inteiro  min = 0, seg = 0

	real segundoMeteoro = 0.0, segundoNave = 0.0

	funcao controle(){
		se(t.tecla_pressionada(t.TECLA_A) ou t.tecla_pressionada(t.TECLA_SETA_ESQUERDA) e px > 0){
			px-=5
		}
		se(t.tecla_pressionada(t.TECLA_D) ou t.tecla_pressionada(t.TECLA_SETA_DIREITA) e px < 800 - 57){
			px+=5
		}
		se(t.tecla_pressionada(t.TECLA_W) ou t.tecla_pressionada(t.TECLA_SETA_ACIMA) e py > 0 ){
			py-=5
		}
		se(t.tecla_pressionada(t.TECLA_S) ou t.tecla_pressionada(t.TECLA_SETA_ABAIXO) e py < 600 - 71){
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
			tx[index] = px + 51
			ty[index] = py + 31
		}
		se(segms ==  segundoNave + 0.5){ 
			disparo = verdadeiro
		}
		
	}
	funcao geracaoMeteoro(){
		se(meteoro == verdadeiro e seg != 0){
			segundoMeteoro = seg
			inteiro index = 0
			para(inteiro i = 0; my[i] != -1; i++){
				index++
			}
			mx[index] = 800
			my[index] = u.sorteia(0, 570)
			meteoro = falso
		}
		se(seg == segundoMeteoro + 4){
			meteoro = verdadeiro
		}
	}
	
	funcao desenhar(){
		g.definir_cor(g.COR_BRANCO)
		g.limpar()
		desenharTiro()
		g.desenhar_imagem(px, py, nave)
		desenharMeteoro()
		g.definir_cor(g.COR_PRETO)
		g.desenhar_texto(750, 5, px + "; " + py)
		g.desenhar_texto(750, 15, min + ":" + segms)
		g.desenhar_texto(5, 5, vidas+"")
	}
	funcao desenharTiro(){
		para(inteiro i = 0; i < 200; i++){
			se(tx[i] != -1){
				se(tx[i] < 800){
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
					se(px + 57 > mx[i] e
					   px < mx[i] + 70 e
					   py + 71 > my[i] e
					   py < my[i] + 30){
					   	vidas--
					   	mx[i] = -69
						my[i] = -69

						px = 150
						py = 300 - aNave/2
					}
					para(inteiro j = 0; j < 200; j++){
						se(tx[j] != -1){
							se(tx[j] + lTiro > mx[i] e
							   tx[j] < mx[i] + 70 e
							   ty[j] + aTiro > my[i] e
							   ty[j] < my[i] + 30){
						   		mx[i] = -69
								tx[j] = 799
							}
						}	
					}
				   	g.definir_cor(g.COR_PRETO)
					g.desenhar_retangulo(mx[i], my[i], 70, 30, verdadeiro, verdadeiro)
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
		}
		segms = m.arredondar(seg + ms/1000, 1)
	}
	funcao inicio(){
		g.iniciar_modo_grafico(verdadeiro)
		g.definir_dimensoes_janela(800, 600)
		para(inteiro i = 0; i < 200; i++){
			tx[i] = -1
			ty[i] = -1
			mx[i] = -1
			my[i] = -1
		}
		
		enquanto(nao t.tecla_pressionada(t.TECLA_ESC)){
			cronometro()
			geracaoMeteoro()
			controle()
			controleTiro()
			desenhar()
			g.renderizar()
			u.aguarde(10)
		}
	}	
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 467; 
 * @DOBRAMENTO-CODIGO = [61];
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */