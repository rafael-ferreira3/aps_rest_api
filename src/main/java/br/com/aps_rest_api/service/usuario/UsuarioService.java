package br.com.aps_rest_api.service.usuario;

import br.com.aps_rest_api.endpoint.usuario.UsuarioParam;
import br.com.aps_rest_api.model.usuario.Usuario;

import java.util.List;

public interface UsuarioService {
    List<Usuario> listaUsuarios();

    Usuario criarUsuario(UsuarioParam usuarioParam);

}
