package Classes;
/**
 *
 * @author lucas-gabreil_silva
 */
public class Carro {
    private int velocidade;
    private boolean status;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
    public int getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(int velocidade) {
        this.velocidade = velocidade;
    }
    
    public void acelerar(int aceleracao){
        if(this.isStatus()){
            this.velocidade += aceleracao;
        }
    }
    
    public void partida(){
        if(!this.isStatus()){
            this.status = true;
        }
    }
    
    public void desligar(){
        this.status = false;
    }
}
