package br.ufac.sgcm.model;

import java.io.Serializable;

public class Usuario implements Serializable {

    private Long id;
    private String nomeCompleto;
    private String nomeUsuario;
    private String senha;
    private boolean ativo;
    private String papel;
    
    public void setId(Long id) {
        this.id = id;
    }
    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }
    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
    public void setPapel(String papel) {
        this.papel = papel;
    }
    public Long getId() {
        return id;
    }
    public String getNomeCompleto() {
        return nomeCompleto;
    }
    public String getNomeUsuario() {
        return nomeUsuario;
    }
    public String getSenha() {
        return senha;
    }
    public boolean isAtivo() {
        return ativo;
    }
    public String getPapel() {
        return papel;
    }

    
}
