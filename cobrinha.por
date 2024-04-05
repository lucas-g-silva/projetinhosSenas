programa
{
	inclua biblioteca Teclado --> t
	inclua biblioteca Util --> u
	inclua biblioteca Graficos --> g

	inteiro corTab[] = {g.criar_cor(167, 216, 81), g.criar_cor(163, 208, 74)}
	inteiro corCobra = g.criar_cor(55, 98, 209)
	inteiro xy = 40
	inteiro px = xy*8, py = xy*8
	inteiro tamanho = 5
	caracter direcao = 'd'
	
	funcao inicio(){
          g.iniciar_modo_grafico(verdadeiro)
          g.definir_dimensoes_janela(680, 680)
          g.definir_titulo_janela("Snake Game")
          enquanto (nao t.tecla_pressionada(t.TECLA_ESC)) {
          	desenhar()
          	mover()
          	moverCobra()
          }
     }
     funcao desenhar(){
     	para(inteiro j = 0; j < 17; j++){
     		para(inteiro i = 0; i < 17; i++){
     			se(((j+1) % 2) == ((i+1) % 2)){
     				g.definir_cor(corTab[0])
     			} senao{
     				g.definir_cor(corTab[1])
     			}
     			g.desenhar_retangulo(xy*i, xy*j, xy, xy, falso, verdadeiro)
     		}
     	}
		para(inteiro i = 0; i < tamanho; i++){
			desenharCobra(i)
		}
     	g.renderizar()
     }
     funcao desenharCobra(inteiro i){
     	g.definir_cor(corCobra)
		g.desenhar_retangulo(px - i*xy, py, xy, xy, verdadeiro, verdadeiro)
     }
     funcao mover(){
     	se(t.tecla_pressionada(t.TECLA_SETA_ACIMA)){
     		enquanto(px % 40 != 0 ou py % 40 != 0){
     			moverCobra()
     			desenhar()
     		}
     		direcao = 'c'
     	} senao se(t.tecla_pressionada(t.TECLA_SETA_ABAIXO)){
     		enquanto(px % 40 != 0 ou py % 40 != 0){
     			moverCobra()
     			desenhar()
     		}
     		direcao = 'b'
     	} senao se(t.tecla_pressionada(t.TECLA_SETA_DIREITA)){
     		enquanto(px % 40 != 0 ou py % 40 != 0){
     			moverCobra()
     			desenhar()
     		}
     		direcao = 'd'
     	} senao se(t.tecla_pressionada(t.TECLA_SETA_ESQUERDA)){
     		enquanto(px % 40 != 0 ou py % 40 != 0){
     			moverCobra()
     			desenhar()
     		}
     		direcao = 'e'
     	}
     }
     funcao moverCobra(){
     	escolha(direcao){
     		caso 'c':
     			py--
     			pare
     		caso 'b':
     			py++
     			pare
     		caso 'd':
     			px++
     			pare
     		caso 'e':
     			px--
     			pare
     	}
     	u.aguarde(5)
     }
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 1348; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */