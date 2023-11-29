// Venda.java
package Model;

import java.util.Date;
import java.util.List;

public class Venda {
    private int id; // Identificador único da venda
    private Date data;
    private Cliente cliente;
    private List<Produto> produtos;
    private double total;

    public Venda(int id, Date data, Cliente cliente, List<Produto> produtos, double total) {
        this.id = id;
        this.data = data;
        this.cliente = cliente;
        this.produtos = produtos;
        this.total = total;
    }

    // Getters e Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
