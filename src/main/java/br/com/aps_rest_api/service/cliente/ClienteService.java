package br.com.aps_rest_api.service.cliente;

import br.com.aps_rest_api.endpoint.cliente.ClienteParam;
import br.com.aps_rest_api.endpoint.cliente.ClienteQuery;
import br.com.aps_rest_api.service.exception.ServiceException;

import java.util.List;

public interface ClienteService {

    void cadastrarCliente(ClienteParam clienteParam) throws ServiceException;

    List<ClienteQuery> listaClientes();

    ClienteQuery buscaCliente(Long idCliente) throws ServiceException;

    ClienteQuery atualizaCliente(ClienteParam clienteParam) throws ServiceException;

    void deletarCliente(Long idCliente) throws ServiceException;


}
