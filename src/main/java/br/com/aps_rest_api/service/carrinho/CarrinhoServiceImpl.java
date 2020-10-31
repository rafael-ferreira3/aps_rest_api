package br.com.aps_rest_api.service.carrinho;

import br.com.aps_rest_api.endpoint.carrinho.CarrinhoParam;
import br.com.aps_rest_api.endpoint.carrinho.CarrinhoQuery;
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

@Service
public class CarrinhoServiceImpl implements CarrinhoService{

    @Autowired
    CarrinhoRepository carrinhoRepository;

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    ProdutoRepository produtoRepository;

    @Override
    public List<CarrinhoQuery> adicionarItemCarrinho(List<CarrinhoParam> carrinhosParam) {
        List<Carrinho> carrinhos = makeCarrinhoList(carrinhosParam);
        return makeCarrinhoQueryList(carrinhos.stream().map( c -> carrinhoRepository.save(c)).collect(Collectors.toList()));
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
        return new CarrinhoQuery(carrinho.getIdCarrinho(),carrinho.getCliente().getIdCliente(),carrinho.getProduto().getIdProduto(),carrinho.getQuantidade());
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

}
