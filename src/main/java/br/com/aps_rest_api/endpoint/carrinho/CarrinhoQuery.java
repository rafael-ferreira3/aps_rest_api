package br.com.aps_rest_api.endpoint.carrinho;

import br.com.aps_rest_api.endpoint.cliente.ClienteQuery;
import br.com.aps_rest_api.endpoint.produto.ProdutoQuery;
import br.com.aps_rest_api.model.cliente.Cliente;
import br.com.aps_rest_api.model.produto.Produto;

import java.io.Serializable;

public class CarrinhoQuery implements Serializable {

    public CarrinhoQuery(){

    }

    public CarrinhoQuery(Long idCarrinho, ClienteQuery cliente, ProdutoQuery idProduto, Integer quantidade) {
        this.idCarrinho = idCarrinho;
        this.cliente = cliente;
        this.idProduto = idProduto;
        this.quantidade = quantidade;
    }

    private Long idCarrinho;

    private ClienteQuery cliente;

    private ProdutoQuery idProduto;

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

    public ProdutoQuery getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(ProdutoQuery idProduto) {
        this.idProduto = idProduto;
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
                ", idProduto=" + idProduto +
                ", quantidade=" + quantidade +
                '}';
    }
}
