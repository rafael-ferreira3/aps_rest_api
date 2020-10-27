package br.com.aps_rest_api.service.login;

import br.com.aps_rest_api.endpoint.cliente.ClienteQuery;
import br.com.aps_rest_api.endpoint.login.LoginParam;
import br.com.aps_rest_api.endpoint.usuario.UsuarioQuery;
import br.com.aps_rest_api.service.exception.ServiceException;

public interface LoginService {
    UsuarioQuery logarUsuario(LoginParam loginParam) throws ServiceException;

    ClienteQuery logarCliente(LoginParam loginParam) throws ServiceException;
}
