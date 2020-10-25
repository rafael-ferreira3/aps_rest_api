package br.com.aps_rest_api.service.login;

import br.com.aps_rest_api.endpoint.login.ClienteLoginQuery;
import br.com.aps_rest_api.endpoint.login.LoginParam;
import br.com.aps_rest_api.endpoint.usuario.UsuarioQuery;
import br.com.aps_rest_api.exception.LoginException;

public interface LoginService {
    UsuarioQuery logarUsuario(LoginParam loginParam) throws LoginException;

    ClienteLoginQuery logarCliente(LoginParam loginParam) throws LoginException;
}
