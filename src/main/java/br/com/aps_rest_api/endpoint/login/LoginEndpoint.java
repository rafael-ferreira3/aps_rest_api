package br.com.aps_rest_api.endpoint.login;

import br.com.aps_rest_api.endpoint.cliente.ClienteQuery;
import br.com.aps_rest_api.endpoint.usuario.UsuarioQuery;
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

    @PostMapping("/logarUsuario")
    @ApiOperation(value = "Faz o Login do Usuario")
    public ResponseEntity<UsuarioQuery> loginUsuario(@RequestBody LoginParam loginParam) throws LoginException {
        UsuarioQuery usuarioLogado = loginService.logarUsuario(loginParam);
        return ResponseEntity.ok(usuarioLogado);
    }

    @PostMapping("/logarCliente")
    @ApiOperation(value = "Faz o Login do Cliente")
    public ResponseEntity<ClienteQuery> loginCliente(@RequestBody LoginParam loginParam) throws LoginException {
        ClienteQuery clienteLogado = loginService.logarCliente(loginParam);
        return ResponseEntity.ok(clienteLogado);
    }

}
