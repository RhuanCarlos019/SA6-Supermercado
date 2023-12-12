package com.exemplo.model;

public class Cliente {
    private String cpfCliente;
    private String nomeCliente;
    private String telefoneCliente;
    private String ruaCliente;
    private String numeroCliente;
    private String cepCliente;
    private boolean vip;

    public Cliente(String cpfCliente, String nomeCliente, String telefoneCliente, String ruaCliente,
                   String numeroCliente, String cepCliente, boolean vip) {
        this.cpfCliente = cpfCliente;
        this.nomeCliente = nomeCliente;
        this.telefoneCliente = telefoneCliente;
        this.ruaCliente = ruaCliente;
        this.numeroCliente = numeroCliente;
        this.cepCliente = cepCliente;
        this.vip = vip;
    }

    // Getters e Setters

    public String getCpfCliente() {
        return cpfCliente;
    }

    public void setCpfCliente(String cpfCliente) {
        this.cpfCliente = cpfCliente;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getTelefoneCliente() {
        return telefoneCliente;
    }

    public void setTelefoneCliente(String telefoneCliente) {
        this.telefoneCliente = telefoneCliente;
    }

    public String getRuaCliente() {
        return ruaCliente;
    }

    public void setRuaCliente(String ruaCliente) {
        this.ruaCliente = ruaCliente;
    }

    public String getNumeroCliente() {
        return numeroCliente;
    }

    public void setNumeroCliente(String numeroCliente) {
        this.numeroCliente = numeroCliente;
    }

    public String getCepCliente() {
        return cepCliente;
    }

    public void setCepCliente(String cepCliente) {
        this.cepCliente = cepCliente;
    }

    public boolean isVip() {
        return vip;
    }

    public void setVip(boolean vip) {
        this.vip = vip;
    }
}
