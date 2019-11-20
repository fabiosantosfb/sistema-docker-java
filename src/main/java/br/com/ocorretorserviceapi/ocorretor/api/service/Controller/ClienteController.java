package br.com.ocorretorserviceapi.ocorretor.api.service.Controller;

import br.com.ocorretorserviceapi.ocorretor.api.service.Model.Usuario.Cliente;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/api")
public class ClienteController {

    @GetMapping("/listar/clientes")
    public List<Cliente> listarCliente() {
        List<Cliente> clientes = new ArrayList<Cliente>();

        Cliente cliente = new Cliente();
        Cliente cliente2 = new Cliente();

        cliente.setNome("Fabiano");
        cliente2.setNome("Fabio");
        clientes.add(cliente);
        clientes.add(cliente2);
        return clientes;
    }

    @GetMapping("/buscar/cliente/{id}")
    public Cliente buscarCliente(@PathVariable(value = "id") long id) {
        Cliente cliente = new Cliente();
        cliente.setNome("Fabiano");

        return cliente;
    }

    @PutMapping("/aditar/cliente")
    public Cliente atualizarCliente(@RequestBody @Valid Cliente cliente) {
        cliente.setNome("Fulano");

        return cliente;
    }

    @PostMapping("/salvar/cliente")
    public Cliente salvarCliente(@RequestBody @Valid Cliente cliente) {
        cliente.setNome("Sicrano");

        return cliente;
    }
}
