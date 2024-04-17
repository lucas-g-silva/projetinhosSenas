programa
{
	inclua biblioteca Matematica --> m
	inclua biblioteca Teclado --> t
	inclua biblioteca Graficos --> g

	funcao eixo(){
		//definir cores grades
		inteiro cinza1 = g.criar_cor(210, 210, 210)
		inteiro cinza2 = g.criar_cor(230, 230, 230)

		//definir grades y
		para(inteiro i = 500; i < 1000; i += 5){
			se(i % 50 == 0){
				g.definir_cor(cinza1)
			}senao se(i != 0){
				g.definir_cor(cinza2)
			}
			g.desenhar_linha(i, 100, i, 570)
		}
		//definir grades x
		para(inteiro i = 100; i < 570; i += 5){
			se((i + 15) % 50 == 0){
				g.definir_cor(cinza1)
			}senao se(i != 0){
				g.definir_cor(cinza2)
			}
			g.desenhar_linha(500, i, 1000, i)
		}
		//definir marcações eixo x
		g.definir_cor(g.COR_VERMELHO)
		para(inteiro i = 500; i < 1000; i += 5){
			se(i % 50 == 0){
				g.desenhar_linha(i, 325, i, 345)
			}senao se(i != 0){
				g.desenhar_linha(i, 332, i, 338)
			}
		}
		//definir marcações eixo y
		para(inteiro i = 100; i < 570; i += 5){
			se((i + 15) % 50 == 0){
				g.desenhar_linha(740, i, 760, i)
			}senao se(i != 0){
				g.desenhar_linha(747, i, 753, i)
			}
		}
		g.definir_cor(g.COR_VERMELHO)
		//definir eixo x
		g.desenhar_linha(500, 335, 1000, 335)
		//definir eixo y
		g.desenhar_linha(750, 100, 750, 570)
	}

	funcao texto(){
		
	}

	funcao parabula(){
		
	}

	funcao desenhar(){
		g.definir_cor(g.COR_BRANCO)
		g.limpar()

		eixo()
		
		g.definir_cor(g.COR_PRETO)
		//Definir Retângulo do título
		g.desenhar_retangulo(20, 10, 980, 80, falso, falso)
		//Definir retângulo da equação
		g.desenhar_retangulo(20, 100, 450, 470, falso, falso)
		//Definir retângulo do eixo
		g.desenhar_retangulo(500, 100, 500, 470, falso, falso)
		
		g.renderizar()
	}
	
	funcao inicio(){
		g.iniciar_modo_grafico(verdadeiro)
		g.definir_dimensoes_janela(1024, 600)
		g.definir_titulo_janela("Traçador Gráfico de Funções")
		enquanto(nao t.tecla_pressionada(t.TECLA_ESC)){
			desenhar()
		}
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 155; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = {i, 13, 15, 1}-{i, 22, 15, 1}-{i, 32, 15, 1}-{i, 40, 15, 1};
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */