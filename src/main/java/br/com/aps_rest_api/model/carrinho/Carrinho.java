package br.com.aps_rest_api.model.carrinho;

import br.com.aps_rest_api.model.cliente.Cliente;
import br.com.aps_rest_api.model.produto.Produto;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "carrinho")
public class Carrinho implements Serializable {

    public Carrinho() {
    }

    @Id
    @Column(name = "idcarrinho")
    @SequenceGenerator(name = "seq_carrinho", sequenceName = "seq_carrinho", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_carrinho")
    private Long idCarrinho;

    @ManyToOne(targetEntity = Cliente.class,fetch = FetchType.LAZY)
    @JoinColumn(name = "idcliente")
    private Cliente cliente;

    @ManyToOne(targetEntity = Produto.class,fetch = FetchType.LAZY)
    @JoinColumn(name = "idproduto")
    private Produto produto;

    @Column(name = "quantidade")
    private Integer quantidade;

    public Long getIdCarrinho() {
        return idCarrinho;
    }

    public void setIdCarrinho(Long idCarrinho) {
        this.idCarrinho = idCarrinho;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
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

    @Override
    public String toString() {
        return "Carrinho{" +
                "idCarrinho=" + idCarrinho +
                ", cliente=" + cliente +
                ", produto=" + produto +
                ", quantidade=" + quantidade +
                '}';
    }
}
