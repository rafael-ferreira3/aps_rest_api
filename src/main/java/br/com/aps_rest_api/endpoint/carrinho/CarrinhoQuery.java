package br.com.aps_rest_api.endpoint.carrinho;

import java.io.Serializable;

public class CarrinhoQuery implements Serializable {

    public CarrinhoQuery(){

    }

    public CarrinhoQuery(Long idCarrinho, Long idCliente, Long idProduto, Integer quantidade) {
        this.idCarrinho = idCarrinho;
        this.idCliente = idCliente;
        this.idProduto = idProduto;
        this.quantidade = quantidade;
    }

    private Long idCarrinho;

    private Long idCliente;

    private Long idProduto;

    private Integer quantidade;

    public Long getIdCarrinho() {
        return idCarrinho;
    }

    public void setIdCarrinho(Long idCarrinho) {
        this.idCarrinho = idCarrinho;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public Long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
}
