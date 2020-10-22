package br.com.aps_rest_api.service.login;

import br.com.aps_rest_api.endpoint.login.LoginParam;
import br.com.aps_rest_api.endpoint.login.UsuarioLoginQuery;
import br.com.aps_rest_api.exception.LoginException;

public interface LoginService {
    UsuarioLoginQuery logar(LoginParam loginParam) throws LoginException;
}
