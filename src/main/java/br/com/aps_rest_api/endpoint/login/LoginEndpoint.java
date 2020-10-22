package br.com.aps_rest_api.endpoint.login;

import br.com.aps_rest_api.exception.LoginException;
import br.com.aps_rest_api.service.login.LoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api")
@Api("Api usada para fazer login")
@CrossOrigin(origins = "*")
public class LoginEndpoint {

    @Autowired
    LoginService loginService;

    @PostMapping("/logar")
    @ApiOperation(value = "Valida o Login")
    public ResponseEntity<UsuarioLoginQuery> logar(@RequestBody LoginParam loginParam) throws LoginException {
        UsuarioLoginQuery usuarioLogado = loginService.logar(loginParam);
        return ResponseEntity.ok(usuarioLogado);
    }

}
