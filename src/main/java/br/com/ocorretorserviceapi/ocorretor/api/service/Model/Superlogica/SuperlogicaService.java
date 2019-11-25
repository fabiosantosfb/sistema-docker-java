package br.com.ocorretorserviceapi.ocorretor.api.service.Model.Superlogica;

import br.com.ocorretorserviceapi.ocorretor.api.service.Model.Usuario.Cliente;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import javax.ws.rs.HttpMethod;
import javax.ws.rs.client.*;
import javax.ws.rs.core.*;
import java.util.ArrayList;

public class SuperlogicaService {
    private MultivaluedMap headers;

    //https://www.baeldung.com/jersey-jax-rs-client
    private Client client;

    private ArrayList<Cliente> clientes;

    private static final String URL  = "https://api.superlogica.net/v2/financeiro/";

    private static final String URI_CLIENTE = "clientes?apenasColunasPrincipais=0&status=2&comDiaDeVencimento=0&apenasPessoasJuridicas=0&pagina=1&itensPorPagina=50&comDadosDoGrupo=1";
    private static final String URI_CLIENTE_ID = "clientes?id=16027";

    private static final String APP_TOKEN = "Zq5baiPoqzjh";
    private static final String ACCESS_TOKEN = "tf8nfifh4l6a";
    private static final String CONTENT_TYPE = "application/x-www-form-urlencoded";

    public Response listarClientesSuperlogica() {

        Client client = ClientBuilder.newClient();
        WebTarget webTarget = client.target(URL).path(URI_CLIENTE);

        Invocation.Builder invocationBuilder = webTarget.request();
        invocationBuilder.headers(this.getRequestHeaders());

        Response result = invocationBuilder.get();

        if (200 == result.getStatus()) {
            System.out.println("result - " + result.getMetadata());
        }

        return result;
    }

    private MultivaluedMap getRequestHeaders() {
        this.headers = new MultivaluedHashMap();

        this.headers.add("Content-Type", CONTENT_TYPE);
        this.headers.add("app_token", APP_TOKEN);
        this.headers.add("access_token", ACCESS_TOKEN);

        return this.headers;
    }

    public Response buscarClienteSuperlogica(int id) {
        Client client = ClientBuilder.newClient();
        WebTarget webTarget = client.target(URL).path(URI_CLIENTE_ID);
        Invocation.Builder invocationBuilder =  webTarget.request().headers(this.getRequestHeaders());
        Response response = invocationBuilder.get();

        int status = response.getStatus();

        System.out.println("status - " + status);
        System.out.println("response - " + response);
        System.out.println("textEntity - " + response.getEntity());

        return response;
    }

    public Response createJsonEmployee(Cliente emp) {
        return client.target(URL + URI_CLIENTE).request(MediaType.APPLICATION_JSON).post(Entity.entity(emp, MediaType.APPLICATION_JSON));
    }

    public Cliente getJsonEmployee(int id) {
        return client.target(URL + URI_CLIENTE).path(String.valueOf(id)).request(MediaType.APPLICATION_JSON).get(Cliente.class);
    }
}
