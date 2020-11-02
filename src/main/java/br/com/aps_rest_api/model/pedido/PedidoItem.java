package br.com.aps_rest_api.model.pedido;

import br.com.aps_rest_api.model.produto.Produto;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "pedidoitem")
public class PedidoItem implements Serializable  {

    public PedidoItem(){

    }

    public PedidoItem(Long idPedidoItem, Produto produto, Integer quantidade, Pedido pedido) {
        this.idPedidoItem = idPedidoItem;
        this.produto = produto;
        this.quantidade = quantidade;
        this.pedido = pedido;
    }

    @Id
    @Column(name = "idpedidoitem")
    @SequenceGenerator(name = "seq_pedidoitem", sequenceName = "seq_pedidoitem", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_pedidoitem")
    private Long idPedidoItem;

    @OneToOne(targetEntity = Produto.class,fetch = FetchType.EAGER)
    @JoinColumn(name = "idproduto")
    private Produto produto;

    @Column(name = "quantidade")
    private Integer quantidade;

    @ManyToOne
    @JoinColumn(name = "idpedido")
    private Pedido pedido;

    public Long getIdPedidoItem() {
        return idPedidoItem;
    }

    public void setIdPedidoItem(Long idPedidoItem) {
        this.idPedidoItem = idPedidoItem;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    @Override
    public String toString() {
        return "PedidoItem{" +
                "idPedidoItem=" + idPedidoItem +
                ", produto=" + produto +
                ", quantidade=" + quantidade +
                ", pedido=" + pedido +
                '}';
    }
}
