programa{
	
	inclua biblioteca Util --> u
	
	inteiro tamanho = 10
	inteiro idades[10]
	
	funcao inicio(){
		cadeia nomes[10]
		inteiro metodo

		para(inteiro i=0; i<tamanho; i++){
			escreva("Nome: ")
			leia(nomes[i])
			escreva("\\-> Idade: ")
			leia(idades[i])
			limpa()
		}
		faca{
			escreva("Escolha o método de ordenação:\n")
			escreva("1 - Comb Sort\n")
			escreva("2 - Bubble Sort\n")
			escreva("3 - Selection Sort\n")
			escreva("4 - Insertion Sort\n")
			leia(metodo)
			limpa()
			se(metodo < 1 e metodo > 4){
				escreva("Método inválido!")
				u.aguarde(2000)
			}
		} enquanto(metodo < 1 e metodo > 4)

		escolha(metodo){
			caso 1:
				comb()
				pare
			caso 2:
				bubble()
				pare
			caso 3:
				selection()
				pare
			caso 4:
				insertion()
				pare
		}
		
		escreva("Idades: \n")
		para(inteiro i=0; i<tamanho; i++){
			escreva(nomes[i], ": ")
			escreva(idades[i], "\n")
		}
	}
	funcao comb(){
		inteiro gap, i, j, indice, auxiliar
		real fator
		logico trocado
		fator = 1.3
		trocado = verdadeiro
		gap = tamanho
		enquanto(gap > 1 ou trocado){
			gap = (gap / fator)
			se(gap < 1){
				gap = 1
			}
			trocado = falso
			i = 0
			enquanto(i + gap < tamanho){
				se(idades[i] < idades[i + gap]){
					auxiliar = idades[i]
					idades[i] = idades[i + gap]
					idades[i + gap] = auxiliar
					trocado = verdadeiro
				}
				i = i + 1
			}
		}
	}
	funcao bubble(){
		inteiro auxiliar
		para(inteiro j = 0; j < tamanho; j++){
			para(inteiro i = 0; i < tamanho - 1; i++){
				se(idades[i] < idades[i+1]){
					auxiliar = idades[i]
					idades[i] = idades[i+1]
					idades[i+1] = auxiliar
				}
			}
		}
	}
	funcao insertion(){
		inteiro elementoAtual, indice
		para(inteiro i = 0; i < tamanho; i++){
			elementoAtual = idades[i]
			indice = i
			enquanto(indice > 0 e idades[indice-1] < elementoAtual){
				idades[indice] = idades[indice-1]
				indice--
			}
			idades[indice] = elementoAtual
		}
	}
	funcao selection(){
		inteiro index, auxiliar
		para(inteiro i = 0; i < tamanho - 1; i++){
			index = i
			para(inteiro c = i + 1; c < tamanho; c++){
				se(idades[c] > idades[index]){
					index = c
				}
			}
			auxiliar = idades[i]
			idades[i] = idades[index]
			idades[index] = auxiliar
		}
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 671; 
 * @DOBRAMENTO-CODIGO = [53, 78, 90, 102];
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */