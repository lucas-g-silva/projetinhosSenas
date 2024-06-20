package appbanco;

import java.util.Scanner;

/**
 *
 * @author lucas-gabreil_silva
 */
public class AppBanco {

    public static void main(String[] args) {
        //banner do app
        System.out.println("|=====================================|");
        System.out.println("|    APP DE GERENCIAMENTO DO BANCO    |");
        System.out.println("|=====================================|");
        
        //instanciar um novo objeto conta
        Conta conta1 = new Conta('0', 101, "Lucas Gabriel Moser da Silva");
        
        conta1.status("Conta 1");
        System.out.println("");
        conta1.depositar(1800.0f);
        System.out.println("");
        conta1.sacar(450.0f);
        System.out.println("");
        conta1.transferir(1000.0f, 102);
    }
}
