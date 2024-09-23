
/**
 * @author lucas-gabreil_silva
 */
public class Cliente {

    private int cod;
    private String nome;
    private String fone;
    private String email;
    private String endereco;

    public Cliente() {
    }

    public Cliente(String nome, String fone) {
        this.nome = nome;
        this.fone = fone;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
