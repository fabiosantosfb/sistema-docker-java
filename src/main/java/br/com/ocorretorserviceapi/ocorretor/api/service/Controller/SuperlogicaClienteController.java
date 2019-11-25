package br.com.ocorretorserviceapi.ocorretor.api.service.Controller;

import br.com.ocorretorserviceapi.ocorretor.api.service.Model.Usuario.Cliente;
import br.com.ocorretorserviceapi.ocorretor.api.service.Model.Usuario.ClienteResponse;
import br.com.ocorretorserviceapi.ocorretor.api.service.Utils.Api.Service.Superlogica.ClienteSuperlogicaService;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api")
@Import({ClienteSuperlogicaService.class})
public class SuperlogicaClienteController {
    @Autowired
    ClienteSuperlogicaService clienteSuperlogicaService;

    @GetMapping("/atualizar-base-ocorretor/super-logica/clientes")
    @Produces(MediaType.APPLICATION_JSON)
    public Response atualizarBaseClienteOcorretor() throws JSONException {
        return Response.status(Response.Status.CREATED).build();
    }

    @GetMapping("/buscar/cliente/super-logica/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public ClienteResponse buscarCliente(@PathVariable(value = "id") long id) {
        return this.clienteSuperlogicaService.buscarClientePoId(id);
    }

    @PostMapping("/criar/cliente/super-logica/")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response criarCliente(@PathVariable(value = "cliente") Cliente cliente) {
        return Response.status(Response.Status.CREATED).build();
    }

    @PutMapping("/user/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(@PathVariable("id") long id, Cliente cliente) {
        return Response.status(Response.Status.CREATED).build();
    }
}
