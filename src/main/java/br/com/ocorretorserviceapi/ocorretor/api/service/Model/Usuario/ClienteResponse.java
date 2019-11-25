package br.com.ocorretorserviceapi.ocorretor.api.service.Model.Usuario;

import com.fasterxml.jackson.annotation.JsonRootName;
import org.springframework.http.HttpStatus;

import java.util.List;

@JsonRootName(value = "ClienteResponse")
public class ClienteResponse {
    private int codigoResponse;

    private HttpStatus mensagem;

    private List<Cliente> clientes;

    private Cliente cliente;

    public int getCodigoResponse() {
        return codigoResponse;
    }

    public void setCodigoResponse(int codigo) {
        this.codigoResponse = codigo;
    }

    public HttpStatus getMensagem() {
        return mensagem;
    }

    public void setMensagem(HttpStatus mensagem) {
        this.mensagem = mensagem;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
