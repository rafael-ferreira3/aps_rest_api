package br.com.aps_rest_api.endpoint.cliente;

import br.com.aps_rest_api.service.cliente.ClienteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api")
@Api("Api de CLiente")
@CrossOrigin(origins = "*")
public class ClienteEndpoint {

    @Autowired
    ClienteService clienteService;

    @PostMapping("/cliente")
    @ApiOperation("Cadastra um novo cliente")
    public void cadastrarCliente(@RequestBody ClienteParam clienteParam){
        clienteService.cadastrarCliente(clienteParam);
    }

}
