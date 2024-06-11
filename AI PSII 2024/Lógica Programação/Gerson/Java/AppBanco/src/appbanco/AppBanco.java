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
        Conta conta1 = new Conta();
        conta1.tipo = '0';
        conta1.numero = 101;
        conta1.titular = "Lucas Gabriel Moser da Silva";
        conta1.saldo = 50.0f;
        conta1.limite = 3000.0f;
       
        
        conta1.status("Conta 1");
        conta1.depositar(1800.0f);
        conta1.sacar(450.0f);
        conta1.transferir(1000.0f, 102);
    }
}
