package br.com.ocorretorserviceapi.ocorretor.api.service.Controller;

import br.com.ocorretorserviceapi.ocorretor.api.service.Model.Usuario.Cliente;
import br.com.ocorretorserviceapi.ocorretor.api.service.Model.Usuario.ClienteResponse;
import br.com.ocorretorserviceapi.ocorretor.api.service.Utils.Api.Service.Superlogica.ClienteSuperlogicaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/api/superlogica")
@Import({ClienteSuperlogicaService.class})
@Api(value = "API REST - Comunicação com superlogica para tratar dados dos clientes")
public class SuperlogicaClienteController {
    @Autowired
    ClienteSuperlogicaService clienteSuperlogicaService;

    @ApiOperation(value = "Retorna todos os clientes registrado no superlogica para atualizar a base de dados do o-corretor")
    @GetMapping("/atualizar-base-ocorretor/clientes")
    @Produces(MediaType.APPLICATION_JSON)
    public Response atualizarBaseClienteOcorretor() throws JSONException {
        return Response.status(Response.Status.CREATED).build();
    }

    @ApiOperation(value = "Busca cliente no superlogica pelo id de identificação")
    @GetMapping("/buscar/cliente/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public ClienteResponse buscarCliente(@PathVariable(value = "id") long id) {
        return this.clienteSuperlogicaService.buscarClientePoId(id);
    }

    @ApiOperation(value = "Registra cliente no superlogica")
    @PostMapping("/criar/cliente/")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response criarCliente(@PathVariable(value = "cliente") Cliente cliente) {
        return Response.status(Response.Status.CREATED).build();
    }

    @ApiOperation(value = "Atualizar cliente no superlogica")
    @PutMapping("/atualizar/cliente/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(@PathVariable("id") long id, Cliente cliente) {
        return Response.status(Response.Status.CREATED).build();
    }
}
