puts "Número de Alunos: "
size = gets.chomp.to_i

puts "Número de Notas por aluno: "
num = gets.chomp.to_i

notas = Array.new(size){Array.new(num)}
medias = Array.new(size)
nomes = Array.new(size)

i = 0
size.times do
    puts "\nNome do Aluno "+(i+1).to_s+": "
    nomes[i] = gets.chomp
    c = 0
    soma = 0.0
    num.times do
        puts "\\-> Nota "+(c+1).to_s+": "
        notas[i][c] = gets.chomp.to_f
        soma = soma + notas[i][c]
        c = c + 1
    end
    medias[i] = soma / num
    i = i + 1
end

auxMedias = 0.0
auxNomes = 0.0
size.times do
    i = 0
    (size - 1).times do
        if medias[i] < medias[i + 1]
            auxMedias = medias[i]
            auxNomes = nomes[i]
            medias[i] = medias[i + 1]
            nomes[i] = nomes[i + 1]
            medias[i + 1] = auxMedias
            nomes[i + 1] = auxNomes
        end
        i = i + 1
    end
end

puts "\nRanking dos Alunos"
puts "------------------"
i = 0
size.times do
    puts (i+1).to_s + "." + nomes[i] + ": " + medias[i].to_s
    i = i + 1
end
