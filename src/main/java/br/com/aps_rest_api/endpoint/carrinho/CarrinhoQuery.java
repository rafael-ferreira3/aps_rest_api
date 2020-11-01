package br.com.aps_rest_api.endpoint.carrinho;

import br.com.aps_rest_api.endpoint.cliente.ClienteQuery;
import br.com.aps_rest_api.endpoint.produto.ProdutoQuery;

import java.io.Serializable;

public class CarrinhoQuery implements Serializable {

    public CarrinhoQuery(){

    }

    public CarrinhoQuery(Long idCarrinho, ClienteQuery cliente, ProdutoQuery produto, Integer quantidade) {
        this.idCarrinho = idCarrinho;
        this.cliente = cliente;
        this.produto = produto;
        this.quantidade = quantidade;
    }

    private Long idCarrinho;

    private ClienteQuery cliente;

    private ProdutoQuery produto;

    private Integer quantidade;

    public Long getIdCarrinho() {
        return idCarrinho;
    }

    public void setIdCarrinho(Long idCarrinho) {
        this.idCarrinho = idCarrinho;
    }

    public ClienteQuery getCliente() {
        return cliente;
    }

    public void setCliente(ClienteQuery cliente) {
        this.cliente = cliente;
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

    @Override
    public String toString() {
        return "CarrinhoQuery{" +
                "idCarrinho=" + idCarrinho +
                ", cliente=" + cliente +
                ", idProduto=" + produto +
                ", quantidade=" + quantidade +
                '}';
    }
}
