package br.com.aps_rest_api.service.cliente;

import br.com.aps_rest_api.endpoint.cliente.ClienteParam;
import br.com.aps_rest_api.endpoint.cliente.ClienteQuery;
import br.com.aps_rest_api.exception.ClienteException;

import java.util.List;

public interface ClienteService {

    void cadastrarCliente(ClienteParam clienteParam) throws ClienteException;

    List<ClienteQuery> listaClientes();

    ClienteQuery buscaCliente(Long idCliente) throws ClienteException;

    ClienteQuery atualizaCliente(ClienteParam clienteParam) throws ClienteException;

    void deletarCliente(Long idCliente) throws ClienteException;


}
