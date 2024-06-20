package Classes;
/**
 *
 * @author lucas-gabreil_silva
 */
public class Carro {
    private int velocidade;
    private boolean status;
    
    public Carro(int velocidade){
        this.velocidade = velocidade;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
    public int getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(int aceleracao) {
        this.velocidade = aceleracao;
    }
    
    public void acelerar(int aceleracao){
        if(this.isStatus()){
            this.velocidade += aceleracao;
        }
    }
    
    public void frear(int aceleracao){
        if(this.isStatus()){
            this.velocidade -= aceleracao;
            if(this.velocidade < 0){
                this.velocidade = 0;
            }
            
        }
    }
    
    public void ligar(){
        if(!this.isStatus()){
            this.status = true;
        }
    }
    
    public void desligar(){
        if(this.isStatus() && this.velocidade == 0){
            this.status = false;
        }
    }
}
