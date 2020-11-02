package br.com.aps_rest_api.model.pedido;

import br.com.aps_rest_api.model.cliente.Cliente;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "pedido")
public class Pedido implements Serializable {

    public Pedido(){

    }

    @Id
    @Column(name = "idpedido")
    @SequenceGenerator(name = "seq_pedido", sequenceName = "seq_pedido", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_pedido")
    private Long idPedido;

    @ManyToOne(targetEntity = Cliente.class,fetch = FetchType.EAGER)
    @JoinColumn(name = "idcliente")
    private Cliente cliente;

    @Column(name = "valor")
    private Double valorTotal;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, targetEntity = PedidoItem.class)
    @JoinColumn(name = "idpedido")
    private List<PedidoItem> itensPedido;

    public Long getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Long idPedido) {
        this.idPedido = idPedido;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public List<PedidoItem> getItensPedido() {
        return itensPedido;
    }

    public void setItensPedido(List<PedidoItem> itensPedido) {
        this.itensPedido = itensPedido;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "idPedido=" + idPedido +
                ", cliente=" + cliente +
                ", valorTotal=" + valorTotal +
                ", itensPedido=" + itensPedido +
                '}';
    }
}
