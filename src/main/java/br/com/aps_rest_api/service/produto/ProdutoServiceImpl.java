package br.com.aps_rest_api.service.produto;

import br.com.aps_rest_api.endpoint.produto.ProdutoParam;
import br.com.aps_rest_api.endpoint.produto.ProdutoQuery;
import br.com.aps_rest_api.model.categoria.Categoria;
import br.com.aps_rest_api.model.produto.Produto;
import br.com.aps_rest_api.repository.categoria.CategoriaRepository;
import br.com.aps_rest_api.repository.produto.ProdutoRepository;
import br.com.aps_rest_api.service.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static br.com.aps_rest_api.service.helpers.UrlConstant.URL;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    @Autowired
    ProdutoRepository produtoRepository;

    @Autowired
    CategoriaRepository categoriaRepository;

    @Override
    public void cadastrarProduto(ProdutoParam produtoParam) {
        Produto produto = makeProduto(produtoParam);
        produtoRepository.save(produto);
    }

    @Override
    public List<ProdutoQuery> buscaProdutoCategoria(Long idCategoria) {
        List<Produto> produtos = produtoRepository.buscaProdutoCategoria(idCategoria);
        return makeProdutoQueryList(produtos);
    }

    @Override
    public String buscaImagemProduto(Long idProduto) {
        Optional<Produto> produto = produtoRepository.findById(idProduto);
        if(!produto.isPresent()){
            throw new ServiceException(HttpStatus.BAD_REQUEST,"Produto ID: "+idProduto+" não encontrado");
        }
        return produto.get().getImg();
    }

    String makeImgUrl(Long idProduto){
        return URL+"/api/produto/img/"+idProduto;
    }

    ProdutoQuery makeProdutoQuery(Produto produto){
        return new ProdutoQuery(produto.getIdProduto(), produto.getCategoria().getIdCategoria(),produto.getDescricao(),produto.getPreco(),makeImgUrl(produto.getIdProduto()));
    }

    List<ProdutoQuery> makeProdutoQueryList(List<Produto> produtos){
        List<ProdutoQuery> produtoQueries = new ArrayList<>();
        for(Produto produto : produtos){
            produtoQueries.add(makeProdutoQuery(produto));
        }
        return produtoQueries;
    }

    Produto makeProduto(ProdutoParam produtoParam){
        return new Produto(produtoParam.getIdCategoria(),buscaCategoria(produtoParam.getIdCategoria()),produtoParam.getDescricao(), produtoParam.getPreco(), produtoParam.getImg());
    }

    Categoria buscaCategoria(Long idCategoria){
        Optional<Categoria> categoria = categoriaRepository.findById(idCategoria);
        if(!categoria.isPresent()){
            throw new ServiceException(HttpStatus.BAD_REQUEST,"Categoria ID: "+idCategoria+" não encontrada");
        }
        return categoria.get();
    }

}
