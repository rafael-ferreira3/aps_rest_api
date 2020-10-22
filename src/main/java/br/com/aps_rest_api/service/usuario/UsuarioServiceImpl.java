package br.com.aps_rest_api.service.usuario;

import br.com.aps_rest_api.endpoint.usuario.UsuarioParam;
import br.com.aps_rest_api.model.usuario.Usuario;
import br.com.aps_rest_api.repository.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService{

    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public List<Usuario> listaUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario criarUsuario(UsuarioParam usuarioParam) {
        Usuario usuario = new Usuario(usuarioParam.getNome(), usuarioParam.getUsername(), usuarioParam.getSenha());
        return usuarioRepository.save(usuario);
    }
}
