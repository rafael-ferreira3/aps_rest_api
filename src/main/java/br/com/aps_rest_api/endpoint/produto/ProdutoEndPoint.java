package br.com.aps_rest_api.endpoint.produto;

import br.com.aps_rest_api.model.produto.Produto;
import br.com.aps_rest_api.service.produto.ProdutoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
@Api("Api de Produtos")
@CrossOrigin(origins = "*")
public class ProdutoEndPoint {

    @Autowired
    ProdutoService produtoService;

    @PostMapping("/produto")
    @ApiOperation("Cadastra um Produto")
    void cadastrarProduto(@RequestBody ProdutoParam produtoParam){
        produtoService.cadastrarProduto(produtoParam);
    }

    @GetMapping("/produto/categoria/{idCategoria}")
    @ApiOperation("Lista todos os Produtos de uma categoria")
    List<ProdutoQuery> buscaProdutosCategoria(@PathVariable Long idCategoria){
        return produtoService.buscaProdutoCategoria(idCategoria);
    }

    @GetMapping("/produto/img/{idProduto}")
    @ApiOperation("Busca imagem do Produto")
    String buscaImagemProduto(@PathVariable Long idProduto){
        return produtoService.buscaImagemProduto(idProduto);
    }

    @GetMapping("/produtos")
    @ApiOperation("Busca todos os produtos")
    List<ProdutoQuery> buscaTodosProdutos(){
        return produtoService.buscaTodosProdutos();
    }

}
