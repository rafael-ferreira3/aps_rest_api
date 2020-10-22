package br.com.aps_rest_api.endpoint.login;

import br.com.aps_rest_api.service.login.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api")
public class LoginEndpoint {

    @Autowired
    LoginService loginService;

    @PostMapping("/logar")
    public ResponseEntity logar(@RequestBody LoginParam loginParam) {
        UsuarioLoginQuery usuarioLogado = null;
        try {
            usuarioLogado = loginService.logar(loginParam);
            return ResponseEntity.ok(usuarioLogado);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
    }

}
