programa
{
     inclua biblioteca Util --> u
     inclua biblioteca Teclado --> t
     inclua biblioteca Graficos --> g
     inteiro bx = 385
     inteiro by = 285
     inteiro v = 5

    	caracter direcao = 'n'

     funcao mover()
     {	
     	se(tecla(t.TECLA_ESPACO)){
     		escolha(direcao){
     			caso 'c':
     				enquanto(by >= 0){
     					by--
     					desenhar()
     				}
     				pare
     			caso 'b':
     				enquanto(by <= 570){
     					by++
     					desenhar()
     				}
     				pare
     			caso 'e':
     				enquanto(bx >= 0){
     					bx--
     					desenhar()
     				}
     				pare
     			caso 'd':
     				enquanto(bx <= 770){
     					bx++
     					desenhar()
     				}
     				pare
     		}
     		
     	}
          se (tecla(t.TECLA_SETA_ACIMA) ou tecla(t.TECLA_W)){
               by--
               u.aguarde(v)
               direcao = 'c'
          }
          se (tecla(t.TECLA_SETA_ABAIXO) ou tecla(t.TECLA_S)) {
               by++
               u.aguarde(v)
               direcao = 'b'
          }
          se (tecla(t.TECLA_SETA_ESQUERDA) ou tecla(t.TECLA_A)) {
               bx--
               u.aguarde(v)
               direcao = 'e'
          }
          se (tecla(t.TECLA_SETA_DIREITA) ou tecla(t.TECLA_D)){
               bx++
               u.aguarde(v)
               direcao = 'd'
          }
          se(by <= -30){
          	by = 629
          }
          se(by >= 630){
          	by = -29
          }
          se(bx <= -30){
          	bx = 829
          }
          se(bx >= 830){
          	bx = -29
          }
          se (v > 0) {
               se (tecla(t.TECLA_ADICAO)) {
                    v--
                    u.aguarde(200)
               }
          }
          se (v < 10) {
               se (tecla(t.TECLA_SUBTRACAO)) {
                    v++
                    u.aguarde(200)
               }
          }
     }

     funcao logico tecla(inteiro tecla_)
     {
          retorne t.tecla_pressionada(tecla_)
     }

     funcao desenhar()
     {	inteiro vermelho = 255-v*25, azul = v*25
     	inteiro color = g.criar_cor(vermelho, 0, azul)
          g.definir_cor(g.COR_BRANCO)
          g.limpar()
          g.definir_cor(color)
          g.desenhar_elipse(bx, by, 30, 30, verdadeiro)
          
          g.definir_cor(g.COR_PRETO)
          g.desenhar_elipse(bx, by, 30, 30, falso)
          g.desenhar_texto(10, 10, "Velocidade: " + (10 - v) + "")
          g.desenhar_texto(10, 30, "X: " + bx + "")
          g.desenhar_texto(10, 50, "Y: " + by + "")

		g.definir_cor(g.COR_BRANCO)
          g.desenhar_elipse(bx+8, by+12, 2, 2, verdadeiro)
          g.desenhar_elipse(bx+20, by+12, 2, 2, verdadeiro)
          g.desenhar_linha(bx+8, by+20, bx+22, by+20)
		g.desenhar_linha(bx+12, by+10-v+2, bx+6, by+v+2)
		g.desenhar_linha(bx+18, by+10-v+2, bx+24, by+v+2)

		
		g.definir_cor(g.COR_PRETO)
		escolha(direcao){
			caso 'c':
				g.desenhar_linha(bx+15, by-5, bx+15, by-15)
				g.desenhar_linha(bx+12, by-12, bx+15, by-15)
				g.desenhar_linha(bx+18, by-12, bx+15, by-15)
				pare
			caso 'b':
				g.desenhar_linha(bx+15, by+35, bx+15, by+45)
				g.desenhar_linha(bx+12, by+42, bx+15, by+45)
				g.desenhar_linha(bx+18, by+42, bx+15, by+45)
				pare
			caso 'e':
				g.desenhar_linha(bx-5, by+15, bx-15, by+15)
				g.desenhar_linha(bx-12, by+12, bx-15, by+15)
				g.desenhar_linha(bx-12, by+18, bx-15, by+15)
				pare
			caso 'd':
				g.desenhar_linha(bx+35, by+15, bx+45, by+15)
				g.desenhar_linha(bx+42, by+12, bx+45, by+15)
				g.desenhar_linha(bx+42, by+18, bx+45, by+15)
		}

          g.renderizar()
     }

     funcao inicio()
     {
          g.iniciar_modo_grafico(verdadeiro)
          g.definir_dimensoes_janela(800, 600)
          g.definir_titulo_janela("Essa é uma Janela!")
          enquanto (nao t.tecla_pressionada(t.TECLA_ESC)) {
               desenhar()
               mover()
          }
     }
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 352; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */