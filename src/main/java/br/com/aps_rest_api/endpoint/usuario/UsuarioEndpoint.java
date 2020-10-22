package br.com.aps_rest_api.endpoint.usuario;

import br.com.aps_rest_api.model.usuario.Usuario;
import br.com.aps_rest_api.service.usuario.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class UsuarioEndpoint {

    @Autowired
    UsuarioService usuarioService;

    @PostMapping("/usuario")
    public ResponseEntity<String> criarUsuario(@RequestBody UsuarioParam usuarioParam){
        try{
            usuarioService.criarUsuario(usuarioParam);
            return ResponseEntity.ok("");
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Usuário já cadastrado");
        }
    }

    @GetMapping("/usuarios")
    public List<Usuario> listaUsuarios(){
        return usuarioService.listaUsuarios();
    }
}
