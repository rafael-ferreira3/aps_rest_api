package br.com.aps_rest_api.service.produto;

import br.com.aps_rest_api.endpoint.produto.ProdutoParam;
import br.com.aps_rest_api.endpoint.produto.ProdutoQuery;

import java.util.List;

public interface ProdutoService {

    void cadastrarProduto(ProdutoParam produtoParam);

    List<ProdutoQuery> buscaProdutoCategoria(Long idCategoria);

    String buscaImagemProduto(Long idProduto);

    List<ProdutoQuery> buscaTodosProdutos();

    List<ProdutoQuery> buscaTodosProdutosComImagemBase64();

    List<ProdutoQuery> buscaProdutosComImagemCategoria(Long idCategoria);

    void deletarProduto(Long idProduto);

    ProdutoQuery alterarProduto(ProdutoParam produtoParam);

}
