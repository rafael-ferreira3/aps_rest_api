package br.com.aps_rest_api.service.cliente;

import br.com.aps_rest_api.endpoint.cliente.ClienteParam;
import br.com.aps_rest_api.exception.ClienteException;
import br.com.aps_rest_api.helpers.Encrypt;
import br.com.aps_rest_api.model.cliente.Cliente;
import br.com.aps_rest_api.repository.cliente.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    @Override
    public void cadastrarCliente(ClienteParam clienteParam) throws ClienteException {

        Cliente cliente = makeCliente(clienteParam);

        Cliente saved = clienteRepository.save(cliente);
        System.out.println(saved);

    }

    Cliente makeCliente(ClienteParam clienteParam) {
        Cliente cliente = new Cliente();
        cliente.setIdCliente(clienteParam.getIdCliente());
        cliente.setNome(clienteParam.getNome());
        cliente.setEmail(clienteParam.getEmail());
        cliente.setRua(clienteParam.getRua());
        cliente.setNumero(clienteParam.getNumero());
        cliente.setTelefone(clienteParam.getTelefone());
        if (clienteParam.getSenha() != null) {
            cliente.setSenha(Encrypt.toMD5(clienteParam.getSenha()));
        }
        return cliente;
    }
}
