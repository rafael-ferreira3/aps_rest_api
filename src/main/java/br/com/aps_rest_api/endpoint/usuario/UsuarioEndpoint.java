package br.com.aps_rest_api.endpoint.usuario;

import br.com.aps_rest_api.endpoint.login.UsuarioLoginQuery;
import br.com.aps_rest_api.model.usuario.Usuario;
import br.com.aps_rest_api.service.usuario.UsuarioService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
@Api(value = "Api de Usuários")
@CrossOrigin(origins = "*")
public class UsuarioEndpoint {

    @Autowired
    UsuarioService usuarioService;

    @PostMapping("/usuario")
    @ApiOperation(value = "Cria uma novo usuário")
    public void criarUsuario(@RequestBody UsuarioParam usuarioParam){
        usuarioService.criarUsuario(usuarioParam);
    }

    @GetMapping("/usuarios")
    @ApiOperation(value = "Lista todos os usuários")
    public List<Usuario> listaUsuarios(){
        return usuarioService.listaUsuarios();
    }

    @PutMapping("/usuario")
    @ApiOperation(value = "Atualiza Conta do Usuário")
    public ResponseEntity<UsuarioLoginQuery> atualizaUsuario(@RequestParam UsuarioParam usuarioParam){
        return ResponseEntity.ok(usuarioService.atualizarUsuario(usuarioParam));
    }

    @DeleteMapping("/usuario/{idUsuario}")
    @ApiOperation(value = "Deleta Conta do Usuário")
    public void deletarUsuario(@PathVariable Long idUsuario){
        usuarioService.deletarUsuario(idUsuario);
    }

}
