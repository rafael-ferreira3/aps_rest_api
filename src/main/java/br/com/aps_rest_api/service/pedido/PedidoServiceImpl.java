package br.com.aps_rest_api.service.pedido;

import br.com.aps_rest_api.endpoint.pedido.PedidoItemQuery;
import br.com.aps_rest_api.endpoint.pedido.PedidoQuery;
import br.com.aps_rest_api.endpoint.produto.ProdutoQuery;
import br.com.aps_rest_api.model.carrinho.Carrinho;
import br.com.aps_rest_api.model.cliente.Cliente;
import br.com.aps_rest_api.model.pedido.Pedido;
import br.com.aps_rest_api.model.pedido.PedidoItem;
import br.com.aps_rest_api.model.produto.Produto;
import br.com.aps_rest_api.repository.carrinho.CarrinhoRepository;
import br.com.aps_rest_api.repository.cliente.ClienteRepository;
import br.com.aps_rest_api.repository.pedido.PedidoRepository;
import br.com.aps_rest_api.service.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static br.com.aps_rest_api.service.helpers.UrlConstant.URL;

@Service
public class PedidoServiceImpl implements PedidoService{

    @Autowired
    PedidoRepository pedidoRepository;

    @Autowired
    CarrinhoRepository carrinhoRepository;

    @Autowired
    ClienteRepository clienteRepository;

    @Override
    public PedidoQuery gerarPedido(Long idCliente) {
        Pedido pedido = preparPedido(idCliente);
        pedidoRepository.save(pedido);
        carrinhoRepository.deleteCarrinhoByCliente(idCliente);
        return makePedidoQuery(pedido);
    }

    @Override
    public List<PedidoQuery> buscaPedidosPorCliente(Long idCliente) {
        return makeListPedidoQuery(pedidoRepository.buscaPedidoByCliente(idCliente));
    }

    private List<PedidoQuery> makeListPedidoQuery(List<Pedido> pedidos){
        return pedidos.stream().map(this::makePedidoQuery).collect(Collectors.toList());
    }

    private PedidoQuery makePedidoQuery(Pedido pedido){
        PedidoQuery pedidoQuery = new PedidoQuery();
        pedidoQuery.setIdPedido(pedido.getIdPedido());
        pedidoQuery.setIdCliente(pedido.getCliente().getIdCliente());
        pedidoQuery.setValorTotal(pedido.getValorTotal());
        pedidoQuery.setItensPedido(makeListPedidoItemQuery(pedido.getItensPedido()));

        return pedidoQuery;
    }

    private List<PedidoItemQuery> makeListPedidoItemQuery(List<PedidoItem> pedidoItems){
        return pedidoItems.stream().map(this::makePedidoItemQuery).collect(Collectors.toList());
    }

    private PedidoItemQuery makePedidoItemQuery(PedidoItem pedidoItem){
        PedidoItemQuery pedidoItemQuery = new PedidoItemQuery();
        pedidoItemQuery.setIdPedidoItem(pedidoItem.getIdPedidoItem());
        if(pedidoItem.getPedido() != null){
            pedidoItemQuery.setIdPedido(pedidoItem.getPedido().getIdPedido());
        }
        pedidoItemQuery.setProduto(makeProdutoQuery(pedidoItem.getProduto()));
        pedidoItemQuery.setQuantidade(pedidoItem.getQuantidade());

        return pedidoItemQuery;
    }

    private Pedido preparPedido(Long idCliente){
        Cliente cliente = buscaCliente(idCliente);
        List<Carrinho> carrinhoItens = buscaCarrinhoCliente(idCliente);
        Pedido pedido = new Pedido();
        pedido.setCliente(cliente);
        pedido.setValorTotal(carrinhoRepository.getValorTotalCarrinhoByIdCliente(idCliente));
        pedido.setItensPedido(makeListPedidoItem(carrinhoItens));

        return pedido;
    }

    List<PedidoItem> makeListPedidoItem(List<Carrinho> carrinhoListc){
        return carrinhoListc.stream().map(this::makePedidoItem).collect(Collectors.toList());
    }

    PedidoItem makePedidoItem(Carrinho carrinho){
        PedidoItem pedidoItem = new PedidoItem();
        pedidoItem.setProduto(carrinho.getProduto());
        pedidoItem.setQuantidade(carrinho.getQuantidade());
        return pedidoItem;
    }

    Cliente buscaCliente(Long idCliente){
        Optional<Cliente> cliente = clienteRepository.findById(idCliente);
        if(!cliente.isPresent()){
            throw new ServiceException(HttpStatus.BAD_REQUEST,"Cliente ID: "+idCliente+" não encontrado");
        }
        return cliente.get();
    }

    List<Carrinho> buscaCarrinhoCliente(Long idCliente){
        List<Carrinho> carrinhoItens = carrinhoRepository.findByIdCliente(idCliente);
        if(carrinhoItens.isEmpty()){
            throw new ServiceException(HttpStatus.BAD_REQUEST,"Carrihno vazio");
        }
        return carrinhoItens;
    }

    ProdutoQuery makeProdutoQuery(Produto produto){
        return new ProdutoQuery(produto.getIdProduto(), produto.getCategoria().getIdCategoria(),produto.getDescricao(),produto.getPreco(),makeImgUrl(produto.getIdProduto()));
    }

    String makeImgUrl(Long idProduto){
        return URL+"/api/produto/img/"+idProduto;
    }

}
