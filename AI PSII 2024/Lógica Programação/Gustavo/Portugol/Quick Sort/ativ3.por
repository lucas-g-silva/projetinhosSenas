programa{
    
    inclua biblioteca Util --> u
    
    const inteiro tam = 50
    inteiro vetor[tam]

    funcao inicio(){
        inteiro tamanho = tam, aux, i
        para(i = 0; i < tamanho; i++){
            vetor[i] = u.sorteia(0, 9)
        }
        escreva("Vetor Original: ")
        para(i = 0; i < tamanho; i++){
            escreva(vetor[i], " ")
        }
        escreva("\n")
        quickSort(vetor, 0, tam -1)

        escreva("Vetor Ordenado Crescente: ")
        para(i = 0; i < tamanho; i++){
            escreva(vetor[i], " ")
        }
		escreva("\n")
        escreva("Vetor Ordenado Decrescente: ")
        para(i = tamanho - 1; i >= 0; i--){
            escreva(vetor[i], " ")
        }
    }

    funcao quickSort(inteiro vetor[], inteiro inicio, inteiro fim){
        inteiro i, j, pivo, aux
        i = inicio
        j = fim
        pivo = vetor[(inicio + fim) / 2]

        enquanto(i <= j){
            enquanto(vetor[i] < pivo){
                i++
            }
            enquanto(vetor[j] > pivo){
                j--
            }
            se(i <= j){
                aux = vetor[i]
                vetor[i] = vetor[j]
                vetor[j] = aux
                i++
                j--
            }
        }
        se(j > inicio){
            quickSort(vetor, inicio, j)
        }
        se(i < fim){
            quickSort(vetor, i, fim)
        }
    }
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 428; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */