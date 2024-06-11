package bancowithmenu;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author lucas-gabreil_silva
 */
public class BancoWithMenu {

    static Conta contas[] = new Conta[100];
    static int auxNumContas = -1;

    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("C:/Users/lucas-gabreil_silva/Documents/GitHub/projetinhosSenas/Lógica Programação/Gerson/Java/BancoWithMenu/src/bancowithmenu/contas.txt");

        Scanner fileScan = new Scanner(file);

        int i = 1;
        while (fileScan.hasNextLine()) {
            switch (i) {
                case 1:
                    auxNumContas++;
                    contas[auxNumContas] = new Conta();
                    contas[auxNumContas].tipo = fileScan.nextInt();
                    i++;
                    break;
                case 2:
                    contas[auxNumContas].numero = fileScan.nextInt();
                    i++;
                    break;
                case 3:
                    contas[auxNumContas].titular = fileScan.nextLine();
                    i++;
                    break;
                case 4:
                    contas[auxNumContas].saldo = fileScan.nextFloat();
                    i++;
                    break;
                case 5:
                    contas[auxNumContas].limite = fileScan.nextFloat();
                    contas[auxNumContas].limite_max = 1000.0f;
                    i = 1;
                    break;
            }
        }

        boolean rodando = true;
        while (rodando) {
            int next = menuInicial();
            if (next == 1) {
                menuCriarConta();
            }
            if (next == 2 && auxNumContas != -1) {
                menuStatus();
            }
            if (next == 3 && auxNumContas != -1) {
                menuSacar();
            }
            if (next == 4 && auxNumContas != -1) {
                menuDepositar();
            }
            if (next == 5) {
                rodando = false;
            }
        }
    }

    public static int menuInicial() {
        System.out.println("|==============================================|");
        System.out.println("|       Aplicativo Gerenciador de Contas       |");
        System.out.println("|----------------------------------------------|");
        System.out.println("|                     MENU                     |");
        System.out.println("|----------------------------------------------|");
        System.out.println("| 1 - Criar Conta       2 - Listar Conta       |");
        System.out.println("| 3 - Sacar             4 - Depositar          |");
        System.out.println("| 5 - Fechar App                               |");
        System.out.println("|                                              |");
        System.out.print("  Escolha uma operacao: ");
        Scanner read = new Scanner(System.in);
        int operacao = read.nextInt();
        clearConsole();
        return operacao;
    }

    public static void menuCriarConta() {
        Scanner read = new Scanner(System.in);
        System.out.println("|==============================================|");
        System.out.println("|       Aplicativo Gerenciador de Contas       |");
        System.out.println("|----------------------------------------------|");
        System.out.println("|                  CRIAR CONTA                 |");
        System.out.println("|----------------------------------------------|");
        System.out.print(" - Nome do Titular: ");
        String titular = read.nextLine();
        System.out.println(" - Tipo da Conta:                               ");
        System.out.println("   - 0 para corrente                            ");
        System.out.println("   - 1 para poupanca                            ");
        System.out.println("   - 2 para salario                             ");
        int tipo = read.nextInt();

        clearConsole();

        auxNumContas++;
        contas[auxNumContas] = new Conta();

        contas[auxNumContas].titular = titular;
        contas[auxNumContas].tipo = tipo;
        contas[auxNumContas].numero = auxNumContas + 1;
        contas[auxNumContas].saldo = 0.0f;
        if (tipo == 0) {
            contas[auxNumContas].limite = 1000.0f;
            contas[auxNumContas].limite_max = 1000.0f;
        }

        System.out.println("Conta Criada com sucesso!");
        System.out.println("");
        contas[auxNumContas].status();

        menuInicialOpcao();

        clearConsole();
    }

    public static void menuStatus() {
        clearConsole();
        System.out.println("|==============================================|");
        System.out.println("|       Aplicativo Gerenciador de Contas       |");
        System.out.println("|----------------------------------------------|");
        System.out.println("|                    CONTAS                    |");
        System.out.println("|----------------------------------------------|");
        for (var i = 0; i <= auxNumContas; i++) {
            contas[i].status();
            System.out.println("");
        }
        menuInicialOpcao();
    }

    public static void menuSacar() {
        clearConsole();
        Scanner read = new Scanner(System.in);
        System.out.println("|==============================================|");
        System.out.println("|       Aplicativo Gerenciador de Contas       |");
        System.out.println("|----------------------------------------------|");
        System.out.println("|                     SACAR                    |");
        System.out.println("|----------------------------------------------|");
        System.out.print("  - Número da conta: ");
        int num = read.nextInt();
        System.out.print("  - Valor: ");
        float valor = read.nextFloat();

        contas[num - 1].sacar(valor);

        menuInicialOpcao();
    }

    public static void menuDepositar() {
        clearConsole();
        Scanner read = new Scanner(System.in);
        System.out.println("|==============================================|");
        System.out.println("|       Aplicativo Gerenciador de Contas       |");
        System.out.println("|----------------------------------------------|");
        System.out.println("|                   DEPOSITAR                  |");
        System.out.println("|----------------------------------------------|");
        System.out.print("  - Número da conta: ");
        int num = read.nextInt();
        System.out.print("  - Valor: ");
        float valor = read.nextFloat();

        contas[num - 1].depositar(valor);

        menuInicialOpcao();
    }

    public static void menuInicialOpcao() {
        Scanner read = new Scanner(System.in);

        System.out.println("");
        System.out.print("Digite para voltar para o menu Inicial ");
        String voltar = read.next();
    }

    public final static void clearConsole() {
        try {
            Robot robot = new Robot();
            robot.setAutoDelay(10);
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_L);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyRelease(KeyEvent.VK_L);
        } catch (AWTException ex) {
        }
    }
}
