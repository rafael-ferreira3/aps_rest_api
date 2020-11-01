package br.com.aps_rest_api.service.carrinho;

import br.com.aps_rest_api.endpoint.carrinho.CarrinhoParam;
import br.com.aps_rest_api.endpoint.carrinho.CarrinhoQuery;

import java.util.List;

public interface CarrinhoService {

    List<CarrinhoQuery> adicionarItemCarrinho(CarrinhoParam carrinho);

    List<CarrinhoQuery> buscaCarrinhoCliente(Long idCliente);

}
