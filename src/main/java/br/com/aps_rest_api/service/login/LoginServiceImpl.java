package br.com.aps_rest_api.service.login;

import br.com.aps_rest_api.endpoint.login.LoginParam;
import br.com.aps_rest_api.endpoint.login.UsuarioLoginQuery;
import br.com.aps_rest_api.helpers.Encrypt;
import br.com.aps_rest_api.model.usuario.Usuario;
import br.com.aps_rest_api.repository.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;


@Service
public class LoginServiceImpl implements LoginService{

    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public UsuarioLoginQuery logar(LoginParam loginParam) throws Exception{
        Usuario usuarioEncontrado = usuarioRepository.findByUsernameAndSenha(loginParam.getUsername(), Encrypt.toMD5(loginParam.getSenha()));
        if(usuarioEncontrado == null){
            throw new Exception("Usuário ou senha incorreta");
        }
        return new UsuarioLoginQuery(usuarioEncontrado.getIdusuario(), usuarioEncontrado.getNome(), usuarioEncontrado.getUsername());
    }
}
