package com.exemplo.model;

public class Usuario {
    private Long cpfUsuario;
    private String nomeUsuario;
    private Long telefoneUsuario;
    private String ruaUsuario;
    private String numeroUsuario;
    private Integer cepUsuario;
    private String senhaUsuario;
    private String nivelAcessoUsuario;

    public Usuario(Long cpfUsuario, String nomeUsuario, Long telefoneUsuario,
                    String ruaUsuario, String numeroUsuario, Integer cepUsuario,
                    String senhaUsuario, String nivelAcessoUsuario) {
        this.cpfUsuario = cpfUsuario;
        this.nomeUsuario = nomeUsuario;
        this.telefoneUsuario = telefoneUsuario;
        this.ruaUsuario = ruaUsuario;
        this.numeroUsuario = numeroUsuario;
        this.cepUsuario = cepUsuario;
        this.senhaUsuario = senhaUsuario;
        this.nivelAcessoUsuario = nivelAcessoUsuario;
    }

    // Getters e Setters

    public Long getCpfUsuario() {
        return cpfUsuario;
    }

    public void setCpfUsuario(Long cpfUsuario) {
        this.cpfUsuario = cpfUsuario;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public Long getTelefoneUsuario() {
        return telefoneUsuario;
    }

    public void setTelefoneUsuario(Long telefoneUsuario) {
        this.telefoneUsuario = telefoneUsuario;
    }

    public String getRuaUsuario() {
        return ruaUsuario;
    }

    public void setRuaUsuario(String ruaUsuario) {
        this.ruaUsuario = ruaUsuario;
    }

    public String getNumeroUsuario() {
        return numeroUsuario;
    }

    public void setNumeroUsuario(String numeroUsuario) {
       
        this.numeroUsuario = numeroUsuario;
    }

    public Integer getCepUsuario() {
        return cepUsuario;
    }

    public void setCepUsuario(Integer cepUsuario) {
        this.cepUsuario = cepUsuario;
    }

    public String getSenhaUsuario() {
        return senhaUsuario;
    }

    public void setSenhaUsuario(String senhaUsuario) {
        this.senhaUsuario = senhaUsuario;
    }

    public String getNivelAcessoUsuario() {
        return nivelAcessoUsuario;
    }

    public void setNivelAcessoUsuario(String nivelAcessoUsuario) {
        this.nivelAcessoUsuario = nivelAcessoUsuario;
    }
}
