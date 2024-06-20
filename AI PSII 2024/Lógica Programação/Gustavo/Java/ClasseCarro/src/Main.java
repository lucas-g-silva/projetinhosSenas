
import Classes.Carro;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Scanner;

/**
 *
 * @author lucas-gabreil_silva
 */
public class Main {

    private static Scanner ler = new Scanner(System.in);

    public static void main(String[] args) {
        //Carro = classe
        //carro = objeto
        //Carro() = construtor
        Carro carro = new Carro(0);

        int opc;

        do {
            System.out.print(carro.isStatus() ? "Ligado" : "Desligado");
            System.out.println("  |  " + carro.getVelocidade() + "km/h");
            System.out.println("--------------------------");
            System.out.println("1 - Acelerar");
            System.out.println("2 - Frear");
            System.out.println("3 - Ligar");
            System.out.println("4 - Desligar");
            System.out.println("0 - Sair");
            System.out.println("--------------------------");
            System.out.print("Opcao: ");
            opc = ler.nextInt();
            clearConsole();
            switch (opc) {
                case 1:
                    if (carro.isStatus()) {
                        System.out.print("Quantos km/h acelerar? ");
                        carro.acelerar(ler.nextInt());
                    } else {
                        System.err.println("Ligue o carro primeiramente");
                    }
                    menuInicialOpcao();
                    break;
                case 2:
                    if (carro.isStatus()) {
                        System.out.print("Quantos km/h frear? ");
                        carro.frear(ler.nextInt());
                    } else if (!carro.isStatus()) {
                        System.err.println("Ligue o carro primeiramente");
                    } else {
                        System.err.println("O carro está parado");
                    }
                    menuInicialOpcao();
                    break;
                case 3:
                    if(!carro.isStatus()) carro.ligar();
                    else {
                        System.err.println("O carro ja esta ligado");
                        menuInicialOpcao();
                    }
                    break;
                case 4:
                    if (carro.isStatus() && carro.getVelocidade() == 0) carro.desligar();
                    else if(!carro.isStatus()) {
                        System.err.println("O carro ja esta desligado");
                        menuInicialOpcao();
                    }
                    else {
                        System.err.println("Carro em movimeto");
                        menuInicialOpcao();
                    }
                    break;
            }

        } while (opc != 0);
    }

    public static void menuInicialOpcao() {
        Scanner read = new Scanner(System.in);

        System.out.println("");
        System.out.print("Pressione Enter para voltar para o Menu Inicial ");
        String voltar = read.nextLine();

        clearConsole();
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
