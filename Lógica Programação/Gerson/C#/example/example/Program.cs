using System.Runtime.ConstrainedExecution;

Console.WriteLine("Número de Alunos: ");
int size = Convert.ToInt32(Console.ReadLine()); //ler número de alunos

Console.Clear();

Console.WriteLine("Número de Notas por aluno: ");
int num = Convert.ToInt32(Console.ReadLine()); //ler número de notas

float[,] notas = new float[size, num]; //matriz para notas
float[] medias = new float[size]; //lista para medias
string[] nomes = new string[size]; //lista para nomes

Console.Clear();

for (int i = 0; i < size; i++) //repetir de acordo com o número de alunos
{
    Console.WriteLine("Nome do Aluno " + (i + 1) + ": ");
    nomes[i] = Console.ReadLine(); //ler o nome do aluno
    float soma = 0.0F; //soma de todas as notas
    for (int c = 0; c < num; c++) //repetir de acordo com número de notas
    {
        Console.WriteLine("\\-> Nota" + (c + 1) + ": ");
        notas[i, c] = float.Parse(Console.ReadLine()); //ler as nota do aluno
        soma += notas[i, c]; //adiciona a nota a soma
    }
    medias[i] = soma / num; //calcular a média a partir da soma
    Console.Clear();
}

float auxMedias;
string auxNomes;
//organização em ordem decresente
for (int j = 0; j < size; j++)//repetir de acordo com o número de alunos
{
    for (int i = 0; i < size-1; i++) //repetir de acordo com o número de alunos - 1
    {
        if (medias[i] < medias[i + 1])
        {
            auxMedias = medias[i];
            auxNomes = nomes[i];
            medias[i] = medias[i + 1];
            nomes[i] = nomes[i + 1];
            medias[i + 1] = auxMedias;
            nomes[i + 1] = auxNomes;
        }
    }
}
Console.WriteLine("Ranking dos Alunos");
Console.WriteLine("------------------");
for (int i = 0; i < size; i++) //repetir de acordo com o número de alunos
{
    Console.WriteLine((i + 1) + ". " + nomes[i] + ": " + medias[i]); //mostra a colocação nome e média de cada aluno
}
