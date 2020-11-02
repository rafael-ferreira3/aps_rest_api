package br.com.aps_rest_api.endpoint.pedido;

import br.com.aps_rest_api.endpoint.produto.ProdutoQuery;
import br.com.aps_rest_api.model.pedido.Pedido;
import java.io.Serializable;

public class PedidoItemQuery implements Serializable {

    public PedidoItemQuery(){

    }

    private Long idPedidoItem;

    private ProdutoQuery produto;

    private Integer quantidade;

    private Long idPedido;

    public Long getIdPedidoItem() {
        return idPedidoItem;
    }

    public void setIdPedidoItem(Long idPedidoItem) {
        this.idPedidoItem = idPedidoItem;
    }

    public ProdutoQuery getProduto() {
        return produto;
    }

    public void setProduto(ProdutoQuery produto) {
        this.produto = produto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Long getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Long idPedido) {
        this.idPedido = idPedido;
    }
}
