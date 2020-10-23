package br.com.aps_rest_api.service.usuario;

import br.com.aps_rest_api.endpoint.login.UsuarioLoginQuery;
import br.com.aps_rest_api.endpoint.usuario.UsuarioParam;
import br.com.aps_rest_api.exception.UsuarioException;
import br.com.aps_rest_api.model.usuario.Usuario;

import java.util.List;

public interface UsuarioService {
    List<Usuario> listaUsuarios();

    void criarUsuario(UsuarioParam usuarioParam) throws UsuarioException;

    UsuarioLoginQuery atualizarUsuario(UsuarioParam usuarioParam) throws UsuarioException;

    void deletarUsuario(long idUsuario) throws UsuarioException;

}
