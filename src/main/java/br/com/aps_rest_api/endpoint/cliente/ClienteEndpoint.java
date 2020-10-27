package br.com.aps_rest_api.endpoint.cliente;

import br.com.aps_rest_api.service.cliente.ClienteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
@Api("Api de CLiente")
@CrossOrigin(origins = "*")
public class ClienteEndpoint {

    @Autowired
    ClienteService clienteService;

    @PostMapping("/cliente")
    @ApiOperation("Cadastra um novo cliente")
    public ClienteQuery cadastrarCliente(@RequestBody ClienteParam clienteParam) {
        return clienteService.cadastrarCliente(clienteParam);
    }

    @GetMapping("/clientes")
    @ApiOperation("Mostra todos os clientes")
    public List<ClienteQuery> listaClientes() {
        return clienteService.listaClientes();
    }

    @GetMapping("/cliente/{idCliente}")
    @ApiOperation("Busca Cliente por Id")
    public ClienteQuery buscaCliente(@PathVariable Long idCliente) {
        return clienteService.buscaCliente(idCliente);
    }

    @PutMapping("/cliente")
    @ApiOperation(value = "Atualiza Conta do Cliente")
    public ResponseEntity<ClienteQuery> atualizaCliente(@RequestBody ClienteParam clienteParam) {
        return ResponseEntity.ok(clienteService.atualizaCliente(clienteParam));
    }

    @DeleteMapping("/cliente/{idCliente}")
    @ApiOperation(value = "Deleta Conta do Cliente")
    public void deletarCliente(@PathVariable Long idCliente) {
        clienteService.deletarCliente(idCliente);
    }

}
