package br.com.aps_rest_api.service.usuario;

import br.com.aps_rest_api.endpoint.usuario.UsuarioQuery;
import br.com.aps_rest_api.endpoint.usuario.UsuarioParam;
import br.com.aps_rest_api.exception.UsuarioException;
import br.com.aps_rest_api.model.usuario.Usuario;

import java.util.List;

public interface UsuarioService {
    List<UsuarioQuery> listaUsuarios();

    void criarUsuario(UsuarioParam usuarioParam) throws UsuarioException;

    UsuarioQuery atualizarUsuario(UsuarioParam usuarioParam) throws UsuarioException;

    void deletarUsuario(long idUsuario) throws UsuarioException;

    UsuarioQuery buscaUsuarioId(Long idUsuario) throws UsuarioException;

}
