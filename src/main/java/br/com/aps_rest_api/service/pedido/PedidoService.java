package br.com.aps_rest_api.service.pedido;

import br.com.aps_rest_api.endpoint.pedido.PedidoQuery;

import java.util.List;

public interface PedidoService {

    PedidoQuery gerarPedido(Long pedidoParam);

    List<PedidoQuery> buscaPedidosPorCliente(Long idCliente);

}
