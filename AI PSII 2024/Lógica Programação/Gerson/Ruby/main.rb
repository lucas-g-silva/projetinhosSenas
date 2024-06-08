puts "Número de Alunos: "
size = gets.chomp.to_i #ler número de alunos

puts "Número de Notas por aluno: "
num = gets.chomp.to_i #ler número de notas

notas = Array.new(size){Array.new(num)} #matriz para notas
medias = Array.new(size) #lista para medias
nomes = Array.new(size) #lista para nomes

i = 0 #declração de index para alunos
size.times do #repetir de acordo com o número de alunos
    puts "\nNome do Aluno "+(i+1).to_s+": "
    nomes[i] = gets.chomp #ler o nome do aluno
    c = 0 #declração de index para notas
    soma = 0.0 #soma de todas as notas
    num.times do #repetir de acordo com número de notas
        puts "\\-> Nota "+(c+1).to_s+": "
        notas[i][c] = gets.chomp.to_f #ler as nota do aluno
        soma = soma + notas[i][c] #adiciona a nota a soma
        c = c + 1 #ADICIONA UM AO INDEX NOTAS
    end
    medias[i] = soma / num #calcular a média a partir da soma 
    i = i + 1 #ADICIONA UM AO INDEX ALUNOS
end

#organização em ordem decresente (bubble sort)
size.times do #repetir de acordo com o número de alunos
    i = 0 #declração de index para alunos
    (size - 1).times do #repetir de acordo com o número de alunos - 1
        if medias[i] < medias[i + 1]
            auxMedias = medias[i]
            auxNomes = nomes[i]
            medias[i] = medias[i + 1]
            nomes[i] = nomes[i + 1]
            medias[i + 1] = auxMedias
            nomes[i + 1] = auxNomes
        end
        i = i + 1 #ADICIONA UM AO INDEX ALUNOS
    end
end

puts "\nRanking dos Alunos"
puts "------------------"
i = 0 #declração de index para alunos
size.times do #repetir de acordo com o número de alunos
    puts (i+1).to_s + ". " + nomes[i] + ": " + medias[i].to_s #mostra a colocação nome e média de cada aluno
    i = i + 1 #ADICIONA UM AO INDEX ALUNOS
end
