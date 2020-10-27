package br.com.aps_rest_api.service.usuario;

import br.com.aps_rest_api.endpoint.usuario.UsuarioQuery;
import br.com.aps_rest_api.endpoint.usuario.UsuarioParam;
import br.com.aps_rest_api.service.exception.ServiceException;

import java.util.List;

public interface UsuarioService {
    List<UsuarioQuery> listaUsuarios();

    void criarUsuario(UsuarioParam usuarioParam) throws ServiceException;

    UsuarioQuery atualizarUsuario(UsuarioParam usuarioParam) throws ServiceException;

    void deletarUsuario(long idUsuario) throws ServiceException;

    UsuarioQuery buscaUsuarioId(Long idUsuario) throws ServiceException;

}
