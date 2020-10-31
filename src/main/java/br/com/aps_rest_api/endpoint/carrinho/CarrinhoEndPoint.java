package br.com.aps_rest_api.endpoint.carrinho;

import br.com.aps_rest_api.model.carrinho.Carrinho;
import br.com.aps_rest_api.service.carrinho.CarrinhoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
@Api("Api de Carrinho")
@CrossOrigin(origins = "*")
public class CarrinhoEndPoint {

    @Autowired
    CarrinhoService carrinhoService;

    @PostMapping("/carrinho")
    @ApiOperation("Adiciona Item no Carrinho")
    List<CarrinhoQuery> adicionarItemCarrinho(@RequestBody List<CarrinhoParam> carrinho){
        return carrinhoService.adicionarItemCarrinho(carrinho);
    }

}
