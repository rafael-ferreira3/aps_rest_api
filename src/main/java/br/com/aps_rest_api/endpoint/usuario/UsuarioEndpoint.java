package br.com.aps_rest_api.endpoint.usuario;

import br.com.aps_rest_api.model.usuario.Usuario;
import br.com.aps_rest_api.service.usuario.UsuarioService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<String> criarUsuario(@RequestBody UsuarioParam usuarioParam){
        try{
            usuarioService.criarUsuario(usuarioParam);
            return ResponseEntity.ok("");
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Usuário já cadastrado");
        }
    }

    @GetMapping("/usuarios")
    @ApiOperation(value = "Lista todos os usuários")
    public List<Usuario> listaUsuarios(){
        return usuarioService.listaUsuarios();
    }
}
