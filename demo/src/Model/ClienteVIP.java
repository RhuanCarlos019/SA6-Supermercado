// ClienteVIP.java
package Model;

public class ClienteVIP {
    private String cpf;
    private String nome;

    public ClienteVIP(String cpf, String nome) {
        this.cpf = cpf;
        this.nome = nome;
    }

    // Métodos getters e setters

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
