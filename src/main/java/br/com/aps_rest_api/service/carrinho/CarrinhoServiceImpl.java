package br.com.aps_rest_api.service.carrinho;

import br.com.aps_rest_api.endpoint.carrinho.CarrinhoParam;
import br.com.aps_rest_api.endpoint.carrinho.CarrinhoQuery;
import br.com.aps_rest_api.endpoint.cliente.ClienteQuery;
import br.com.aps_rest_api.endpoint.produto.ProdutoQuery;
import br.com.aps_rest_api.model.carrinho.Carrinho;
import br.com.aps_rest_api.model.cliente.Cliente;
import br.com.aps_rest_api.model.produto.Produto;
import br.com.aps_rest_api.repository.carrinho.CarrinhoRepository;
import br.com.aps_rest_api.repository.cliente.ClienteRepository;
import br.com.aps_rest_api.repository.produto.ProdutoRepository;
import br.com.aps_rest_api.service.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static br.com.aps_rest_api.service.helpers.UrlConstant.URL;

@Service
public class CarrinhoServiceImpl implements CarrinhoService{

    @Autowired
    CarrinhoRepository carrinhoRepository;

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    ProdutoRepository produtoRepository;

    @Override
    public List<CarrinhoQuery> adicionarItemCarrinho(CarrinhoParam carrinhosParam) {
        carrinhoRepository.save(makeCarrinho(carrinhosParam));
        List<Carrinho> CarrinhoCliente = carrinhoRepository.findByIdCliente(carrinhosParam.getIdCliente());
        return makeCarrinhoQueryList(CarrinhoCliente);
    }

    @Override
    public List<CarrinhoQuery> buscaCarrinhoCliente(Long idCliente) {
        return makeCarrinhoQueryList(carrinhoRepository.findByIdCliente(idCliente));
    }

    Carrinho makeCarrinho(CarrinhoParam carrinhoParam){
        Cliente cliente = buscaCliente(carrinhoParam.getIdCliente());
        Produto produto = buscaProduto(carrinhoParam.getIdProduto());

        Carrinho carrinho = new Carrinho();

        if(carrinhoParam.getIdCarrinho() != null){
            carrinho.setIdCarrinho(carrinhoParam.getIdCarrinho());
        }
        carrinho.setCliente(cliente);
        carrinho.setProduto(produto);
        carrinho.setQuantidade(carrinhoParam.getQuantidade());
        return carrinho;
    }

    List<Carrinho> makeCarrinhoList(List<CarrinhoParam> paramList){
        return paramList.stream().map(this::makeCarrinho).collect(Collectors.toList());
    }

    CarrinhoQuery makeCarrinhoQuery(Carrinho carrinho){
        return new CarrinhoQuery(carrinho.getIdCarrinho(),makeClienteQuery(carrinho.getCliente()),makeProdutoQuery(carrinho.getProduto()),carrinho.getQuantidade());
    }

    List<CarrinhoQuery> makeCarrinhoQueryList(List<Carrinho> listCarrinhos){
        return listCarrinhos.stream().map(this::makeCarrinhoQuery).collect(Collectors.toList());
    }

    Cliente buscaCliente(Long idCliente){
        Optional<Cliente> cliente = clienteRepository.findById(idCliente);
        if(!cliente.isPresent()){
            throw new ServiceException(HttpStatus.BAD_REQUEST,"Cliente ID: "+idCliente+" não encontrado");
        }
        return cliente.get();
    }

    Produto buscaProduto(Long idProduto){
        Optional<Produto> produto = produtoRepository.findById(idProduto);
        if(!produto.isPresent()){
            throw new ServiceException(HttpStatus.BAD_REQUEST,"Produto ID: "+idProduto+" não encontrado");
        }
        return produto.get();
    }

    ClienteQuery makeClienteQuery(Cliente cliente){
        return new ClienteQuery(cliente.getIdCliente(), cliente.getNome(), cliente.getEmail(), cliente.getTelefone(), cliente.getRua(), cliente.getNumero());
    }

    ProdutoQuery makeProdutoQuery(Produto produto){
        return new ProdutoQuery(produto.getIdProduto(), produto.getCategoria().getIdCategoria(),produto.getDescricao(),produto.getPreco(),makeImgUrl(produto.getIdProduto()));
    }

    String makeImgUrl(Long idProduto){
        return URL+"/api/produto/img/"+idProduto;
    }

}
