import java.util.Scanner;
/**
 *
 * @author lucas-gabreil_silva
 */
public class Main {
    public static void main(String[] args) {
        //tipos primitivos
        byte a = 2;         //-128 a 127 = 1 byte
        short b = 2;        //-32 768 a 32 767 = 2 byte
        int c = 2;          //-2,147,483,648 a 2,147,483,647
        long d = 2;         //-9,223,372,036,854,775,808 a 9,223,372,036,854,775,807
        boolean e = false;  //1 bit
        char f = 'a';       //2 bytes
        float g = 22;       //4 bytes
        double h2 = 23;     //8 bytes
        String nome;
        
        Scanner input = new Scanner(System.in);
        System.out.print("Informe um numero: ");
        int valor = input.nextInt();
        
        System.out.println(valor);
    }
}
