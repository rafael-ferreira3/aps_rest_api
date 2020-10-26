package br.com.aps_rest_api.service.cliente;

import br.com.aps_rest_api.endpoint.cliente.ClienteParam;
import br.com.aps_rest_api.endpoint.cliente.ClienteQuery;
import br.com.aps_rest_api.endpoint.usuario.UsuarioQuery;
import br.com.aps_rest_api.exception.ClienteException;
import br.com.aps_rest_api.helpers.Encrypt;
import br.com.aps_rest_api.model.cliente.Cliente;
import br.com.aps_rest_api.model.usuario.Usuario;
import br.com.aps_rest_api.repository.cliente.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    @Override
    public List<ClienteQuery> listaClientes() {
        return makeUsuarioQueryList(clienteRepository.findAll());
    }

    @Override
    public ClienteQuery buscaCliente(Long idCliente) throws ClienteException {
        Optional<Cliente> cliente = clienteRepository.findById(idCliente);
        if(!cliente.isPresent()){
            throw new ClienteException(HttpStatus.BAD_REQUEST,"Cliente ID: "+idCliente+" Não Encontrado");
        }

        return makeClienteQuery(cliente.get());
    }

    @Override
    public ClienteQuery atualizaCliente(ClienteParam clienteParam) throws ClienteException {
        Optional<Cliente> cliente = clienteRepository.findById(clienteParam.getIdCliente());
        if(!cliente.isPresent()){
            throw new ClienteException(HttpStatus.BAD_REQUEST,"Cliente ID: "+clienteParam.getIdCliente()+" Não Encontrado");
        }
        Cliente clienteAtualizar = makeClienteAtualizar(cliente.get(),clienteParam);
        clienteRepository.save(clienteAtualizar);
        return makeClienteQuery(clienteAtualizar);
    }

    @Override
    public void deletarCliente(Long idCliente) throws ClienteException {
        Optional<Cliente> cliente = clienteRepository.findById(idCliente);
        if(!cliente.isPresent()){
            throw new ClienteException(HttpStatus.BAD_REQUEST,"Cliente ID: "+idCliente+" Não Encontrado");
        }

        clienteRepository.delete(cliente.get());
    }

    ClienteQuery makeClienteQuery(Cliente cliente){
        return new ClienteQuery(cliente.getIdCliente(), cliente.getNome(), cliente.getEmail(), cliente.getTelefone(), cliente.getRua(), cliente.getNumero());
    }

    List<ClienteQuery> makeUsuarioQueryList(List<Cliente> listUsuario){
        List<ClienteQuery> listClienteQuery = new ArrayList<>();
        for(Cliente cliente : listUsuario){
            listClienteQuery.add(makeClienteQuery(cliente));
        }
        return listClienteQuery;
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

    Cliente makeClienteAtualizar(Cliente cliente, ClienteParam clienteParam) {
        if(clienteParam.getNome() != null){
            cliente.setNome(clienteParam.getNome());
        }
        if(clienteParam.getRua() != null){
            cliente.setRua(clienteParam.getRua());
        }
        if(clienteParam.getNumero() != null){
            cliente.setNumero(clienteParam.getNumero());
        }
        if(clienteParam.getTelefone() != null){
            cliente.setTelefone(clienteParam.getTelefone());
        }
        if (clienteParam.getSenha() != null) {
            cliente.setSenha(Encrypt.toMD5(clienteParam.getSenha()));
        }
        return cliente;
    }
}
