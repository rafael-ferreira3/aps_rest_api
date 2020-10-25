package br.com.aps_rest_api.service.cliente;

import br.com.aps_rest_api.endpoint.cliente.ClienteParam;
import br.com.aps_rest_api.exception.ClienteException;

public interface ClienteService {

    void cadastrarCliente(ClienteParam clienteParam) throws ClienteException;
}
