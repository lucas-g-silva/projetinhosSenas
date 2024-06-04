Console.WriteLine("Número de Alunos: ");
int size = Convert.ToInt32(Console.ReadLine());

Console.Clear();

Console.WriteLine("Número de Notas por aluno: ");
int num = Convert.ToInt32(Console.ReadLine());

float[,] notas = new float[size, num];
float[] medias = new float[size];
string[] nomes = new string[size];

Console.Clear();

for (int i = 0; i < size; i++)
{
    Console.WriteLine("Nome do Aluno " + (i + 1) + ": ");
    nomes[i] = Console.ReadLine();
    float soma = 0.0F;
    for (int c = 0; c < num; c++)
    {
        Console.WriteLine("\\-> Nota" + (c + 1) + ": ");
        notas[i, c] = float.Parse(Console.ReadLine());
        soma += notas[i, c];
    }
    medias[i] = soma / num;
    Console.Clear();
}

float auxMedias;
string auxNomes;
for (int j = 0; j < size; j++)
{
    for (int i = 0; i < size-1; i++)
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
for (int i = 0; i < size; i++)
{
    Console.WriteLine((i + 1) + ". " + nomes[i] + ": " + medias[i]);
}
