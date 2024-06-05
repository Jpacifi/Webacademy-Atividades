package br.ufac.sgcm.model;

import java.io.Serializable;

public class Atendimento implements Serializable{
    private Long id;
    private String data;
    private String status;
    private Long convenio_id;
    private Long paciente_id;
    private Long profissional_id;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getData() {
        return data;
    }
    public void setData(String data) {
        this.data = data;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public Long getConvenio_id() {
        return convenio_id;
    }
    public void setConvenio_id(Long convenio_id) {
        this.convenio_id = convenio_id;
    }
    public Long getPaciente_id() {
        return paciente_id;
    }
    public void setPaciente_id(Long paciente_id) {
        this.paciente_id = paciente_id;
    }
    public Long getProfissional_id() {
        return profissional_id;
    }
    public void setProfissional_id(Long profissional_id) {
        this.profissional_id = profissional_id;
    }
}
