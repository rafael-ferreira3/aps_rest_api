package br.com.aps_rest_api.endpoint.pedido;

import java.io.Serializable;
import java.util.List;

public class PedidoQuery implements Serializable {

    public PedidoQuery() {

    }

    public PedidoQuery(Long idPedido, Long idCliente, Double valorTotal, List<PedidoItemQuery> itensPedido) {
        this.idPedido = idPedido;
        this.idCliente = idCliente;
        this.valorTotal = valorTotal;
        this.itensPedido = itensPedido;
    }

    private Long idPedido;

    private Long idCliente;

    private Double valorTotal;

    private List<PedidoItemQuery> itensPedido;

    public Long getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Long idPedido) {
        this.idPedido = idPedido;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public List<PedidoItemQuery> getItensPedido() {
        return itensPedido;
    }

    public void setItensPedido(List<PedidoItemQuery> itensPedido) {
        this.itensPedido = itensPedido;
    }

    @Override
    public String toString() {
        return "PedidoQuery{" +
                "idPedido=" + idPedido +
                ", idCliente=" + idCliente +
                ", valorTotal=" + valorTotal +
                ", itenPedido=" + itensPedido +
                '}';
    }
}
