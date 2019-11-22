package br.com.ocorretorserviceapi.ocorretor.api.service.Controller;

import br.com.ocorretorserviceapi.ocorretor.api.service.Model.Superlogica.SuperlogicaService;
import br.com.ocorretorserviceapi.ocorretor.api.service.Model.Usuario.Cliente;
import org.json.JSONException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping(value = "/api")
public class SuperlogicaClienteController {

    public static final int HTTP_CREATED = 201;

    @GetMapping("/atualizar-base-ocorretor/super-logica/clientes")
    public ArrayList<Cliente> atualizarBaseClienteOcorretor() throws JSONException {
        SuperlogicaService client = new SuperlogicaService();

        ArrayList<Cliente> response = client.listarClientesSuperlogica();

        return response;
    }
}
