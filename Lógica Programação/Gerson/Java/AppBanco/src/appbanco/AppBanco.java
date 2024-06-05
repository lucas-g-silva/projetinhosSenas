package appbanco;
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
        conta1.titular = "Lucas Gabriel Moser da Silva";
        conta1.saldo = 200.0f;
        conta1.limite = 1000.0f;
        
        conta1.status("Conta 1");
        
        //instanciar um novo objeto conta
        Conta conta2 = new Conta();
        conta2.numero = 100;
        conta2.tipo = '2';
        conta2.titular = "Dylan Rampon";
        conta2.saldo = 230.0f;
        
        conta2.status("Conta 2");
        
        conta1.sacar(300.0f);
    }
    
}
