package br.com.ocorretorserviceapi.ocorretor.api.service.Model.Usuario;

import java.io.Serializable;

public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;
    private String nome;
    private boolean status;
    private String bloqueio;
    private int id;

    public Cliente() {
    }

    public String getNome() {
        return nome;
    }

    public boolean isStatus() {
        return status;
    }

    public String getBloqueio() {
        return bloqueio;
    }

    public int getId() {
        return id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
