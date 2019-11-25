package br.com.ocorretorserviceapi.ocorretor.api.service.Utils.Api.Service.Superlogica;

import br.com.ocorretorserviceapi.ocorretor.api.service.Model.Usuario.Cliente;
import br.com.ocorretorserviceapi.ocorretor.api.service.Model.Usuario.ClienteResponse;
import br.com.ocorretorserviceapi.ocorretor.api.service.Model.Usuario.Endereco;
import br.com.ocorretorserviceapi.ocorretor.api.service.Model.Usuario.Telefone;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

public class ClienteSuperlogicaService {
    private static final String URL  = "https://api.superlogica.net/v2/financeiro/";
    private static final String URI_CLIENTE = "clientes?apenasColunasPrincipais=0&status=2&comDiaDeVencimento=0&apenasPessoasJuridicas=0&pagina=1&itensPorPagina=50&comDadosDoGrupo=1";
    private static final String URI_CLIENTE_ID = "clientes?id=";

    private static final String APP_TOKEN = "a3862d71";
    private static final String ACCESS_TOKEN = "94001549";
    private static final String CONTENT_TYPE = "application/x-www-form-urlencoded";
    private static final String CONTENT_TYPE_JSON = "application/json";

    private ClienteResponse clienteResponse;
    private HttpHeaders headers;

    public ClienteResponse buscarClientePoId(long id) {
        this.clienteResponse = new ClienteResponse();
        RestTemplate restTemplate = new RestTemplate();

        try {
            ResponseEntity<String> response = restTemplate.exchange(
                    URL + URI_CLIENTE_ID + id,
                    HttpMethod.GET,
                    this.gerarHeaders(),
                    String.class
            );

            if (response.getStatusCode() == HttpStatus.OK && !response.getBody().equals("[]")) {
                this.clienteResponse.setCodigoResponse(HttpStatus.OK.value());
                this.clienteResponse.setMensagem(HttpStatus.OK);

                Cliente cliente = this.tratarJsonClient(response.getBody());
                this.clienteResponse.setCliente(cliente);

                this.clienteResponse.setCliente(cliente);
            } else if (response.getBody().equals("[]")) {
                System.out.println("HttpStatus - " + HttpStatus.NOT_FOUND.value());
                this.clienteResponse.setMensagem(HttpStatus.NOT_FOUND);
                this.clienteResponse.setCodigoResponse(HttpStatus.NOT_FOUND.value());
            } else {
                this.clienteResponse.setMensagem(HttpStatus.FORBIDDEN);
                this.clienteResponse.setCodigoResponse(HttpStatus.FORBIDDEN.value());
            }
        } catch (HttpClientErrorException exception) {
            this.clienteResponse.setMensagem(HttpStatus.UNAUTHORIZED);
            this.clienteResponse.setCodigoResponse(HttpStatus.UNAUTHORIZED.value());
        } finally {
            return this.clienteResponse;
        }
    }

    private Cliente tratarJsonClient(String body) {
        Cliente cliente = null;
        try {
            JSONArray jsonArray = new JSONArray(body);
            JSONObject object =  new JSONObject(jsonArray.get(0).toString());

            Endereco endereco = this.buildEndereco(object);
            List<Telefone> telefones = this.tratarTelefoneJson(object);

            cliente = this.buildCliente(object, endereco, telefones);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return cliente;
    }

    private Cliente buildCliente(JSONObject json, Endereco endereco, List<Telefone> telefones) throws JSONException {
        return new Cliente(
                json.getInt("id_sacado_sac"),
                json.getString("st_nome_sac"),
                null,
                json.getString("st_email_sac"),
                false,
                endereco,
                telefones
        );
    }

    private Endereco buildEndereco(JSONObject json) throws JSONException {
        return new Endereco(
                json.getString("st_endereco_sac"),
                json.getString("st_bairro_sac"),
                json.getString("st_cidade_sac"),
                json.getString("st_estado_sac"),
                "",
                json.getString("st_cep_sac"),
                json.getString("st_numero_sac"),
                json.getString("st_pais_sac")
        );
    }

    private Telefone buildTelelfone(String numero) throws JSONException {
        return new Telefone(
                numero
        );
    }

    private List<Telefone> tratarTelefoneJson(JSONObject json) throws JSONException {
        List<Telefone> telefones = new ArrayList<>();
        JSONArray celulares = new JSONArray();
        celulares = json.getJSONArray("celular");

        for (int i = 0; i < celulares.length(); i++) {
            JSONObject object =  new JSONObject(celulares.get(i).toString());
            telefones.add(this.buildTelelfone(object.getString("st_celular_sac")));
        }

        return telefones;
    }

    private HttpEntity gerarHeaders() {
        this.headers = new HttpHeaders();
        this.headers.set("Content-Type", CONTENT_TYPE_JSON);
        this.headers.set("app_token", APP_TOKEN);
        this.headers.set("access_token", ACCESS_TOKEN);

        return new HttpEntity(this.headers);
    }
}
