package br.ufac.sgcm.model;

import java.io.Serializable;

public class Profissional implements Serializable {
    private Long id;
    private String nome;
    private String registro;
    private String email;
    private String telefone;
    private Long unidade;
    private Long especialidade;

    // Construtor vazio
    public Profissional() {
    }


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRegistro() {
        return registro;
    }

    public void setRegistro(String registro) {
        this.registro = registro;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Long getUnidade() {
        return unidade;
    }

    public void setUnidade(Long unidade) {
        this.unidade = unidade;
    }

    public Long getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(Long especialidade) {
        this.especialidade = especialidade;
    }

}
