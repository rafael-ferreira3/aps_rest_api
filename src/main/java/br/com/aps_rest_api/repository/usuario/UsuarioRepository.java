package br.com.aps_rest_api.repository.usuario;

import br.com.aps_rest_api.model.usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Usuario findByUsernameAndSenha(String username, String senha);

    @Query(value = "select u.idUsuario, u.username, u.nome from usuario u where u.username = :username and u.senha = MD5(:senha)", nativeQuery = true)
    Usuario logar(String username, String senha);

}
