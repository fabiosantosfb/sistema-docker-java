package br.com.ocorretorserviceapi.ocorretor.api.service.Controller;

import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/api/client")
public class ClienteController {
//    @Autowired
//    ClienteRepositoryInterface clienteRespository;

//    @GetMapping("/listar/clientes")
//    public List<Cliente> listarCliente() {
//        return clienteRespository.findAll();
//    }
//
//    @GetMapping("/buscar/cliente/{id}")
//    public Cliente buscarCliente(@PathVariable(value = "id") long id) {
//        return clienteRespository.findById(id);
//    }
//
//    @PutMapping("/aditar/cliente")
//    public Cliente atualizarCliente(@RequestBody @Valid Cliente cliente) {
//        return clienteRespository.save(cliente);
//    }
//
//    @PostMapping("/salvar/cliente")
//    public Cliente salvarCliente(@RequestBody @Valid Cliente cliente) {
//        return clienteRespository.save(cliente);
//    }
}
