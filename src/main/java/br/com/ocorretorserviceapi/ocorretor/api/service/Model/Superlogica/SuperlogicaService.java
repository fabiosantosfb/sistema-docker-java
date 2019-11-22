package br.com.ocorretorserviceapi.ocorretor.api.service.Model.Superlogica;

import br.com.ocorretorserviceapi.ocorretor.api.service.Model.Usuario.Cliente;
import org.json.JSONException;
import org.json.JSONObject;

import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.util.ArrayList;

public class SuperlogicaService {
    //https://www.baeldung.com/jersey-jax-rs-client
    private Client client;

    private ArrayList<Cliente> clientes;

    private static final String URL  = "https://api.superlogica.net/v2/financeiro/";

    private static final String URI_CLIENTE = "clientes?apenasColunasPrincipais=0&status=2&comDiaDeVencimento=0&apenasPessoasJuridicas=0&pagina=1&itensPorPagina=50&comDadosDoGrupo=1";

    private static final String APP_TOKEN = "Zq5baiPoqzjh";

    private static final String ACCESS_TOKEN = "tf8nfifh4l6a";

    public ArrayList<Cliente> listarClientesSuperlogica() throws JSONException {
        client = ClientBuilder.newClient();
        WebTarget webTarget = client.target(URL);

        WebTarget employeeWebTarget = webTarget.path(URI_CLIENTE);
        Invocation.Builder invocationBuilder = employeeWebTarget.request(MediaType.APPLICATION_FORM_URLENCODED);

        Cliente cliente = new Cliente();
        Response response = invocationBuilder.post(Entity.entity(toString(), MediaType.APPLICATION_FORM_URLENCODED));

        System.out.println("toString - " + response);

        this.clientes = new ArrayList<Cliente>();

        return  clientes;
    }

    @Override
    public String toString() {
        return "{\"app_token\": \"Zq5baiPoqzjh\", \"access_token\":\"tf8nfifh4l6a\"}";
    }

    public Cliente buscarClienteSuperlogica(int id) {
        return client
                .target(URL)
                .path(URI_CLIENTE)
                .request(MediaType.APPLICATION_FORM_URLENCODED)
                .get(Cliente.class);
    }

    public Response createJsonEmployee(Cliente emp) {
        return client.target(URL + URI_CLIENTE).request(MediaType.APPLICATION_JSON).post(Entity.entity(emp, MediaType.APPLICATION_JSON));
    }

    public Cliente getJsonEmployee(int id) {
        return client.target(URL + URI_CLIENTE).path(String.valueOf(id)).request(MediaType.APPLICATION_JSON).get(Cliente.class);
    }
}
