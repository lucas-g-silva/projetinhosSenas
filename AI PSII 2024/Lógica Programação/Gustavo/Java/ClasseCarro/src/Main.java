
import Classes.Carro;
import java.util.Scanner;

/**
 *
 * @author lucas-gabreil_silva
 */
public class Main {

    public static void main(String[] args) {
        //Carro = classe
        //carro = objeto
        //Carro() = construtor
        Carro carro = new Carro();

        Scanner ler = new Scanner(System.in);

        int opc = 0;

        do {
            System.out.println("--------------------------");
            System.out.println("1 - Acelerar");
            System.out.println("2 - Frear");
            System.out.println("3 - Ligar");
            System.out.println("4 - Desligar");
            System.out.println("0 - Sair");
            System.out.println("--------------------------");
            opc = ler.nextInt();

            switch (opc) {
                case 1:
                    
                    break;
                case 2:
                    
                    break;
                case 3:
                    
                    break;
                case 4:
                    
                    break;
            }

        } while (opc != 0);
    }

}
