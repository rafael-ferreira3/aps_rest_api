package br.com.aps_rest_api.endpoint.carrinho;

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
    List<CarrinhoQuery> adicionarItemCarrinho(@RequestBody CarrinhoParam carrinho){
        return carrinhoService.adicionarItemCarrinho(carrinho);
    }

    @GetMapping("/carrinho/{idCliente}")
    @ApiOperation("Busca o carrinho de um cliente")
    List<CarrinhoQuery> buscaCarrinhoCliente(@PathVariable Long idCliente){
        return carrinhoService.buscaCarrinhoCliente(idCliente);
    }

    @PutMapping("/carrinho/increment/{idCliente}/{idCarrinho}")
    @ApiOperation("Incrementa em 1 a quantidade do item")
    void incrementarProduto(@PathVariable Long idCliente, @PathVariable Long idCarrinho){
        carrinhoService.incrementaItemCarrinho(idCliente, idCarrinho);
    }

    @PutMapping("/carrinho/decrement/{idCliente}/{idCarrinho}")
    @ApiOperation("Decrementa em 1 a quantidade do item")
    void decrementarProduto(@PathVariable Long idCliente, @PathVariable Long idCarrinho){
        carrinhoService.decrementaItemCarrinho(idCliente, idCarrinho);
    }

    @DeleteMapping("/carrinho/{idCliente}/{idCarrinho}")
    @ApiOperation("Deleta o Item do Carrinho")
    void removerItemCarrinho(@PathVariable Long idCliente, @PathVariable Long idCarrinho){
        carrinhoService.removeItemCarrinho(idCliente, idCarrinho);
    }
}
