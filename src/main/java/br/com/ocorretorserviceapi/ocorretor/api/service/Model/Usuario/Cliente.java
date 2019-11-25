package br.com.ocorretorserviceapi.ocorretor.api.service.Model.Usuario;

import java.io.Serializable;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;

public class Cliente implements Serializable {
    private static final long serialVersionUID = 1L;

    private int id;

    private String nome;

    private String logoMarca;

    private String email;

    private boolean status;

    private Endereco endereco;

    private List<Telefone> telefones;

    public Cliente(
            int id,
            String nome,
            String logoMarca,
            String email,
            boolean status,
            Endereco endereco,
            List<Telefone> telefones
    ) {
        this.id = id;
        this.nome = nome;
        this.logoMarca = logoMarca;
        this.email = email;
        this.status = status;
        this.endereco = endereco;
        this.telefones = telefones;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogoMarca() {
        return logoMarca;
    }

    public void setLogoMarca(String logoMarca) {
        this.logoMarca = logoMarca;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public List<Telefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<Telefone> telefones) {
        this.telefones = telefones;
    }
}
