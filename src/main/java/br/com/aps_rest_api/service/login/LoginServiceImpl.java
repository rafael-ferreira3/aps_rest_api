package br.com.aps_rest_api.service.login;

import br.com.aps_rest_api.endpoint.cliente.ClienteQuery;
import br.com.aps_rest_api.endpoint.login.LoginParam;
import br.com.aps_rest_api.endpoint.usuario.UsuarioQuery;
import br.com.aps_rest_api.exception.LoginException;
import br.com.aps_rest_api.helpers.Encrypt;
import br.com.aps_rest_api.model.cliente.Cliente;
import br.com.aps_rest_api.model.usuario.Usuario;
import br.com.aps_rest_api.repository.cliente.ClienteRepository;
import br.com.aps_rest_api.repository.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;


@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    ClienteRepository clienteRepository;

    @Override
    public UsuarioQuery logarUsuario(LoginParam loginParam) throws LoginException {
        Usuario usuarioEncontrado = usuarioRepository.findByUsernameAndSenha(loginParam.getUsername(), Encrypt.toMD5(loginParam.getSenha()));
        if (usuarioEncontrado == null) {
            throw new LoginException(HttpStatus.UNAUTHORIZED, "Usuário ou senha incorreta");
        }
        return makeUsuarioQuery(usuarioEncontrado);
    }

    @Override
    public ClienteQuery logarCliente(LoginParam loginParam) throws LoginException {
        Cliente clienteLogado = clienteRepository.findByEmailAndSenha(loginParam.getUsername(), Encrypt.toMD5(loginParam.getSenha()));
        if (clienteLogado == null) {
            throw new LoginException(HttpStatus.UNAUTHORIZED, "Usuário ou senha incorreta");
        }

        return makeClienteLogin(clienteLogado);
    }

    UsuarioQuery makeUsuarioQuery(Usuario usuairo){
        return new UsuarioQuery(usuairo.getIdUsuario(), usuairo.getNome(), usuairo.getUsername());
    }

    ClienteQuery makeClienteLogin(Cliente cliente){
        return new ClienteQuery(cliente.getIdCliente(), cliente.getNome(), cliente.getEmail(), cliente.getTelefone(), cliente.getRua(), cliente.getNumero());
    }

}
