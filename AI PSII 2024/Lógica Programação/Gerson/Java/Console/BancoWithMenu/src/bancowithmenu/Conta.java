package bancowithmenu;
/**
 *
 * @author lucas-gabreil_silva
 */
public class Conta {
    //atributos da classe
    //tipo => (0 - corrente   1 - poupança   2 - salário)
    int tipo;
    int numero;
    String titular;
    float saldo;
    float limite;
    float limite_max;

    //métodos da classe
    public void sacar(float valor) {
        if (this.saldo >= valor) {
            this.saldo -= valor;
            System.out.println("  Saque de " + valor + " realizado com sucesso!");
            System.out.println("  Saldo atual: " + this.saldo);
        } else if (this.tipo == 0 && this.saldo + this.limite >= valor) {
            float limite_utilizado = this.saldo - valor;
            this.limite += limite_utilizado;
            this.saldo = 0.0f;
            System.out.println("  Saque de " + valor + " realizado com sucesso!");
            System.out.println("  Saldo atual: " + this.saldo);
            System.out.println("  Limite atual: " + this.limite);
            System.out.println("  Limite utilizado: " + limite_utilizado);
        } else {
            System.out.println("  Voce nao tem saldo suficiente para esta operacao!");
        }
    }

    public void depositar(float valor) {
        if (this.limite_max > this.limite) {
            if (this.limite + valor > this.limite_max) {
                valor += (this.limite - this.limite_max);
                this.limite = this.limite_max;
            } else {
                this.limite += valor;
                valor = 0;
            }
        }
        this.saldo += valor;
        System.out.println("  Deposito de " + valor + " realizado com sucesso!");
        System.out.println("  Saldo atual: " + this.saldo);
        System.out.println("  Limite atual: " + this.limite);
    }

    public float verificar_saldo() {
        return this.saldo;
    }

    public void status() {
        System.out.println("  INFORMACOES DA CONTA - " + this.numero);
        System.out.println("  Tipo......: " + this.tipo);
        System.out.println("  Numero....: " + this.numero);
        System.out.println("  Titular...: " + this.titular);
        System.out.println("  Saldo.....: " + this.saldo);
        System.out.println("  Limite....: " + this.limite);
    }
}
