package br.com.aps_rest_api.service.usuario;

import br.com.aps_rest_api.endpoint.login.UsuarioLoginQuery;
import br.com.aps_rest_api.endpoint.usuario.UsuarioParam;
import br.com.aps_rest_api.exception.UsuarioException;
import br.com.aps_rest_api.helpers.Encrypt;
import br.com.aps_rest_api.model.usuario.Usuario;
import br.com.aps_rest_api.repository.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService{

    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public List<Usuario> listaUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public void criarUsuario(UsuarioParam usuarioParam) {
        Usuario usuario = makeUsuario(usuarioParam);
        usuarioRepository.save(usuario);
    }

    @Override
    public UsuarioLoginQuery atualizarUsuario(UsuarioParam usuarioParam) throws UsuarioException {
        Optional<Usuario> usuario = usuarioRepository.findById(usuarioParam.getIdUsuario());
        if(!usuario.isPresent()){
            throw new UsuarioException(HttpStatus.BAD_REQUEST,"Usuário Não Encontrado");
        }
        Usuario usuarioAtualizar = usuario.get();
        usuarioAtualizar.setNome(usuarioParam.getNome());
        return new UsuarioLoginQuery(usuarioRepository.save(usuarioAtualizar));
    }

    @Override
    public void deletarUsuario(long idUsuario) throws UsuarioException {
        Optional<Usuario> usuario = usuarioRepository.findById(idUsuario);
        if(!usuario.isPresent()){
            throw new UsuarioException(HttpStatus.BAD_REQUEST,"Usuário Não Encontrado");
        }
        usuarioRepository.delete(usuario.get());
    }

    Usuario makeUsuario(UsuarioParam usuarioParam){
        Usuario usuario = new Usuario();
        usuario.setIdUsuario(usuarioParam.getIdUsuario());
        usuario.setNome(usuarioParam.getNome());
        usuario.setUsername(usuarioParam.getUsername());
        if(usuarioParam.getSenha() != null){
            usuario.setSenha(Encrypt.toMD5(usuarioParam.getSenha()));
        }
        return usuario;
    }

}
