/**
 *
 * @author lucas-gabreil_silva
 */
public class Conta {
    //atributos da classe
    //tipo => (0 - corrente   1 - poupança   2 - salário)
    char tipo;
    int numero;
    String titular;
    float saldo = 0.0f;
    float limite = 0.0f;
        
    //métodos da classe
    public void sacar(float valor){
        
    }
    public void depositar(float valor){
        
    }
    public void transferir(float valor, int destino){
        
    }
    public float verificar_saldo(){
        return this.saldo;
    }
    public void status(String nome_da_conta){
        System.out.println("---------------------------------------");
        System.out.println("INFORMACOES DA CONTA - "+nome_da_conta);
        System.out.println("Tipo......: "+this.tipo);
        System.out.println("Numero....: "+this.numero);
        System.out.println("Titular...: "+this.titular);
        System.out.println("Saldo.....: "+this.saldo);
        System.out.println("Limite....: "+this.limite);
        System.out.println("---------------------------------------");
    }
}
